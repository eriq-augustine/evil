!Sparc v9 Assembly file compiled by Evan Ralston and Eriq Augustine

      .file "read.s"
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
      ba TAG1
      nop
TAG1:
      mov 5, %l0
      mov %l0, %l0
      mov 0, %l1
      cmp %l0, %l1
      mov 0, %l1
      movg %icc, 1, %l1
      cmp %l1, 1
      be TAG2
      nop
TAG2:
      sethi %hi(readMePrzButDontTouch), %o5
      or %o5, %lo(readMePrzButDontTouch), %o5
      st %l0, [%o5]
      sethi %hi(readMePrzButDontTouch), %o5
      or %o5, %lo(readMePrzButDontTouch), %o5
      sethi %hi(.LLC0), %o5
      or %o5, %lo(.LLC0), %o5
      mov %l0, %o1
      call scanf
      nop
      sethi %hi(readMePrzButDontTouch), %o5
      or %o5, %lo(readMePrzButDontTouch), %o5
      ld [%o5], %l0
      sethi %hi(.LLC1), %o5
      or %o5, %lo(.LLC1), %o0
      mov %l0, %o1
      call printf, 0
      nop
      ba TAG3
      nop
TAG3:
      mov 0, %l1
      cmp %l0, %l1
      mov 0, %l1
      movg %icc, 1, %l1
      cmp %l1, 1
      be TAG2
      nop
TAG4:
      ba TAG5
      nop
TAG5:
      ret
      restore
      .size main, .-main
      .common readMePrzButDontTouch,4,4
