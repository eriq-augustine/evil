!Sparc v9 Assembly file compiled by Evan Ralston and Eriq Augustine

      .file "linkedStruct.s"
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
      ba TAG4
      nop
TAG4:
      call fnu
      nop
      mov %o0, %l0
      ldsw [%l0+4], %l0
      ldsw [%l0+0], %l0
      sethi %hi(.LLC1), %o5
      or %o5, %lo(.LLC1), %o0
      mov %l0, %o1
      call printf, 0
      nop
      set 1, %l0
      mov %l0, %i0
      ret
      restore
      ba TAG5
      nop
TAG5:
      ret
      restore
      .size main, .-main
      .common readMePrzButDontTouch,4,4
      .align 4
      .global fnu
      .type fnu, #function
      .proc 04
fnu:
      save %sp, -112, %sp
      ba TAG1
      nop
TAG1:
      mov 8, %o0
      call malloc
      nop
      mov %o0, %l1
      mov %l1, %l1
      mov 8, %o0
      call malloc
      nop
      mov %o0, %l2
      mov %l2, %l2
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
      stw %l2, [%l1+4]
      mov %l1, %i0
      ret
      restore
      ba TAG2
      nop
TAG2:
      ret
      restore
      .size fnu, .-fnu
