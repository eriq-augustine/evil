!Sparc v9 Assembly file compiled by Evan Ralston and Eriq Augustine

      .file "demo.s"
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
      set 0, %l0
      mov 8, %o0
      call malloc
      nop
      mov %o0, %l0
      mov %l0, %l0
      set 1, %l2
      set -1, %l1
      sra %l2, %g0, %o5
      sra %l1, %g0, %o4
      mulx %o5, %o4, %l1
      stw %l1, [%l0+0]
      set 1, %l1
      stw %l1, [%l0+4]
      set 5, %l1
      mov %l1, %l1
      set 52, %l2
      mov %l2, %l2
      ldsw [%l0+4], %l3
      cmp %l3, 1
      be TAG8
      nop
      ba TAG13
      nop
TAG8:
      cmp %l2, %l1
      set 0, %l3
      movg %icc, 1, %l3
      cmp %l3, 1
      be TAG9
      nop
      ba TAG10
      nop
TAG10:
      mov %l1, %o0
      mov %l2, %o1
      call funfnu
      nop
      mov %o0, %l1
      mov %l1, %l1
      set 0, %l3
      stw %l3, [%l0+4]
      ba TAG11
      nop
TAG9:
      mov %l1, %o0
      mov %l2, %o1
      call funfnu
      nop
      mov %o0, %l2
      mov %l2, %l2
      ba TAG11
      nop
TAG11:
      ldsw [%l0+4], %l3
      cmp %l3, 1
      be TAG8
      nop
      ba TAG13
      nop
TAG13:
      ldsw [%l0+0], %l0
      sethi %hi(.LLC1), %o5
      or %o5, %lo(.LLC1), %o0
      mov %l0, %o1
      call printf, 0
      nop
      set 2, %l0
      set -1, %l1
      sra %l0, %g0, %o5
      sra %l1, %g0, %o4
      mulx %o5, %o4, %l1
      sethi %hi(foo), %o5
      or %o5, %lo(foo), %o5
      st %l1, [%o5]
      sethi %hi(foo), %o5
      or %o5, %lo(foo), %o5
      ld [%o5], %l0
      sethi %hi(.LLC1), %o5
      or %o5, %lo(.LLC1), %o0
      mov %l0, %o1
      call printf, 0
      nop
      ret
      restore
      .size main, .-main
      .common foo,4,4

      .align 4
      .global funfnu
      .type funfnu, #function
      .proc 04
funfnu:
      save %sp, -112, %sp
      mov %i0, %l2
      mov %i1, %l1
      cmp %l2, %l1
      set 0, %l0
      movg %icc, 1, %l0
      cmp %l0, 1
      be TAG2
      nop
      ba TAG3
      nop
TAG3:
      sethi %hi(.LLC1), %o5
      or %o5, %lo(.LLC1), %o0
      mov %l1, %o1
      call printf, 0
      nop
      sub %l1, %l2, %l0
      mov %l0, %i0
      ret
      restore
      ret
      restore
TAG2:
      sethi %hi(.LLC1), %o5
      or %o5, %lo(.LLC1), %o0
      mov %l2, %o1
      call printf, 0
      nop
      sub %l2, %l1, %l0
      mov %l0, %i0
      ret
      restore
      ret
      restore
TAG4:
      .size funfnu, .-funfnu
