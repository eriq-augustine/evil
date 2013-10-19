!Sparc v9 Assembly file compiled by Evan Ralston and Eriq Augustine

      .file "bert.s"
      .section ".text"

.LLC0:
      .asciz "%d"
      .section ".text"

.LLC1:
      .asciz "%d\n"
      .section ".text"

      .align 4
      .global main
      .type main, #function
      .proc 04
main:
save %sp, -800, %sp
      ba TAG114
      nop
TAG114:
      mov %l0, %l1
      mov 0, %l2
      mov %l2, %l2
      mov 10, %l5
      cmp %l2, %l5
      mov 0, %l5
      movl %icc, 1, %l5
      cmp %l5, 1
      be TAG115
      nop
TAG115:
      sethi %hi(readMePrzButDontTouch), %o5
      or %o5, %lo(readMePrzButDontTouch), %o5
      st %l0, [%o5]
      sethi %hi(readMePrzButDontTouch), %o5
      or %o5, %lo(readMePrzButDontTouch), %o5
      sethi %hi(.LLC0), %o5
      or %o5, %lo(.LLC0), %o5
      mov %l0, %o1
      call scanf, 0
      nop
      sethi %hi(readMePrzButDontTouch), %o5
      or %o5, %lo(readMePrzButDontTouch), %o5
      ld [%o5], %l0
      mov %l1, %o0
      mov %l0, %o1
      call add
      nop
      mov %o0, %l1
      mov %l1, %l1
      mov %l1, %o0
      call myCopy
      nop
      mov %o0, %l3
      mov %l3, %l3
      mov %l1, %o0
      call myCopy
      nop
      mov %o0, %l4
      mov %l4, %l4
      mov %l3, %o0
      call quickSortMain
      nop
      mov %o0, %l5
      mov %l5, %l5
      mov %l5, %o0
      call freeList
      nop
      mov %l4, %o0
      call treeMain
      nop
      mov 1, %l5
      add %l2, %l5, %l2
      mov %l2, %l2
      ba TAG116
      nop
TAG116:
      mov 10, %l5
      cmp %l2, %l5
      mov 0, %l5
      movl %icc, 1, %l5
      cmp %l5, 1
      be TAG115
      nop
TAG117:
      mov %l1, %o0
      call freeList
      nop
      mov %l3, %o0
      call freeList
      nop
      mov %l4, %o0
      call freeList
      nop
      mov 0, %l0
      mov %l0, %i0
      ret
      restore
      ba TAG118
      nop
TAG118:
      ret
      restore
      .size main, .-main
      .common TEMP_NAME,4,4
      .common i,4,4
      .common b,4,4
      .common a,4,4
      .align 4
      .global myCopy
      .type myCopy, #function
      .proc 04
myCopy:
save %sp, -800, %sp
      mov %i0, %l0
      ba TAG109
      nop
TAG109:
      cmp %l0, %l1
      mov 0, %l2
      move %icc, 1, %l2
      cmp %l2, 1
      be TAG110
      nop
TAG110:
      mov %l1, %i0
      ret
      restore
      ba TAG111
      nop
TAG111:
      mov %l1, %o0
      ldsw [%l0+0], %l2
      mov %l2, %o1
      call add
      nop
      mov %o0, %l2
      mov %l2, %o0
      ldsw [%l0+4], %l0
      mov %l0, %o0
      call myCopy
      nop
      mov %l1, %o1
      call concatLists
      nop
      mov %o0, %l0
      mov %l0, %i0
      ret
      restore
      ba TAG112
      nop
TAG112:
      ret
      restore
      .size myCopy, .-myCopy
      .align 4
      .global treeMain
      .type treeMain, #function
      .proc 04
treeMain:
save %sp, -800, %sp
      mov %i0, %l0
      ba TAG106
      nop
TAG106:
      mov %l0, %o0
      call buildTree
      nop
      mov %o0, %l0
      mov %l0, %l0
      mov %l0, %o0
      call treeprint
      nop
      mov 999, %l2
      mov -1, %l1
      sra %l2, %g0, %l2
      sra %l1, %g0, %l1
      mov %l2, %o4
      mov %l1, %o5
      mulx %o4, %o5, %l1
      sethi %hi(.LLC1), %o5
      or %o5, %lo(.LLC1), %o0
      mov %l1, %o1
      call printf, 0
      nop
      mov %l0, %o0
      call inOrder
      nop
      mov %o0, %l1
      mov %l1, %l2
      mov %l2, %o0
      call printList
      nop
      mov 999, %l1
      mov -1, %l3
      sra %l1, %g0, %l1
      sra %l3, %g0, %l3
      mov %l1, %o4
      mov %l3, %o5
      mulx %o4, %o5, %l3
      sethi %hi(.LLC1), %o5
      or %o5, %lo(.LLC1), %o0
      mov %l3, %o1
      call printf, 0
      nop
      mov %l2, %o0
      call freeList
      nop
      mov %l0, %o0
      call postOrder
      nop
      mov %o0, %l1
      mov %l1, %l2
      mov %l2, %o0
      call printList
      nop
      mov 999, %l3
      mov -1, %l1
      sra %l3, %g0, %l3
      sra %l1, %g0, %l1
      mov %l3, %o4
      mov %l1, %o5
      mulx %o4, %o5, %l1
      sethi %hi(.LLC1), %o5
      or %o5, %lo(.LLC1), %o0
      mov %l1, %o1
      call printf, 0
      nop
      mov %l2, %o0
      call freeList
      nop
      mov %l0, %o0
      mov 0, %l1
      mov %l1, %o1
      call treesearch
      nop
      mov %o0, %l1
      sethi %hi(.LLC1), %o5
      or %o5, %lo(.LLC1), %o0
      mov %l1, %o1
      call printf, 0
      nop
      mov 999, %l2
      mov -1, %l1
      sra %l2, %g0, %l2
      sra %l1, %g0, %l1
      mov %l2, %o4
      mov %l1, %o5
      mulx %o4, %o5, %l1
      sethi %hi(.LLC1), %o5
      or %o5, %lo(.LLC1), %o0
      mov %l1, %o1
      call printf, 0
      nop
      mov %l0, %o0
      mov 10, %l1
      mov %l1, %o1
      call treesearch
      nop
      mov %o0, %l1
      sethi %hi(.LLC1), %o5
      or %o5, %lo(.LLC1), %o0
      mov %l1, %o1
      call printf, 0
      nop
      mov 999, %l2
      mov -1, %l1
      sra %l2, %g0, %l2
      sra %l1, %g0, %l1
      mov %l2, %o4
      mov %l1, %o5
      mulx %o4, %o5, %l1
      sethi %hi(.LLC1), %o5
      or %o5, %lo(.LLC1), %o0
      mov %l1, %o1
      call printf, 0
      nop
      mov %l0, %o0
      mov 2, %l2
      mov -1, %l1
      sra %l2, %g0, %l2
      sra %l1, %g0, %l1
      mov %l2, %o4
      mov %l1, %o5
      mulx %o4, %o5, %l1
      mov %l1, %o1
      call treesearch
      nop
      mov %o0, %l1
      sethi %hi(.LLC1), %o5
      or %o5, %lo(.LLC1), %o0
      mov %l1, %o1
      call printf, 0
      nop
      mov 999, %l2
      mov -1, %l1
      sra %l2, %g0, %l2
      sra %l1, %g0, %l1
      mov %l2, %o4
      mov %l1, %o5
      mulx %o4, %o5, %l1
      sethi %hi(.LLC1), %o5
      or %o5, %lo(.LLC1), %o0
      mov %l1, %o1
      call printf, 0
      nop
      mov %l0, %o0
      mov 2, %l1
      mov %l1, %o1
      call treesearch
      nop
      mov %o0, %l1
      sethi %hi(.LLC1), %o5
      or %o5, %lo(.LLC1), %o0
      mov %l1, %o1
      call printf, 0
      nop
      mov 999, %l1
      mov -1, %l2
      sra %l1, %g0, %l1
      sra %l2, %g0, %l2
      mov %l1, %o4
      mov %l2, %o5
      mulx %o4, %o5, %l2
      sethi %hi(.LLC1), %o5
      or %o5, %lo(.LLC1), %o0
      mov %l2, %o1
      call printf, 0
      nop
      mov %l0, %o0
      mov 3, %l1
      mov %l1, %o1
      call treesearch
      nop
      mov %o0, %l1
      sethi %hi(.LLC1), %o5
      or %o5, %lo(.LLC1), %o0
      mov %l1, %o1
      call printf, 0
      nop
      mov 999, %l1
      mov -1, %l2
      sra %l1, %g0, %l1
      sra %l2, %g0, %l2
      mov %l1, %o4
      mov %l2, %o5
      mulx %o4, %o5, %l2
      sethi %hi(.LLC1), %o5
      or %o5, %lo(.LLC1), %o0
      mov %l2, %o1
      call printf, 0
      nop
      mov %l0, %o0
      mov 9, %l1
      mov %l1, %o1
      call treesearch
      nop
      mov %o0, %l1
      sethi %hi(.LLC1), %o5
      or %o5, %lo(.LLC1), %o0
      mov %l1, %o1
      call printf, 0
      nop
      mov 999, %l2
      mov -1, %l1
      sra %l2, %g0, %l2
      sra %l1, %g0, %l1
      mov %l2, %o4
      mov %l1, %o5
      mulx %o4, %o5, %l1
      sethi %hi(.LLC1), %o5
      or %o5, %lo(.LLC1), %o0
      mov %l1, %o1
      call printf, 0
      nop
      mov %l0, %o0
      mov 1, %l1
      mov %l1, %o1
      call treesearch
      nop
      mov %o0, %l1
      sethi %hi(.LLC1), %o5
      or %o5, %lo(.LLC1), %o0
      mov %l1, %o1
      call printf, 0
      nop
      mov 999, %l2
      mov -1, %l1
      sra %l2, %g0, %l2
      sra %l1, %g0, %l1
      mov %l2, %o4
      mov %l1, %o5
      mulx %o4, %o5, %l1
      sethi %hi(.LLC1), %o5
      or %o5, %lo(.LLC1), %o0
      mov %l1, %o1
      call printf, 0
      nop
      mov %l0, %o0
      mov 0, %l1
      mov %l1, %o1
      call bintreesearch
      nop
      mov %o0, %l1
      sethi %hi(.LLC1), %o5
      or %o5, %lo(.LLC1), %o0
      mov %l1, %o1
      call printf, 0
      nop
      mov 999, %l1
      mov -1, %l2
      sra %l1, %g0, %l1
      sra %l2, %g0, %l2
      mov %l1, %o4
      mov %l2, %o5
      mulx %o4, %o5, %l2
      sethi %hi(.LLC1), %o5
      or %o5, %lo(.LLC1), %o0
      mov %l2, %o1
      call printf, 0
      nop
      mov %l0, %o0
      mov 10, %l1
      mov %l1, %o1
      call bintreesearch
      nop
      mov %o0, %l1
      sethi %hi(.LLC1), %o5
      or %o5, %lo(.LLC1), %o0
      mov %l1, %o1
      call printf, 0
      nop
      mov 999, %l2
      mov -1, %l1
      sra %l2, %g0, %l2
      sra %l1, %g0, %l1
      mov %l2, %o4
      mov %l1, %o5
      mulx %o4, %o5, %l1
      sethi %hi(.LLC1), %o5
      or %o5, %lo(.LLC1), %o0
      mov %l1, %o1
      call printf, 0
      nop
      mov %l0, %o0
      mov 2, %l2
      mov -1, %l1
      sra %l2, %g0, %l2
      sra %l1, %g0, %l1
      mov %l2, %o4
      mov %l1, %o5
      mulx %o4, %o5, %l1
      mov %l1, %o1
      call bintreesearch
      nop
      mov %o0, %l1
      sethi %hi(.LLC1), %o5
      or %o5, %lo(.LLC1), %o0
      mov %l1, %o1
      call printf, 0
      nop
      mov 999, %l1
      mov -1, %l2
      sra %l1, %g0, %l1
      sra %l2, %g0, %l2
      mov %l1, %o4
      mov %l2, %o5
      mulx %o4, %o5, %l2
      sethi %hi(.LLC1), %o5
      or %o5, %lo(.LLC1), %o0
      mov %l2, %o1
      call printf, 0
      nop
      mov %l0, %o0
      mov 2, %l1
      mov %l1, %o1
      call bintreesearch
      nop
      mov %o0, %l1
      sethi %hi(.LLC1), %o5
      or %o5, %lo(.LLC1), %o0
      mov %l1, %o1
      call printf, 0
      nop
      mov 999, %l2
      mov -1, %l1
      sra %l2, %g0, %l2
      sra %l1, %g0, %l1
      mov %l2, %o4
      mov %l1, %o5
      mulx %o4, %o5, %l1
      sethi %hi(.LLC1), %o5
      or %o5, %lo(.LLC1), %o0
      mov %l1, %o1
      call printf, 0
      nop
      mov %l0, %o0
      mov 3, %l1
      mov %l1, %o1
      call bintreesearch
      nop
      mov %o0, %l1
      sethi %hi(.LLC1), %o5
      or %o5, %lo(.LLC1), %o0
      mov %l1, %o1
      call printf, 0
      nop
      mov 999, %l1
      mov -1, %l2
      sra %l1, %g0, %l1
      sra %l2, %g0, %l2
      mov %l1, %o4
      mov %l2, %o5
      mulx %o4, %o5, %l2
      sethi %hi(.LLC1), %o5
      or %o5, %lo(.LLC1), %o0
      mov %l2, %o1
      call printf, 0
      nop
      mov %l0, %o0
      mov 9, %l1
      mov %l1, %o1
      call bintreesearch
      nop
      mov %o0, %l1
      sethi %hi(.LLC1), %o5
      or %o5, %lo(.LLC1), %o0
      mov %l1, %o1
      call printf, 0
      nop
      mov 999, %l1
      mov -1, %l2
      sra %l1, %g0, %l1
      sra %l2, %g0, %l2
      mov %l1, %o4
      mov %l2, %o5
      mulx %o4, %o5, %l2
      sethi %hi(.LLC1), %o5
      or %o5, %lo(.LLC1), %o0
      mov %l2, %o1
      call printf, 0
      nop
      mov %l0, %o0
      mov 1, %l1
      mov %l1, %o1
      call bintreesearch
      nop
      mov %o0, %l1
      sethi %hi(.LLC1), %o5
      or %o5, %lo(.LLC1), %o0
      mov %l1, %o1
      call printf, 0
      nop
      mov 999, %l1
      mov -1, %l2
      sra %l1, %g0, %l1
      sra %l2, %g0, %l2
      mov %l1, %o4
      mov %l2, %o5
      mulx %o4, %o5, %l2
      sethi %hi(.LLC1), %o5
      or %o5, %lo(.LLC1), %o0
      mov %l2, %o1
      call printf, 0
      nop
      mov %l0, %o0
      call freeTree
      nop
      ba TAG107
      nop
TAG107:
      ret
      restore
      .size treeMain, .-treeMain
      .align 4
      .global buildTree
      .type buildTree, #function
      .proc 04
buildTree:
save %sp, -800, %sp
      mov %i0, %l0
      ba TAG100
      nop
TAG100:
      mov %l1, %l1
      mov 0, %l2
      mov %l2, %l2
      mov %l0, %o0
      call size
      nop
      mov %o0, %l3
      cmp %l2, %l3
      mov 0, %l3
      movl %icc, 1, %l3
      cmp %l3, 1
      be TAG101
      nop
TAG101:
      mov %l1, %o0
      mov %l0, %o0
      mov %l2, %o1
      call get
      nop
      mov %o0, %l1
      mov %l1, %o1
      call treeadd
      nop
      mov %o0, %l1
      mov %l1, %l1
      mov 1, %l3
      add %l2, %l3, %l2
      mov %l2, %l2
      ba TAG102
      nop
TAG102:
      mov %l0, %o0
      call size
      nop
      mov %o0, %l3
      cmp %l2, %l3
      mov 0, %l3
      movl %icc, 1, %l3
      cmp %l3, 1
      be TAG101
      nop
TAG103:
      mov %l1, %i0
      ret
      restore
      ba TAG104
      nop
TAG104:
      ret
      restore
      .size buildTree, .-buildTree
      .align 4
      .global bintreesearch
      .type bintreesearch, #function
      .proc 04
bintreesearch:
save %sp, -800, %sp
      mov %i0, %l1
      mov %i1, %l0
      ba TAG90
      nop
TAG90:
      mov 1, %l3
      mov -1, %l4
      sra %l3, %g0, %l3
      sra %l4, %g0, %l4
      mov %l3, %o4
      mov %l4, %o5
      mulx %o4, %o5, %l4
      sethi %hi(.LLC1), %o5
      or %o5, %lo(.LLC1), %o0
      mov %l4, %o1
      call printf, 0
      nop
      cmp %l1, %l2
      mov 0, %l3
      movne %icc, 1, %l3
      cmp %l3, 1
      be TAG91
      nop
TAG91:
      ldsw [%l1+0], %l3
      cmp %l3, %l0
      mov 0, %l3
      move %icc, 1, %l3
      cmp %l3, 1
      be TAG92
      nop
TAG92:
      mov 1, %l3
      mov %l3, %i0
      ret
      restore
      ba TAG93
      nop
TAG93:
      ldsw [%l1+0], %l3
      cmp %l0, %l3
      mov 0, %l3
      movl %icc, 1, %l3
      cmp %l3, 1
      be TAG94
      nop
TAG95:
      ldsw [%l1+8], %l1
      mov %l1, %o0
      mov %l0, %o1
      call bintreesearch
      nop
      mov %l2, %i0
      ret
      restore
      ba TAG96
      nop
TAG94:
      ldsw [%l1+4], %l1
      mov %l1, %o0
      mov %l0, %o1
      call bintreesearch
      nop
      mov %l2, %i0
      ret
      restore
      ba TAG96
      nop
TAG96:
      ba TAG97
      nop
TAG97:
      mov 0, %l0
      mov %l0, %i0
      ret
      restore
      ba TAG98
      nop
TAG98:
      ret
      restore
      .size bintreesearch, .-bintreesearch
      .align 4
      .global inOrder
      .type inOrder, #function
      .proc 04
inOrder:
save %sp, -800, %sp
      mov %i0, %l0
      ba TAG84
      nop
TAG84:
      cmp %l0, %l1
      mov 0, %l2
      movne %icc, 1, %l2
      cmp %l2, 1
      be TAG85
      nop
TAG86:
      mov %l1, %i0
      ret
      restore
      ba TAG87
      nop
TAG85:
      mov 8, %o0
      call malloc
      nop
      mov %o0, %l2
      mov %l2, %l2
      ldsw [%l0+0], %l3
      stw %l3, [%l2+0]
      stw %l3, [%l2+4]
      ldsw [%l0+4], %l3
      mov %l3, %o0
      call inOrder
      nop
      mov %l1, %o0
      mov %l2, %o0
      ldsw [%l0+8], %l0
      mov %l0, %o0
      call inOrder
      nop
      mov %l1, %o1
      call concatLists
      nop
      mov %o0, %l0
      mov %l0, %o1
      call concatLists
      nop
      mov %o0, %l0
      mov %l0, %i0
      ret
      restore
      ba TAG87
      nop
TAG87:
      ba TAG88
      nop
TAG88:
      ret
      restore
      .size inOrder, .-inOrder
      .align 4
      .global treesearch
      .type treesearch, #function
      .proc 04
treesearch:
save %sp, -800, %sp
      mov %i0, %l2
      mov %i1, %l0
      ba TAG72
      nop
TAG72:
      mov 1, %l4
      mov -1, %l3
      sra %l4, %g0, %l4
      sra %l3, %g0, %l3
      mov %l4, %o4
      mov %l3, %o5
      mulx %o4, %o5, %l3
      sethi %hi(.LLC1), %o5
      or %o5, %lo(.LLC1), %o0
      mov %l3, %o1
      call printf, 0
      nop
      cmp %l2, %l1
      mov 0, %l3
      movne %icc, 1, %l3
      cmp %l3, 1
      be TAG73
      nop
TAG73:
      ldsw [%l2+0], %l3
      cmp %l3, %l0
      mov 0, %l3
      move %icc, 1, %l3
      cmp %l3, 1
      be TAG74
      nop
TAG74:
      mov 1, %l3
      mov %l3, %i0
      ret
      restore
      ba TAG75
      nop
TAG75:
      ldsw [%l2+4], %l3
      mov %l3, %o0
      mov %l0, %o1
      call treesearch
      nop
      mov 1, %l3
      cmp %l1, %l3
      mov 0, %l3
      move %icc, 1, %l3
      cmp %l3, 1
      be TAG76
      nop
TAG76:
      mov 1, %l3
      mov %l3, %i0
      ret
      restore
      ba TAG77
      nop
TAG77:
      ldsw [%l2+8], %l2
      mov %l2, %o0
      mov %l0, %o1
      call treesearch
      nop
      mov 1, %l0
      cmp %l1, %l0
      mov 0, %l0
      move %icc, 1, %l0
      cmp %l0, 1
      be TAG78
      nop
TAG79:
      mov 0, %l0
      mov %l0, %i0
      ret
      restore
      ba TAG80
      nop
TAG78:
      mov 1, %l0
      mov %l0, %i0
      ret
      restore
      ba TAG80
      nop
TAG80:
      ba TAG81
      nop
TAG81:
      mov 0, %l0
      mov %l0, %i0
      ret
      restore
      ba TAG82
      nop
TAG82:
      ret
      restore
      .size treesearch, .-treesearch
      .align 4
      .global quickSortMain
      .type quickSortMain, #function
      .proc 04
quickSortMain:
save %sp, -800, %sp
      mov %i0, %l0
      ba TAG69
      nop
TAG69:
      mov %l0, %o0
      call printList
      nop
      mov 999, %l1
      mov -1, %l2
      sra %l1, %g0, %l1
      sra %l2, %g0, %l2
      mov %l1, %o4
      mov %l2, %o5
      mulx %o4, %o5, %l2
      sethi %hi(.LLC1), %o5
      or %o5, %lo(.LLC1), %o0
      mov %l2, %o1
      call printf, 0
      nop
      mov %l0, %o0
      call printList
      nop
      mov 999, %l1
      mov -1, %l2
      sra %l1, %g0, %l1
      sra %l2, %g0, %l2
      mov %l1, %o4
      mov %l2, %o5
      mulx %o4, %o5, %l2
      sethi %hi(.LLC1), %o5
      or %o5, %lo(.LLC1), %o0
      mov %l2, %o1
      call printf, 0
      nop
      mov %l0, %o0
      call printList
      nop
      mov 999, %l2
      mov -1, %l1
      sra %l2, %g0, %l2
      sra %l1, %g0, %l1
      mov %l2, %o4
      mov %l1, %o5
      mulx %o4, %o5, %l1
      sethi %hi(.LLC1), %o5
      or %o5, %lo(.LLC1), %o0
      mov %l1, %o1
      call printf, 0
      nop
      mov %l0, %i0
      ret
      restore
      ba TAG70
      nop
TAG70:
      ret
      restore
      .size quickSortMain, .-quickSortMain
      .align 4
      .global quickSort
      .type quickSort, #function
      .proc 04
quickSort:
save %sp, -800, %sp
      mov %i0, %l0
      ba TAG58
      nop
TAG58:
      mov %l1, %l1
      mov %l2, %l2
      mov %l0, %o0
      call size
      nop
      mov %o0, %l4
      mov 1, %l5
      cmp %l4, %l5
      mov 0, %l4
      movle %icc, 1, %l4
      cmp %l4, 1
      be TAG59
      nop
TAG59:
      mov %l0, %i0
      ret
      restore
      ba TAG60
      nop
TAG60:
      mov %l0, %o0
      mov 0, %l4
      mov %l4, %o1
      call get
      nop
      mov %o0, %l4
      mov %l0, %o0
      mov %l0, %o0
      call size
      nop
      mov %o0, %l6
      mov 1, %l5
      sub %l6, %l5, %l5
      mov %l5, %o1
      call get
      nop
      mov %o0, %l5
      add %l4, %l5, %l5
      mov 2, %l4
      sra %l5, %g0, %l5
      sra %l4, %g0, %l4
      mov %l5, %o4
      mov %l4, %o5
      sdivx %o4, %o5, %l4
      mov %l4, %l4
      mov %l0, %l5
      mov 0, %l6
      mov %l6, %l6
      cmp %l5, %l3
      mov 0, %l7
      movne %icc, 1, %l7
      cmp %l7, 1
      be TAG61
      nop
TAG61:
      mov %l0, %o0
      mov %l6, %o1
      call get
      nop
      mov %o0, %l7
      cmp %l7, %l4
      mov 0, %l7
      movg %icc, 1, %l7
      cmp %l7, 1
      be TAG62
      nop
TAG63:
      mov %l1, %o0
      mov %l0, %o0
      mov %l6, %o1
      call get
      nop
      mov %o0, %l1
      mov %l1, %o1
      call add
      nop
      mov %o0, %l1
      mov %l1, %l1
      ba TAG64
      nop
TAG62:
      mov %l2, %o0
      mov %l0, %o0
      mov %l6, %o1
      call get
      nop
      mov %o0, %l2
      mov %l2, %o1
      call add
      nop
      mov %o0, %l2
      mov %l2, %l2
      ba TAG64
      nop
TAG64:
      ldsw [%l5+4], %l5
      mov %l5, %l5
      mov 1, %l7
      add %l6, %l7, %l6
      mov %l6, %l6
      ba TAG65
      nop
TAG65:
      cmp %l5, %l3
      mov 0, %l7
      movne %icc, 1, %l7
      cmp %l7, 1
      be TAG61
      nop
TAG66:
      mov %l0, %o0
      call freeList
      nop
      mov %l1, %o0
      call quickSort
      nop
      mov %l3, %o0
      mov %l2, %o0
      call quickSort
      nop
      mov %l3, %o1
      call concatLists
      nop
      mov %o0, %l0
      mov %l0, %i0
      ret
      restore
      ba TAG67
      nop
TAG67:
      ret
      restore
      .size quickSort, .-quickSort
      .align 4
      .global treeadd
      .type treeadd, #function
      .proc 04
treeadd:
save %sp, -800, %sp
      mov %i0, %l0
      mov %i1, %l1
      ba TAG50
      nop
TAG50:
      cmp %l0, %l2
      mov 0, %l1
      move %icc, 1, %l1
      cmp %l1, 1
      be TAG51
      nop
TAG51:
      mov 12, %o0
      call malloc
      nop
      mov %o0, %l1
      mov %l1, %l2
      stw %l1, [%l2+0]
      stw %l3, [%l2+4]
      stw %l3, [%l2+8]
      mov %l2, %i0
      ret
      restore
      ba TAG52
      nop
TAG52:
      ldsw [%l0+0], %l2
      cmp %l1, %l2
      mov 0, %l2
      movl %icc, 1, %l2
      cmp %l2, 1
      be TAG53
      nop
TAG54:
      ldsw [%l0+8], %l2
      mov %l2, %o0
      mov %l1, %o1
      call treeadd
      nop
      stw %l1, [%l0+8]
      ba TAG55
      nop
TAG53:
      ldsw [%l0+4], %l2
      mov %l2, %o0
      mov %l1, %o1
      call treeadd
      nop
      stw %l1, [%l0+4]
      ba TAG55
      nop
TAG55:
      mov %l0, %i0
      ret
      restore
      ba TAG56
      nop
TAG56:
      ret
      restore
      .size treeadd, .-treeadd
      .align 4
      .global postOrder
      .type postOrder, #function
      .proc 04
postOrder:
save %sp, -800, %sp
      mov %i0, %l0
      ba TAG45
      nop
TAG45:
      cmp %l0, %l1
      mov 0, %l2
      movne %icc, 1, %l2
      cmp %l2, 1
      be TAG46
      nop
TAG46:
      mov 8, %o0
      call malloc
      nop
      mov %o0, %l2
      mov %l2, %l2
      ldsw [%l0+0], %l3
      stw %l3, [%l2+0]
      stw %l3, [%l2+4]
      ldsw [%l0+4], %l3
      mov %l3, %o0
      call postOrder
      nop
      mov %l1, %o0
      ldsw [%l0+8], %l0
      mov %l0, %o0
      call postOrder
      nop
      mov %l1, %o1
      call concatLists
      nop
      mov %o0, %l0
      mov %l0, %o0
      mov %l2, %o1
      call concatLists
      nop
      mov %o0, %l0
      mov %l0, %i0
      ret
      restore
      ba TAG47
      nop
TAG47:
      mov %l1, %i0
      ret
      restore
      ba TAG48
      nop
TAG48:
      ret
      restore
      .size postOrder, .-postOrder
      .align 4
      .global freeTree
      .type freeTree, #function
      .proc 04
freeTree:
save %sp, -800, %sp
      mov %i0, %l0
      ba TAG40
      nop
TAG40:
      cmp %l0, %l1
      mov 0, %l1
      move %icc, 1, %l1
      mov -1, %o5
      xor %l1, %o5, %l1
      cmp %l1, 1
      be TAG41
      nop
TAG41:
      ldsw [%l0+4], %l1
      mov %l1, %o0
      call freeTree
      nop
      ldsw [%l0+8], %l1
      mov %l1, %o0
      call freeTree
      nop
      ba TAG42
      nop
TAG42:
      ba TAG43
      nop
TAG43:
      ret
      restore
      .size freeTree, .-freeTree
      .align 4
      .global freeList
      .type freeList, #function
      .proc 04
freeList:
save %sp, -800, %sp
      mov %i0, %l0
      ba TAG35
      nop
TAG35:
      cmp %l0, %l1
      mov 0, %l1
      movne %icc, 1, %l1
      cmp %l1, 1
      be TAG36
      nop
TAG36:
      ldsw [%l0+4], %l1
      mov %l1, %o0
      call freeList
      nop
      ba TAG37
      nop
TAG37:
      ba TAG38
      nop
TAG38:
      ret
      restore
      .size freeList, .-freeList
      .align 4
      .global treeprint
      .type treeprint, #function
      .proc 04
treeprint:
save %sp, -800, %sp
      mov %i0, %l0
      ba TAG30
      nop
TAG30:
      cmp %l0, %l1
      mov 0, %l1
      movne %icc, 1, %l1
      cmp %l1, 1
      be TAG31
      nop
TAG31:
      ldsw [%l0+4], %l1
      mov %l1, %o0
      call treeprint
      nop
      ldsw [%l0+0], %l1
      sethi %hi(.LLC1), %o5
      or %o5, %lo(.LLC1), %o0
      mov %l1, %o1
      call printf, 0
      nop
      ldsw [%l0+8], %l0
      mov %l0, %o0
      call treeprint
      nop
      ba TAG32
      nop
TAG32:
      ba TAG33
      nop
TAG33:
      ret
      restore
      .size treeprint, .-treeprint
      .align 4
      .global printList
      .type printList, #function
      .proc 04
printList:
save %sp, -800, %sp
      mov %i0, %l0
      ba TAG25
      nop
TAG25:
      cmp %l0, %l1
      mov 0, %l1
      movne %icc, 1, %l1
      cmp %l1, 1
      be TAG26
      nop
TAG26:
      ldsw [%l0+0], %l1
      sethi %hi(.LLC1), %o5
      or %o5, %lo(.LLC1), %o0
      mov %l1, %o1
      call printf, 0
      nop
      ldsw [%l0+4], %l0
      mov %l0, %o0
      call printList
      nop
      ba TAG27
      nop
TAG27:
      ba TAG28
      nop
TAG28:
      ret
      restore
      .size printList, .-printList
      .align 4
      .global pop
      .type pop, #function
      .proc 04
pop:
save %sp, -800, %sp
      mov %i0, %l0
      ba TAG22
      nop
TAG22:
      ldsw [%l0+4], %l0
      mov %l0, %l0
      mov %l0, %i0
      ret
      restore
      ba TAG23
      nop
TAG23:
      ret
      restore
      .size pop, .-pop
      .align 4
      .global get
      .type get, #function
      .proc 04
get:
save %sp, -800, %sp
      mov %i0, %l1
      mov %i1, %l2
      ba TAG17
      nop
TAG17:
      mov 0, %l3
      cmp %l1, %l3
      mov 0, %l3
      move %icc, 1, %l3
      cmp %l3, 1
      be TAG18
      nop
TAG18:
      ldsw [%l2+0], %l3
      mov %l3, %i0
      ret
      restore
      ba TAG19
      nop
TAG19:
      ldsw [%l2+4], %l2
      mov %l2, %o0
      mov 1, %l2
      sub %l1, %l2, %l1
      mov %l1, %o1
      call get
      nop
      mov %l0, %i0
      ret
      restore
      ba TAG20
      nop
TAG20:
      ret
      restore
      .size get, .-get
      .align 4
      .global size
      .type size, #function
      .proc 04
size:
save %sp, -800, %sp
      mov %i0, %l1
      ba TAG12
      nop
TAG12:
      cmp %l1, %l0
      mov 0, %l2
      move %icc, 1, %l2
      cmp %l2, 1
      be TAG13
      nop
TAG13:
      mov 0, %l2
      mov %l2, %i0
      ret
      restore
      ba TAG14
      nop
TAG14:
      mov 1, %l2
      ldsw [%l1+4], %l1
      mov %l1, %o0
      call size
      nop
      add %l2, %l0, %l0
      mov %l0, %i0
      ret
      restore
      ba TAG15
      nop
TAG15:
      ret
      restore
      .size size, .-size
      .align 4
      .global add
      .type add, #function
      .proc 04
add:
save %sp, -800, %sp
      mov %i0, %l1
      mov %i1, %l1
      ba TAG9
      nop
TAG9:
      mov 8, %o0
      call malloc
      nop
      mov %o0, %l0
      mov %l0, %l0
      stw %l1, [%l0+0]
      stw %l1, [%l0+4]
      mov %l0, %i0
      ret
      restore
      ba TAG10
      nop
TAG10:
      ret
      restore
      .size add, .-add
      .align 4
      .global concatLists
      .type concatLists, #function
      .proc 04
concatLists:
save %sp, -800, %sp
      mov %i0, %l3
      mov %i1, %l0
      ba TAG1
      nop
TAG1:
      mov %l0, %l1
      cmp %l0, %l2
      mov 0, %l4
      move %icc, 1, %l4
      cmp %l4, 1
      be TAG2
      nop
TAG2:
      mov %l3, %i0
      ret
      restore
      ba TAG3
      nop
TAG3:
      ldsw [%l1+4], %l3
      cmp %l3, %l2
      mov 0, %l3
      movne %icc, 1, %l3
      cmp %l3, 1
      be TAG4
      nop
TAG4:
      ldsw [%l1+4], %l1
      mov %l1, %l1
      ba TAG5
      nop
TAG5:
      ldsw [%l1+4], %l3
      cmp %l3, %l2
      mov 0, %l3
      movne %icc, 1, %l3
      cmp %l3, 1
      be TAG4
      nop
TAG6:
      stw %l3, [%l1+4]
      mov %l0, %i0
      ret
      restore
      ba TAG7
      nop
TAG7:
      ret
      restore
      .size concatLists, .-concatLists
