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
      call getIntList
      nop
      mov %o0, %l0
      mov %l0, %o0
      call biggestInList
      nop
      mov %o0, %l0
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
      .global biggestInList
      .type biggestInList, #function
      .proc 04
biggestInList:
      save %sp, -112, %sp
      mov %i0, %l0
      ldsw [%l0+0], %l1
      ldsw [%l0+4], %l2
      set 0, %l3
      cmp %l2, %l3
      set 0, %l2
      movne %icc, 1, %l2
      cmp %l2, 1
      be TAG14
      nop
      ba TAG16
      nop
TAG14:
      ldsw [%l0+0], %l2
      mov %l1, %o0
      mov %l2, %o1
      call biggest
      nop
      mov %o0, %l1
      ldsw [%l0+4], %l2
      mov %l2, %l0
      ldsw [%l2+4], %l3
      set 0, %l2
      cmp %l3, %l2
      set 0, %l2
      movne %icc, 1, %l2
      cmp %l2, 1
      be TAG14
      nop
      ba TAG16
      nop
TAG16:
      mov %l1, %i0
      ret
      restore
      .size biggestInList, .-biggestInList

      .align 4
      .global biggest
      .type biggest, #function
      .proc 04
biggest:
      save %sp, -112, %sp
      mov %i0, %l0
      mov %i1, %l1
      cmp %l0, %l1
      set 0, %l2
      movg %icc, 1, %l2
      cmp %l2, 1
      be TAG8
      nop
      ba TAG9
      nop
TAG9:
      mov %l1, %i0
      ret
      restore
TAG8:
      mov %l0, %i0
      ret
      restore
TAG10:
      .size biggest, .-biggest

      .align 4
      .global getIntList
      .type getIntList, #function
      .proc 04
getIntList:
      save %sp, -112, %sp
      mov 8, %o0
      call malloc
      nop
      mov %o0, %l0
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
      set -1, %l2
      cmp %l1, %l2
      set 0, %l2
      move %icc, 1, %l2
      cmp %l2, 1
      be TAG2
      nop
      ba TAG3
      nop
TAG3:
      stw %l1, [%l0+0]
      call getIntList
      nop
      mov %o0, %l1
      stw %l1, [%l0+4]
      mov %l0, %i0
      ret
      restore
TAG2:
      mov %l0, %i0
      ret
      restore
TAG4:
      .size getIntList, .-getIntList
