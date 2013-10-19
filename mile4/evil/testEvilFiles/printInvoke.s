!Sparc v9 Assembly file compiled by Evan Ralston and Eriq Augustine

      .file "printInvoke.s"
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
      ba TAG4
      nop
TAG4:
      mov 8, %o0
      call malloc
      nop
      mov %o0, %l0
      mov %l0, %l1
      set 5, %l0
      stw %l0, [%l1+0]
      mov %l1, %o0
      call fnu
      nop
      mov %o0, %l0
      ldsw [%l0+0], %l0
      sethi %hi(.LLC0), %o5
      or %o5, %lo(.LLC0), %o0
      mov %l0, %o1
      call printf, 0
      nop
      set 999, %l1
      set -1, %l0
      sra %l1, %g0, %o5
      sra %l0, %g0, %o4
      mulx %o5, %o4, %l0
      sethi %hi(.LLC1), %o5
      or %o5, %lo(.LLC1), %o0
      mov %l0, %o1
      call printf, 0
      nop
      ba TAG5
      nop
TAG5:
      ret
      restore
      .size main, .-main
      .align 4
      .global fnu
      .type fnu, #function
      .proc 04
fnu:
      save %sp, -112, %sp
      mov %i0, %l0
      ba TAG1
      nop
TAG1:
      mov %l0, %i0
      ret
      restore
      ba TAG2
      nop
TAG2:
      ret
      restore
      .size fnu, .-fnu
