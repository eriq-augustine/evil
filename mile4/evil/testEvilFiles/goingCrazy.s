!Sparc v9 Assembly file compiled by Evan Ralston and Eriq Augustine

      .file "goingCrazy.s"
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
      mov 8, %o0
      call malloc
      nop
      mov %o0, %l0
      mov %l0, %l0
      mov 5, %l1
      stw %l1, [%l0+0]
      mov 1, %l1
      stw %l1, [%l0+4]
      ldsw [%l0+4], %l1
      cmp %l1, 1
      be TAG2
      nop
TAG3:
      mov 7, %l1
      sethi %hi(.LLC1), %o5
      or %o5, %lo(.LLC1), %o0
      mov %l1, %o1
      call printf, 0
      nop
      mov 7, %l1
      stw %l1, [%l0+0]
      ba TAG4
      nop
TAG2:
      mov 6, %l1
      sethi %hi(.LLC1), %o5
      or %o5, %lo(.LLC1), %o0
      mov %l1, %o1
      call printf, 0
      nop
      mov 6, %l1
      stw %l1, [%l0+0]
      ba TAG4
      nop
TAG4:
      ldsw [%l0+0], %l1
      sethi %hi(.LLC1), %o5
      or %o5, %lo(.LLC1), %o0
      mov %l1, %o1
      call printf, 0
      nop
      ldsw [%l0+0], %l0
      mov %l0, %i0
      ret
      restore
      ba TAG5
      nop
TAG5:
      ret
      restore
      .size main, .-main
      .common gB,4,4
      .common gA,4,4
