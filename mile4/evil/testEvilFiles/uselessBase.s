!Sparc v9 Assembly file compiled by Evan Ralston and Eriq Augustine

      .file "useless.s"
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
      set 1, %l0
      mov %l0, %l0
      set 2, %l1
      mov %l1, %l1
      set 3, %l2
      mov %l2, %l2
      add %l1, %l2, %l1
      mov %l1, %l1
      set 3, %l2
      set 4, %l3
      add %l2, %l3, %l2
      mov %l2, %l2
      add %l2, %l1, %l1
      mov %l1, %l1
      mov %l0, %i0
      ret
      restore
      ba TAG2
      nop
TAG2:
      ret
      restore
      .size main, .-main
