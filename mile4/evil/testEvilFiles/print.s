!Sparc v9 Assembly file compiled by Evan Ralston and Eriq Augustine

      .file "print.s"
      .section ".text"

.LLC0:
      .asciz "%d"
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
      mov 1, %l0
      sethi %hi(.LLC0), %g1
      or %g1, %lo(.LLC0), %o0
      mov %l0, %o1
      call printf, 0
      nop
      mov 0, %l0
      mov %l0, %i0
      ret
      restore
      ba TAG2
      nop
TAG2:
      ret
      restore
      .size main, .-main
