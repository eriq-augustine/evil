!Sparc v9 Assembly file compiled by Evan Ralston and Eriq Augustine

      .file "aritmetic.s"
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
      mov 1, %l0
      mov 2, %l2
      mov 3, %l1
      sra %l2, %g0, %l2
      sra %l1, %g0, %l1
      mov %l2, %o4
      mov %l1, %o5
      mulx %o4, %o5, %l1
      add %l0, %l1, %l0
      mov 4, %l1
      sub %l0, %l1, %l0
      mov %l0, %i0
      ret
      restore
      ba TAG2
      nop
TAG2:
      ret
      restore
      .size main, .-main
