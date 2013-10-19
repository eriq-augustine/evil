!Sparc Assembly file compiled by Evan Ralston and Eriq Augustine

      .file "simple5.s"
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
      mov 6, %l1
      mov %l1, %l1
      mov 7, %l1
      mov %l1, %l1
      add %l0, %l1, %l0
      mov %l0, %l1
      mov %l1, %i0
      ret
      restore
      ba TAG2
      nop
TAG2:
      ret
      restore
      .size main, .-main
