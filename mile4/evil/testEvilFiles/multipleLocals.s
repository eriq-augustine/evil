!Sparc v9 Assembly file compiled by Evan Ralston and Eriq Augustine

      .file "multipleLocals.s"
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
      set 0, %l1
      stw %l1, [%l0+0]
      set 0, %l0
      mov %l0, %i0
      ret
      restore
      ba TAG2
      nop
TAG2:
      ret
      restore
      .size main, .-main
