!Sparc v9 Assembly file compiled by Evan Ralston and Eriq Augustine

      .file "spill.s"
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
      save %sp, -112, %sp
      ba TAG4
      nop
TAG4:
      mov 1, %l0
      mov %l0, %o0
      mov 2, %l0
      mov %l0, %o1
      mov 3, %l0
      mov %l0, %o2
      mov 4, %l0
      mov %l0, %o3
      call fnu
      nop
      mov %o0, %l0
      sethi %hi(.LLC0), %o5
      or %o5, %lo(.LLC0), %o0
      mov %l0, %o1
      call printf, 0
      nop
      mov 1, %l0
      mov %l0, %o0
      mov 2, %l0
      mov %l0, %o1
      mov 3, %l0
      mov %l0, %o2
      mov 4, %l0
      mov %l0, %o3
      call fnu
      nop
      mov %o0, %l0
      mov %l0, %i0
      ret
      restore
      ba TAG5
      nop
TAG5:
      ret
      restore
      .size main, .-main
      .align 4
      .global fnu
      .type fnu, #function
      .proc 04
fnu:
      save %sp, -120, %sp
      mov %i0, %l2
      mov %i1, %l1
      mov %i2, %l0
      mov %i3, %o5
      st %o5, [%fp+96]
      ba TAG1
      nop
TAG1:
      add %l2, %l1, %l1
      sub %l1, %l0, %l0
      ld [%fp+96], %o4
      add %l0, %o4, %l0
      mov %l0, %i0
      ret
      restore
      ba TAG2
      nop
TAG2:
      ret
      restore
      .size fnu, .-fnu
