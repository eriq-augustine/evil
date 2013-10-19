!Sparc v9 Assembly file compiled by Evan Ralston and Eriq Augustine

      .file "copyProp.s"
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
      set 5, %l2
      mov %l2, %l0
      set 0, %l1
      cmp %l2, %l1
      set 0, %l1
      movg %icc, 1, %l1
      cmp %l1, 1
      be TAG2
      nop
      ba TAG6
      nop
TAG2:
      mov %l0, %l1
      set 1, %l1
      sub %l0, %l1, %l1
      mov %l1, %l2
      set 1, %l2
      cmp %l2, 1
      be TAG3
      nop
      ba TAG4
      nop
TAG3:
      sethi %hi(.LLC1), %o5
      or %o5, %lo(.LLC1), %o0
      mov %l0, %o1
      call printf, 0
      nop
      sethi %hi(.LLC1), %o5
      or %o5, %lo(.LLC1), %o0
      mov %l1, %o1
      call printf, 0
      nop
      ba TAG4
      nop
TAG4:
      set 1, %l0
      add %l1, %l0, %l0
      mov %l0, %l1
      set 1, %l1
      sub %l0, %l1, %l2
      mov %l2, %l0
      ba TAG5
      nop
TAG5:
      set 0, %l1
      cmp %l2, %l1
      set 0, %l1
      movg %icc, 1, %l1
      cmp %l1, 1
      be TAG2
      nop
      ba TAG6
      nop
TAG6:
      set 0, %l0
      mov %l0, %i0
      ret
      restore
      ba TAG7
      nop
TAG7:
      ret
      restore
      .size main, .-main
