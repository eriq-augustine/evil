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
      sethi %hi(readMePrzButDontTouch), %o5
      or %o5, %lo(readMePrzButDontTouch), %o5
      st %l1, [%o5]
      sethi %hi(readMePrzButDontTouch), %o5
      or %o5, %lo(readMePrzButDontTouch), %o5
      mov %o5, %l1
      sethi %hi(.LLC2), %o5
      or %o5, %lo(.LLC2), %o0
      mov %l1, %o1
      call scanf
      nop
      sethi %hi(readMePrzButDontTouch), %o5
      or %o5, %lo(readMePrzButDontTouch), %o5
      ld [%o5], %l1
      set 0, %l4
      mov %l4, %l2
      cmp %l4, %l1
      set 0, %l4
      movl %icc, 1, %l4
      cmp %l4, 1
      be TAG11
      nop
      ba TAG13
      nop
TAG11:
      mov %l0, %o0
      call fact
      nop
      mov %o0, %l3
      add %l2, 1, %l4
      mov %l4, %l2
      cmp %l4, %l1
      set 0, %l4
      movl %icc, 1, %l4
      cmp %l4, 1
      be TAG11
      nop
      ba TAG13
      nop
TAG13:
      sethi %hi(.LLC0), %o5
      or %o5, %lo(.LLC0), %o0
      mov %l0, %o1
      call printf, 0
      nop
      sethi %hi(.LLC1), %o5
      or %o5, %lo(.LLC1), %o0
      mov %l3, %o1
      call printf, 0
      nop
      set 0, %l0
      mov %l0, %i0
      ret
      restore
      .size main, .-main
      .common readMePrzButDontTouch,4,4

      .align 4
      .global fact
      .type fact, #function
      .proc 04
fact:
      save %sp, -112, %sp
      mov %i0, %l2
      mov 8, %o0
      call malloc
      nop
      mov %o0, %l1
      mov %l1, %l0
      stw %l2, [%l1+0]
      set 1, %l2
      stw %l2, [%l1+4]
      ldsw [%l1+0], %l2
      set 1, %l1
      cmp %l2, %l1
      set 0, %l1
      movg %icc, 1, %l1
      cmp %l1, 1
      be TAG5
      nop
      ba TAG7
      nop
TAG5:
      mov %l0, %o0
      call factarth
      nop
      mov %o0, %l1
      mov %l1, %l0
      ldsw [%l1+0], %l2
      set 1, %l1
      cmp %l2, %l1
      set 0, %l1
      movg %icc, 1, %l1
      cmp %l1, 1
      be TAG5
      nop
      ba TAG7
      nop
TAG7:
      ldsw [%l0+4], %l1
      mov %l0, %o0
      call free
      nop
      mov %l1, %i0
      ret
      restore
      .size fact, .-fact

      .align 4
      .global factarth
      .type factarth, #function
      .proc 04
factarth:
      save %sp, -112, %sp
      mov %i0, %l0
      ldsw [%l0+4], %l1
      ldsw [%l0+0], %l2
      sra %l1, %g0, %o5
      sra %l2, %g0, %o4
      mulx %o5, %o4, %l1
      stw %l1, [%l0+4]
      ldsw [%l0+0], %l1
      sub %l1, 1, %l1
      stw %l1, [%l0+0]
      mov %l0, %i0
      ret
      restore
      .size factarth, .-factarth
