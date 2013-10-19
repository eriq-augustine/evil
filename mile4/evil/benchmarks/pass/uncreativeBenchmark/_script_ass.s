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
      mov 40, %o0
      call malloc
      nop
      mov %o0, %l2
      mov %l2, %l0
      set 0, %l3
      stw %l3, [%l2+0]
      set 0, %l3
      stw %l3, [%l2+4]
      set 0, %l3
      stw %l3, [%l2+8]
      set 0, %l3
      stw %l3, [%l2+12]
      set 0, %l3
      stw %l3, [%l2+16]
      set 0, %l3
      stw %l3, [%l2+20]
      set 0, %l3
      stw %l3, [%l2+24]
      set 0, %l3
      stw %l3, [%l2+28]
      set 0, %l3
      stw %l3, [%l2+32]
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
      set 0, %l2
      cmp %l1, %l2
      set 0, %l2
      movne %icc, 1, %l2
      cmp %l2, 1
      be TAG41
      nop
      ba TAG67
      nop
TAG41:
      set 1, %l2
      cmp %l1, %l2
      set 0, %l2
      move %icc, 1, %l2
      cmp %l2, 1
      be TAG42
      nop
      ba TAG43
      nop
TAG43:
      set 2, %l2
      cmp %l1, %l2
      set 0, %l2
      move %icc, 1, %l2
      cmp %l2, 1
      be TAG44
      nop
      ba TAG45
      nop
TAG45:
      set 3, %l2
      cmp %l1, %l2
      set 0, %l2
      move %icc, 1, %l2
      cmp %l2, 1
      be TAG46
      nop
      ba TAG47
      nop
TAG47:
      set 4, %l2
      cmp %l1, %l2
      set 0, %l2
      move %icc, 1, %l2
      cmp %l2, 1
      be TAG48
      nop
      ba TAG49
      nop
TAG49:
      set 5, %l2
      cmp %l1, %l2
      set 0, %l2
      move %icc, 1, %l2
      cmp %l2, 1
      be TAG50
      nop
      ba TAG51
      nop
TAG51:
      set 6, %l2
      cmp %l1, %l2
      set 0, %l2
      move %icc, 1, %l2
      cmp %l2, 1
      be TAG52
      nop
      ba TAG53
      nop
TAG53:
      set 7, %l2
      cmp %l1, %l2
      set 0, %l2
      move %icc, 1, %l2
      cmp %l2, 1
      be TAG54
      nop
      ba TAG55
      nop
TAG55:
      set 8, %l2
      cmp %l1, %l2
      set 0, %l2
      move %icc, 1, %l2
      cmp %l2, 1
      be TAG56
      nop
      ba TAG57
      nop
TAG57:
      ldsw [%l0+32], %l2
      add %l2, 1, %l2
      stw %l2, [%l0+32]
      ba TAG65
      nop
TAG56:
      ldsw [%l0+28], %l2
      add %l2, 1, %l2
      stw %l2, [%l0+28]
      ba TAG65
      nop
TAG54:
      ldsw [%l0+24], %l2
      add %l2, 1, %l2
      stw %l2, [%l0+24]
      ba TAG65
      nop
TAG52:
      ldsw [%l0+20], %l2
      add %l2, 1, %l2
      stw %l2, [%l0+20]
      ba TAG65
      nop
TAG50:
      ldsw [%l0+16], %l2
      add %l2, 1, %l2
      stw %l2, [%l0+16]
      ba TAG65
      nop
TAG48:
      ldsw [%l0+12], %l2
      add %l2, 1, %l2
      stw %l2, [%l0+12]
      ba TAG65
      nop
TAG46:
      ldsw [%l0+8], %l2
      add %l2, 1, %l2
      stw %l2, [%l0+8]
      ba TAG65
      nop
TAG44:
      ldsw [%l0+4], %l2
      add %l2, 1, %l2
      stw %l2, [%l0+4]
      ba TAG65
      nop
TAG42:
      ldsw [%l0+0], %l2
      add %l2, 1, %l2
      stw %l2, [%l0+0]
      ba TAG65
      nop
TAG65:
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
      set 0, %l2
      cmp %l1, %l2
      set 0, %l2
      movne %icc, 1, %l2
      cmp %l2, 1
      be TAG41
      nop
      ba TAG67
      nop
TAG67:
      mov %l0, %o0
      call countTotal
      nop
      mov %o0, %l1
      sethi %hi(.LLC1), %o5
      or %o5, %lo(.LLC1), %o0
      mov %l1, %o1
      call printf, 0
      nop
      set 1, %l1
      mov %l1, %o0
      call convertBinary
      nop
      mov %o0, %l1
      ldsw [%l0+0], %l2
      mov %l1, %o0
      mov %l2, %o1
      call printRecursive
      nop
      set 2, %l1
      mov %l1, %o0
      call convertBinary
      nop
      mov %o0, %l2
      ldsw [%l0+4], %l1
      mov %l2, %o0
      mov %l1, %o1
      call printRecursive
      nop
      set 3, %l1
      mov %l1, %o0
      call convertBinary
      nop
      mov %o0, %l2
      ldsw [%l0+8], %l1
      mov %l2, %o0
      mov %l1, %o1
      call printRecursive
      nop
      set 4, %l1
      mov %l1, %o0
      call convertBinary
      nop
      mov %o0, %l2
      ldsw [%l0+12], %l1
      mov %l2, %o0
      mov %l1, %o1
      call printRecursive
      nop
      set 5, %l1
      mov %l1, %o0
      call convertBinary
      nop
      mov %o0, %l2
      ldsw [%l0+16], %l1
      mov %l2, %o0
      mov %l1, %o1
      call printRecursive
      nop
      set 6, %l1
      mov %l1, %o0
      call convertBinary
      nop
      mov %o0, %l2
      ldsw [%l0+20], %l1
      mov %l2, %o0
      mov %l1, %o1
      call printRecursive
      nop
      set 7, %l1
      mov %l1, %o0
      call convertBinary
      nop
      mov %o0, %l1
      ldsw [%l0+24], %l2
      mov %l1, %o0
      mov %l2, %o1
      call printRecursive
      nop
      set 8, %l1
      mov %l1, %o0
      call convertBinary
      nop
      mov %o0, %l1
      ldsw [%l0+28], %l2
      mov %l1, %o0
      mov %l2, %o1
      call printRecursive
      nop
      set 9, %l1
      mov %l1, %o0
      call convertBinary
      nop
      mov %o0, %l1
      ldsw [%l0+32], %l0
      mov %l1, %o0
      mov %l0, %o1
      call printRecursive
      nop
      set 0, %l0
      mov %l0, %i0
      ret
      restore
      .size main, .-main
      .common readMePrzButDontTouch,4,4

      .align 4
      .global convertBinary
      .type convertBinary, #function
      .proc 04
convertBinary:
      save %sp, -112, %sp
      mov %i0, %l0
      set 0, %l1
      cmp %l0, %l1
      set 0, %l1
      move %icc, 1, %l1
      cmp %l1, 1
      be TAG11
      nop
      ba TAG12
      nop
TAG12:
      set 1, %l1
      cmp %l0, %l1
      set 0, %l1
      move %icc, 1, %l1
      cmp %l1, 1
      be TAG13
      nop
      ba TAG14
      nop
TAG14:
      set 2, %l1
      cmp %l0, %l1
      set 0, %l1
      move %icc, 1, %l1
      cmp %l1, 1
      be TAG15
      nop
      ba TAG16
      nop
TAG16:
      set 3, %l1
      cmp %l0, %l1
      set 0, %l1
      move %icc, 1, %l1
      cmp %l1, 1
      be TAG17
      nop
      ba TAG18
      nop
TAG18:
      set 4, %l1
      cmp %l0, %l1
      set 0, %l1
      move %icc, 1, %l1
      cmp %l1, 1
      be TAG19
      nop
      ba TAG20
      nop
TAG20:
      set 5, %l1
      cmp %l0, %l1
      set 0, %l1
      move %icc, 1, %l1
      cmp %l1, 1
      be TAG21
      nop
      ba TAG22
      nop
TAG22:
      set 6, %l1
      cmp %l0, %l1
      set 0, %l1
      move %icc, 1, %l1
      cmp %l1, 1
      be TAG23
      nop
      ba TAG24
      nop
TAG24:
      set 7, %l1
      cmp %l0, %l1
      set 0, %l1
      move %icc, 1, %l1
      cmp %l1, 1
      be TAG25
      nop
      ba TAG26
      nop
TAG26:
      set 8, %l1
      cmp %l0, %l1
      set 0, %l0
      move %icc, 1, %l0
      cmp %l0, 1
      be TAG27
      nop
      ba TAG28
      nop
TAG28:
      set 1001, %l0
      mov %l0, %i0
      ret
      restore
TAG27:
      set 1000, %l0
      mov %l0, %i0
      ret
      restore
TAG25:
      set 111, %l0
      mov %l0, %i0
      ret
      restore
TAG23:
      set 110, %l0
      mov %l0, %i0
      ret
      restore
TAG21:
      set 101, %l0
      mov %l0, %i0
      ret
      restore
TAG19:
      set 100, %l0
      mov %l0, %i0
      ret
      restore
TAG17:
      set 11, %l0
      mov %l0, %i0
      ret
      restore
TAG15:
      set 10, %l0
      mov %l0, %i0
      ret
      restore
TAG13:
      set 1, %l0
      mov %l0, %i0
      ret
      restore
TAG11:
      set 0, %l0
      mov %l0, %i0
      ret
      restore
TAG37:
      .size convertBinary, .-convertBinary

      .align 4
      .global printRecursive
      .type printRecursive, #function
      .proc 04
printRecursive:
      save %sp, -112, %sp
      mov %i0, %l0
      mov %i1, %l1
      set 0, %l2
      cmp %l1, %l2
      set 0, %l2
      move %icc, 1, %l2
      cmp %l2, 1
      be TAG5
      nop
      ba TAG6
      nop
TAG6:
      sethi %hi(.LLC1), %o5
      or %o5, %lo(.LLC1), %o0
      mov %l0, %o1
      call printf, 0
      nop
      sub %l1, 1, %l1
      mov %l0, %o0
      mov %l1, %o1
      call printRecursive
      nop
      mov %o0, %l0
      mov %l0, %i0
      ret
      restore
TAG5:
      mov %l0, %i0
      ret
      restore
TAG7:
      .size printRecursive, .-printRecursive

      .align 4
      .global countTotal
      .type countTotal, #function
      .proc 04
countTotal:
      save %sp, -112, %sp
      mov %i0, %l0
      ldsw [%l0+0], %l1
      ldsw [%l0+4], %l2
      add %l1, %l2, %l1
      ldsw [%l0+8], %l2
      add %l1, %l2, %l2
      ldsw [%l0+12], %l1
      add %l2, %l1, %l1
      ldsw [%l0+16], %l2
      add %l1, %l2, %l2
      ldsw [%l0+20], %l1
      add %l2, %l1, %l2
      ldsw [%l0+24], %l1
      add %l2, %l1, %l2
      ldsw [%l0+28], %l1
      add %l2, %l1, %l1
      ldsw [%l0+32], %l0
      add %l1, %l0, %l0
      mov %l0, %i0
      ret
      restore
      .size countTotal, .-countTotal
