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
      set 0, %l2
      set 0, %l1
      set 0, %l3
      mov %l3, %l4
      set 0, %l5
      mov %l5, %l3
      set 10, %l6
      cmp %l5, %l6
      set 0, %l5
      movl %icc, 1, %l5
      cmp %l5, 1
      be TAG115
      nop
      ba TAG117
      nop
TAG115:
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
      mov %l4, %o0
      mov %l0, %o1
      call add
      nop
      mov %o0, %l2
      mov %l2, %l4
      mov %l2, %o0
      call myCopy
      nop
      mov %o0, %l6
      mov %l6, %l1
      mov %l2, %o0
      call myCopy
      nop
      mov %o0, %l5
      mov %l5, %l2
      mov %l6, %o0
      call quickSortMain
      nop
      mov %o0, %l6
      mov %l6, %o0
      call freeList
      nop
      mov %l5, %o0
      call treeMain
      nop
      add %l3, 1, %l6
      mov %l6, %l3
      set 10, %l5
      cmp %l6, %l5
      set 0, %l5
      movl %icc, 1, %l5
      cmp %l5, 1
      be TAG115
      nop
      ba TAG117
      nop
TAG117:
      mov %l4, %o0
      call freeList
      nop
      mov %l1, %o0
      call freeList
      nop
      mov %l2, %o0
      call freeList
      nop
      set 0, %l0
      mov %l0, %i0
      ret
      restore
      .size main, .-main
      .common readMePrzButDontTouch,4,4
      .common i,4,4
      .common b,4,4
      .common a,4,4

      .align 4
      .global myCopy
      .type myCopy, #function
      .proc 04
myCopy:
      save %sp, -112, %sp
      mov %i0, %l0
      set 0, %l1
      cmp %l0, %l1
      set 0, %l1
      move %icc, 1, %l1
      cmp %l1, 1
      be TAG110
      nop
      ba TAG111
      nop
TAG110:
      set 0, %l1
      mov %l1, %i0
      ret
      restore
      ba TAG111
      nop
TAG111:
      set 0, %l1
      ldsw [%l0+0], %l2
      mov %l1, %o0
      mov %l2, %o1
      call add
      nop
      mov %o0, %l1
      ldsw [%l0+4], %l0
      mov %l0, %o0
      call myCopy
      nop
      mov %o0, %l0
      mov %l1, %o0
      mov %l0, %o1
      call concatLists
      nop
      mov %o0, %l0
      mov %l0, %i0
      ret
      restore
      .size myCopy, .-myCopy

      .align 4
      .global treeMain
      .type treeMain, #function
      .proc 04
treeMain:
      save %sp, -112, %sp
      mov %i0, %l0
      mov %l0, %o0
      call buildTree
      nop
      mov %o0, %l0
      mov %l0, %o0
      call treeprint
      nop
      set -999, %l1
      sethi %hi(.LLC1), %o5
      or %o5, %lo(.LLC1), %o0
      mov %l1, %o1
      call printf, 0
      nop
      mov %l0, %o0
      call inOrder
      nop
      mov %o0, %l1
      mov %l1, %o0
      call printList
      nop
      set -999, %l2
      sethi %hi(.LLC1), %o5
      or %o5, %lo(.LLC1), %o0
      mov %l2, %o1
      call printf, 0
      nop
      mov %l1, %o0
      call freeList
      nop
      mov %l0, %o0
      call postOrder
      nop
      mov %o0, %l1
      mov %l1, %o0
      call printList
      nop
      set -999, %l2
      sethi %hi(.LLC1), %o5
      or %o5, %lo(.LLC1), %o0
      mov %l2, %o1
      call printf, 0
      nop
      mov %l1, %o0
      call freeList
      nop
      set 0, %l1
      mov %l0, %o0
      mov %l1, %o1
      call treesearch
      nop
      mov %o0, %l1
      sethi %hi(.LLC1), %o5
      or %o5, %lo(.LLC1), %o0
      mov %l1, %o1
      call printf, 0
      nop
      set -999, %l1
      sethi %hi(.LLC1), %o5
      or %o5, %lo(.LLC1), %o0
      mov %l1, %o1
      call printf, 0
      nop
      set 10, %l1
      mov %l0, %o0
      mov %l1, %o1
      call treesearch
      nop
      mov %o0, %l1
      sethi %hi(.LLC1), %o5
      or %o5, %lo(.LLC1), %o0
      mov %l1, %o1
      call printf, 0
      nop
      set -999, %l1
      sethi %hi(.LLC1), %o5
      or %o5, %lo(.LLC1), %o0
      mov %l1, %o1
      call printf, 0
      nop
      set -2, %l1
      mov %l0, %o0
      mov %l1, %o1
      call treesearch
      nop
      mov %o0, %l1
      sethi %hi(.LLC1), %o5
      or %o5, %lo(.LLC1), %o0
      mov %l1, %o1
      call printf, 0
      nop
      set -999, %l1
      sethi %hi(.LLC1), %o5
      or %o5, %lo(.LLC1), %o0
      mov %l1, %o1
      call printf, 0
      nop
      set 2, %l1
      mov %l0, %o0
      mov %l1, %o1
      call treesearch
      nop
      mov %o0, %l1
      sethi %hi(.LLC1), %o5
      or %o5, %lo(.LLC1), %o0
      mov %l1, %o1
      call printf, 0
      nop
      set -999, %l1
      sethi %hi(.LLC1), %o5
      or %o5, %lo(.LLC1), %o0
      mov %l1, %o1
      call printf, 0
      nop
      set 3, %l1
      mov %l0, %o0
      mov %l1, %o1
      call treesearch
      nop
      mov %o0, %l1
      sethi %hi(.LLC1), %o5
      or %o5, %lo(.LLC1), %o0
      mov %l1, %o1
      call printf, 0
      nop
      set -999, %l1
      sethi %hi(.LLC1), %o5
      or %o5, %lo(.LLC1), %o0
      mov %l1, %o1
      call printf, 0
      nop
      set 9, %l1
      mov %l0, %o0
      mov %l1, %o1
      call treesearch
      nop
      mov %o0, %l1
      sethi %hi(.LLC1), %o5
      or %o5, %lo(.LLC1), %o0
      mov %l1, %o1
      call printf, 0
      nop
      set -999, %l1
      sethi %hi(.LLC1), %o5
      or %o5, %lo(.LLC1), %o0
      mov %l1, %o1
      call printf, 0
      nop
      set 1, %l1
      mov %l0, %o0
      mov %l1, %o1
      call treesearch
      nop
      mov %o0, %l1
      sethi %hi(.LLC1), %o5
      or %o5, %lo(.LLC1), %o0
      mov %l1, %o1
      call printf, 0
      nop
      set -999, %l1
      sethi %hi(.LLC1), %o5
      or %o5, %lo(.LLC1), %o0
      mov %l1, %o1
      call printf, 0
      nop
      set 0, %l1
      mov %l0, %o0
      mov %l1, %o1
      call bintreesearch
      nop
      mov %o0, %l1
      sethi %hi(.LLC1), %o5
      or %o5, %lo(.LLC1), %o0
      mov %l1, %o1
      call printf, 0
      nop
      set -999, %l1
      sethi %hi(.LLC1), %o5
      or %o5, %lo(.LLC1), %o0
      mov %l1, %o1
      call printf, 0
      nop
      set 10, %l1
      mov %l0, %o0
      mov %l1, %o1
      call bintreesearch
      nop
      mov %o0, %l1
      sethi %hi(.LLC1), %o5
      or %o5, %lo(.LLC1), %o0
      mov %l1, %o1
      call printf, 0
      nop
      set -999, %l1
      sethi %hi(.LLC1), %o5
      or %o5, %lo(.LLC1), %o0
      mov %l1, %o1
      call printf, 0
      nop
      set -2, %l1
      mov %l0, %o0
      mov %l1, %o1
      call bintreesearch
      nop
      mov %o0, %l1
      sethi %hi(.LLC1), %o5
      or %o5, %lo(.LLC1), %o0
      mov %l1, %o1
      call printf, 0
      nop
      set -999, %l1
      sethi %hi(.LLC1), %o5
      or %o5, %lo(.LLC1), %o0
      mov %l1, %o1
      call printf, 0
      nop
      set 2, %l1
      mov %l0, %o0
      mov %l1, %o1
      call bintreesearch
      nop
      mov %o0, %l1
      sethi %hi(.LLC1), %o5
      or %o5, %lo(.LLC1), %o0
      mov %l1, %o1
      call printf, 0
      nop
      set -999, %l1
      sethi %hi(.LLC1), %o5
      or %o5, %lo(.LLC1), %o0
      mov %l1, %o1
      call printf, 0
      nop
      set 3, %l1
      mov %l0, %o0
      mov %l1, %o1
      call bintreesearch
      nop
      mov %o0, %l1
      sethi %hi(.LLC1), %o5
      or %o5, %lo(.LLC1), %o0
      mov %l1, %o1
      call printf, 0
      nop
      set -999, %l1
      sethi %hi(.LLC1), %o5
      or %o5, %lo(.LLC1), %o0
      mov %l1, %o1
      call printf, 0
      nop
      set 9, %l1
      mov %l0, %o0
      mov %l1, %o1
      call bintreesearch
      nop
      mov %o0, %l1
      sethi %hi(.LLC1), %o5
      or %o5, %lo(.LLC1), %o0
      mov %l1, %o1
      call printf, 0
      nop
      set -999, %l1
      sethi %hi(.LLC1), %o5
      or %o5, %lo(.LLC1), %o0
      mov %l1, %o1
      call printf, 0
      nop
      set 1, %l1
      mov %l0, %o0
      mov %l1, %o1
      call bintreesearch
      nop
      mov %o0, %l1
      sethi %hi(.LLC1), %o5
      or %o5, %lo(.LLC1), %o0
      mov %l1, %o1
      call printf, 0
      nop
      set -999, %l1
      sethi %hi(.LLC1), %o5
      or %o5, %lo(.LLC1), %o0
      mov %l1, %o1
      call printf, 0
      nop
      mov %l0, %o0
      call freeTree
      nop
      ret
      restore
      .size treeMain, .-treeMain

      .align 4
      .global buildTree
      .type buildTree, #function
      .proc 04
buildTree:
      save %sp, -112, %sp
      mov %i0, %l0
      set 0, %l1
      mov %l1, %l2
      set 0, %l3
      mov %l3, %l1
      mov %l0, %o0
      call size
      nop
      mov %o0, %l4
      cmp %l3, %l4
      set 0, %l3
      movl %icc, 1, %l3
      cmp %l3, 1
      be TAG101
      nop
      ba TAG103
      nop
TAG101:
      mov %l0, %o0
      mov %l1, %o1
      call get
      nop
      mov %o0, %l3
      mov %l2, %o0
      mov %l3, %o1
      call treeadd
      nop
      mov %o0, %l2
      add %l1, 1, %l4
      mov %l4, %l1
      mov %l0, %o0
      call size
      nop
      mov %o0, %l3
      cmp %l4, %l3
      set 0, %l3
      movl %icc, 1, %l3
      cmp %l3, 1
      be TAG101
      nop
      ba TAG103
      nop
TAG103:
      mov %l2, %i0
      ret
      restore
      .size buildTree, .-buildTree

      .align 4
      .global bintreesearch
      .type bintreesearch, #function
      .proc 04
bintreesearch:
      save %sp, -112, %sp
      mov %i0, %l1
      mov %i1, %l0
      set -1, %l2
      sethi %hi(.LLC1), %o5
      or %o5, %lo(.LLC1), %o0
      mov %l2, %o1
      call printf, 0
      nop
      set 0, %l2
      cmp %l1, %l2
      set 0, %l2
      movne %icc, 1, %l2
      cmp %l2, 1
      be TAG91
      nop
      ba TAG97
      nop
TAG91:
      ldsw [%l1+0], %l2
      cmp %l2, %l0
      set 0, %l2
      move %icc, 1, %l2
      cmp %l2, 1
      be TAG92
      nop
      ba TAG93
      nop
TAG92:
      set 1, %l2
      mov %l2, %i0
      ret
      restore
      ba TAG93
      nop
TAG93:
      ldsw [%l1+0], %l2
      cmp %l0, %l2
      set 0, %l2
      movl %icc, 1, %l2
      cmp %l2, 1
      be TAG94
      nop
      ba TAG95
      nop
TAG95:
      ldsw [%l1+8], %l1
      mov %l1, %o0
      mov %l0, %o1
      call bintreesearch
      nop
      mov %o0, %l0
      mov %l0, %i0
      ret
      restore
      ba TAG97
      nop
TAG94:
      ldsw [%l1+4], %l1
      mov %l1, %o0
      mov %l0, %o1
      call bintreesearch
      nop
      mov %o0, %l0
      mov %l0, %i0
      ret
      restore
      ba TAG97
      nop
TAG97:
      set 0, %l0
      mov %l0, %i0
      ret
      restore
      .size bintreesearch, .-bintreesearch

      .align 4
      .global inOrder
      .type inOrder, #function
      .proc 04
inOrder:
      save %sp, -112, %sp
      mov %i0, %l0
      set 0, %l1
      cmp %l0, %l1
      set 0, %l1
      movne %icc, 1, %l1
      cmp %l1, 1
      be TAG85
      nop
      ba TAG86
      nop
TAG86:
      set 0, %l0
      mov %l0, %i0
      ret
      restore
TAG85:
      mov 8, %o0
      call malloc
      nop
      mov %o0, %l1
      ldsw [%l0+0], %l2
      stw %l2, [%l1+0]
      set 0, %l2
      stw %l2, [%l1+4]
      ldsw [%l0+4], %l2
      mov %l2, %o0
      call inOrder
      nop
      mov %o0, %l2
      ldsw [%l0+8], %l0
      mov %l0, %o0
      call inOrder
      nop
      mov %o0, %l0
      mov %l1, %o0
      mov %l0, %o1
      call concatLists
      nop
      mov %o0, %l0
      mov %l2, %o0
      mov %l0, %o1
      call concatLists
      nop
      mov %o0, %l0
      mov %l0, %i0
      ret
      restore
TAG87:
      .size inOrder, .-inOrder

      .align 4
      .global treesearch
      .type treesearch, #function
      .proc 04
treesearch:
      save %sp, -112, %sp
      mov %i0, %l1
      mov %i1, %l0
      set -1, %l2
      sethi %hi(.LLC1), %o5
      or %o5, %lo(.LLC1), %o0
      mov %l2, %o1
      call printf, 0
      nop
      set 0, %l2
      cmp %l1, %l2
      set 0, %l2
      movne %icc, 1, %l2
      cmp %l2, 1
      be TAG73
      nop
      ba TAG81
      nop
TAG73:
      ldsw [%l1+0], %l2
      cmp %l2, %l0
      set 0, %l2
      move %icc, 1, %l2
      cmp %l2, 1
      be TAG74
      nop
      ba TAG75
      nop
TAG74:
      set 1, %l2
      mov %l2, %i0
      ret
      restore
      ba TAG75
      nop
TAG75:
      ldsw [%l1+4], %l2
      mov %l2, %o0
      mov %l0, %o1
      call treesearch
      nop
      mov %o0, %l3
      set 1, %l2
      cmp %l3, %l2
      set 0, %l2
      move %icc, 1, %l2
      cmp %l2, 1
      be TAG76
      nop
      ba TAG77
      nop
TAG76:
      set 1, %l2
      mov %l2, %i0
      ret
      restore
      ba TAG77
      nop
TAG77:
      ldsw [%l1+8], %l1
      mov %l1, %o0
      mov %l0, %o1
      call treesearch
      nop
      mov %o0, %l0
      set 1, %l1
      cmp %l0, %l1
      set 0, %l0
      move %icc, 1, %l0
      cmp %l0, 1
      be TAG78
      nop
      ba TAG79
      nop
TAG79:
      set 0, %l0
      mov %l0, %i0
      ret
      restore
      ba TAG81
      nop
TAG78:
      set 1, %l0
      mov %l0, %i0
      ret
      restore
      ba TAG81
      nop
TAG81:
      set 0, %l0
      mov %l0, %i0
      ret
      restore
      .size treesearch, .-treesearch

      .align 4
      .global quickSortMain
      .type quickSortMain, #function
      .proc 04
quickSortMain:
      save %sp, -112, %sp
      mov %i0, %l0
      mov %l0, %o0
      call printList
      nop
      set -999, %l1
      sethi %hi(.LLC1), %o5
      or %o5, %lo(.LLC1), %o0
      mov %l1, %o1
      call printf, 0
      nop
      mov %l0, %o0
      call printList
      nop
      set -999, %l1
      sethi %hi(.LLC1), %o5
      or %o5, %lo(.LLC1), %o0
      mov %l1, %o1
      call printf, 0
      nop
      mov %l0, %o0
      call printList
      nop
      set -999, %l1
      sethi %hi(.LLC1), %o5
      or %o5, %lo(.LLC1), %o0
      mov %l1, %o1
      call printf, 0
      nop
      mov %l0, %i0
      ret
      restore
      .size quickSortMain, .-quickSortMain

      .align 4
      .global quickSort
      .type quickSort, #function
      .proc 04
quickSort:
      save %sp, -112, %sp
      mov %i0, %l0
      set 0, %l4
      set 0, %l1
      set 0, %l2
      mov %l0, %o0
      call size
      nop
      mov %o0, %l4
      set 1, %l3
      cmp %l4, %l3
      set 0, %l3
      movle %icc, 1, %l3
      cmp %l3, 1
      be TAG59
      nop
      ba TAG60
      nop
TAG59:
      mov %l0, %i0
      ret
      restore
      ba TAG60
      nop
TAG60:
      set 0, %l3
      mov %l0, %o0
      mov %l3, %o1
      call get
      nop
      mov %o0, %l3
      mov %l0, %o0
      call size
      nop
      mov %o0, %l4
      sub %l4, 1, %l4
      mov %l0, %o0
      mov %l4, %o1
      call get
      nop
      mov %o0, %l4
      add %l3, %l4, %l3
      sra %l3, %g0, %o5
      sdivx %o5, 2, %l3
      mov %l0, %l4
      set 0, %l5
      set 0, %l6
      cmp %l0, %l6
      set 0, %l6
      movne %icc, 1, %l6
      cmp %l6, 1
      be TAG61
      nop
      ba TAG66
      nop
TAG61:
      mov %l0, %o0
      mov %l5, %o1
      call get
      nop
      mov %o0, %l6
      cmp %l6, %l3
      set 0, %l6
      movg %icc, 1, %l6
      cmp %l6, 1
      be TAG62
      nop
      ba TAG63
      nop
TAG63:
      mov %l0, %o0
      mov %l5, %o1
      call get
      nop
      mov %o0, %l6
      mov %l1, %o0
      mov %l6, %o1
      call add
      nop
      mov %o0, %l1
      ba TAG64
      nop
TAG62:
      mov %l0, %o0
      mov %l5, %o1
      call get
      nop
      mov %o0, %l6
      mov %l2, %o0
      mov %l6, %o1
      call add
      nop
      mov %o0, %l2
      ba TAG64
      nop
TAG64:
      ldsw [%l4+4], %l6
      mov %l6, %l4
      add %l5, 1, %l5
      set 0, %l7
      cmp %l6, %l7
      set 0, %l6
      movne %icc, 1, %l6
      cmp %l6, 1
      be TAG61
      nop
      ba TAG66
      nop
TAG66:
      mov %l0, %o0
      call freeList
      nop
      mov %l1, %o0
      call quickSort
      nop
      mov %o0, %l0
      mov %l2, %o0
      call quickSort
      nop
      mov %o0, %l1
      mov %l0, %o0
      mov %l1, %o1
      call concatLists
      nop
      mov %o0, %l0
      mov %l0, %i0
      ret
      restore
      .size quickSort, .-quickSort

      .align 4
      .global treeadd
      .type treeadd, #function
      .proc 04
treeadd:
      save %sp, -112, %sp
      mov %i0, %l0
      mov %i1, %l1
      set 0, %l2
      cmp %l0, %l2
      set 0, %l2
      move %icc, 1, %l2
      cmp %l2, 1
      be TAG51
      nop
      ba TAG52
      nop
TAG51:
      mov 16, %o0
      call malloc
      nop
      mov %o0, %l2
      stw %l1, [%l2+0]
      set 0, %l3
      stw %l3, [%l2+4]
      set 0, %l3
      stw %l3, [%l2+8]
      mov %l2, %i0
      ret
      restore
      ba TAG52
      nop
TAG52:
      ldsw [%l0+0], %l2
      cmp %l1, %l2
      set 0, %l2
      movl %icc, 1, %l2
      cmp %l2, 1
      be TAG53
      nop
      ba TAG54
      nop
TAG54:
      ldsw [%l0+8], %l2
      mov %l2, %o0
      mov %l1, %o1
      call treeadd
      nop
      mov %o0, %l1
      stw %l1, [%l0+8]
      ba TAG55
      nop
TAG53:
      ldsw [%l0+4], %l2
      mov %l2, %o0
      mov %l1, %o1
      call treeadd
      nop
      mov %o0, %l1
      stw %l1, [%l0+4]
      ba TAG55
      nop
TAG55:
      mov %l0, %i0
      ret
      restore
      .size treeadd, .-treeadd

      .align 4
      .global postOrder
      .type postOrder, #function
      .proc 04
postOrder:
      save %sp, -112, %sp
      mov %i0, %l1
      set 0, %l0
      cmp %l1, %l0
      set 0, %l0
      movne %icc, 1, %l0
      cmp %l0, 1
      be TAG46
      nop
      ba TAG47
      nop
TAG46:
      mov 8, %o0
      call malloc
      nop
      mov %o0, %l0
      ldsw [%l1+0], %l2
      stw %l2, [%l0+0]
      set 0, %l2
      stw %l2, [%l0+4]
      ldsw [%l1+4], %l2
      mov %l2, %o0
      call postOrder
      nop
      mov %o0, %l2
      ldsw [%l1+8], %l1
      mov %l1, %o0
      call postOrder
      nop
      mov %o0, %l1
      mov %l2, %o0
      mov %l1, %o1
      call concatLists
      nop
      mov %o0, %l1
      mov %l1, %o0
      mov %l0, %o1
      call concatLists
      nop
      mov %o0, %l0
      mov %l0, %i0
      ret
      restore
      ba TAG47
      nop
TAG47:
      set 0, %l0
      mov %l0, %i0
      ret
      restore
      .size postOrder, .-postOrder

      .align 4
      .global freeTree
      .type freeTree, #function
      .proc 04
freeTree:
      save %sp, -112, %sp
      mov %i0, %l0
      set 0, %l1
      cmp %l0, %l1
      set 0, %l1
      move %icc, 1, %l1
      mov -1, %o4
      xor %l1, %o4, %l1
      cmp %l1, 1
      be TAG41
      nop
      ba TAG42
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
      mov %l0, %o0
      call free
      nop
      ba TAG42
      nop
TAG42:
      ret
      restore
      .size freeTree, .-freeTree

      .align 4
      .global freeList
      .type freeList, #function
      .proc 04
freeList:
      save %sp, -112, %sp
      mov %i0, %l0
      set 0, %l1
      cmp %l0, %l1
      set 0, %l1
      movne %icc, 1, %l1
      cmp %l1, 1
      be TAG36
      nop
      ba TAG37
      nop
TAG36:
      ldsw [%l0+4], %l1
      mov %l1, %o0
      call freeList
      nop
      mov %l0, %o0
      call free
      nop
      ba TAG37
      nop
TAG37:
      ret
      restore
      .size freeList, .-freeList

      .align 4
      .global treeprint
      .type treeprint, #function
      .proc 04
treeprint:
      save %sp, -112, %sp
      mov %i0, %l0
      set 0, %l1
      cmp %l0, %l1
      set 0, %l1
      movne %icc, 1, %l1
      cmp %l1, 1
      be TAG31
      nop
      ba TAG32
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
      ret
      restore
      .size treeprint, .-treeprint

      .align 4
      .global printList
      .type printList, #function
      .proc 04
printList:
      save %sp, -112, %sp
      mov %i0, %l0
      set 0, %l1
      cmp %l0, %l1
      set 0, %l1
      movne %icc, 1, %l1
      cmp %l1, 1
      be TAG26
      nop
      ba TAG27
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
      ret
      restore
      .size printList, .-printList

      .align 4
      .global pop
      .type pop, #function
      .proc 04
pop:
      save %sp, -112, %sp
      mov %i0, %l0
      ldsw [%l0+4], %l0
      mov %l0, %i0
      ret
      restore
      .size pop, .-pop

      .align 4
      .global get
      .type get, #function
      .proc 04
get:
      save %sp, -112, %sp
      mov %i0, %l1
      mov %i1, %l0
      set 0, %l2
      cmp %l0, %l2
      set 0, %l2
      move %icc, 1, %l2
      cmp %l2, 1
      be TAG18
      nop
      ba TAG19
      nop
TAG18:
      ldsw [%l1+0], %l2
      mov %l2, %i0
      ret
      restore
      ba TAG19
      nop
TAG19:
      ldsw [%l1+4], %l1
      sub %l0, 1, %l0
      mov %l1, %o0
      mov %l0, %o1
      call get
      nop
      mov %o0, %l0
      mov %l0, %i0
      ret
      restore
      .size get, .-get

      .align 4
      .global size
      .type size, #function
      .proc 04
size:
      save %sp, -112, %sp
      mov %i0, %l0
      set 0, %l1
      cmp %l0, %l1
      set 0, %l1
      move %icc, 1, %l1
      cmp %l1, 1
      be TAG13
      nop
      ba TAG14
      nop
TAG13:
      set 0, %l1
      mov %l1, %i0
      ret
      restore
      ba TAG14
      nop
TAG14:
      ldsw [%l0+4], %l0
      mov %l0, %o0
      call size
      nop
      mov %o0, %l0
      add %l0, 1, %l0
      mov %l0, %i0
      ret
      restore
      .size size, .-size

      .align 4
      .global add
      .type add, #function
      .proc 04
add:
      save %sp, -112, %sp
      mov %i0, %l2
      mov %i1, %l0
      mov 8, %o0
      call malloc
      nop
      mov %o0, %l1
      stw %l0, [%l1+0]
      stw %l2, [%l1+4]
      mov %l1, %i0
      ret
      restore
      .size add, .-add

      .align 4
      .global concatLists
      .type concatLists, #function
      .proc 04
concatLists:
      save %sp, -112, %sp
      mov %i0, %l0
      mov %i1, %l1
      mov %l0, %l2
      set 0, %l3
      cmp %l0, %l3
      set 0, %l3
      move %icc, 1, %l3
      cmp %l3, 1
      be TAG2
      nop
      ba TAG3
      nop
TAG2:
      mov %l1, %i0
      ret
      restore
      ba TAG3
      nop
TAG3:
      ldsw [%l0+4], %l4
      set 0, %l3
      cmp %l4, %l3
      set 0, %l3
      movne %icc, 1, %l3
      cmp %l3, 1
      be TAG4
      nop
      ba TAG6
      nop
TAG4:
      ldsw [%l2+4], %l3
      mov %l3, %l2
      ldsw [%l3+4], %l4
      set 0, %l3
      cmp %l4, %l3
      set 0, %l3
      movne %icc, 1, %l3
      cmp %l3, 1
      be TAG4
      nop
      ba TAG6
      nop
TAG6:
      stw %l1, [%l2+4]
      mov %l0, %i0
      ret
      restore
      .size concatLists, .-concatLists
