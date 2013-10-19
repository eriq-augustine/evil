!Sparc v9 Assembly file compiled by Evan Ralston and Eriq Augustine

      .file "binaryConverter.s"
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
      ba TAG23
      nop
TAG23:
      sethi %hi(readMePrzButDontTouch), %o5
      or %o5, %lo(readMePrzButDontTouch), %o5
      st %l0, [%o5]
      sethi %hi(readMePrzButDontTouch), %o5
      or %o5, %lo(readMePrzButDontTouch), %o5
      mov %o5, %l0
      sethi %hi(.LLC2), %o5
      or %o5, %lo(.LLC2), %o0
      mov %l0, %o1
      call scanf
      nop
      sethi %hi(readMePrzButDontTouch), %o5
      or %o5, %lo(readMePrzButDontTouch), %o5
      ld [%o5], %l0
      mov %l0, %o0
      call convertToDecimal
      nop
      mov %o0, %l0
      sra %l0, %g0, %o5
      sra %l0, %g0, %o4
      mulx %o5, %o4, %l1
      set 0, %l2
      cmp %l1, %l2
      set 0, %l2
      movg %icc, 1, %l2
      cmp %l2, 1
      be TAG24
      nop
      ba TAG26
      nop
TAG24:
      mov %l1, %o0
      call wait
      nop
      set 1, %l2
      sub %l1, %l2, %l1
      ba TAG25
      nop
TAG25:
      set 0, %l2
      cmp %l1, %l2
      set 0, %l2
      movg %icc, 1, %l2
      cmp %l2, 1
      be TAG24
      nop
      ba TAG26
      nop
TAG26:
      sethi %hi(.LLC1), %o5
      or %o5, %lo(.LLC1), %o0
      mov %l0, %o1
      call printf, 0
      nop
      set 0, %l0
      mov %l0, %i0
      ret
      restore
      ba TAG27
      nop
TAG27:
      ret
      restore
      .size main, .-main
      .common readMePrzButDontTouch,4,4

      .align 4
      .global convertToDecimal
      .type convertToDecimal, #function
      .proc 04
convertToDecimal:
      save %sp, -112, %sp
      mov %i0, %l0
      ba TAG20
      nop
TAG20:
      set 0, %l1
      set 0, %l2
      mov %l0, %o0
      mov %l2, %o1
      mov %l1, %o2
      call recursiveDecimalSum
      nop
      mov %o0, %l0
      mov %l0, %i0
      ret
      restore
      ba TAG21
      nop
TAG21:
      ret
      restore
      .size convertToDecimal, .-convertToDecimal

      .align 4
      .global recursiveDecimalSum
      .type recursiveDecimalSum, #function
      .proc 04
recursiveDecimalSum:
      save %sp, -112, %sp
      mov %i0, %l2
      mov %i1, %l0
      mov %i2, %l1
      ba TAG13
      nop
TAG13:
      set 0, %l3
      cmp %l2, %l3
      set 0, %l3
      movg %icc, 1, %l3
      cmp %l3, 1
      be TAG14
      nop
      ba TAG17
      nop
TAG14:
      set 2, %l3
      set 10, %l4
      sra %l2, %g0, %o5
      sra %l4, %g0, %o4
      sdivx %o5, %o4, %l4
      set 10, %l5
      sra %l4, %g0, %o5
      sra %l5, %g0, %o4
      mulx %o5, %o4, %l4
      sub %l2, %l4, %l4
      set 1, %l5
      cmp %l4, %l5
      set 0, %l4
      move %icc, 1, %l4
      cmp %l4, 1
      be TAG15
      nop
      ba TAG16
      nop
TAG15:
      mov %l3, %o0
      mov %l1, %o1
      call power
      nop
      mov %o0, %l3
      add %l0, %l3, %l0
      ba TAG16
      nop
TAG16:
      set 10, %l3
      sra %l2, %g0, %o5
      sra %l3, %g0, %o4
      sdivx %o5, %o4, %l2
      set 1, %l3
      add %l1, %l3, %l1
      mov %l2, %o0
      mov %l0, %o1
      mov %l1, %o2
      call recursiveDecimalSum
      nop
      mov %o0, %l1
      mov %l1, %i0
      ret
      restore
      ba TAG17
      nop
TAG17:
      mov %l0, %i0
      ret
      restore
      ba TAG18
      nop
TAG18:
      ret
      restore
      .size recursiveDecimalSum, .-recursiveDecimalSum

      .align 4
      .global power
      .type power, #function
      .proc 04
power:
      save %sp, -112, %sp
      mov %i0, %l0
      mov %i1, %l1
      ba TAG7
      nop
TAG7:
      set 1, %l2
      set 0, %l3
      cmp %l1, %l3
      set 0, %l3
      movg %icc, 1, %l3
      cmp %l3, 1
      be TAG8
      nop
      ba TAG10
      nop
TAG8:
      sra %l2, %g0, %o5
      sra %l0, %g0, %o4
      mulx %o5, %o4, %l2
      set 1, %l3
      sub %l1, %l3, %l1
      ba TAG9
      nop
TAG9:
      set 0, %l3
      cmp %l1, %l3
      set 0, %l3
      movg %icc, 1, %l3
      cmp %l3, 1
      be TAG8
      nop
      ba TAG10
      nop
TAG10:
      mov %l2, %i0
      ret
      restore
      ba TAG11
      nop
TAG11:
      ret
      restore
      .size power, .-power

      .align 4
      .global wait
      .type wait, #function
      .proc 04
wait:
      save %sp, -112, %sp
      mov %i0, %l0
      ba TAG1
      nop
TAG1:
      set 0, %l1
      cmp %l0, %l1
      set 0, %l1
      movg %icc, 1, %l1
      cmp %l1, 1
      be TAG2
      nop
      ba TAG4
      nop
TAG2:
      set 1, %l1
      sub %l0, %l1, %l0
      ba TAG3
      nop
TAG3:
      set 0, %l1
      cmp %l0, %l1
      set 0, %l1
      movg %icc, 1, %l1
      cmp %l1, 1
      be TAG2
      nop
      ba TAG4
      nop
TAG4:
      set 0, %l0
      mov %l0, %i0
      ret
      restore
      ba TAG5
      nop
TAG5:
      ret
      restore
      .size wait, .-wait
