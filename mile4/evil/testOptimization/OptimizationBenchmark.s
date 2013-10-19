!Sparc v9 Assembly file compiled by Evan Ralston and Eriq Augustine

      .file "OptimizationBenchmark.s"
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
      ba TAG88
      nop
TAG88:
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
      cmp %l1, %l0
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
      set 1000, %l2
      sra %l0, %g0, %o5
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
      mov %l0, %o0
      call randomCalculation
      nop
      mov %o0, %l2
      sethi %hi(.LLC1), %o5
      or %o5, %lo(.LLC1), %o0
      mov %l2, %o1
      call printf, 0
      nop
      set 5, %l2
      sra %l0, %g0, %o5
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
      set 1000, %l2
      sra %l0, %g0, %o5
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
      set 1, %l2
      add %l1, 1, %l1
      ba TAG90
      nop
TAG90:
      cmp %l1, %l0
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
      ba TAG92
      nop
TAG92:
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
      ba TAG82
      nop
TAG82:
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
      set 1, %l1
      sub %l0, 1, %l1
      mov %l1, %o0
      call recursiveFibonacci
      nop
      mov %o0, %l1
      set 2, %l2
      sub %l0, 2, %l0
      mov %l0, %o0
      call recursiveFibonacci
      nop
      mov %o0, %l0
      add %l1, %l0, %l0
      mov %l0, %i0
      ret
      restore
      ba TAG85
      nop
TAG83:
      mov %l0, %i0
      ret
      restore
      ba TAG85
      nop
TAG85:
      ba TAG86
      nop
TAG86:
      ret
      restore
      .size recursiveFibonacci, .-recursiveFibonacci

      .align 4
      .global iterativeFibonacci
      .type iterativeFibonacci, #function
      .proc 04
iterativeFibonacci:
      save %sp, -112, %sp
      mov %i0, %l0
      ba TAG76
      nop
TAG76:
      set 1, %l1
      set -1, %l1
      set 1, %l2
      set 0, %l3
      cmp %l3, %l0
      set 0, %l4
      movl %icc, 1, %l4
      cmp %l4, 1
      be TAG77
      nop
      ba TAG79
      nop
TAG77:
      add %l2, %l1, %l1
      mov %l1, %l4
      mov %l2, %l1
      mov %l4, %l2
      set 1, %l4
      add %l3, 1, %l3
      ba TAG78
      nop
TAG78:
      cmp %l3, %l0
      set 0, %l4
      movl %icc, 1, %l4
      cmp %l4, 1
      be TAG77
      nop
      ba TAG79
      nop
TAG79:
      mov %l2, %i0
      ret
      restore
      ba TAG80
      nop
TAG80:
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
      ba TAG70
      nop
TAG70:
      set 0, %l1
      mov %l1, %l2
      set 0, %l1
      cmp %l2, %l0
      set 0, %l3
      movl %icc, 1, %l3
      cmp %l3, 1
      be TAG71
      nop
      ba TAG73
      nop
TAG71:
      set 4, %l3
      set 7, %l4
      mov %l4, %l5
      set 8, %l4
      add %l3, %l5, %l3
      add %l3, %l4, %l3
      add %l1, %l3, %l1
      set 2, %l3
      sra %l2, %g0, %o5
      mulx %o5, 2, %l2
      set 2, %l3
      sra %l2, %g0, %o5
      sdivx %o5, 2, %l2
      set 3, %l3
      sra %l2, %g0, %o5
      mulx %o5, 3, %l2
      set 3, %l3
      sra %l2, %g0, %o5
      sdivx %o5, 3, %l2
      set 4, %l3
      sra %l2, %g0, %o5
      mulx %o5, 4, %l2
      set 4, %l3
      sra %l2, %g0, %o5
      sdivx %o5, 4, %l2
      set 1, %l3
      add %l2, 1, %l2
      ba TAG72
      nop
TAG72:
      cmp %l2, %l0
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
      ba TAG74
      nop
TAG74:
      ret
      restore
      .size randomCalculation, .-randomCalculation

      .align 4
      .global unswitching
      .type unswitching, #function
      .proc 04
unswitching:
      save %sp, -112, %sp
      ba TAG61
      nop
TAG61:
      set 1, %l0
      mov %l0, %l1
      set 2, %l0
      set 1000000, %l2
      cmp %l1, %l2
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
      set 2, %l2
      add %l1, 2, %l1
      ba TAG65
      nop
TAG63:
      set 1, %l2
      add %l1, 1, %l1
      ba TAG65
      nop
TAG65:
      ba TAG66
      nop
TAG66:
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
      ba TAG68
      nop
TAG68:
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
      ba TAG58
      nop
TAG58:
      set 0, %l1
      mov %l0, %o0
      mov %l1, %o1
      call tailRecursionHelper
      nop
      mov %o0, %l0
      mov %l0, %i0
      ret
      restore
      ba TAG59
      nop
TAG59:
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
      ba TAG52
      nop
TAG52:
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
      set 1, %l2
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
      ba TAG55
      nop
TAG53:
      mov %l1, %i0
      ret
      restore
      ba TAG55
      nop
TAG55:
      ba TAG56
      nop
TAG56:
      ret
      restore
      .size tailRecursionHelper, .-tailRecursionHelper

      .align 4
      .global association
      .type association, #function
      .proc 04
association:
      save %sp, -112, %sp
      ba TAG49
      nop
TAG49:
      set 10, %l0
      set 2, %l1
      sra %l0, %g0, %o5
      mulx %o5, 2, %l0
      set 2, %l1
      sra %l0, %g0, %o5
      sdivx %o5, 2, %l0
      set 3, %l1
      sra %l0, %g0, %o5
      mulx %o5, 3, %l0
      set 3, %l1
      sra %l0, %g0, %o5
      sdivx %o5, 3, %l0
      set 4, %l1
      sra %l0, %g0, %o5
      mulx %o5, 4, %l0
      set 4, %l1
      sra %l0, %g0, %o5
      sdivx %o5, 4, %l0
      set 4, %l1
      add %l0, 4, %l0
      set 4, %l1
      sub %l0, 4, %l0
      set 50, %l1
      sra %l0, %g0, %o5
      mulx %o5, 50, %l0
      set 50, %l1
      sra %l0, %g0, %o5
      sdivx %o5, 50, %l0
      mov %l0, %i0
      ret
      restore
      ba TAG50
      nop
TAG50:
      ret
      restore
      .size association, .-association

      .align 4
      .global integerDivide
      .type integerDivide, #function
      .proc 04
integerDivide:
      save %sp, -112, %sp
      ba TAG46
      nop
TAG46:
      set 3000, %l0
      set 2, %l1
      sra %l0, %g0, %o5
      sdivx %o5, 2, %l0
      set 4, %l1
      sra %l0, %g0, %o5
      mulx %o5, 4, %l0
      set 8, %l1
      sra %l0, %g0, %o5
      sdivx %o5, 8, %l0
      set 16, %l1
      sra %l0, %g0, %o5
      sdivx %o5, 16, %l0
      set 32, %l1
      sra %l0, %g0, %o5
      mulx %o5, 32, %l0
      set 64, %l1
      sra %l0, %g0, %o5
      sdivx %o5, 64, %l0
      set 128, %l1
      sra %l0, %g0, %o5
      mulx %o5, 128, %l0
      set 4, %l1
      sra %l0, %g0, %o5
      sdivx %o5, 4, %l0
      mov %l0, %i0
      ret
      restore
      ba TAG47
      nop
TAG47:
      ret
      restore
      .size integerDivide, .-integerDivide

      .align 4
      .global doubleIf
      .type doubleIf, #function
      .proc 04
doubleIf:
      save %sp, -112, %sp
      ba TAG38
      nop
TAG38:
      set 1, %l0
      set 2, %l2
      set 3, %l2
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
      set 20, %l1
      mov %l1, %l2
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
      set 1, %l0
      set 2, %l0
      mov %l0, %l2
      set 3, %l0
      mov %l0, %l2
      ba TAG42
      nop
TAG40:
      set 200, %l0
      mov %l0, %l2
      set 300, %l0
      mov %l0, %l2
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
      ba TAG44
      nop
TAG44:
      ret
      restore
      .size doubleIf, .-doubleIf

      .align 4
      .global hoisting
      .type hoisting, #function
      .proc 04
hoisting:
      save %sp, -112, %sp
      ba TAG32
      nop
TAG32:
      set 1, %l0
      set 2, %l1
      set 3, %l2
      set 4, %l3
      set 0, %l4
      set 1000000, %l5
      cmp %l4, %l5
      set 0, %l5
      movl %icc, 1, %l5
      cmp %l5, 1
      be TAG33
      nop
      ba TAG35
      nop
TAG33:
      set 5, %l5
      add %l0, %l1, %l5
      add %l5, %l2, %l5
      add %l2, %l3, %l6
      add %l6, %l5, %l5
      set 1, %l5
      add %l4, 1, %l4
      ba TAG34
      nop
TAG34:
      set 1000000, %l5
      cmp %l4, %l5
      set 0, %l5
      movl %icc, 1, %l5
      cmp %l5, 1
      be TAG33
      nop
      ba TAG35
      nop
TAG35:
      mov %l1, %i0
      ret
      restore
      ba TAG36
      nop
TAG36:
      ret
      restore
      .size hoisting, .-hoisting

      .align 4
      .global commonSubexpressionElimination
      .type commonSubexpressionElimination, #function
      .proc 04
commonSubexpressionElimination:
      save %sp, -192, %sp
      ba TAG29
      nop
TAG29:
      set 11, %l0
      mov %l0, %o4
      st %o4, [%fp+96]
      set 22, %l0
      mov %l0, %o4
      st %o4, [%fp+132]
      set 33, %l0
      mov %l0, %o4
      st %o4, [%fp+124]
      set 44, %l0
      mov %l0, %o4
      st %o4, [%fp+104]
      set 55, %l0
      mov %l0, %o4
      st %o4, [%fp+108]
      set 66, %l0
      mov %l0, %o4
      st %o4, [%fp+120]
      set 77, %l0
      mov %l0, %o4
      st %o4, [%fp+128]
      ld [%fp+96], %o5
      ld [%fp+132], %o4
      sra %o5, %g0, %o5
      sra %o4, %g0, %o4
      mulx %o5, %o4, %l0
      mov %l0, %o4
      st %o4, [%fp+100]
      ld [%fp+124], %o5
      ld [%fp+104], %o4
      sra %o5, %g0, %o5
      sra %o4, %g0, %o4
      sdivx %o5, %o4, %l0
      mov %l0, %o4
      st %o4, [%fp+116]
      ld [%fp+108], %o5
      ld [%fp+120], %o4
      sra %o5, %g0, %o5
      sra %o4, %g0, %o4
      mulx %o5, %o4, %l0
      mov %l0, %o4
      st %o4, [%fp+112]
      ld [%fp+96], %o5
      ld [%fp+132], %o4
      sra %o5, %g0, %o5
      sra %o4, %g0, %o4
      mulx %o5, %o4, %l0
      ld [%fp+124], %o5
      ld [%fp+104], %o4
      sra %o5, %g0, %o5
      sra %o4, %g0, %o4
      sdivx %o5, %o4, %l1
      add %l0, %l1, %l1
      ld [%fp+108], %o5
      ld [%fp+120], %o4
      sra %o5, %g0, %o5
      sra %o4, %g0, %o4
      mulx %o5, %o4, %l0
      sub %l1, %l0, %l0
      ld [%fp+128], %o4
      add %l0, %o4, %l0
      mov %l0, %o4
      st %o4, [%fp+136]
      ld [%fp+96], %o5
      ld [%fp+132], %o4
      sra %o5, %g0, %o5
      sra %o4, %g0, %o4
      mulx %o5, %o4, %l0
      ld [%fp+124], %o5
      ld [%fp+104], %o4
      sra %o5, %g0, %o5
      sra %o4, %g0, %o4
      sdivx %o5, %o4, %l1
      add %l0, %l1, %l0
      ld [%fp+108], %o5
      ld [%fp+120], %o4
      sra %o5, %g0, %o5
      sra %o4, %g0, %o4
      mulx %o5, %o4, %l1
      sub %l0, %l1, %l0
      ld [%fp+128], %o4
      add %l0, %o4, %l0
      mov %l0, %o4
      st %o4, [%fp+140]
      ld [%fp+96], %o5
      ld [%fp+132], %o4
      sra %o5, %g0, %o5
      sra %o4, %g0, %o4
      mulx %o5, %o4, %l1
      ld [%fp+124], %o5
      ld [%fp+104], %o4
      sra %o5, %g0, %o5
      sra %o4, %g0, %o4
      sdivx %o5, %o4, %l0
      add %l1, %l0, %l1
      ld [%fp+108], %o5
      ld [%fp+120], %o4
      sra %o5, %g0, %o5
      sra %o4, %g0, %o4
      mulx %o5, %o4, %l0
      sub %l1, %l0, %l0
      ld [%fp+128], %o4
      add %l0, %o4, %l0
      mov %l0, %o4
      st %o4, [%fp+144]
      ld [%fp+96], %o5
      ld [%fp+132], %o4
      sra %o5, %g0, %o5
      sra %o4, %g0, %o4
      mulx %o5, %o4, %l0
      ld [%fp+124], %o5
      ld [%fp+104], %o4
      sra %o5, %g0, %o5
      sra %o4, %g0, %o4
      sdivx %o5, %o4, %l1
      add %l0, %l1, %l0
      ld [%fp+108], %o5
      ld [%fp+120], %o4
      sra %o5, %g0, %o5
      sra %o4, %g0, %o4
      mulx %o5, %o4, %l1
      sub %l0, %l1, %l0
      ld [%fp+128], %o4
      add %l0, %o4, %l0
      mov %l0, %o4
      st %o4, [%fp+148]
      ld [%fp+96], %o5
      ld [%fp+132], %o4
      sra %o5, %g0, %o5
      sra %o4, %g0, %o4
      mulx %o5, %o4, %l0
      ld [%fp+124], %o5
      ld [%fp+104], %o4
      sra %o5, %g0, %o5
      sra %o4, %g0, %o4
      sdivx %o5, %o4, %l1
      add %l0, %l1, %l1
      ld [%fp+108], %o5
      ld [%fp+120], %o4
      sra %o5, %g0, %o5
      sra %o4, %g0, %o4
      mulx %o5, %o4, %l0
      sub %l1, %l0, %l0
      ld [%fp+128], %o4
      add %l0, %o4, %l0
      mov %l0, %o4
      st %o4, [%fp+152]
      ld [%fp+96], %o5
      ld [%fp+132], %o4
      sra %o5, %g0, %o5
      sra %o4, %g0, %o4
      mulx %o5, %o4, %l0
      ld [%fp+124], %o5
      ld [%fp+104], %o4
      sra %o5, %g0, %o5
      sra %o4, %g0, %o4
      sdivx %o5, %o4, %l1
      add %l0, %l1, %l0
      ld [%fp+108], %o5
      ld [%fp+120], %o4
      sra %o5, %g0, %o5
      sra %o4, %g0, %o4
      mulx %o5, %o4, %l1
      sub %l0, %l1, %l0
      ld [%fp+128], %o4
      add %l0, %o4, %l0
      mov %l0, %o4
      st %o4, [%fp+156]
      ld [%fp+96], %o5
      ld [%fp+132], %o4
      sra %o5, %g0, %o5
      sra %o4, %g0, %o4
      mulx %o5, %o4, %l0
      ld [%fp+124], %o5
      ld [%fp+104], %o4
      sra %o5, %g0, %o5
      sra %o4, %g0, %o4
      sdivx %o5, %o4, %l1
      add %l0, %l1, %l0
      ld [%fp+108], %o5
      ld [%fp+120], %o4
      sra %o5, %g0, %o5
      sra %o4, %g0, %o4
      mulx %o5, %o4, %l1
      sub %l0, %l1, %l0
      ld [%fp+128], %o4
      add %l0, %o4, %l0
      mov %l0, %o4
      st %o4, [%fp+160]
      ld [%fp+96], %o5
      ld [%fp+132], %o4
      sra %o5, %g0, %o5
      sra %o4, %g0, %o4
      mulx %o5, %o4, %l0
      ld [%fp+124], %o5
      ld [%fp+104], %o4
      sra %o5, %g0, %o5
      sra %o4, %g0, %o4
      sdivx %o5, %o4, %l1
      add %l0, %l1, %l1
      ld [%fp+108], %o5
      ld [%fp+120], %o4
      sra %o5, %g0, %o5
      sra %o4, %g0, %o4
      mulx %o5, %o4, %l0
      sub %l1, %l0, %l0
      ld [%fp+128], %o4
      add %l0, %o4, %l0
      mov %l0, %o4
      st %o4, [%fp+164]
      ld [%fp+96], %o5
      ld [%fp+132], %o4
      sra %o5, %g0, %o5
      sra %o4, %g0, %o4
      mulx %o5, %o4, %l1
      ld [%fp+124], %o5
      ld [%fp+104], %o4
      sra %o5, %g0, %o5
      sra %o4, %g0, %o4
      sdivx %o5, %o4, %l0
      add %l1, %l0, %l1
      ld [%fp+108], %o5
      ld [%fp+120], %o4
      sra %o5, %g0, %o5
      sra %o4, %g0, %o4
      mulx %o5, %o4, %l0
      sub %l1, %l0, %l0
      ld [%fp+128], %o4
      add %l0, %o4, %l0
      mov %l0, %o4
      st %o4, [%fp+168]
      ld [%fp+96], %o5
      ld [%fp+132], %o4
      sra %o5, %g0, %o5
      sra %o4, %g0, %o4
      mulx %o5, %o4, %l1
      ld [%fp+124], %o5
      ld [%fp+104], %o4
      sra %o5, %g0, %o5
      sra %o4, %g0, %o4
      sdivx %o5, %o4, %l0
      add %l1, %l0, %l0
      ld [%fp+108], %o5
      ld [%fp+120], %o4
      sra %o5, %g0, %o5
      sra %o4, %g0, %o4
      mulx %o5, %o4, %l1
      sub %l0, %l1, %l0
      ld [%fp+128], %o4
      add %l0, %o4, %l0
      ld [%fp+96], %o5
      ld [%fp+132], %o4
      sra %o5, %g0, %o5
      sra %o4, %g0, %o4
      mulx %o5, %o4, %l2
      ld [%fp+124], %o5
      ld [%fp+104], %o4
      sra %o5, %g0, %o5
      sra %o4, %g0, %o4
      sdivx %o5, %o4, %l1
      add %l2, %l1, %l1
      ld [%fp+108], %o5
      ld [%fp+120], %o4
      sra %o5, %g0, %o5
      sra %o4, %g0, %o4
      mulx %o5, %o4, %l2
      sub %l1, %l2, %l1
      ld [%fp+128], %o4
      add %l1, %o4, %l1
      ld [%fp+132], %o5
      ld [%fp+96], %o4
      sra %o5, %g0, %o5
      sra %o4, %g0, %o4
      mulx %o5, %o4, %l3
      ld [%fp+124], %o5
      ld [%fp+104], %o4
      sra %o5, %g0, %o5
      sra %o4, %g0, %o4
      sdivx %o5, %o4, %l2
      add %l3, %l2, %l2
      ld [%fp+108], %o5
      ld [%fp+120], %o4
      sra %o5, %g0, %o5
      sra %o4, %g0, %o4
      mulx %o5, %o4, %l3
      sub %l2, %l3, %l2
      ld [%fp+128], %o4
      add %l2, %o4, %l2
      ld [%fp+96], %o5
      ld [%fp+132], %o4
      sra %o5, %g0, %o5
      sra %o4, %g0, %o4
      mulx %o5, %o4, %l4
      ld [%fp+124], %o5
      ld [%fp+104], %o4
      sra %o5, %g0, %o5
      sra %o4, %g0, %o4
      sdivx %o5, %o4, %l3
      add %l4, %l3, %l4
      ld [%fp+120], %o5
      ld [%fp+108], %o4
      sra %o5, %g0, %o5
      sra %o4, %g0, %o4
      mulx %o5, %o4, %l3
      sub %l4, %l3, %l3
      ld [%fp+128], %o4
      add %l3, %o4, %l3
      ld [%fp+96], %o5
      ld [%fp+132], %o4
      sra %o5, %g0, %o5
      sra %o4, %g0, %o4
      mulx %o5, %o4, %l4
      ld [%fp+128], %o5
      add %o5, %l4, %l4
      ld [%fp+124], %o5
      ld [%fp+104], %o4
      sra %o5, %g0, %o5
      sra %o4, %g0, %o4
      sdivx %o5, %o4, %l5
      add %l4, %l5, %l4
      ld [%fp+108], %o5
      ld [%fp+120], %o4
      sra %o5, %g0, %o5
      sra %o4, %g0, %o4
      mulx %o5, %o4, %l5
      sub %l4, %l5, %l4
      ld [%fp+96], %o5
      ld [%fp+132], %o4
      sra %o5, %g0, %o5
      sra %o4, %g0, %o4
      mulx %o5, %o4, %l6
      ld [%fp+124], %o5
      ld [%fp+104], %o4
      sra %o5, %g0, %o5
      sra %o4, %g0, %o4
      sdivx %o5, %o4, %l5
      add %l6, %l5, %l6
      ld [%fp+108], %o5
      ld [%fp+120], %o4
      sra %o5, %g0, %o5
      sra %o4, %g0, %o4
      mulx %o5, %o4, %l5
      sub %l6, %l5, %l5
      ld [%fp+128], %o4
      add %l5, %o4, %l5
      ld [%fp+124], %o5
      ld [%fp+104], %o4
      sra %o5, %g0, %o5
      sra %o4, %g0, %o4
      sdivx %o5, %o4, %l7
      ld [%fp+96], %o5
      ld [%fp+132], %o4
      sra %o5, %g0, %o5
      sra %o4, %g0, %o4
      mulx %o5, %o4, %l6
      add %l7, %l6, %l7
      ld [%fp+108], %o5
      ld [%fp+120], %o4
      sra %o5, %g0, %o5
      sra %o4, %g0, %o4
      mulx %o5, %o4, %l6
      sub %l7, %l6, %l6
      ld [%fp+128], %o4
      add %l6, %o4, %l6
      ld [%fp+96], %o5
      ld [%fp+132], %o4
      add %o5, %o4, %l7
      ld [%fp+124], %o4
      add %l7, %o4, %l7
      ld [%fp+104], %o4
      add %l7, %o4, %l7
      ld [%fp+108], %o4
      add %l7, %o4, %l7
      ld [%fp+120], %o4
      add %l7, %o4, %l7
      ld [%fp+128], %o4
      add %l7, %o4, %l7
      ld [%fp+100], %o4
      add %l7, %o4, %l7
      ld [%fp+116], %o4
      add %l7, %o4, %l7
      ld [%fp+112], %o4
      add %l7, %o4, %l7
      ld [%fp+136], %o4
      add %l7, %o4, %l7
      ld [%fp+140], %o4
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
      ba TAG30
      nop
TAG30:
      ret
      restore
      .size commonSubexpressionElimination, .-commonSubexpressionElimination

      .align 4
      .global interProceduralOptimization
      .type interProceduralOptimization, #function
      .proc 04
interProceduralOptimization:
      save %sp, -112, %sp
      ba TAG19
      nop
TAG19:
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
      ld [%o5], %l2
      set 1, %l1
      cmp %l2, %l1
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
      ld [%o5], %l1
      set 3, %l2
      cmp %l1, %l2
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
      ba TAG27
      nop
TAG27:
      ret
      restore
      .size interProceduralOptimization, .-interProceduralOptimization

      .align 4
      .global doesntModifyGlobals
      .type doesntModifyGlobals, #function
      .proc 04
doesntModifyGlobals:
      save %sp, -112, %sp
      ba TAG16
      nop
TAG16:
      set 1, %l0
      set 2, %l1
      add %l0, %l1, %l0
      mov %l0, %i0
      ret
      restore
      ba TAG17
      nop
TAG17:
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
      ba TAG10
      nop
TAG10:
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
      set 1, %l2
      sub %l0, 1, %l0
      ba TAG12
      nop
TAG12:
      set 0, %l2
      cmp %l0, %l2
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
      ba TAG14
      nop
TAG14:
      ret
      restore
      .size sum, .-sum

      .align 4
      .global deadCodeElimination
      .type deadCodeElimination, #function
      .proc 04
deadCodeElimination:
      save %sp, -112, %sp
      ba TAG7
      nop
TAG7:
      set 4, %l0
      set 5, %l0
      set 7, %l0
      set 8, %l0
      set 6, %l1
      set 9, %l1
      set 12, %l1
      set 8, %l1
      set 10, %l2
      set 13, %l2
      set 9, %l2
      set 45, %l3
      set 12, %l3
      set 3, %l3
      set 23, %l4
      set 10, %l4
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
      add %l0, %l1, %l0
      add %l0, %l2, %l0
      add %l0, %l3, %l0
      add %l0, %l4, %l0
      mov %l0, %i0
      ret
      restore
      ba TAG8
      nop
TAG8:
      ret
      restore
      .size deadCodeElimination, .-deadCodeElimination

      .align 4
      .global constantPropagation
      .type constantPropagation, #function
      .proc 04
constantPropagation:
      save %sp, -144, %sp
      ba TAG4
      nop
TAG4:
      set 4, %l0
      mov %l0, %o4
      st %o4, [%fp+104]
      set 7, %l0
      mov %l0, %o4
      st %o4, [%fp+108]
      set 8, %l0
      mov %l0, %o4
      st %o4, [%fp+116]
      set 5, %l0
      mov %l0, %o4
      st %o4, [%fp+100]
      set 11, %l0
      mov %l0, %l1
      set 21, %l0
      mov %l0, %o4
      st %o4, [%fp+112]
      ld [%fp+104], %o5
      ld [%fp+108], %o4
      add %o5, %o4, %l0
      mov %l0, %l4
      ld [%fp+116], %o5
      ld [%fp+100], %o4
      add %o5, %o4, %l0
      mov %l0, %l5
      ld [%fp+112], %o4
      add %l1, %o4, %l0
      mov %l0, %l2
      add %l4, %l5, %l0
      sra %l2, %g0, %o5
      sra %l0, %g0, %o4
      mulx %o5, %o4, %l3
      mov %l3, %o4
      st %o4, [%fp+96]
      sra %l5, %g0, %o5
      sra %l2, %g0, %o4
      mulx %o5, %o4, %l3
      add %l1, %l3, %l3
      ld [%fp+96], %o4
      sub %l3, %o4, %l3
      mov %l3, %o4
      st %o4, [%fp+120]
      sra %l2, %g0, %o5
      sra %l0, %g0, %o4
      mulx %o5, %o4, %l3
      sub %l5, %l3, %l3
      ld [%fp+96], %o5
      ld [%fp+120], %o4
      sra %o5, %g0, %o5
      sra %o4, %g0, %o4
      sdivx %o5, %o4, %l6
      add %l3, %l6, %l3
      ld [%fp+112], %o4
      add %l1, %o4, %l6
      add %l6, %l4, %l6
      add %l6, %l5, %l6
      add %l6, %l2, %l6
      sub %l6, %l0, %l0
      sub %l0, %l3, %l3
      add %l3, %l5, %l3
      ld [%fp+104], %o4
      sub %l3, %o4, %l3
      ld [%fp+108], %o4
      sub %l3, %o4, %l3
      ld [%fp+96], %o5
      ld [%fp+120], %o4
      add %o5, %o4, %l6
      sub %l6, %l4, %l4
      sub %l4, %l5, %l4
      ld [%fp+108], %o5
      ld [%fp+104], %o4
      sub %o5, %o4, %l5
      ld [%fp+100], %o4
      sra %l5, %g0, %o5
      sra %o4, %g0, %o4
      mulx %o5, %o4, %l5
      sub %l5, %l2, %l5
      ld [%fp+120], %o5
      ld [%fp+116], %o4
      sra %o5, %g0, %o5
      sra %o4, %g0, %o4
      mulx %o5, %o4, %l5
      ld [%fp+100], %o4
      sra %l5, %g0, %o5
      sra %o4, %g0, %o4
      mulx %o5, %o4, %l5
      add %l5, %l3, %l5
      ld [%fp+108], %o5
      ld [%fp+104], %o4
      sra %o5, %g0, %o5
      sra %o4, %g0, %o4
      mulx %o5, %o4, %l6
      ld [%fp+116], %o4
      sra %l6, %g0, %o5
      sra %o4, %g0, %o4
      mulx %o5, %o4, %l6
      sra %l6, %g0, %o5
      sra %l1, %g0, %o4
      sdivx %o5, %o4, %l1
      sub %l1, %l3, %l1
      mov %l1, %l6
      ld [%fp+96], %o4
      add %l2, %o4, %l1
      ld [%fp+116], %o4
      add %l1, %o4, %l1
      sub %l1, %l4, %l1
      add %l0, %l3, %l2
      ld [%fp+112], %o5
      ld [%fp+104], %o4
      sra %o5, %g0, %o5
      sra %o4, %g0, %o4
      mulx %o5, %o4, %l7
      sub %l2, %l7, %l2
      ld [%fp+104], %o5
      ld [%fp+108], %o4
      sra %o5, %g0, %o5
      sra %o4, %g0, %o4
      mulx %o5, %o4, %l2
      ld [%fp+96], %o4
      sub %l2, %o4, %l2
      ld [%fp+120], %o4
      sub %l2, %o4, %l2
      mov %l2, %l7
      sub %l7, %l6, %l2
      ld [%fp+100], %o4
      sra %l5, %g0, %o5
      sra %o4, %g0, %o4
      mulx %o5, %o4, %l5
      sub %l2, %l5, %l2
      sub %l3, %l2, %l3
      sub %l3, %l7, %l3
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
      ba TAG5
      nop
TAG5:
      ret
      restore
      .size constantPropagation, .-constantPropagation

      .align 4
      .global constantFolding
      .type constantFolding, #function
      .proc 04
constantFolding:
      save %sp, -112, %sp
      ba TAG1
      nop
TAG1:
      set 8, %l0
      set 9, %l0
      set 72, %l0
      set 4, %l0
      set 18, %l0
      set 2, %l0
      set 20, %l0
      set 5, %l0
      set 8, %l0
      set 40, %l0
      set -20, %l0
      set 9, %l0
      set -11, %l0
      set 12, %l0
      set -23, %l0
      set 6, %l0
      set -17, %l0
      set 9, %l0
      set -26, %l0
      set 18, %l0
      set -44, %l0
      set 23, %l0
      set 3, %l0
      set 69, %l0
      set 23, %l0
      set 3, %l0
      set 90, %l0
      set 270, %l0
      set 226, %l0
      mov %l0, %i0
      ret
      restore
      ba TAG2
      nop
TAG2:
      ret
      restore
      .size constantFolding, .-constantFolding
