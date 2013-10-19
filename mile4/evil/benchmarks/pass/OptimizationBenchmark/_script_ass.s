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
      set 1, %l2
      mov %l2, %l0
      cmp %l2, %l1
      set 0, %l2
      movl %icc, 1, %l2
      cmp %l2, 1
      be TAG89
      nop
      ba TAG91
      nop
TAG89:
      call constantFolding
      nop
      mov %o0, %l2
      sethi %hi(.LLC1), %o5
      or %o5, %lo(.LLC1), %o0
      mov %l2, %o1
      call printf, 0
      nop
      call constantPropagation
      nop
      mov %o0, %l2
      sethi %hi(.LLC1), %o5
      or %o5, %lo(.LLC1), %o0
      mov %l2, %o1
      call printf, 0
      nop
      call deadCodeElimination
      nop
      mov %o0, %l2
      sethi %hi(.LLC1), %o5
      or %o5, %lo(.LLC1), %o0
      mov %l2, %o1
      call printf, 0
      nop
      call interProceduralOptimization
      nop
      mov %o0, %l2
      sethi %hi(.LLC1), %o5
      or %o5, %lo(.LLC1), %o0
      mov %l2, %o1
      call printf, 0
      nop
      call commonSubexpressionElimination
      nop
      mov %o0, %l2
      sethi %hi(.LLC1), %o5
      or %o5, %lo(.LLC1), %o0
      mov %l2, %o1
      call printf, 0
      nop
      call hoisting
      nop
      mov %o0, %l2
      sethi %hi(.LLC1), %o5
      or %o5, %lo(.LLC1), %o0
      mov %l2, %o1
      call printf, 0
      nop
      call doubleIf
      nop
      mov %o0, %l2
      sethi %hi(.LLC1), %o5
      or %o5, %lo(.LLC1), %o0
      mov %l2, %o1
      call printf, 0
      nop
      call integerDivide
      nop
      mov %o0, %l2
      sethi %hi(.LLC1), %o5
      or %o5, %lo(.LLC1), %o0
      mov %l2, %o1
      call printf, 0
      nop
      call association
      nop
      mov %o0, %l2
      sethi %hi(.LLC1), %o5
      or %o5, %lo(.LLC1), %o0
      mov %l2, %o1
      call printf, 0
      nop
      sra %l1, %g0, %o5
      sdivx %o5, 1000, %l2
      mov %l2, %o0
      call tailRecursion
      nop
      mov %o0, %l2
      sethi %hi(.LLC1), %o5
      or %o5, %lo(.LLC1), %o0
      mov %l2, %o1
      call printf, 0
      nop
      call unswitching
      nop
      mov %o0, %l2
      sethi %hi(.LLC1), %o5
      or %o5, %lo(.LLC1), %o0
      mov %l2, %o1
      call printf, 0
      nop
      mov %l1, %o0
      call randomCalculation
      nop
      mov %o0, %l2
      sethi %hi(.LLC1), %o5
      or %o5, %lo(.LLC1), %o0
      mov %l2, %o1
      call printf, 0
      nop
      sra %l1, %g0, %o5
      sdivx %o5, 5, %l2
      mov %l2, %o0
      call iterativeFibonacci
      nop
      mov %o0, %l2
      sethi %hi(.LLC1), %o5
      or %o5, %lo(.LLC1), %o0
      mov %l2, %o1
      call printf, 0
      nop
      sra %l1, %g0, %o5
      sdivx %o5, 1000, %l2
      mov %l2, %o0
      call recursiveFibonacci
      nop
      mov %o0, %l2
      sethi %hi(.LLC1), %o5
      or %o5, %lo(.LLC1), %o0
      mov %l2, %o1
      call printf, 0
      nop
      add %l0, 1, %l2
      mov %l2, %l0
      cmp %l2, %l1
      set 0, %l2
      movl %icc, 1, %l2
      cmp %l2, 1
      be TAG89
      nop
      ba TAG91
      nop
TAG91:
      set 9999, %l0
      sethi %hi(.LLC1), %o5
      or %o5, %lo(.LLC1), %o0
      mov %l0, %o1
      call printf, 0
      nop
      set 0, %l0
      mov %l0, %i0
      ret
      restore
      .size main, .-main
      .common global3,4,4
      .common global2,4,4
      .common global1,4,4
      .common readMePrzButDontTouch,4,4

      .align 4
      .global recursiveFibonacci
      .type recursiveFibonacci, #function
      .proc 04
recursiveFibonacci:
      save %sp, -112, %sp
      mov %i0, %l0
      set 0, %l1
      cmp %l0, %l1
      set 0, %l1
      movle %icc, 1, %l1
      set 1, %l2
      cmp %l0, %l2
      set 0, %l2
      move %icc, 1, %l2
      or %l1, %l2, %l1
      cmp %l1, 1
      be TAG83
      nop
      ba TAG84
      nop
TAG84:
      sub %l0, 1, %l1
      mov %l1, %o0
      call recursiveFibonacci
      nop
      mov %o0, %l1
      sub %l0, 2, %l0
      mov %l0, %o0
      call recursiveFibonacci
      nop
      mov %o0, %l0
      add %l1, %l0, %l0
      mov %l0, %i0
      ret
      restore
TAG83:
      mov %l0, %i0
      ret
      restore
TAG85:
      .size recursiveFibonacci, .-recursiveFibonacci

      .align 4
      .global iterativeFibonacci
      .type iterativeFibonacci, #function
      .proc 04
iterativeFibonacci:
      save %sp, -112, %sp
      mov %i0, %l0
      set -1, %l1
      set 1, %l2
      mov %l2, %l3
      set 0, %l4
      mov %l4, %l2
      cmp %l4, %l0
      set 0, %l4
      movl %icc, 1, %l4
      cmp %l4, 1
      be TAG77
      nop
      ba TAG79
      nop
TAG77:
      add %l3, %l1, %l4
      mov %l3, %l1
      mov %l4, %l3
      add %l2, 1, %l4
      mov %l4, %l2
      cmp %l4, %l0
      set 0, %l4
      movl %icc, 1, %l4
      cmp %l4, 1
      be TAG77
      nop
      ba TAG79
      nop
TAG79:
      mov %l3, %i0
      ret
      restore
      .size iterativeFibonacci, .-iterativeFibonacci

      .align 4
      .global randomCalculation
      .type randomCalculation, #function
      .proc 04
randomCalculation:
      save %sp, -112, %sp
      mov %i0, %l0
      set 0, %l3
      mov %l3, %l2
      set 0, %l1
      cmp %l3, %l0
      set 0, %l3
      movl %icc, 1, %l3
      cmp %l3, 1
      be TAG71
      nop
      ba TAG73
      nop
TAG71:
      set 4, %l4
      set 7, %l5
      set 8, %l3
      add %l4, %l5, %l4
      add %l4, %l3, %l3
      add %l1, %l3, %l1
      sra %l2, %g0, %o5
      mulx %o5, 2, %l2
      sra %l2, %g0, %o5
      sdivx %o5, 2, %l2
      sra %l2, %g0, %o5
      mulx %o5, 3, %l2
      sra %l2, %g0, %o5
      sdivx %o5, 3, %l2
      sra %l2, %g0, %o5
      mulx %o5, 4, %l2
      sra %l2, %g0, %o5
      sdivx %o5, 4, %l2
      add %l2, 1, %l3
      mov %l3, %l2
      cmp %l3, %l0
      set 0, %l3
      movl %icc, 1, %l3
      cmp %l3, 1
      be TAG71
      nop
      ba TAG73
      nop
TAG73:
      mov %l1, %i0
      ret
      restore
      .size randomCalculation, .-randomCalculation

      .align 4
      .global unswitching
      .type unswitching, #function
      .proc 04
unswitching:
      save %sp, -112, %sp
      set 1, %l2
      mov %l2, %l1
      set 2, %l0
      set 1000000, %l3
      cmp %l2, %l3
      set 0, %l2
      movl %icc, 1, %l2
      cmp %l2, 1
      be TAG62
      nop
      ba TAG67
      nop
TAG62:
      set 2, %l2
      cmp %l0, %l2
      set 0, %l2
      move %icc, 1, %l2
      cmp %l2, 1
      be TAG63
      nop
      ba TAG64
      nop
TAG64:
      add %l1, 2, %l1
      ba TAG65
      nop
TAG63:
      add %l1, 1, %l1
      ba TAG65
      nop
TAG65:
      set 1000000, %l2
      cmp %l1, %l2
      set 0, %l2
      movl %icc, 1, %l2
      cmp %l2, 1
      be TAG62
      nop
      ba TAG67
      nop
TAG67:
      mov %l1, %i0
      ret
      restore
      .size unswitching, .-unswitching

      .align 4
      .global tailRecursion
      .type tailRecursion, #function
      .proc 04
tailRecursion:
      save %sp, -112, %sp
      mov %i0, %l0
      set 0, %l1
      mov %l0, %o0
      mov %l1, %o1
      call tailRecursionHelper
      nop
      mov %o0, %l0
      mov %l0, %i0
      ret
      restore
      .size tailRecursion, .-tailRecursion

      .align 4
      .global tailRecursionHelper
      .type tailRecursionHelper, #function
      .proc 04
tailRecursionHelper:
      save %sp, -112, %sp
      mov %i0, %l0
      mov %i1, %l1
      set 0, %l2
      cmp %l0, %l2
      set 0, %l2
      move %icc, 1, %l2
      cmp %l2, 1
      be TAG53
      nop
      ba TAG54
      nop
TAG54:
      sub %l0, 1, %l2
      add %l1, %l0, %l0
      mov %l2, %o0
      mov %l0, %o1
      call tailRecursionHelper
      nop
      mov %o0, %l0
      mov %l0, %i0
      ret
      restore
TAG53:
      mov %l1, %i0
      ret
      restore
TAG55:
      .size tailRecursionHelper, .-tailRecursionHelper

      .align 4
      .global association
      .type association, #function
      .proc 04
association:
      save %sp, -112, %sp
      set 10, %l0
      sra %l0, %g0, %o5
      mulx %o5, 2, %l0
      sra %l0, %g0, %o5
      sdivx %o5, 2, %l0
      sra %l0, %g0, %o5
      mulx %o5, 3, %l0
      sra %l0, %g0, %o5
      sdivx %o5, 3, %l0
      sra %l0, %g0, %o5
      mulx %o5, 4, %l0
      sra %l0, %g0, %o5
      sdivx %o5, 4, %l0
      add %l0, 4, %l0
      sub %l0, 4, %l0
      sra %l0, %g0, %o5
      mulx %o5, 50, %l0
      sra %l0, %g0, %o5
      sdivx %o5, 50, %l0
      mov %l0, %i0
      ret
      restore
      .size association, .-association

      .align 4
      .global integerDivide
      .type integerDivide, #function
      .proc 04
integerDivide:
      save %sp, -112, %sp
      set 3000, %l0
      sra %l0, %g0, %o5
      sdivx %o5, 2, %l0
      sra %l0, %g0, %o5
      mulx %o5, 4, %l0
      sra %l0, %g0, %o5
      sdivx %o5, 8, %l0
      sra %l0, %g0, %o5
      sdivx %o5, 16, %l0
      sra %l0, %g0, %o5
      mulx %o5, 32, %l0
      sra %l0, %g0, %o5
      sdivx %o5, 64, %l0
      sra %l0, %g0, %o5
      mulx %o5, 128, %l0
      sra %l0, %g0, %o5
      sdivx %o5, 4, %l0
      mov %l0, %i0
      ret
      restore
      .size integerDivide, .-integerDivide

      .align 4
      .global doubleIf
      .type doubleIf, #function
      .proc 04
doubleIf:
      save %sp, -112, %sp
      set 1, %l0
      set 1, %l2
      cmp %l0, %l2
      set 0, %l2
      move %icc, 1, %l2
      cmp %l2, 1
      be TAG39
      nop
      ba TAG43
      nop
TAG39:
      set 1, %l1
      cmp %l0, %l1
      set 0, %l0
      move %icc, 1, %l0
      cmp %l0, 1
      be TAG40
      nop
      ba TAG41
      nop
TAG41:
      ba TAG42
      nop
TAG40:
      ba TAG42
      nop
TAG42:
      set 50, %l0
      mov %l0, %l1
      ba TAG43
      nop
TAG43:
      mov %l1, %i0
      ret
      restore
      .size doubleIf, .-doubleIf

      .align 4
      .global hoisting
      .type hoisting, #function
      .proc 04
hoisting:
      save %sp, -112, %sp
      set 2, %l0
      set 0, %l2
      mov %l2, %l1
      set 1000000, %l3
      cmp %l2, %l3
      set 0, %l2
      movl %icc, 1, %l2
      cmp %l2, 1
      be TAG33
      nop
      ba TAG35
      nop
TAG33:
      add %l1, 1, %l2
      mov %l2, %l1
      set 1000000, %l3
      cmp %l2, %l3
      set 0, %l2
      movl %icc, 1, %l2
      cmp %l2, 1
      be TAG33
      nop
      ba TAG35
      nop
TAG35:
      mov %l0, %i0
      ret
      restore
      .size hoisting, .-hoisting

      .align 4
      .global commonSubexpressionElimination
      .type commonSubexpressionElimination, #function
      .proc 04
commonSubexpressionElimination:
      save %sp, -192, %sp
      set 11, %o5
      st %o5, [%fp+140]
      set 22, %o5
      st %o5, [%fp+136]
      set 33, %o5
      st %o5, [%fp+128]
      set 44, %o5
      st %o5, [%fp+124]
      set 55, %o5
      st %o5, [%fp+120]
      set 66, %o5
      st %o5, [%fp+116]
      set 77, %o5
      st %o5, [%fp+108]
      ld [%fp+140], %o5
      ld [%fp+136], %o4
      sra %o5, %g0, %o5
      sra %o4, %g0, %o4
      mulx %o5, %o4, %o3
      st %o3, [%fp+104]
      ld [%fp+128], %o5
      ld [%fp+124], %o4
      sra %o5, %g0, %o5
      sra %o4, %g0, %o4
      sdivx %o5, %o4, %o3
      st %o3, [%fp+100]
      ld [%fp+120], %o5
      ld [%fp+116], %o4
      sra %o5, %g0, %o5
      sra %o4, %g0, %o4
      mulx %o5, %o4, %o3
      st %o3, [%fp+96]
      ld [%fp+140], %o5
      ld [%fp+136], %o4
      sra %o5, %g0, %o5
      sra %o4, %g0, %o4
      mulx %o5, %o4, %l0
      ld [%fp+128], %o5
      ld [%fp+124], %o4
      sra %o5, %g0, %o5
      sra %o4, %g0, %o4
      sdivx %o5, %o4, %l1
      add %l0, %l1, %l0
      ld [%fp+120], %o5
      ld [%fp+116], %o4
      sra %o5, %g0, %o5
      sra %o4, %g0, %o4
      mulx %o5, %o4, %l1
      sub %l0, %l1, %l0
      ld [%fp+108], %o4
      add %l0, %o4, %o3
      st %o3, [%fp+112]
      ld [%fp+140], %o5
      ld [%fp+136], %o4
      sra %o5, %g0, %o5
      sra %o4, %g0, %o4
      mulx %o5, %o4, %l1
      ld [%fp+128], %o5
      ld [%fp+124], %o4
      sra %o5, %g0, %o5
      sra %o4, %g0, %o4
      sdivx %o5, %o4, %l0
      add %l1, %l0, %l1
      ld [%fp+120], %o5
      ld [%fp+116], %o4
      sra %o5, %g0, %o5
      sra %o4, %g0, %o4
      mulx %o5, %o4, %l0
      sub %l1, %l0, %l0
      ld [%fp+108], %o4
      add %l0, %o4, %o3
      st %o3, [%fp+132]
      ld [%fp+140], %o5
      ld [%fp+136], %o4
      sra %o5, %g0, %o5
      sra %o4, %g0, %o4
      mulx %o5, %o4, %l1
      ld [%fp+128], %o5
      ld [%fp+124], %o4
      sra %o5, %g0, %o5
      sra %o4, %g0, %o4
      sdivx %o5, %o4, %l0
      add %l1, %l0, %l1
      ld [%fp+120], %o5
      ld [%fp+116], %o4
      sra %o5, %g0, %o5
      sra %o4, %g0, %o4
      mulx %o5, %o4, %l0
      sub %l1, %l0, %l0
      ld [%fp+108], %o4
      add %l0, %o4, %o3
      st %o3, [%fp+144]
      ld [%fp+140], %o5
      ld [%fp+136], %o4
      sra %o5, %g0, %o5
      sra %o4, %g0, %o4
      mulx %o5, %o4, %l1
      ld [%fp+128], %o5
      ld [%fp+124], %o4
      sra %o5, %g0, %o5
      sra %o4, %g0, %o4
      sdivx %o5, %o4, %l0
      add %l1, %l0, %l1
      ld [%fp+120], %o5
      ld [%fp+116], %o4
      sra %o5, %g0, %o5
      sra %o4, %g0, %o4
      mulx %o5, %o4, %l0
      sub %l1, %l0, %l0
      ld [%fp+108], %o4
      add %l0, %o4, %o3
      st %o3, [%fp+148]
      ld [%fp+140], %o5
      ld [%fp+136], %o4
      sra %o5, %g0, %o5
      sra %o4, %g0, %o4
      mulx %o5, %o4, %l1
      ld [%fp+128], %o5
      ld [%fp+124], %o4
      sra %o5, %g0, %o5
      sra %o4, %g0, %o4
      sdivx %o5, %o4, %l0
      add %l1, %l0, %l1
      ld [%fp+120], %o5
      ld [%fp+116], %o4
      sra %o5, %g0, %o5
      sra %o4, %g0, %o4
      mulx %o5, %o4, %l0
      sub %l1, %l0, %l0
      ld [%fp+108], %o4
      add %l0, %o4, %o3
      st %o3, [%fp+152]
      ld [%fp+140], %o5
      ld [%fp+136], %o4
      sra %o5, %g0, %o5
      sra %o4, %g0, %o4
      mulx %o5, %o4, %l1
      ld [%fp+128], %o5
      ld [%fp+124], %o4
      sra %o5, %g0, %o5
      sra %o4, %g0, %o4
      sdivx %o5, %o4, %l0
      add %l1, %l0, %l0
      ld [%fp+120], %o5
      ld [%fp+116], %o4
      sra %o5, %g0, %o5
      sra %o4, %g0, %o4
      mulx %o5, %o4, %l1
      sub %l0, %l1, %l0
      ld [%fp+108], %o4
      add %l0, %o4, %o3
      st %o3, [%fp+156]
      ld [%fp+140], %o5
      ld [%fp+136], %o4
      sra %o5, %g0, %o5
      sra %o4, %g0, %o4
      mulx %o5, %o4, %l0
      ld [%fp+128], %o5
      ld [%fp+124], %o4
      sra %o5, %g0, %o5
      sra %o4, %g0, %o4
      sdivx %o5, %o4, %l1
      add %l0, %l1, %l0
      ld [%fp+120], %o5
      ld [%fp+116], %o4
      sra %o5, %g0, %o5
      sra %o4, %g0, %o4
      mulx %o5, %o4, %l1
      sub %l0, %l1, %l0
      ld [%fp+108], %o4
      add %l0, %o4, %o3
      st %o3, [%fp+160]
      ld [%fp+140], %o5
      ld [%fp+136], %o4
      sra %o5, %g0, %o5
      sra %o4, %g0, %o4
      mulx %o5, %o4, %l0
      ld [%fp+128], %o5
      ld [%fp+124], %o4
      sra %o5, %g0, %o5
      sra %o4, %g0, %o4
      sdivx %o5, %o4, %l1
      add %l0, %l1, %l0
      ld [%fp+120], %o5
      ld [%fp+116], %o4
      sra %o5, %g0, %o5
      sra %o4, %g0, %o4
      mulx %o5, %o4, %l1
      sub %l0, %l1, %l0
      ld [%fp+108], %o4
      add %l0, %o4, %o3
      st %o3, [%fp+164]
      ld [%fp+140], %o5
      ld [%fp+136], %o4
      sra %o5, %g0, %o5
      sra %o4, %g0, %o4
      mulx %o5, %o4, %l1
      ld [%fp+128], %o5
      ld [%fp+124], %o4
      sra %o5, %g0, %o5
      sra %o4, %g0, %o4
      sdivx %o5, %o4, %l0
      add %l1, %l0, %l0
      ld [%fp+120], %o5
      ld [%fp+116], %o4
      sra %o5, %g0, %o5
      sra %o4, %g0, %o4
      mulx %o5, %o4, %l1
      sub %l0, %l1, %l0
      ld [%fp+108], %o4
      add %l0, %o4, %o3
      st %o3, [%fp+168]
      ld [%fp+140], %o5
      ld [%fp+136], %o4
      sra %o5, %g0, %o5
      sra %o4, %g0, %o4
      mulx %o5, %o4, %l1
      ld [%fp+128], %o5
      ld [%fp+124], %o4
      sra %o5, %g0, %o5
      sra %o4, %g0, %o4
      sdivx %o5, %o4, %l0
      add %l1, %l0, %l0
      ld [%fp+120], %o5
      ld [%fp+116], %o4
      sra %o5, %g0, %o5
      sra %o4, %g0, %o4
      mulx %o5, %o4, %l1
      sub %l0, %l1, %l0
      ld [%fp+108], %o4
      add %l0, %o4, %l0
      ld [%fp+140], %o5
      ld [%fp+136], %o4
      sra %o5, %g0, %o5
      sra %o4, %g0, %o4
      mulx %o5, %o4, %l2
      ld [%fp+128], %o5
      ld [%fp+124], %o4
      sra %o5, %g0, %o5
      sra %o4, %g0, %o4
      sdivx %o5, %o4, %l1
      add %l2, %l1, %l2
      ld [%fp+120], %o5
      ld [%fp+116], %o4
      sra %o5, %g0, %o5
      sra %o4, %g0, %o4
      mulx %o5, %o4, %l1
      sub %l2, %l1, %l1
      ld [%fp+108], %o4
      add %l1, %o4, %l1
      ld [%fp+136], %o5
      ld [%fp+140], %o4
      sra %o5, %g0, %o5
      sra %o4, %g0, %o4
      mulx %o5, %o4, %l3
      ld [%fp+128], %o5
      ld [%fp+124], %o4
      sra %o5, %g0, %o5
      sra %o4, %g0, %o4
      sdivx %o5, %o4, %l2
      add %l3, %l2, %l2
      ld [%fp+120], %o5
      ld [%fp+116], %o4
      sra %o5, %g0, %o5
      sra %o4, %g0, %o4
      mulx %o5, %o4, %l3
      sub %l2, %l3, %l2
      ld [%fp+108], %o4
      add %l2, %o4, %l2
      ld [%fp+140], %o5
      ld [%fp+136], %o4
      sra %o5, %g0, %o5
      sra %o4, %g0, %o4
      mulx %o5, %o4, %l3
      ld [%fp+128], %o5
      ld [%fp+124], %o4
      sra %o5, %g0, %o5
      sra %o4, %g0, %o4
      sdivx %o5, %o4, %l4
      add %l3, %l4, %l3
      ld [%fp+116], %o5
      ld [%fp+120], %o4
      sra %o5, %g0, %o5
      sra %o4, %g0, %o4
      mulx %o5, %o4, %l4
      sub %l3, %l4, %l3
      ld [%fp+108], %o4
      add %l3, %o4, %l3
      ld [%fp+140], %o5
      ld [%fp+136], %o4
      sra %o5, %g0, %o5
      sra %o4, %g0, %o4
      mulx %o5, %o4, %l4
      ld [%fp+108], %o5
      add %o5, %l4, %l5
      ld [%fp+128], %o5
      ld [%fp+124], %o4
      sra %o5, %g0, %o5
      sra %o4, %g0, %o4
      sdivx %o5, %o4, %l4
      add %l5, %l4, %l5
      ld [%fp+120], %o5
      ld [%fp+116], %o4
      sra %o5, %g0, %o5
      sra %o4, %g0, %o4
      mulx %o5, %o4, %l4
      sub %l5, %l4, %l4
      ld [%fp+140], %o5
      ld [%fp+136], %o4
      sra %o5, %g0, %o5
      sra %o4, %g0, %o4
      mulx %o5, %o4, %l5
      ld [%fp+128], %o5
      ld [%fp+124], %o4
      sra %o5, %g0, %o5
      sra %o4, %g0, %o4
      sdivx %o5, %o4, %l6
      add %l5, %l6, %l6
      ld [%fp+120], %o5
      ld [%fp+116], %o4
      sra %o5, %g0, %o5
      sra %o4, %g0, %o4
      mulx %o5, %o4, %l5
      sub %l6, %l5, %l5
      ld [%fp+108], %o4
      add %l5, %o4, %l5
      ld [%fp+128], %o5
      ld [%fp+124], %o4
      sra %o5, %g0, %o5
      sra %o4, %g0, %o4
      sdivx %o5, %o4, %l7
      ld [%fp+140], %o5
      ld [%fp+136], %o4
      sra %o5, %g0, %o5
      sra %o4, %g0, %o4
      mulx %o5, %o4, %l6
      add %l7, %l6, %l7
      ld [%fp+120], %o5
      ld [%fp+116], %o4
      sra %o5, %g0, %o5
      sra %o4, %g0, %o4
      mulx %o5, %o4, %l6
      sub %l7, %l6, %l6
      ld [%fp+108], %o4
      add %l6, %o4, %l6
      ld [%fp+140], %o5
      ld [%fp+136], %o4
      add %o5, %o4, %l7
      ld [%fp+128], %o4
      add %l7, %o4, %l7
      ld [%fp+124], %o4
      add %l7, %o4, %l7
      ld [%fp+120], %o4
      add %l7, %o4, %l7
      ld [%fp+116], %o4
      add %l7, %o4, %l7
      ld [%fp+108], %o4
      add %l7, %o4, %l7
      ld [%fp+104], %o4
      add %l7, %o4, %l7
      ld [%fp+100], %o4
      add %l7, %o4, %l7
      ld [%fp+96], %o4
      add %l7, %o4, %l7
      ld [%fp+112], %o4
      add %l7, %o4, %l7
      ld [%fp+132], %o4
      add %l7, %o4, %l7
      ld [%fp+144], %o4
      add %l7, %o4, %l7
      ld [%fp+148], %o4
      add %l7, %o4, %l7
      ld [%fp+152], %o4
      add %l7, %o4, %l7
      ld [%fp+156], %o4
      add %l7, %o4, %l7
      ld [%fp+160], %o4
      add %l7, %o4, %l7
      ld [%fp+164], %o4
      add %l7, %o4, %l7
      ld [%fp+168], %o4
      add %l7, %o4, %l7
      add %l7, %l0, %l0
      add %l0, %l1, %l0
      add %l0, %l2, %l0
      add %l0, %l3, %l0
      add %l0, %l4, %l0
      add %l0, %l5, %l0
      add %l0, %l6, %l0
      mov %l0, %i0
      ret
      restore
      .size commonSubexpressionElimination, .-commonSubexpressionElimination

      .align 4
      .global interProceduralOptimization
      .type interProceduralOptimization, #function
      .proc 04
interProceduralOptimization:
      save %sp, -112, %sp
      set 1, %l0
      sethi %hi(global1), %o5
      or %o5, %lo(global1), %o5
      st %l0, [%o5]
      set 0, %l0
      sethi %hi(global2), %o5
      or %o5, %lo(global2), %o5
      st %l0, [%o5]
      set 0, %l0
      sethi %hi(global3), %o5
      or %o5, %lo(global3), %o5
      st %l0, [%o5]
      set 100, %l0
      mov %l0, %o0
      call sum
      nop
      mov %o0, %l0
      sethi %hi(global1), %o5
      or %o5, %lo(global1), %o5
      ld [%o5], %l1
      set 1, %l2
      cmp %l1, %l2
      set 0, %l1
      move %icc, 1, %l1
      cmp %l1, 1
      be TAG20
      nop
      ba TAG21
      nop
TAG21:
      sethi %hi(global2), %o5
      or %o5, %lo(global2), %o5
      ld [%o5], %l1
      set 2, %l2
      cmp %l1, %l2
      set 0, %l1
      move %icc, 1, %l1
      cmp %l1, 1
      be TAG22
      nop
      ba TAG23
      nop
TAG22:
      set 20000, %l0
      mov %l0, %o0
      call sum
      nop
      mov %o0, %l0
      ba TAG23
      nop
TAG23:
      sethi %hi(global3), %o5
      or %o5, %lo(global3), %o5
      ld [%o5], %l2
      set 3, %l1
      cmp %l2, %l1
      set 0, %l1
      move %icc, 1, %l1
      cmp %l1, 1
      be TAG24
      nop
      ba TAG25
      nop
TAG24:
      set 30000, %l0
      mov %l0, %o0
      call sum
      nop
      mov %o0, %l0
      ba TAG25
      nop
TAG25:
      ba TAG26
      nop
TAG20:
      set 10000, %l0
      mov %l0, %o0
      call sum
      nop
      mov %o0, %l0
      ba TAG26
      nop
TAG26:
      mov %l0, %i0
      ret
      restore
      .size interProceduralOptimization, .-interProceduralOptimization

      .align 4
      .global doesntModifyGlobals
      .type doesntModifyGlobals, #function
      .proc 04
doesntModifyGlobals:
      save %sp, -112, %sp
      set 1, %l0
      set 2, %l1
      add %l0, %l1, %l0
      mov %l0, %i0
      ret
      restore
      .size doesntModifyGlobals, .-doesntModifyGlobals

      .align 4
      .global sum
      .type sum, #function
      .proc 04
sum:
      save %sp, -112, %sp
      mov %i0, %l0
      set 0, %l1
      set 0, %l2
      cmp %l0, %l2
      set 0, %l2
      movg %icc, 1, %l2
      cmp %l2, 1
      be TAG11
      nop
      ba TAG13
      nop
TAG11:
      add %l1, %l0, %l1
      sub %l0, 1, %l2
      mov %l2, %l0
      set 0, %l3
      cmp %l2, %l3
      set 0, %l2
      movg %icc, 1, %l2
      cmp %l2, 1
      be TAG11
      nop
      ba TAG13
      nop
TAG13:
      mov %l1, %i0
      ret
      restore
      .size sum, .-sum

      .align 4
      .global deadCodeElimination
      .type deadCodeElimination, #function
      .proc 04
deadCodeElimination:
      save %sp, -112, %sp
      set 8, %l4
      set 8, %l3
      set 9, %l2
      set 3, %l1
      set 10, %l0
      set 11, %l5
      sethi %hi(global1), %o5
      or %o5, %lo(global1), %o5
      st %l5, [%o5]
      set 5, %l5
      sethi %hi(global1), %o5
      or %o5, %lo(global1), %o5
      st %l5, [%o5]
      set 9, %l5
      sethi %hi(global1), %o5
      or %o5, %lo(global1), %o5
      st %l5, [%o5]
      add %l4, %l3, %l3
      add %l3, %l2, %l2
      add %l2, %l1, %l1
      add %l1, %l0, %l0
      mov %l0, %i0
      ret
      restore
      .size deadCodeElimination, .-deadCodeElimination

      .align 4
      .global constantPropagation
      .type constantPropagation, #function
      .proc 04
constantPropagation:
      save %sp, -136, %sp
      set 4, %o5
      st %o5, [%fp+108]
      set 7, %o5
      st %o5, [%fp+112]
      set 8, %o5
      st %o5, [%fp+116]
      set 5, %o5
      st %o5, [%fp+100]
      set 11, %l2
      set 21, %l6
      ld [%fp+108], %o5
      ld [%fp+112], %o4
      add %o5, %o4, %l5
      ld [%fp+116], %o5
      ld [%fp+100], %o4
      add %o5, %o4, %l4
      add %l2, %l6, %l1
      add %l5, %l4, %l0
      sra %l1, %g0, %o5
      sra %l0, %g0, %o4
      mulx %o5, %o4, %o3
      st %o3, [%fp+96]
      sra %l4, %g0, %o5
      sra %l1, %g0, %o4
      mulx %o5, %o4, %l3
      add %l2, %l3, %l3
      ld [%fp+96], %o4
      sub %l3, %o4, %o3
      st %o3, [%fp+104]
      sra %l1, %g0, %o5
      sra %l0, %g0, %o4
      mulx %o5, %o4, %l3
      sub %l4, %l3, %l3
      ld [%fp+96], %o5
      ld [%fp+104], %o4
      sra %o5, %g0, %o5
      sra %o4, %g0, %o4
      sdivx %o5, %o4, %l7
      add %l3, %l7, %l3
      add %l2, %l6, %l6
      add %l6, %l5, %l6
      add %l6, %l4, %l6
      add %l6, %l1, %l6
      sub %l6, %l0, %l0
      sub %l0, %l3, %l3
      add %l3, %l4, %l3
      ld [%fp+108], %o4
      sub %l3, %o4, %l3
      ld [%fp+112], %o4
      sub %l3, %o4, %l3
      ld [%fp+96], %o5
      ld [%fp+104], %o4
      add %o5, %o4, %l6
      sub %l6, %l5, %l5
      sub %l5, %l4, %l4
      ld [%fp+104], %o5
      ld [%fp+116], %o4
      sra %o5, %g0, %o5
      sra %o4, %g0, %o4
      mulx %o5, %o4, %l5
      ld [%fp+100], %o4
      sra %l5, %g0, %o5
      sra %o4, %g0, %o4
      mulx %o5, %o4, %l5
      add %l5, %l3, %l5
      ld [%fp+112], %o5
      ld [%fp+108], %o4
      sra %o5, %g0, %o5
      sra %o4, %g0, %o4
      mulx %o5, %o4, %l6
      ld [%fp+116], %o4
      sra %l6, %g0, %o5
      sra %o4, %g0, %o4
      mulx %o5, %o4, %l6
      sra %l6, %g0, %o5
      sra %l2, %g0, %o4
      sdivx %o5, %o4, %l2
      sub %l2, %l3, %l2
      ld [%fp+96], %o4
      add %l1, %o4, %l1
      ld [%fp+116], %o4
      add %l1, %o4, %l1
      sub %l1, %l4, %l1
      ld [%fp+108], %o5
      ld [%fp+112], %o4
      sra %o5, %g0, %o5
      sra %o4, %g0, %o4
      mulx %o5, %o4, %l6
      ld [%fp+96], %o4
      sub %l6, %o4, %l6
      ld [%fp+104], %o4
      sub %l6, %o4, %l6
      sub %l6, %l2, %l2
      ld [%fp+100], %o4
      sra %l5, %g0, %o5
      sra %o4, %g0, %o4
      mulx %o5, %o4, %l5
      sub %l2, %l5, %l2
      sub %l3, %l2, %l3
      sub %l3, %l6, %l3
      sub %l3, %l0, %l0
      sra %l4, %g0, %o5
      sra %l0, %g0, %o4
      mulx %o5, %o4, %l3
      sra %l3, %g0, %o5
      sra %l1, %g0, %o4
      mulx %o5, %o4, %l1
      sub %l1, %l2, %l1
      sra %l0, %g0, %o5
      sra %l1, %g0, %o4
      mulx %o5, %o4, %l0
      sub %l2, %l0, %l0
      ld [%fp+96], %o4
      add %l0, %o4, %l0
      mov %l0, %i0
      ret
      restore
      .size constantPropagation, .-constantPropagation

      .align 4
      .global constantFolding
      .type constantFolding, #function
      .proc 04
constantFolding:
      save %sp, -112, %sp
      set 226, %l0
      mov %l0, %i0
      ret
      restore
      .size constantFolding, .-constantFolding
