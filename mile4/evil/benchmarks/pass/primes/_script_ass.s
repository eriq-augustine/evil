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
      set 0, %l2
      mov %l2, %l1
      cmp %l2, %l0
      set 0, %l2
      movle %icc, 1, %l2
      cmp %l2, 1
      be TAG19
      nop
      ba TAG23
      nop
TAG19:
      mov %l1, %o0
      call prime
      nop
      mov %o0, %l2
      cmp %l2, 1
      be TAG20
      nop
      ba TAG21
      nop
TAG20:
      sethi %hi(.LLC1), %o5
      or %o5, %lo(.LLC1), %o0
      mov %l1, %o1
      call printf, 0
      nop
      ba TAG21
      nop
TAG21:
      add %l1, 1, %l2
      mov %l2, %l1
      cmp %l2, %l0
      set 0, %l2
      movle %icc, 1, %l2
      cmp %l2, 1
      be TAG19
      nop
      ba TAG23
      nop
TAG23:
      set 0, %l0
      mov %l0, %i0
      ret
      restore
      .size main, .-main
      .common readMePrzButDontTouch,4,4

      .align 4
      .global prime
      .type prime, #function
      .proc 04
prime:
      save %sp, -112, %sp
      mov %i0, %l0
      set 2, %l1
      cmp %l0, %l1
      set 0, %l1
      movl %icc, 1, %l1
      cmp %l1, 1
      be TAG8
      nop
      ba TAG9
      nop
TAG9:
      mov %l0, %o0
      call isqrt
      nop
      mov %o0, %l4
      mov %l4, %l2
      set 2, %l3
      mov %l3, %l1
      cmp %l3, %l4
      set 0, %l3
      movle %icc, 1, %l3
      cmp %l3, 1
      be TAG10
      nop
      ba TAG14
      nop
TAG10:
      sra %l0, %g0, %o5
      sra %l1, %g0, %o4
      sdivx %o5, %o4, %l3
      sra %l3, %g0, %o5
      sra %l1, %g0, %o4
      mulx %o5, %o4, %l3
      sub %l0, %l3, %l3
      set 0, %l4
      cmp %l3, %l4
      set 0, %l3
      move %icc, 1, %l3
      cmp %l3, 1
      be TAG11
      nop
      ba TAG12
      nop
TAG11:
      set 0, %l3
      mov %l3, %i0
      ret
      restore
      ba TAG12
      nop
TAG12:
      add %l1, 1, %l3
      mov %l3, %l1
      cmp %l3, %l2
      set 0, %l3
      movle %icc, 1, %l3
      cmp %l3, 1
      be TAG10
      nop
      ba TAG14
      nop
TAG14:
      set 1, %l0
      mov %l0, %i0
      ret
      restore
TAG8:
      set 0, %l0
      mov %l0, %i0
      ret
      restore
TAG15:
      .size prime, .-prime

      .align 4
      .global isqrt
      .type isqrt, #function
      .proc 04
isqrt:
      save %sp, -112, %sp
      mov %i0, %l0
      set 1, %l3
      mov %l3, %l1
      set 3, %l2
      cmp %l3, %l0
      set 0, %l3
      movle %icc, 1, %l3
      cmp %l3, 1
      be TAG2
      nop
      ba TAG4
      nop
TAG2:
      add %l1, %l2, %l3
      mov %l3, %l1
      add %l2, 2, %l2
      cmp %l3, %l0
      set 0, %l3
      movle %icc, 1, %l3
      cmp %l3, 1
      be TAG2
      nop
      ba TAG4
      nop
TAG4:
      sra %l2, %g0, %o5
      sdivx %o5, 2, %l0
      sub %l0, 1, %l0
      mov %l0, %i0
      ret
      restore
      .size isqrt, .-isqrt
