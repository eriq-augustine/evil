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
      mov %l0, %o0
      call hailstone
      nop
      set 0, %l0
      mov %l0, %i0
      ret
      restore
      .size main, .-main
      .common readMePrzButDontTouch,4,4

      .align 4
      .global hailstone
      .type hailstone, #function
      .proc 04
hailstone:
      save %sp, -112, %sp
      mov %i0, %l0
      set 1, %l1
      cmp %l1, 1
      be TAG5
      nop
      ba TAG12
      nop
TAG5:
      sethi %hi(.LLC0), %o5
      or %o5, %lo(.LLC0), %o0
      mov %l0, %o1
      call printf, 0
      nop
      set 2, %l1
      mov %l0, %o0
      mov %l1, %o1
      call mod
      nop
      mov %o0, %l1
      set 1, %l2
      cmp %l1, %l2
      set 0, %l1
      move %icc, 1, %l1
      cmp %l1, 1
      be TAG6
      nop
      ba TAG7
      nop
TAG7:
      sra %l0, %g0, %o5
      sdivx %o5, 2, %l0
      ba TAG8
      nop
TAG6:
      sra %l0, %g0, %o5
      mulx %o5, 3, %l0
      add %l0, 1, %l0
      ba TAG8
      nop
TAG8:
      set 1, %l1
      cmp %l0, %l1
      set 0, %l1
      movle %icc, 1, %l1
      cmp %l1, 1
      be TAG9
      nop
      ba TAG10
      nop
TAG9:
      sethi %hi(.LLC1), %o5
      or %o5, %lo(.LLC1), %o0
      mov %l0, %o1
      call printf, 0
      nop
      ret
      restore
      ba TAG10
      nop
TAG10:
      set 1, %l1
      cmp %l1, 1
      be TAG5
      nop
      ba TAG12
      nop
TAG12:
      ret
      restore
      .size hailstone, .-hailstone

      .align 4
      .global mod
      .type mod, #function
      .proc 04
mod:
      save %sp, -112, %sp
      mov %i0, %l0
      mov %i1, %l1
      sra %l0, %g0, %o5
      sra %l1, %g0, %o4
      sdivx %o5, %o4, %l2
      sra %l2, %g0, %o5
      sra %l1, %g0, %o4
      mulx %o5, %o4, %l1
      sub %l0, %l1, %l0
      mov %l0, %i0
      ret
      restore
      .size mod, .-mod
