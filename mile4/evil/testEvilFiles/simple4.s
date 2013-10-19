!Sparc Assembly file compiled by Evan Ralston and Eriq Augustine

      .file "simple4.s"
      .section ".text"

      .align 4
      .global main
      .type main, #function
      .proc 04
main:
save %sp, -800, %sp
      ba TAG4
      nop
TAG4:
      mov 7, %l0
      mov %l0, %o0
      mov 46, %l0
      mov %l0, %o1
      call funfnu
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
      .global funfnu
      .type funfnu, #function
      .proc 04
funfnu:
save %sp, -800, %sp
      mov %i0, %l0
      mov %i1, %l1
      ba TAG1
      nop
TAG1:
      add %l1, %l0, %l0
      mov %l0, %i0
      ret
      restore
      ba TAG2
      nop
TAG2:
      ret
      restore
      .size funfnu, .-funfnu
