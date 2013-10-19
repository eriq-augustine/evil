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
      set 0, %l4
      mov %l4, %l2
      set 0, %l0
      call buildList
      nop
      mov %o0, %l3
      mov %l3, %o0
      call multiple
      nop
      mov %o0, %l1
      mov %l3, %o0
      call add
      nop
      mov %o0, %l5
      sra %l5, %g0, %o5
      sdivx %o5, 2, %l5
      sub %l1, %l5, %l1
      set 10000, %l5
      cmp %l4, %l5
      set 0, %l4
      movl %icc, 1, %l4
      cmp %l4, 1
      be TAG23
      nop
      ba TAG25
      nop
TAG23:
      mov %l3, %o0
      call recurseList
      nop
      mov %o0, %l4
      add %l0, %l4, %l0
      add %l2, 1, %l4
      mov %l4, %l2
      set 10000, %l5
      cmp %l4, %l5
      set 0, %l4
      movl %icc, 1, %l4
      cmp %l4, 1
      be TAG23
      nop
      ba TAG25
      nop
TAG25:
      sethi %hi(.LLC1), %o5
      or %o5, %lo(.LLC1), %o0
      mov %l0, %o1
      call printf, 0
      nop
      set 0, %l2
      cmp %l0, %l2
      set 0, %l2
      movne %icc, 1, %l2
      cmp %l2, 1
      be TAG26
      nop
      ba TAG28
      nop
TAG26:
      sub %l0, 1, %l2
      mov %l2, %l0
      set 0, %l3
      cmp %l2, %l3
      set 0, %l2
      movne %icc, 1, %l2
      cmp %l2, 1
      be TAG26
      nop
      ba TAG28
      nop
TAG28:
      sethi %hi(.LLC1), %o5
      or %o5, %lo(.LLC1), %o0
      mov %l1, %o1
      call printf, 0
      nop
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
      .global recurseList
      .type recurseList, #function
      .proc 04
recurseList:
      save %sp, -112, %sp
      mov %i0, %l0
      ldsw [%l0+4], %l2
      set 0, %l1
      cmp %l2, %l1
      set 0, %l1
      move %icc, 1, %l1
      cmp %l1, 1
      be TAG17
      nop
      ba TAG18
      nop
TAG18:
      ldsw [%l0+0], %l1
      ldsw [%l0+4], %l0
      mov %l0, %o0
      call recurseList
      nop
      mov %o0, %l0
      sra %l1, %g0, %o5
      sra %l0, %g0, %o4
      mulx %o5, %o4, %l0
      mov %l0, %i0
      ret
      restore
TAG17:
      ldsw [%l0+0], %l0
      mov %l0, %i0
      ret
      restore
TAG19:
      .size recurseList, .-recurseList

      .align 4
      .global add
      .type add, #function
      .proc 04
add:
      save %sp, -112, %sp
      mov %i0, %l2
      set 0, %l3
      mov %l3, %l0
      ldsw [%l2+0], %l1
      ldsw [%l2+4], %l2
      set 5, %l4
      cmp %l3, %l4
      set 0, %l3
      movl %icc, 1, %l3
      cmp %l3, 1
      be TAG11
      nop
      ba TAG13
      nop
TAG11:
      ldsw [%l2+0], %l3
      add %l1, %l3, %l3
      mov %l3, %l1
      ldsw [%l2+4], %l2
      sethi %hi(.LLC1), %o5
      or %o5, %lo(.LLC1), %o0
      mov %l3, %o1
      call printf, 0
      nop
      add %l0, 1, %l3
      mov %l3, %l0
      set 5, %l4
      cmp %l3, %l4
      set 0, %l3
      movl %icc, 1, %l3
      cmp %l3, 1
      be TAG11
      nop
      ba TAG13
      nop
TAG13:
      mov %l1, %i0
      ret
      restore
      .size add, .-add

      .align 4
      .global multiple
      .type multiple, #function
      .proc 04
multiple:
      save %sp, -112, %sp
      mov %i0, %l2
      set 0, %l3
      mov %l3, %l0
      ldsw [%l2+0], %l1
      ldsw [%l2+4], %l2
      set 5, %l4
      cmp %l3, %l4
      set 0, %l3
      movl %icc, 1, %l3
      cmp %l3, 1
      be TAG5
      nop
      ba TAG7
      nop
TAG5:
      ldsw [%l2+0], %l3
      sra %l1, %g0, %o5
      sra %l3, %g0, %o4
      mulx %o5, %o4, %l3
      mov %l3, %l1
      ldsw [%l2+4], %l2
      sethi %hi(.LLC1), %o5
      or %o5, %lo(.LLC1), %o0
      mov %l3, %o1
      call printf, 0
      nop
      add %l0, 1, %l4
      mov %l4, %l0
      set 5, %l3
      cmp %l4, %l3
      set 0, %l3
      movl %icc, 1, %l3
      cmp %l3, 1
      be TAG5
      nop
      ba TAG7
      nop
TAG7:
      mov %l1, %i0
      ret
      restore
      .size multiple, .-multiple

      .align 4
      .global buildList
      .type buildList, #function
      .proc 04
buildList:
      save %sp, -128, %sp
      mov 8, %o0
      call malloc
      nop
      mov %o0, %o5
      st %o5, [%fp+100]
      mov 8, %o0
      call malloc
      nop
      mov %o0, %l1
      mov 8, %o0
      call malloc
      nop
      mov %o0, %l2
      mov 8, %o0
      call malloc
      nop
      mov %o0, %l5
      mov 8, %o0
      call malloc
      nop
      mov %o0, %o5
      st %o5, [%fp+104]
      mov 8, %o0
      call malloc
      nop
      mov %o0, %o5
      st %o5, [%fp+96]
      sethi %hi(readMePrzButDontTouch), %o5
      or %o5, %lo(readMePrzButDontTouch), %o5
      st %l7, [%o5]
      sethi %hi(readMePrzButDontTouch), %o5
      or %o5, %lo(readMePrzButDontTouch), %o5
      mov %o5, %l7
      sethi %hi(.LLC2), %o5
      or %o5, %lo(.LLC2), %o0
      mov %l7, %o1
      call scanf
      nop
      sethi %hi(readMePrzButDontTouch), %o5
      or %o5, %lo(readMePrzButDontTouch), %o5
      ld [%o5], %l7
      ld [%fp+100], %o4
      stw %l7, [%o4+0]
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
      stw %l4, [%l1+0]
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
      stw %l0, [%l2+0]
      sethi %hi(readMePrzButDontTouch), %o5
      or %o5, %lo(readMePrzButDontTouch), %o5
      st %l6, [%o5]
      sethi %hi(readMePrzButDontTouch), %o5
      or %o5, %lo(readMePrzButDontTouch), %o5
      mov %o5, %l6
      sethi %hi(.LLC2), %o5
      or %o5, %lo(.LLC2), %o0
      mov %l6, %o1
      call scanf
      nop
      sethi %hi(readMePrzButDontTouch), %o5
      or %o5, %lo(readMePrzButDontTouch), %o5
      ld [%o5], %l6
      stw %l6, [%l5+0]
      ld [%fp+108], %o4
      sethi %hi(readMePrzButDontTouch), %o5
      or %o5, %lo(readMePrzButDontTouch), %o5
      st %o4, [%o5]
      sethi %hi(readMePrzButDontTouch), %o5
      or %o5, %lo(readMePrzButDontTouch), %o5
      mov %o5, %o4
      st %o4, [%fp+108]
      ld [%fp+108], %o4
      sethi %hi(.LLC2), %o5
      or %o5, %lo(.LLC2), %o0
      mov %o4, %o1
      call scanf
      nop
      sethi %hi(readMePrzButDontTouch), %o5
      or %o5, %lo(readMePrzButDontTouch), %o5
      ld [%o5], %o4
      st %o4, [%fp+108]
      ld [%fp+108], %o5
      ld [%fp+104], %o4
      stw %o5, [%o4+0]
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
      ld [%fp+96], %o4
      stw %l3, [%o4+0]
      ld [%fp+100], %o4
      stw %l1, [%o4+4]
      stw %l2, [%l1+4]
      stw %l5, [%l2+4]
      ld [%fp+104], %o5
      stw %o5, [%l5+4]
      ld [%fp+96], %o5
      ld [%fp+104], %o4
      stw %o5, [%o4+4]
      set 0, %l0
      ld [%fp+96], %o4
      stw %l0, [%o4+4]
      ld [%fp+100], %o5
      mov %o5, %i0
      ret
      restore
      .size buildList, .-buildList
