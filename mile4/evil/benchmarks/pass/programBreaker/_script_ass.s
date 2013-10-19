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
      set 0, %l0
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
      set 10000, %l1
      cmp %l0, %l1
      set 0, %l1
      movl %icc, 1, %l1
      cmp %l1, 1
      be TAG16
      nop
      ba TAG18
      nop
TAG16:
      set 3, %l2
      set 5, %l1
      mov %l2, %o0
      mov %l0, %o1
      mov %l1, %o2
      call fun1
      nop
      mov %o0, %l1
      sethi %hi(.LLC1), %o5
      or %o5, %lo(.LLC1), %o0
      mov %l1, %o1
      call printf, 0
      nop
      add %l0, 1, %l2
      mov %l2, %l0
      set 10000, %l1
      cmp %l2, %l1
      set 0, %l1
      movl %icc, 1, %l1
      cmp %l1, 1
      be TAG16
      nop
      ba TAG18
      nop
TAG18:
      set 0, %l0
      mov %l0, %i0
      ret
      restore
      .size main, .-main
      .common GLOBAL,4,4
      .common count,4,4
      .common readMePrzButDontTouch,4,4

      .align 4
      .global fun1
      .type fun1, #function
      .proc 04
fun1:
      save %sp, -112, %sp
      mov %i0, %l2
      mov %i1, %l0
      mov %i2, %l1
      set 11, %l4
      sra %l2, %g0, %o5
      mulx %o5, 2, %l3
      sub %l4, %l3, %l3
      set 4, %l4
      sra %l4, %g0, %o5
      sra %l0, %g0, %o4
      sdivx %o5, %o4, %l4
      add %l3, %l4, %l3
      add %l3, %l1, %l1
      cmp %l1, %l0
      set 0, %l3
      movg %icc, 1, %l3
      cmp %l3, 1
      be TAG8
      nop
      ba TAG9
      nop
TAG9:
      set 5, %l3
      set 6, %l2
      cmp %l3, %l2
      set 0, %l3
      movl %icc, 1, %l3
      cmp %l1, %l0
      set 0, %l2
      movle %icc, 1, %l2
      and %l3, %l2, %l2
      cmp %l2, 1
      be TAG10
      nop
      ba TAG11
      nop
TAG10:
      mov %l1, %o0
      mov %l0, %o1
      call fun2
      nop
      mov %o0, %l0
      mov %l0, %i0
      ret
      restore
      ba TAG11
      nop
TAG11:
      ba TAG12
      nop
TAG8:
      mov %l1, %o0
      mov %l2, %o1
      call fun2
      nop
      mov %o0, %l0
      mov %l0, %i0
      ret
      restore
      ba TAG12
      nop
TAG12:
      mov %l1, %i0
      ret
      restore
      .size fun1, .-fun1

      .align 4
      .global fun2
      .type fun2, #function
      .proc 04
fun2:
      save %sp, -112, %sp
      mov %i0, %l1
      mov %i1, %l0
      set 0, %l2
      cmp %l1, %l2
      set 0, %l2
      move %icc, 1, %l2
      cmp %l2, 1
      be TAG2
      nop
      ba TAG3
      nop
TAG3:
      sub %l1, 1, %l1
      mov %l1, %o0
      mov %l0, %o1
      call fun2
      nop
      mov %o0, %l0
      mov %l0, %i0
      ret
      restore
TAG2:
      mov %l0, %i0
      ret
      restore
TAG4:
      .size fun2, .-fun2
