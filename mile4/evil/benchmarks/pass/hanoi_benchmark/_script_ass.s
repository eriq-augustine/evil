!Sparc v9 Assembly file compiled by Evan Ralston and Eriq Augustine

      .file "_script_ass.s"
      .section ".text"

.LLC0:
      .asciz "%d "
      .section ".text"

.LLC1:
      .asciz "%d\n"
      .section ".text"

.LLC2:
      .asciz "%d"
      .section ".text"

      .align 4
      .global main
      .type main, #function
      .proc 04
main:
      save %sp, -112, %sp
      set 0, %l1
      sethi %hi(peg1), %o5
      or %o5, %lo(peg1), %o5
      st %l1, [%o5]
      set 0, %l1
      sethi %hi(peg2), %o5
      or %o5, %lo(peg2), %o5
      st %l1, [%o5]
      set 0, %l1
      sethi %hi(peg3), %o5
      or %o5, %lo(peg3), %o5
      st %l1, [%o5]
      set 0, %l1
      sethi %hi(numMoves), %o5
      or %o5, %lo(numMoves), %o5
      st %l1, [%o5]
      sethi %hi(readMePrzButDontTouch), %o5
      or %o5, %lo(readMePrzButDontTouch), %o5
      st %l0, [%o5]
      sethi %hi(readMePrzButDontTouch), %o5
      or %o5, %lo(readMePrzButDontTouch), %o5
      mov %o5, %l0
      sethi %hi(.LLC2), %o5
      or %o5, %lo(.LLC2), %o0
      mov %l0, %o1
      call scanf
      nop
      sethi %hi(readMePrzButDontTouch), %o5
      or %o5, %lo(readMePrzButDontTouch), %o5
      ld [%o5], %l0
      set 1, %l1
      cmp %l0, %l1
      set 0, %l1
      movge %icc, 1, %l1
      cmp %l1, 1
      be TAG29
      nop
      ba TAG36
      nop
TAG29:
      mov %l0, %l1
      set 0, %l2
      cmp %l0, %l2
      set 0, %l2
      movne %icc, 1, %l2
      cmp %l2, 1
      be TAG30
      nop
      ba TAG32
      nop
TAG30:
      mov 8, %o0
      call malloc
      nop
      mov %o0, %l2
      stw %l1, [%l2+0]
      sethi %hi(peg1), %o5
      or %o5, %lo(peg1), %o5
      ld [%o5], %l3
      stw %l3, [%l2+4]
      sethi %hi(peg1), %o5
      or %o5, %lo(peg1), %o5
      st %l2, [%o5]
      sub %l1, 1, %l3
      mov %l3, %l1
      set 0, %l2
      cmp %l3, %l2
      set 0, %l2
      movne %icc, 1, %l2
      cmp %l2, 1
      be TAG30
      nop
      ba TAG32
      nop
TAG32:
      set 1, %l1
      sethi %hi(.LLC1), %o5
      or %o5, %lo(.LLC1), %o0
      mov %l1, %o1
      call printf, 0
      nop
      sethi %hi(peg1), %o5
      or %o5, %lo(peg1), %o5
      ld [%o5], %l1
      mov %l1, %o0
      call printPeg
      nop
      set 2, %l1
      sethi %hi(.LLC1), %o5
      or %o5, %lo(.LLC1), %o0
      mov %l1, %o1
      call printf, 0
      nop
      sethi %hi(peg2), %o5
      or %o5, %lo(peg2), %o5
      ld [%o5], %l1
      mov %l1, %o0
      call printPeg
      nop
      set 3, %l1
      sethi %hi(.LLC1), %o5
      or %o5, %lo(.LLC1), %o0
      mov %l1, %o1
      call printf, 0
      nop
      sethi %hi(peg3), %o5
      or %o5, %lo(peg3), %o5
      ld [%o5], %l1
      mov %l1, %o0
      call printPeg
      nop
      set 1, %l2
      set 3, %l3
      set 2, %l1
      mov %l0, %o0
      mov %l2, %o1
      mov %l3, %o2
      mov %l1, %o3
      call hanoi
      nop
      set 1, %l0
      sethi %hi(.LLC1), %o5
      or %o5, %lo(.LLC1), %o0
      mov %l0, %o1
      call printf, 0
      nop
      sethi %hi(peg1), %o5
      or %o5, %lo(peg1), %o5
      ld [%o5], %l0
      mov %l0, %o0
      call printPeg
      nop
      set 2, %l0
      sethi %hi(.LLC1), %o5
      or %o5, %lo(.LLC1), %o0
      mov %l0, %o1
      call printf, 0
      nop
      sethi %hi(peg2), %o5
      or %o5, %lo(peg2), %o5
      ld [%o5], %l0
      mov %l0, %o0
      call printPeg
      nop
      set 3, %l0
      sethi %hi(.LLC1), %o5
      or %o5, %lo(.LLC1), %o0
      mov %l0, %o1
      call printf, 0
      nop
      sethi %hi(peg3), %o5
      or %o5, %lo(peg3), %o5
      ld [%o5], %l0
      mov %l0, %o0
      call printPeg
      nop
      sethi %hi(numMoves), %o5
      or %o5, %lo(numMoves), %o5
      ld [%o5], %l0
      sethi %hi(.LLC1), %o5
      or %o5, %lo(.LLC1), %o0
      mov %l0, %o1
      call printf, 0
      nop
      sethi %hi(peg3), %o5
      or %o5, %lo(peg3), %o5
      ld [%o5], %l1
      set 0, %l0
      cmp %l1, %l0
      set 0, %l0
      movne %icc, 1, %l0
      cmp %l0, 1
      be TAG33
      nop
      ba TAG35
      nop
TAG33:
      sethi %hi(peg3), %o5
      or %o5, %lo(peg3), %o5
      ld [%o5], %l0
      sethi %hi(peg3), %o5
      or %o5, %lo(peg3), %o5
      ld [%o5], %l1
      ldsw [%l1+4], %l1
      sethi %hi(peg3), %o5
      or %o5, %lo(peg3), %o5
      st %l1, [%o5]
      mov %l0, %o0
      call free
      nop
      sethi %hi(peg3), %o5
      or %o5, %lo(peg3), %o5
      ld [%o5], %l1
      set 0, %l0
      cmp %l1, %l0
      set 0, %l0
      movne %icc, 1, %l0
      cmp %l0, 1
      be TAG33
      nop
      ba TAG35
      nop
TAG35:
      ba TAG36
      nop
TAG36:
      set 0, %l0
      mov %l0, %i0
      ret
      restore
      .size main, .-main
      .common numMoves,4,4
      .common readMePrzButDontTouch,4,4
      .common peg3,4,4
      .common peg2,4,4
      .common peg1,4,4

      .align 4
      .global printPeg
      .type printPeg, #function
      .proc 04
printPeg:
      save %sp, -112, %sp
      mov %i0, %l2
      mov %l2, %l0
      set 0, %l1
      cmp %l2, %l1
      set 0, %l1
      movne %icc, 1, %l1
      cmp %l1, 1
      be TAG23
      nop
      ba TAG25
      nop
TAG23:
      ldsw [%l0+0], %l1
      sethi %hi(.LLC1), %o5
      or %o5, %lo(.LLC1), %o0
      mov %l1, %o1
      call printf, 0
      nop
      ldsw [%l0+4], %l1
      mov %l1, %l0
      set 0, %l2
      cmp %l1, %l2
      set 0, %l1
      movne %icc, 1, %l1
      cmp %l1, 1
      be TAG23
      nop
      ba TAG25
      nop
TAG25:
      ret
      restore
      .size printPeg, .-printPeg

      .align 4
      .global hanoi
      .type hanoi, #function
      .proc 04
hanoi:
      save %sp, -112, %sp
      mov %i0, %l3
      mov %i1, %l2
      mov %i2, %l0
      mov %i3, %l1
      set 1, %l4
      cmp %l3, %l4
      set 0, %l4
      move %icc, 1, %l4
      cmp %l4, 1
      be TAG17
      nop
      ba TAG18
      nop
TAG18:
      sub %l3, 1, %l4
      mov %l4, %o0
      mov %l2, %o1
      mov %l1, %o2
      mov %l0, %o3
      call hanoi
      nop
      mov %l2, %o0
      mov %l0, %o1
      call move
      nop
      sub %l3, 1, %l3
      mov %l3, %o0
      mov %l1, %o1
      mov %l0, %o2
      mov %l2, %o3
      call hanoi
      nop
      ret
      restore
TAG17:
      mov %l2, %o0
      mov %l0, %o1
      call move
      nop
      ret
      restore
TAG19:
      .size hanoi, .-hanoi

      .align 4
      .global move
      .type move, #function
      .proc 04
move:
      save %sp, -112, %sp
      mov %i0, %l2
      mov %i1, %l0
      set 0, %l1
      set 1, %l1
      cmp %l2, %l1
      set 0, %l1
      move %icc, 1, %l1
      cmp %l1, 1
      be TAG2
      nop
      ba TAG3
      nop
TAG3:
      set 2, %l1
      cmp %l2, %l1
      set 0, %l1
      move %icc, 1, %l1
      cmp %l1, 1
      be TAG4
      nop
      ba TAG5
      nop
TAG5:
      sethi %hi(peg3), %o5
      or %o5, %lo(peg3), %o5
      ld [%o5], %l1
      sethi %hi(peg3), %o5
      or %o5, %lo(peg3), %o5
      ld [%o5], %l2
      ldsw [%l2+4], %l2
      sethi %hi(peg3), %o5
      or %o5, %lo(peg3), %o5
      st %l2, [%o5]
      ba TAG7
      nop
TAG4:
      sethi %hi(peg2), %o5
      or %o5, %lo(peg2), %o5
      ld [%o5], %l1
      sethi %hi(peg2), %o5
      or %o5, %lo(peg2), %o5
      ld [%o5], %l2
      ldsw [%l2+4], %l2
      sethi %hi(peg2), %o5
      or %o5, %lo(peg2), %o5
      st %l2, [%o5]
      ba TAG7
      nop
TAG2:
      sethi %hi(peg1), %o5
      or %o5, %lo(peg1), %o5
      ld [%o5], %l1
      sethi %hi(peg1), %o5
      or %o5, %lo(peg1), %o5
      ld [%o5], %l2
      ldsw [%l2+4], %l2
      sethi %hi(peg1), %o5
      or %o5, %lo(peg1), %o5
      st %l2, [%o5]
      ba TAG7
      nop
TAG7:
      set 1, %l2
      cmp %l0, %l2
      set 0, %l2
      move %icc, 1, %l2
      cmp %l2, 1
      be TAG8
      nop
      ba TAG9
      nop
TAG9:
      set 2, %l2
      cmp %l0, %l2
      set 0, %l0
      move %icc, 1, %l0
      cmp %l0, 1
      be TAG10
      nop
      ba TAG11
      nop
TAG11:
      sethi %hi(peg3), %o5
      or %o5, %lo(peg3), %o5
      ld [%o5], %l0
      stw %l0, [%l1+4]
      sethi %hi(peg3), %o5
      or %o5, %lo(peg3), %o5
      st %l1, [%o5]
      ba TAG13
      nop
TAG10:
      sethi %hi(peg2), %o5
      or %o5, %lo(peg2), %o5
      ld [%o5], %l0
      stw %l0, [%l1+4]
      sethi %hi(peg2), %o5
      or %o5, %lo(peg2), %o5
      st %l1, [%o5]
      ba TAG13
      nop
TAG8:
      sethi %hi(peg1), %o5
      or %o5, %lo(peg1), %o5
      ld [%o5], %l0
      stw %l0, [%l1+4]
      sethi %hi(peg1), %o5
      or %o5, %lo(peg1), %o5
      st %l1, [%o5]
      ba TAG13
      nop
TAG13:
      sethi %hi(numMoves), %o5
      or %o5, %lo(numMoves), %o5
      ld [%o5], %l0
      add %l0, 1, %l0
      sethi %hi(numMoves), %o5
      or %o5, %lo(numMoves), %o5
      st %l0, [%o5]
      ret
      restore
      .size move, .-move
