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
      mov %l0, %o0
      mov %l1, %o1
      call getRands
      nop
      mov %o0, %l0
      mov %l0, %o0
      call calcMean
      nop
      mov %o0, %l1
      sethi %hi(.LLC1), %o5
      or %o5, %lo(.LLC1), %o0
      mov %l1, %o1
      call printf, 0
      nop
      mov %l0, %o0
      call range
      nop
      mov %l0, %o0
      call approxSqrtAll
      nop
      set 0, %l0
      mov %l0, %i0
      ret
      restore
      .size main, .-main
      .common readMePrzButDontTouch,4,4

      .align 4
      .global range
      .type range, #function
      .proc 04
range:
      save %sp, -112, %sp
      mov %i0, %l0
      set 0, %l1
      set 0, %l2
      set 1, %l3
      set 0, %l4
      cmp %l0, %l4
      set 0, %l4
      movne %icc, 1, %l4
      cmp %l4, 1
      be TAG28
      nop
      ba TAG38
      nop
TAG28:
      cmp %l3, 1
      be TAG29
      nop
      ba TAG30
      nop
TAG30:
      ldsw [%l0+0], %l4
      cmp %l4, %l1
      set 0, %l4
      movl %icc, 1, %l4
      cmp %l4, 1
      be TAG31
      nop
      ba TAG32
      nop
TAG32:
      ldsw [%l0+0], %l4
      cmp %l4, %l2
      set 0, %l4
      movg %icc, 1, %l4
      cmp %l4, 1
      be TAG33
      nop
      ba TAG34
      nop
TAG33:
      ldsw [%l0+0], %l2
      ba TAG34
      nop
TAG34:
      ba TAG36
      nop
TAG31:
      ldsw [%l0+0], %l1
      ba TAG36
      nop
TAG29:
      ldsw [%l0+0], %l1
      ldsw [%l0+0], %l2
      set 0, %l3
      ba TAG36
      nop
TAG36:
      ldsw [%l0+4], %l4
      mov %l4, %l0
      set 0, %l5
      cmp %l4, %l5
      set 0, %l4
      movne %icc, 1, %l4
      cmp %l4, 1
      be TAG28
      nop
      ba TAG38
      nop
TAG38:
      sethi %hi(.LLC1), %o5
      or %o5, %lo(.LLC1), %o0
      mov %l1, %o1
      call printf, 0
      nop
      sethi %hi(.LLC1), %o5
      or %o5, %lo(.LLC1), %o0
      mov %l2, %o1
      call printf, 0
      nop
      ret
      restore
      .size range, .-range

      .align 4
      .global approxSqrtAll
      .type approxSqrtAll, #function
      .proc 04
approxSqrtAll:
      save %sp, -112, %sp
      mov %i0, %l0
      set 0, %l1
      cmp %l0, %l1
      set 0, %l1
      movne %icc, 1, %l1
      cmp %l1, 1
      be TAG22
      nop
      ba TAG24
      nop
TAG22:
      ldsw [%l0+0], %l1
      mov %l1, %o0
      call approxSqrt
      nop
      mov %o0, %l1
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
      be TAG22
      nop
      ba TAG24
      nop
TAG24:
      ret
      restore
      .size approxSqrtAll, .-approxSqrtAll

      .align 4
      .global approxSqrt
      .type approxSqrt, #function
      .proc 04
approxSqrt:
      save %sp, -112, %sp
      mov %i0, %l0
      set 1, %l2
      mov %l2, %l1
      set 0, %l3
      cmp %l3, %l0
      set 0, %l3
      movl %icc, 1, %l3
      cmp %l3, 1
      be TAG16
      nop
      ba TAG18
      nop
TAG16:
      sra %l1, %g0, %o5
      sra %l1, %g0, %o4
      mulx %o5, %o4, %l3
      mov %l1, %l2
      add %l1, 1, %l1
      cmp %l3, %l0
      set 0, %l3
      movl %icc, 1, %l3
      cmp %l3, 1
      be TAG16
      nop
      ba TAG18
      nop
TAG18:
      mov %l2, %i0
      ret
      restore
      .size approxSqrt, .-approxSqrt

      .align 4
      .global calcMean
      .type calcMean, #function
      .proc 04
calcMean:
      save %sp, -112, %sp
      mov %i0, %l1
      set 0, %l0
      set 0, %l2
      mov %l2, %l3
      set 0, %l2
      set 0, %l4
      cmp %l1, %l4
      set 0, %l4
      movne %icc, 1, %l4
      cmp %l4, 1
      be TAG8
      nop
      ba TAG10
      nop
TAG8:
      add %l3, 1, %l3
      ldsw [%l1+0], %l4
      add %l0, %l4, %l0
      ldsw [%l1+4], %l5
      mov %l5, %l1
      set 0, %l4
      cmp %l5, %l4
      set 0, %l4
      movne %icc, 1, %l4
      cmp %l4, 1
      be TAG8
      nop
      ba TAG10
      nop
TAG10:
      set 0, %l1
      cmp %l3, %l1
      set 0, %l1
      movne %icc, 1, %l1
      cmp %l1, 1
      be TAG11
      nop
      ba TAG12
      nop
TAG11:
      sra %l0, %g0, %o5
      sra %l3, %g0, %o4
      sdivx %o5, %o4, %l0
      mov %l0, %l2
      ba TAG12
      nop
TAG12:
      mov %l2, %i0
      ret
      restore
      .size calcMean, .-calcMean

      .align 4
      .global getRands
      .type getRands, #function
      .proc 04
getRands:
      save %sp, -112, %sp
      mov %i0, %l1
      mov %i1, %l2
      set 0, %l3
      sra %l1, %g0, %o5
      sra %l1, %g0, %o4
      mulx %o5, %o4, %l4
      mov 8, %o0
      call malloc
      nop
      mov %o0, %l6
      mov %l6, %l0
      stw %l4, [%l6+0]
      set 0, %l5
      stw %l5, [%l6+4]
      sub %l2, 1, %l5
      mov %l5, %l2
      set 0, %l6
      cmp %l5, %l6
      set 0, %l5
      movg %icc, 1, %l5
      cmp %l5, 1
      be TAG2
      nop
      ba TAG4
      nop
TAG2:
      sra %l4, %g0, %o5
      sra %l4, %g0, %o4
      mulx %o5, %o4, %l3
      sra %l3, %g0, %o5
      sra %l1, %g0, %o4
      sdivx %o5, %o4, %l3
      sra %l1, %g0, %o5
      sdivx %o5, 2, %l4
      sra %l3, %g0, %o5
      sra %l4, %g0, %o4
      mulx %o5, %o4, %l3
      add %l3, 1, %l4
      mov 8, %o0
      call malloc
      nop
      mov %o0, %l5
      mov %l5, %l3
      stw %l4, [%l5+0]
      stw %l0, [%l5+4]
      mov %l5, %l0
      sub %l2, 1, %l5
      mov %l5, %l2
      set 0, %l6
      cmp %l5, %l6
      set 0, %l5
      movg %icc, 1, %l5
      cmp %l5, 1
      be TAG2
      nop
      ba TAG4
      nop
TAG4:
      mov %l3, %i0
      ret
      restore
      .size getRands, .-getRands
