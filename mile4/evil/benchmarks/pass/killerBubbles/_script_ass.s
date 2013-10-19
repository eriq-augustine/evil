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
      set 0, %l0
      set 666, %l0
      sethi %hi(swapped), %o5
      or %o5, %lo(swapped), %o5
      st %l0, [%o5]
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
      set 0, %l0
      cmp %l1, %l0
      set 0, %l0
      movle %icc, 1, %l0
      cmp %l0, 1
      be TAG22
      nop
      ba TAG23
      nop
TAG22:
      set -1, %l0
      sethi %hi(.LLC1), %o5
      or %o5, %lo(.LLC1), %o0
      mov %l0, %o1
      call printf, 0
      nop
      set -1, %l0
      mov %l0, %i0
      ret
      restore
      ba TAG23
      nop
TAG23:
      sra %l1, %g0, %o5
      mulx %o5, 1000, %l0
      mov 16, %o0
      call malloc
      nop
      mov %o0, %l1
      stw %l0, [%l1+0]
      stw %l1, [%l1+4]
      stw %l1, [%l1+8]
      sub %l0, 1, %l4
      mov %l4, %l2
      mov %l1, %l0
      set 0, %l3
      cmp %l4, %l3
      set 0, %l3
      movg %icc, 1, %l3
      cmp %l3, 1
      be TAG24
      nop
      ba TAG26
      nop
TAG24:
      mov 16, %o0
      call malloc
      nop
      mov %o0, %l3
      stw %l2, [%l3+0]
      stw %l0, [%l3+4]
      stw %l1, [%l3+8]
      stw %l3, [%l0+8]
      mov %l3, %l0
      sub %l2, 1, %l4
      mov %l4, %l2
      set 0, %l3
      cmp %l4, %l3
      set 0, %l3
      movg %icc, 1, %l3
      cmp %l3, 1
      be TAG24
      nop
      ba TAG26
      nop
TAG26:
      mov %l1, %o0
      call deathSort
      nop
      mov %l1, %o0
      call printEVILList
      nop
      set 0, %l0
      mov %l0, %i0
      ret
      restore
      .size main, .-main
      .common readMePrzButDontTouch,4,4
      .common swapped,4,4

      .align 4
      .global printEVILList
      .type printEVILList, #function
      .proc 04
printEVILList:
      save %sp, -112, %sp
      mov %i0, %l0
      ldsw [%l0+8], %l2
      mov %l2, %l1
      ldsw [%l0+0], %l3
      sethi %hi(.LLC1), %o5
      or %o5, %lo(.LLC1), %o0
      mov %l3, %o1
      call printf, 0
      nop
      mov %l0, %o0
      call free
      nop
      cmp %l2, %l0
      set 0, %l2
      movne %icc, 1, %l2
      cmp %l2, 1
      be TAG16
      nop
      ba TAG18
      nop
TAG16:
      mov %l1, %l2
      ldsw [%l1+0], %l3
      sethi %hi(.LLC1), %o5
      or %o5, %lo(.LLC1), %o0
      mov %l3, %o1
      call printf, 0
      nop
      ldsw [%l1+8], %l3
      mov %l3, %l1
      mov %l2, %o0
      call free
      nop
      cmp %l3, %l0
      set 0, %l2
      movne %icc, 1, %l2
      cmp %l2, 1
      be TAG16
      nop
      ba TAG18
      nop
TAG18:
      ret
      restore
      .size printEVILList, .-printEVILList

      .align 4
      .global deathSort
      .type deathSort, #function
      .proc 04
deathSort:
      save %sp, -112, %sp
      mov %i0, %l0
      set 0, %l1
      set 1, %l1
      mov %l1, %l2
      set 1, %l2
      cmp %l1, %l2
      set 0, %l1
      move %icc, 1, %l1
      cmp %l1, 1
      be TAG5
      nop
      ba TAG12
      nop
TAG5:
      set 0, %l1
      mov %l1, %l2
      mov %l0, %l1
      ldsw [%l0+8], %l3
      cmp %l3, %l0
      set 0, %l3
      movne %icc, 1, %l3
      cmp %l3, 1
      be TAG6
      nop
      ba TAG10
      nop
TAG6:
      ldsw [%l1+8], %l3
      mov %l1, %o0
      mov %l3, %o1
      call compare
      nop
      mov %o0, %l4
      set 0, %l3
      cmp %l4, %l3
      set 0, %l3
      movg %icc, 1, %l3
      cmp %l3, 1
      be TAG7
      nop
      ba TAG8
      nop
TAG7:
      ldsw [%l1+0], %l2
      ldsw [%l1+8], %l3
      ldsw [%l3+0], %l3
      stw %l3, [%l1+0]
      ldsw [%l1+8], %l3
      stw %l2, [%l3+0]
      set 1, %l2
      ba TAG8
      nop
TAG8:
      ldsw [%l1+8], %l3
      mov %l3, %l1
      ldsw [%l3+8], %l3
      cmp %l3, %l0
      set 0, %l3
      movne %icc, 1, %l3
      cmp %l3, 1
      be TAG6
      nop
      ba TAG10
      nop
TAG10:
      set 1, %l1
      cmp %l2, %l1
      set 0, %l1
      move %icc, 1, %l1
      cmp %l1, 1
      be TAG5
      nop
      ba TAG12
      nop
TAG12:
      ret
      restore
      .size deathSort, .-deathSort

      .align 4
      .global compare
      .type compare, #function
      .proc 04
compare:
      save %sp, -112, %sp
      mov %i0, %l0
      mov %i1, %l1
      ldsw [%l0+0], %l0
      ldsw [%l1+0], %l1
      sub %l0, %l1, %l0
      mov %l0, %i0
      ret
      restore
      .size compare, .-compare
