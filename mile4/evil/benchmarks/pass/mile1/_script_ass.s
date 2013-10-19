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
      mov 8, %o0
      call malloc
      nop
      mov %o0, %l0
      sethi %hi(readMePrzButDontTouch), %o5
      or %o5, %lo(readMePrzButDontTouch), %o5
      st %l2, [%o5]
      sethi %hi(readMePrzButDontTouch), %o5
      or %o5, %lo(readMePrzButDontTouch), %o5
      mov %o5, %l2
      sethi %hi(.LLC2), %o5
      or %o5, %lo(.LLC2), %o0
      mov %l2, %o1
      call scanf
      nop
      sethi %hi(readMePrzButDontTouch), %o5
      or %o5, %lo(readMePrzButDontTouch), %o5
      ld [%o5], %l2
      stw %l2, [%l0+0]
      sethi %hi(readMePrzButDontTouch), %o5
      or %o5, %lo(readMePrzButDontTouch), %o5
      st %l2, [%o5]
      sethi %hi(readMePrzButDontTouch), %o5
      or %o5, %lo(readMePrzButDontTouch), %o5
      mov %o5, %l2
      sethi %hi(.LLC2), %o5
      or %o5, %lo(.LLC2), %o0
      mov %l2, %o1
      call scanf
      nop
      sethi %hi(readMePrzButDontTouch), %o5
      or %o5, %lo(readMePrzButDontTouch), %o5
      ld [%o5], %l2
      set 0, %l3
      cmp %l2, %l3
      set 0, %l3
      movl %icc, 1, %l3
      cmp %l3, 1
      be TAG8
      nop
      ba TAG9
      nop
TAG8:
      set -1, %l3
      mov %l3, %i0
      ret
      restore
      ba TAG9
      nop
TAG9:
      stw %l2, [%l0+4]
      set 0, %l3
      mov %l3, %l2
      set 1000000, %l4
      cmp %l3, %l4
      set 0, %l3
      movl %icc, 1, %l3
      cmp %l3, 1
      be TAG10
      nop
      ba TAG12
      nop
TAG10:
      add %l2, 1, %l3
      mov %l3, %l2
      ldsw [%l0+0], %l1
      ldsw [%l0+4], %l4
      mov %l1, %o0
      mov %l4, %o1
      call calcPower
      nop
      mov %o0, %l1
      set 1000000, %l4
      cmp %l3, %l4
      set 0, %l3
      movl %icc, 1, %l3
      cmp %l3, 1
      be TAG10
      nop
      ba TAG12
      nop
TAG12:
      sethi %hi(.LLC1), %o5
      or %o5, %lo(.LLC1), %o0
      mov %l1, %o1
      call printf, 0
      nop
      set 0, %l0
      mov %l0, %i0
      ret
      restore
      .size main, .-main
      .common readMePrzButDontTouch,4,4

      .align 4
      .global calcPower
      .type calcPower, #function
      .proc 04
calcPower:
      save %sp, -112, %sp
      mov %i0, %l1
      mov %i1, %l0
      set 1, %l2
      set 0, %l3
      cmp %l0, %l3
      set 0, %l3
      movg %icc, 1, %l3
      cmp %l3, 1
      be TAG2
      nop
      ba TAG4
      nop
TAG2:
      sra %l2, %g0, %o5
      sra %l1, %g0, %o4
      mulx %o5, %o4, %l2
      sub %l0, 1, %l4
      mov %l4, %l0
      set 0, %l3
      cmp %l4, %l3
      set 0, %l3
      movg %icc, 1, %l3
      cmp %l3, 1
      be TAG2
      nop
      ba TAG4
      nop
TAG4:
      mov %l2, %i0
      ret
      restore
      .size calcPower, .-calcPower
