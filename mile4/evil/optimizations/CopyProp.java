/**
 * Do optimizations plz.
 */

package evil.optimizations;

import java.util.*;

import evil.evilCFG.*;
import evil.instruction.*;

public class CopyProp {
    private ArrayList<ArrayList<BasicBlock>> allCFGs;
    private boolean changed;

    public CopyProp(ArrayList<BasicBlock> blks)
    {
        allCFGs = BasicBlock.getAllCFGs();
    }

    public void optimize()
    {
        //ArrayList<BasicBlock> blocks = allCFGs.get(0);
        for(ArrayList<BasicBlock> blocks : allCFGs)
        {
//            System.out.println("LOOKING AT CFG FOR FUNCTION: " + blocks.get(0).getTag());
            HashMap<BasicBlock, LocalInfo> info = getLocalInfo(blocks.get(0).getTopoCFG());
            propogateAndReplace(info, blocks.get(0).getTopoCFG());
        }
    }

    private void propogateAndReplace(HashMap<BasicBlock, LocalInfo> info, ArrayList<BasicBlock> allBlocks)
    {
        changed = true;
        while(changed)
        {
            changed = false;
            //FOR all blocks in the CFG
            for(BasicBlock block : allBlocks)
            {
                LocalInfo local = info.get(block);
                //FOR all of this blocks parents
                for(BasicBlock parent : block.getParents())
                {
                    HashSet<Copy> temp = new HashSet<Copy>(info.get(parent).copyIn);
                    ArrayList<Copy> doesntGetToStay = new ArrayList<Copy>();
                    //FOR all copy's in the parents copyIn
                    for(Copy c : temp)
                    {
                        //FOR all registers killed by the parent
                        for(Register r : info.get(parent).kill)
                        {
                            //IF this copy uses that register kill if
                            if(c.uses(r))
                            {
                                doesntGetToStay.add(c);
                            }
                        }
                    }
                    temp.removeAll(doesntGetToStay);

                    temp.addAll(info.get(parent).gen);
                    if(!local.visited)
                    {
                        local.copyIn.addAll(temp);
                        local.visited = true;
                        changed = true;
                    }
                    else
                    {
                        ArrayList<Copy> toRemove = copyIntersection(local.copyIn, temp);
                        if(toRemove.size() > 0)
                        {
                            local.copyIn.removeAll(toRemove);
                            changed = true;
                        }
                    }
                }
            }
        }


        changed = true;
        while(changed)
        {
            changed = false;
            for(BasicBlock block : allBlocks)
            {
                LocalInfo local = info.get(block);

                HashSet<Copy> temp = new HashSet<Copy>(local.copyIn);

                ArrayList<Instruction> instructions = block.getInstructions();
                for(int j = 0; j < instructions.size(); j++)
                {
                    Instruction inst = instructions.get(j);
                    ArrayList<Register> srcs = inst.getSources();
                    ArrayList<Copy> toRemove = new ArrayList<Copy>();

                    for(Register r : inst.getTargets())
                    {
                        for(Copy c : temp)
                            if(c.uses(r))
                                toRemove.add(c);
                    }
                    temp.removeAll(toRemove);

                    for(int i = 0; i < srcs.size(); i++)
                    {
                        Register r = srcs.get(i);
                        for(Copy c : temp)
                        {
                            if(c.to == r)
                            {
                                changed = true;
//                                System.out.print("REPLACING REGISTER: " + srcs.get(i) + " WITH: " + c.from + " IN: " + inst);
//                                srcs.set(i, c.from);
                                inst.replaceSource(c.to, c.from);
//                                System.out.println(" NOW: " + instructions.get(j));
//                                System.out.println("\n--------------------------------");
                            }
                        }
                    }

                    if(inst instanceof Inst_mov)
                    {
                        Inst_mov tempInst = (Inst_mov)inst;
                        temp.add(new Copy(tempInst.getAddr0(), tempInst.getAddr1(), block, inst));
                    }
                }
            }
        }
    }

    //returns a ArrayList<Copy> to remove from the first parameter to generate the intersection set
    private ArrayList<Copy> copyIntersection(HashSet<Copy> removeFrom, HashSet<Copy>src)
    {

        ArrayList<Copy> toRemove = new ArrayList<Copy>();
        for(Copy c : removeFrom)
        {
            if(!src.contains(c))
            {
                toRemove.add(c);
            }
        }
        return toRemove;
    }

    private ArrayList<Copy> copyUnion(HashSet<Copy> src1, HashSet<Copy>src2)
    {

        ArrayList<Copy> toAdd = new ArrayList<Copy>();
        for(Copy c : src2)
        {
            if(!src1.contains(c))
            {
                toAdd.add(c);
            }
        }
        return toAdd;
    }

    private HashMap<BasicBlock, LocalInfo> getLocalInfo(ArrayList<BasicBlock> allBlocks)
    {
        HashMap<BasicBlock, LocalInfo> cfgInfo = new HashMap<BasicBlock, LocalInfo>();
        //FOR all blocks in the CFG
        for(BasicBlock block : allBlocks)
        {
            LocalInfo info = new LocalInfo();
            cfgInfo.put(block, info);
            //REVERSE ITERATE through all instructions
            for(int i = block.getInstructions().size() - 1; i >= 0; i--)
            {
                Instruction inst = block.getInstructions().get(i);

                //IF the instruction is a copy
                if(inst instanceof Inst_mov)
                {
                    Inst_mov temp = (Inst_mov)inst;
                    //IF neither the src or target of the copy gets killed below this
                    if(!info.kill.contains(temp.getAddr0()) && !info.kill.contains(temp.getAddr1()) && temp.getAddr0() != temp.getAddr1()) {
                        info.gen.add(new Copy(temp.getAddr0(), temp.getAddr1(), block, inst));
                    }
                }

                //KILL all dst registers of this instruction
                for(Register dst : inst.getTargets())
                    info.kill.add(dst);
            }
        }
        return cfgInfo;
    }

    private class LocalInfo
    {
        public HashSet<Copy> gen;
        public HashSet<Register> kill;
        public HashSet<Copy> copyIn;
        public boolean visited;

        public LocalInfo()
        {
            gen = new HashSet<Copy>();
            kill = new HashSet<Register>();
            copyIn = new HashSet<Copy>();
            visited = false;
        }
    }

    private class Copy
    {
        public Register from;
        public Register to;
        public BasicBlock block;
        public Instruction inst;

        public Copy(Register src, Register dst, BasicBlock blk, Instruction ins)
        {
            from = src;
            to = dst;
            block = blk;
            inst = ins;
        }

        public boolean uses(Register r)
        {
            return (r == from || r == to);
        }

        public boolean equals(Object o)
        {
            if(o instanceof Copy)
            {
                Copy other = (Copy)o;
                return (from.equals(other.from) && to.equals(other.to));
            }

            return false;
        }
    }
}
