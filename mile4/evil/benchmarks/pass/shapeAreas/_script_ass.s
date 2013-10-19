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
      save %sp, -120, %sp
      mov 8, %o0
      call malloc
      nop
      mov %o0, %l2
      mov 8, %o0
      call malloc
      nop
      mov %o0, %l3
      mov 8, %o0
      call malloc
      nop
      mov %o0, %l4
      mov %l4, %l5
      set 1, %l6
      mov %l6, %l4
      set 0, %l7
      cmp %l6, %l7
      set 0, %l6
      movne %icc, 1, %l6
      cmp %l6, 1
      be TAG11
      nop
      ba TAG21
      nop
TAG11:
      sethi %hi(readMePrzButDontTouch), %o5
      or %o5, %lo(readMePrzButDontTouch), %o5
      st %l4, [%o5]
      sethi %hi(readMePrzButDontTouch), %o5
      or %o5, %lo(readMePrzButDontTouch), %o5
      mov %o5, %l4
      sethi %hi(.LLC2), %o5
      or %o5, %lo(.LLC2), %o0
      mov %l4, %o1
      call scanf
      nop
      sethi %hi(readMePrzButDontTouch), %o5
      or %o5, %lo(readMePrzButDontTouch), %o5
      ld [%o5], %l4
      set 0, %l6
      cmp %l4, %l6
      set 0, %l6
      movne %icc, 1, %l6
      cmp %l6, 1
      be TAG12
      nop
      ba TAG19
      nop
TAG12:
      set 1, %l6
      cmp %l4, %l6
      set 0, %l6
      move %icc, 1, %l6
      cmp %l6, 1
      be TAG13
      nop
      ba TAG14
      nop
TAG14:
      set 2, %l6
      cmp %l4, %l6
      set 0, %l6
      move %icc, 1, %l6
      cmp %l6, 1
      be TAG15
      nop
      ba TAG16
      nop
TAG16:
      ld [%fp+96], %o4
      sethi %hi(readMePrzButDontTouch), %o5
      or %o5, %lo(readMePrzButDontTouch), %o5
      st %o4, [%o5]
      sethi %hi(readMePrzButDontTouch), %o5
      or %o5, %lo(readMePrzButDontTouch), %o5
      mov %o5, %o4
      st %o4, [%fp+96]
      ld [%fp+96], %o4
      sethi %hi(.LLC2), %o5
      or %o5, %lo(.LLC2), %o0
      mov %o4, %o1
      call scanf
      nop
      sethi %hi(readMePrzButDontTouch), %o5
      or %o5, %lo(readMePrzButDontTouch), %o5
      ld [%o5], %o4
      st %o4, [%fp+96]
      ld [%fp+96], %o5
      stw %o5, [%l2+0]
      ld [%fp+100], %o4
      sethi %hi(readMePrzButDontTouch), %o5
      or %o5, %lo(readMePrzButDontTouch), %o5
      st %o4, [%o5]
      sethi %hi(readMePrzButDontTouch), %o5
      or %o5, %lo(readMePrzButDontTouch), %o5
      mov %o5, %o4
      st %o4, [%fp+100]
      ld [%fp+100], %o4
      sethi %hi(.LLC2), %o5
      or %o5, %lo(.LLC2), %o0
      mov %o4, %o1
      call scanf
      nop
      sethi %hi(readMePrzButDontTouch), %o5
      or %o5, %lo(readMePrzButDontTouch), %o5
      ld [%o5], %o4
      st %o4, [%fp+100]
      ld [%fp+100], %o5
      stw %o5, [%l2+4]
      mov %l2, %o0
      call areaRectangle
      nop
      mov %o0, %l6
      sethi %hi(.LLC1), %o5
      or %o5, %lo(.LLC1), %o0
      mov %l6, %o1
      call printf, 0
      nop
      ba TAG19
      nop
TAG15:
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
      stw %l0, [%l5+0]
      mov %l5, %o0
      call areaSquare
      nop
      mov %o0, %l6
      sethi %hi(.LLC1), %o5
      or %o5, %lo(.LLC1), %o0
      mov %l6, %o1
      call printf, 0
      nop
      ba TAG19
      nop
TAG13:
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
      stw %l1, [%l3+0]
      mov %l3, %o0
      call areaCircle
      nop
      mov %o0, %l6
      sethi %hi(.LLC1), %o5
      or %o5, %lo(.LLC1), %o0
      mov %l6, %o1
      call printf, 0
      nop
      ba TAG19
      nop
TAG19:
      set 0, %l6
      cmp %l4, %l6
      set 0, %l6
      movne %icc, 1, %l6
      cmp %l6, 1
      be TAG11
      nop
      ba TAG21
      nop
TAG21:
      set 0, %l0
      mov %l0, %i0
      ret
      restore
      .size main, .-main
      .common readMePrzButDontTouch,4,4

      .align 4
      .global areaSquare
      .type areaSquare, #function
      .proc 04
areaSquare:
      save %sp, -112, %sp
      mov %i0, %l1
      ldsw [%l1+0], %l0
      ldsw [%l1+0], %l1
      sra %l0, %g0, %o5
      sra %l1, %g0, %o4
      mulx %o5, %o4, %l0
      mov %l0, %i0
      ret
      restore
      .size areaSquare, .-areaSquare

      .align 4
      .global areaRectangle
      .type areaRectangle, #function
      .proc 04
areaRectangle:
      save %sp, -112, %sp
      mov %i0, %l1
      ldsw [%l1+0], %l0
      ldsw [%l1+4], %l1
      sra %l0, %g0, %o5
      sra %l1, %g0, %o4
      mulx %o5, %o4, %l0
      mov %l0, %i0
      ret
      restore
      .size areaRectangle, .-areaRectangle

      .align 4
      .global areaCircle
      .type areaCircle, #function
      .proc 04
areaCircle:
      save %sp, -112, %sp
      mov %i0, %l1
      ldsw [%l1+0], %l0
      ldsw [%l1+0], %l1
      sra %l0, %g0, %o5
      sra %l1, %g0, %o4
      mulx %o5, %o4, %l0
      sra %l0, %g0, %o5
      mulx %o5, 3, %l0
      mov %l0, %i0
      ret
      restore
      .size areaCircle, .-areaCircle
