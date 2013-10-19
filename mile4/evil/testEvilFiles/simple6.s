!Sparc Assembly file compiled by Evan Ralston and Eriq Augustine

      .file "simple6.s"
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
      sethi %hi(a), %g1
      or %g1, %lo(a), %g1
      st %l0, [%g1]
      sethi %hi(a), %g1
      or %g1, %lo(a), %g1
      ld [%g1], %l0
      mov %l0, %i0
      ret
      restore
      ba TAG2
      nop
TAG2:
      ret
      restore
      .size main, .-main
      .common a,4,4
