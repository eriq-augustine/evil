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
      sethi %hi(intList), %o5
      or %o5, %lo(intList), %o5
      st %l0, [%o5]
      set 0, %l0
      mov %l0, %l1
      set 0, %l0
      sethi %hi(intList), %o5
      or %o5, %lo(intList), %o5
      ld [%o5], %l2
      set 0, %l3
      cmp %l2, %l3
      set 0, %l2
      movg %icc, 1, %l2
      cmp %l2, 1
      be TAG17
      nop
      ba TAG19
      nop
TAG17:
      sethi %hi(intList), %o5
      or %o5, %lo(intList), %o5
      ld [%o5], %l2
      mov %l0, %o0
      mov %l2, %o1
      call addToFront
      nop
      mov %o0, %l2
      mov %l2, %l0
      ldsw [%l2+0], %l2
      sethi %hi(.LLC0), %o5
      or %o5, %lo(.LLC0), %o0
      mov %l2, %o1
      call printf, 0
      nop
      sethi %hi(intList), %o5
      or %o5, %lo(intList), %o5
      ld [%o5], %l2
      sub %l2, 1, %l2
      sethi %hi(intList), %o5
      or %o5, %lo(intList), %o5
      st %l2, [%o5]
      sethi %hi(intList), %o5
      or %o5, %lo(intList), %o5
      ld [%o5], %l3
      set 0, %l2
      cmp %l3, %l2
      set 0, %l2
      movg %icc, 1, %l2
      cmp %l2, 1
      be TAG17
      nop
      ba TAG19
      nop
TAG19:
      mov %l0, %o0
      call length
      nop
      mov %o0, %l2
      sethi %hi(.LLC0), %o5
      or %o5, %lo(.LLC0), %o0
      mov %l2, %o1
      call printf, 0
      nop
      mov %l0, %o0
      call length
      nop
      mov %o0, %l2
      set 0, %l3
      cmp %l2, %l3
      set 0, %l2
      movg %icc, 1, %l2
      cmp %l2, 1
      be TAG20
      nop
      ba TAG22
      nop
TAG20:
      ldsw [%l0+0], %l2
      add %l1, %l2, %l1
      mov %l0, %o0
      call length
      nop
      mov %o0, %l2
      sethi %hi(.LLC0), %o5
      or %o5, %lo(.LLC0), %o0
      mov %l2, %o1
      call printf, 0
      nop
      mov %l0, %o0
      call deleteFirst
      nop
      mov %o0, %l2
      mov %l2, %l0
      mov %l2, %o0
      call length
      nop
      mov %o0, %l3
      set 0, %l2
      cmp %l3, %l2
      set 0, %l2
      movg %icc, 1, %l2
      cmp %l2, 1
      be TAG20
      nop
      ba TAG22
      nop
TAG22:
      sethi %hi(.LLC1), %o5
      or %o5, %lo(.LLC1), %o0
      mov %l1, %o1
      call printf, 0
      nop
      set 0, %l0
      mov %l0, %i0
      ret
      restore
      .size main, .-main
      .common intList,4,4
      .common readMePrzButDontTouch,4,4

      .align 4
      .global deleteFirst
      .type deleteFirst, #function
      .proc 04
deleteFirst:
      save %sp, -112, %sp
      mov %i0, %l0
      set 0, %l1
      cmp %l0, %l1
      set 0, %l1
      move %icc, 1, %l1
      cmp %l1, 1
      be TAG12
      nop
      ba TAG13
      nop
TAG12:
      set 0, %l1
      mov %l1, %i0
      ret
      restore
      ba TAG13
      nop
TAG13:
      mov %l0, %l1
      ldsw [%l0+4], %l0
      mov %l1, %o0
      call free
      nop
      mov %l0, %i0
      ret
      restore
      .size deleteFirst, .-deleteFirst

      .align 4
      .global addToFront
      .type addToFront, #function
      .proc 04
addToFront:
      save %sp, -112, %sp
      mov %i0, %l0
      mov %i1, %l1
      set 0, %l2
      cmp %l0, %l2
      set 0, %l2
      move %icc, 1, %l2
      cmp %l2, 1
      be TAG7
      nop
      ba TAG8
      nop
TAG7:
      mov 8, %o0
      call malloc
      nop
      mov %o0, %l2
      mov %l2, %l0
      stw %l1, [%l2+0]
      mov %l2, %i0
      ret
      restore
      ba TAG8
      nop
TAG8:
      mov 8, %o0
      call malloc
      nop
      mov %o0, %l2
      stw %l1, [%l2+0]
      stw %l0, [%l2+4]
      mov %l2, %i0
      ret
      restore
      .size addToFront, .-addToFront

      .align 4
      .global length
      .type length, #function
      .proc 04
length:
      save %sp, -112, %sp
      mov %i0, %l0
      set 0, %l1
      cmp %l0, %l1
      set 0, %l1
      move %icc, 1, %l1
      cmp %l1, 1
      be TAG2
      nop
      ba TAG3
      nop
TAG2:
      set 0, %l1
      mov %l1, %i0
      ret
      restore
      ba TAG3
      nop
TAG3:
      ldsw [%l0+4], %l0
      mov %l0, %o0
      call length
      nop
      mov %o0, %l0
      add %l0, 1, %l0
      mov %l0, %i0
      ret
      restore
      .size length, .-length
