!Sparc v9 Assembly file compiled by Evan Ralston and Eriq Augustine

      .file "global.s"
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
      mov 4, %o0
      call malloc
      nop
      mov %o0, %l0
      sethi %hi(stA), %o5
      or %o5, %lo(stA), %o5
      st %l0, [%o5]
      mov 5, %l1
      sethi %hi(stA), %o5
      or %o5, %lo(stA), %o5
      ld [%o5], %l0
      stw %l1, [%l0+0]
      sethi %hi(stA), %o5
      or %o5, %lo(stA), %o5
      ld [%o5], %l0
      ldsw [%l0+0], %l0
      mov %l0, %i0
      ret
      restore
      ba TAG2
      nop
TAG2:
      ret
      restore
      .size main, .-main
      .common stA,4,4
