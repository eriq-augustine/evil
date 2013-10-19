!Sparc Assembly file compiled by Evan Ralston and Eriq Augustine

      .file "simple3.s"
      .section ".text"

      .align 4
      .global main
      .type main, #function
      .proc 04
main:
save %sp, -800, %sp
      ba TAG7
      nop
TAG7:
      mov 4, %l0
      mov %l0, %o0
      mov 10, %l0
      mov %l0, %o1
      call funfnu
      nop
      mov %o0, %l0
      mov %l0, %i0
      ret
      restore
      ba TAG8
      nop
TAG8:
      ret
      restore
      .size main, .-main
      .align 4
      .global funfnu
      .type funfnu, #function
      .proc 04
funfnu:
save %sp, -800, %sp
      mov %i0, %l2
      mov %i1, %l0
      ba TAG1
      nop
TAG1:
      cmp %l0, %l2
      mov 0, %l1
      movg %icc, 1, %l1
      cmp %l1, 1
      be TAG2
      nop
TAG3:
      sub %l2, %l0, %l0
      mov %l0, %i0
      ret
      restore
      ba TAG4
      nop
TAG2:
      sub %l0, %l2, %l0
      mov %l0, %i0
      ret
      restore
      ba TAG4
      nop
TAG4:
      ba TAG5
      nop
TAG5:
      ret
      restore
      .size funfnu, .-funfnu
