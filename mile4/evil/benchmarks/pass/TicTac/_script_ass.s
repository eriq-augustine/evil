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
      set 0, %l5
      mov %l5, %o4
      st %o4, [%fp+96]
      set 0, %l0
      mov %l0, %l2
      set 0, %l0
      set 0, %l1
      mov %l1, %l3
      set -1, %l6
      mov %l6, %l4
      mov 40, %o0
      call malloc
      nop
      mov %o0, %l7
      mov %l7, %l1
      mov %l7, %o0
      call cleanBoard
      nop
      set 0, %l7
      cmp %l6, %l7
      set 0, %l6
      movl %icc, 1, %l6
      set 8, %l7
      cmp %l5, %l7
      set 0, %l5
      movne %icc, 1, %l5
      and %l6, %l5, %l5
      cmp %l5, 1
      be TAG115
      nop
      ba TAG120
      nop
TAG115:
      mov %l1, %o0
      call printBoard
      nop
      set 0, %l4
      cmp %l2, %l4
      set 0, %l4
      move %icc, 1, %l4
      cmp %l4, 1
      be TAG116
      nop
      ba TAG117
      nop
TAG117:
      sub %l2, 1, %l2
      sethi %hi(readMePrzButDontTouch), %o5
      or %o5, %lo(readMePrzButDontTouch), %o5
      st %l3, [%o5]
      sethi %hi(readMePrzButDontTouch), %o5
      or %o5, %lo(readMePrzButDontTouch), %o5
      mov %o5, %l3
      sethi %hi(.LLC2), %o5
      or %o5, %lo(.LLC2), %o0
      mov %l3, %o1
      call scanf
      nop
      sethi %hi(readMePrzButDontTouch), %o5
      or %o5, %lo(readMePrzButDontTouch), %o5
      ld [%o5], %l3
      set 2, %l4
      mov %l1, %o0
      mov %l4, %o1
      mov %l3, %o2
      call placePiece
      nop
      ba TAG118
      nop
TAG116:
      add %l2, 1, %l2
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
      set 1, %l4
      mov %l1, %o0
      mov %l4, %o1
      mov %l0, %o2
      call placePiece
      nop
      ba TAG118
      nop
TAG118:
      mov %l1, %o0
      call checkWinner
      nop
      mov %o0, %l6
      mov %l6, %l4
      ld [%fp+96], %o5
      add %o5, 1, %l5
      mov %l5, %o4
      st %o4, [%fp+96]
      set 0, %l7
      cmp %l6, %l7
      set 0, %l6
      movl %icc, 1, %l6
      set 8, %l7
      cmp %l5, %l7
      set 0, %l5
      movne %icc, 1, %l5
      and %l6, %l5, %l5
      cmp %l5, 1
      be TAG115
      nop
      ba TAG120
      nop
TAG120:
      add %l4, 1, %l0
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
      .common readMePrzButDontTouch,4,4

      .align 4
      .global checkWinner
      .type checkWinner, #function
      .proc 04
checkWinner:
      save %sp, -112, %sp
      mov %i0, %l0
      ldsw [%l0+0], %l2
      set 1, %l1
      cmp %l2, %l1
      set 0, %l1
      move %icc, 1, %l1
      cmp %l1, 1
      be TAG40
      nop
      ba TAG45
      nop
TAG40:
      ldsw [%l0+4], %l1
      set 1, %l2
      cmp %l1, %l2
      set 0, %l1
      move %icc, 1, %l1
      cmp %l1, 1
      be TAG41
      nop
      ba TAG44
      nop
TAG41:
      ldsw [%l0+8], %l2
      set 1, %l1
      cmp %l2, %l1
      set 0, %l1
      move %icc, 1, %l1
      cmp %l1, 1
      be TAG42
      nop
      ba TAG43
      nop
TAG42:
      set 0, %l1
      mov %l1, %i0
      ret
      restore
      ba TAG43
      nop
TAG43:
      ba TAG44
      nop
TAG44:
      ba TAG45
      nop
TAG45:
      ldsw [%l0+0], %l2
      set 2, %l1
      cmp %l2, %l1
      set 0, %l1
      move %icc, 1, %l1
      cmp %l1, 1
      be TAG46
      nop
      ba TAG51
      nop
TAG46:
      ldsw [%l0+4], %l2
      set 2, %l1
      cmp %l2, %l1
      set 0, %l1
      move %icc, 1, %l1
      cmp %l1, 1
      be TAG47
      nop
      ba TAG50
      nop
TAG47:
      ldsw [%l0+8], %l1
      set 2, %l2
      cmp %l1, %l2
      set 0, %l1
      move %icc, 1, %l1
      cmp %l1, 1
      be TAG48
      nop
      ba TAG49
      nop
TAG48:
      set 1, %l1
      mov %l1, %i0
      ret
      restore
      ba TAG49
      nop
TAG49:
      ba TAG50
      nop
TAG50:
      ba TAG51
      nop
TAG51:
      ldsw [%l0+12], %l1
      set 1, %l2
      cmp %l1, %l2
      set 0, %l1
      move %icc, 1, %l1
      cmp %l1, 1
      be TAG52
      nop
      ba TAG57
      nop
TAG52:
      ldsw [%l0+16], %l2
      set 1, %l1
      cmp %l2, %l1
      set 0, %l1
      move %icc, 1, %l1
      cmp %l1, 1
      be TAG53
      nop
      ba TAG56
      nop
TAG53:
      ldsw [%l0+20], %l2
      set 1, %l1
      cmp %l2, %l1
      set 0, %l1
      move %icc, 1, %l1
      cmp %l1, 1
      be TAG54
      nop
      ba TAG55
      nop
TAG54:
      set 0, %l1
      mov %l1, %i0
      ret
      restore
      ba TAG55
      nop
TAG55:
      ba TAG56
      nop
TAG56:
      ba TAG57
      nop
TAG57:
      ldsw [%l0+12], %l2
      set 2, %l1
      cmp %l2, %l1
      set 0, %l1
      move %icc, 1, %l1
      cmp %l1, 1
      be TAG58
      nop
      ba TAG63
      nop
TAG58:
      ldsw [%l0+16], %l2
      set 2, %l1
      cmp %l2, %l1
      set 0, %l1
      move %icc, 1, %l1
      cmp %l1, 1
      be TAG59
      nop
      ba TAG62
      nop
TAG59:
      ldsw [%l0+20], %l1
      set 2, %l2
      cmp %l1, %l2
      set 0, %l1
      move %icc, 1, %l1
      cmp %l1, 1
      be TAG60
      nop
      ba TAG61
      nop
TAG60:
      set 1, %l1
      mov %l1, %i0
      ret
      restore
      ba TAG61
      nop
TAG61:
      ba TAG62
      nop
TAG62:
      ba TAG63
      nop
TAG63:
      ldsw [%l0+24], %l1
      set 1, %l2
      cmp %l1, %l2
      set 0, %l1
      move %icc, 1, %l1
      cmp %l1, 1
      be TAG64
      nop
      ba TAG69
      nop
TAG64:
      ldsw [%l0+28], %l1
      set 1, %l2
      cmp %l1, %l2
      set 0, %l1
      move %icc, 1, %l1
      cmp %l1, 1
      be TAG65
      nop
      ba TAG68
      nop
TAG65:
      ldsw [%l0+32], %l1
      set 1, %l2
      cmp %l1, %l2
      set 0, %l1
      move %icc, 1, %l1
      cmp %l1, 1
      be TAG66
      nop
      ba TAG67
      nop
TAG66:
      set 0, %l1
      mov %l1, %i0
      ret
      restore
      ba TAG67
      nop
TAG67:
      ba TAG68
      nop
TAG68:
      ba TAG69
      nop
TAG69:
      ldsw [%l0+24], %l2
      set 2, %l1
      cmp %l2, %l1
      set 0, %l1
      move %icc, 1, %l1
      cmp %l1, 1
      be TAG70
      nop
      ba TAG75
      nop
TAG70:
      ldsw [%l0+28], %l1
      set 2, %l2
      cmp %l1, %l2
      set 0, %l1
      move %icc, 1, %l1
      cmp %l1, 1
      be TAG71
      nop
      ba TAG74
      nop
TAG71:
      ldsw [%l0+32], %l1
      set 2, %l2
      cmp %l1, %l2
      set 0, %l1
      move %icc, 1, %l1
      cmp %l1, 1
      be TAG72
      nop
      ba TAG73
      nop
TAG72:
      set 1, %l1
      mov %l1, %i0
      ret
      restore
      ba TAG73
      nop
TAG73:
      ba TAG74
      nop
TAG74:
      ba TAG75
      nop
TAG75:
      ldsw [%l0+0], %l2
      set 1, %l1
      cmp %l2, %l1
      set 0, %l1
      move %icc, 1, %l1
      cmp %l1, 1
      be TAG76
      nop
      ba TAG81
      nop
TAG76:
      ldsw [%l0+12], %l1
      set 1, %l2
      cmp %l1, %l2
      set 0, %l1
      move %icc, 1, %l1
      cmp %l1, 1
      be TAG77
      nop
      ba TAG80
      nop
TAG77:
      ldsw [%l0+24], %l2
      set 1, %l1
      cmp %l2, %l1
      set 0, %l1
      move %icc, 1, %l1
      cmp %l1, 1
      be TAG78
      nop
      ba TAG79
      nop
TAG78:
      set 0, %l1
      mov %l1, %i0
      ret
      restore
      ba TAG79
      nop
TAG79:
      ba TAG80
      nop
TAG80:
      ba TAG81
      nop
TAG81:
      ldsw [%l0+0], %l1
      set 2, %l2
      cmp %l1, %l2
      set 0, %l1
      move %icc, 1, %l1
      cmp %l1, 1
      be TAG82
      nop
      ba TAG87
      nop
TAG82:
      ldsw [%l0+12], %l2
      set 2, %l1
      cmp %l2, %l1
      set 0, %l1
      move %icc, 1, %l1
      cmp %l1, 1
      be TAG83
      nop
      ba TAG86
      nop
TAG83:
      ldsw [%l0+24], %l2
      set 2, %l1
      cmp %l2, %l1
      set 0, %l1
      move %icc, 1, %l1
      cmp %l1, 1
      be TAG84
      nop
      ba TAG85
      nop
TAG84:
      set 1, %l1
      mov %l1, %i0
      ret
      restore
      ba TAG85
      nop
TAG85:
      ba TAG86
      nop
TAG86:
      ba TAG87
      nop
TAG87:
      ldsw [%l0+4], %l1
      set 1, %l2
      cmp %l1, %l2
      set 0, %l1
      move %icc, 1, %l1
      cmp %l1, 1
      be TAG88
      nop
      ba TAG93
      nop
TAG88:
      ldsw [%l0+16], %l1
      set 1, %l2
      cmp %l1, %l2
      set 0, %l1
      move %icc, 1, %l1
      cmp %l1, 1
      be TAG89
      nop
      ba TAG92
      nop
TAG89:
      ldsw [%l0+28], %l1
      set 1, %l2
      cmp %l1, %l2
      set 0, %l1
      move %icc, 1, %l1
      cmp %l1, 1
      be TAG90
      nop
      ba TAG91
      nop
TAG90:
      set 0, %l1
      mov %l1, %i0
      ret
      restore
      ba TAG91
      nop
TAG91:
      ba TAG92
      nop
TAG92:
      ba TAG93
      nop
TAG93:
      ldsw [%l0+4], %l1
      set 2, %l2
      cmp %l1, %l2
      set 0, %l1
      move %icc, 1, %l1
      cmp %l1, 1
      be TAG94
      nop
      ba TAG99
      nop
TAG94:
      ldsw [%l0+16], %l2
      set 2, %l1
      cmp %l2, %l1
      set 0, %l1
      move %icc, 1, %l1
      cmp %l1, 1
      be TAG95
      nop
      ba TAG98
      nop
TAG95:
      ldsw [%l0+28], %l2
      set 2, %l1
      cmp %l2, %l1
      set 0, %l1
      move %icc, 1, %l1
      cmp %l1, 1
      be TAG96
      nop
      ba TAG97
      nop
TAG96:
      set 1, %l1
      mov %l1, %i0
      ret
      restore
      ba TAG97
      nop
TAG97:
      ba TAG98
      nop
TAG98:
      ba TAG99
      nop
TAG99:
      ldsw [%l0+8], %l2
      set 1, %l1
      cmp %l2, %l1
      set 0, %l1
      move %icc, 1, %l1
      cmp %l1, 1
      be TAG100
      nop
      ba TAG105
      nop
TAG100:
      ldsw [%l0+20], %l2
      set 1, %l1
      cmp %l2, %l1
      set 0, %l1
      move %icc, 1, %l1
      cmp %l1, 1
      be TAG101
      nop
      ba TAG104
      nop
TAG101:
      ldsw [%l0+32], %l2
      set 1, %l1
      cmp %l2, %l1
      set 0, %l1
      move %icc, 1, %l1
      cmp %l1, 1
      be TAG102
      nop
      ba TAG103
      nop
TAG102:
      set 0, %l1
      mov %l1, %i0
      ret
      restore
      ba TAG103
      nop
TAG103:
      ba TAG104
      nop
TAG104:
      ba TAG105
      nop
TAG105:
      ldsw [%l0+8], %l1
      set 2, %l2
      cmp %l1, %l2
      set 0, %l1
      move %icc, 1, %l1
      cmp %l1, 1
      be TAG106
      nop
      ba TAG111
      nop
TAG106:
      ldsw [%l0+20], %l2
      set 2, %l1
      cmp %l2, %l1
      set 0, %l1
      move %icc, 1, %l1
      cmp %l1, 1
      be TAG107
      nop
      ba TAG110
      nop
TAG107:
      ldsw [%l0+32], %l1
      set 2, %l0
      cmp %l1, %l0
      set 0, %l0
      move %icc, 1, %l0
      cmp %l0, 1
      be TAG108
      nop
      ba TAG109
      nop
TAG108:
      set 1, %l0
      mov %l0, %i0
      ret
      restore
      ba TAG109
      nop
TAG109:
      ba TAG110
      nop
TAG110:
      ba TAG111
      nop
TAG111:
      set -1, %l0
      mov %l0, %i0
      ret
      restore
      .size checkWinner, .-checkWinner

      .align 4
      .global placePiece
      .type placePiece, #function
      .proc 04
placePiece:
      save %sp, -112, %sp
      mov %i0, %l0
      mov %i1, %l1
      mov %i2, %l2
      set 1, %l3
      cmp %l2, %l3
      set 0, %l3
      move %icc, 1, %l3
      cmp %l3, 1
      be TAG11
      nop
      ba TAG12
      nop
TAG12:
      set 2, %l3
      cmp %l2, %l3
      set 0, %l3
      move %icc, 1, %l3
      cmp %l3, 1
      be TAG13
      nop
      ba TAG14
      nop
TAG14:
      set 3, %l3
      cmp %l2, %l3
      set 0, %l3
      move %icc, 1, %l3
      cmp %l3, 1
      be TAG15
      nop
      ba TAG16
      nop
TAG16:
      set 4, %l3
      cmp %l2, %l3
      set 0, %l3
      move %icc, 1, %l3
      cmp %l3, 1
      be TAG17
      nop
      ba TAG18
      nop
TAG18:
      set 5, %l3
      cmp %l2, %l3
      set 0, %l3
      move %icc, 1, %l3
      cmp %l3, 1
      be TAG19
      nop
      ba TAG20
      nop
TAG20:
      set 6, %l3
      cmp %l2, %l3
      set 0, %l3
      move %icc, 1, %l3
      cmp %l3, 1
      be TAG21
      nop
      ba TAG22
      nop
TAG22:
      set 7, %l3
      cmp %l2, %l3
      set 0, %l3
      move %icc, 1, %l3
      cmp %l3, 1
      be TAG23
      nop
      ba TAG24
      nop
TAG24:
      set 8, %l3
      cmp %l2, %l3
      set 0, %l3
      move %icc, 1, %l3
      cmp %l3, 1
      be TAG25
      nop
      ba TAG26
      nop
TAG26:
      set 9, %l3
      cmp %l2, %l3
      set 0, %l2
      move %icc, 1, %l2
      cmp %l2, 1
      be TAG27
      nop
      ba TAG28
      nop
TAG27:
      stw %l1, [%l0+32]
      ba TAG28
      nop
TAG28:
      ret
      restore
TAG25:
      stw %l1, [%l0+28]
      ret
      restore
TAG23:
      stw %l1, [%l0+24]
      ret
      restore
TAG21:
      stw %l1, [%l0+20]
      ret
      restore
TAG19:
      stw %l1, [%l0+16]
      ret
      restore
TAG17:
      stw %l1, [%l0+12]
      ret
      restore
TAG15:
      stw %l1, [%l0+8]
      ret
      restore
TAG13:
      stw %l1, [%l0+4]
      ret
      restore
TAG11:
      stw %l1, [%l0+0]
      ret
      restore
TAG36:
      .size placePiece, .-placePiece

      .align 4
      .global printMoveBoard
      .type printMoveBoard, #function
      .proc 04
printMoveBoard:
      save %sp, -112, %sp
      set 123, %l0
      sethi %hi(.LLC1), %o5
      or %o5, %lo(.LLC1), %o0
      mov %l0, %o1
      call printf, 0
      nop
      set 456, %l0
      sethi %hi(.LLC1), %o5
      or %o5, %lo(.LLC1), %o0
      mov %l0, %o1
      call printf, 0
      nop
      set 789, %l0
      sethi %hi(.LLC1), %o5
      or %o5, %lo(.LLC1), %o0
      mov %l0, %o1
      call printf, 0
      nop
      ret
      restore
      .size printMoveBoard, .-printMoveBoard

      .align 4
      .global printBoard
      .type printBoard, #function
      .proc 04
printBoard:
      save %sp, -112, %sp
      mov %i0, %l0
      ldsw [%l0+0], %l1
      sethi %hi(.LLC0), %o5
      or %o5, %lo(.LLC0), %o0
      mov %l1, %o1
      call printf, 0
      nop
      ldsw [%l0+4], %l1
      sethi %hi(.LLC0), %o5
      or %o5, %lo(.LLC0), %o0
      mov %l1, %o1
      call printf, 0
      nop
      ldsw [%l0+8], %l1
      sethi %hi(.LLC1), %o5
      or %o5, %lo(.LLC1), %o0
      mov %l1, %o1
      call printf, 0
      nop
      ldsw [%l0+12], %l1
      sethi %hi(.LLC0), %o5
      or %o5, %lo(.LLC0), %o0
      mov %l1, %o1
      call printf, 0
      nop
      ldsw [%l0+16], %l1
      sethi %hi(.LLC0), %o5
      or %o5, %lo(.LLC0), %o0
      mov %l1, %o1
      call printf, 0
      nop
      ldsw [%l0+20], %l1
      sethi %hi(.LLC1), %o5
      or %o5, %lo(.LLC1), %o0
      mov %l1, %o1
      call printf, 0
      nop
      ldsw [%l0+24], %l1
      sethi %hi(.LLC0), %o5
      or %o5, %lo(.LLC0), %o0
      mov %l1, %o1
      call printf, 0
      nop
      ldsw [%l0+28], %l1
      sethi %hi(.LLC0), %o5
      or %o5, %lo(.LLC0), %o0
      mov %l1, %o1
      call printf, 0
      nop
      ldsw [%l0+32], %l0
      sethi %hi(.LLC1), %o5
      or %o5, %lo(.LLC1), %o0
      mov %l0, %o1
      call printf, 0
      nop
      ret
      restore
      .size printBoard, .-printBoard

      .align 4
      .global cleanBoard
      .type cleanBoard, #function
      .proc 04
cleanBoard:
      save %sp, -112, %sp
      mov %i0, %l0
      set 0, %l1
      stw %l1, [%l0+0]
      set 0, %l1
      stw %l1, [%l0+4]
      set 0, %l1
      stw %l1, [%l0+8]
      set 0, %l1
      stw %l1, [%l0+12]
      set 0, %l1
      stw %l1, [%l0+16]
      set 0, %l1
      stw %l1, [%l0+20]
      set 0, %l1
      stw %l1, [%l0+24]
      set 0, %l1
      stw %l1, [%l0+28]
      set 0, %l1
      stw %l1, [%l0+32]
      ret
      restore
      .size cleanBoard, .-cleanBoard
