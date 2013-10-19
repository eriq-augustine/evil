!Sparc v9 Assembly file compiled by Evan Ralston and Eriq Augustine

      .file "negative.s"
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
      ba TAG1
      nop
TAG1:
      set 2, %l1
      set -1, %l0
      sra %l1, %g0, %o5
      sra %l0, %g0, %o4
      mulx %o5, %o4, %l0
      sethi %hi(.LLC1), %o5
      or %o5, %lo(.LLC1), %o0
      mov %l0, %o1
      call printf, 0
      nop
      ba TAG2
      nop
TAG2:
      ret
      restore
      .size main, .-main
