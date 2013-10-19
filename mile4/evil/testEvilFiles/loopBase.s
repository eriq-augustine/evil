!Sparc v9 Assembly file compiled by Evan Ralston and Eriq Augustine

      .file "loop.s"
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
      set 10, %l0
      mov %l0, %l0
      set 0, %l1
      cmp %l0, %l1
      set 0, %l1
      movge %icc, 1, %l1
      cmp %l1, 1
      be TAG2
      nop
      ba TAG4
      nop
TAG2:
      sethi %hi(.LLC1), %o5
      or %o5, %lo(.LLC1), %o0
      mov %l0, %o1
      call printf, 0
      nop
      set 1, %l1
      sub %l0, %l1, %l0
      mov %l0, %l0
      ba TAG3
      nop
TAG3:
      set 0, %l1
      cmp %l0, %l1
      set 0, %l1
      movge %icc, 1, %l1
      cmp %l1, 1
      be TAG2
      nop
      ba TAG4
      nop
TAG4:
      ba TAG5
      nop
TAG5:
      ret
      restore
      .size main, .-main
