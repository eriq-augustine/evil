!Sparc v9 Assembly file compiled by Evan Ralston and Eriq Augustine

      .file "_script_ass.s"
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
      mulx %o5, %o4, %l2
      mov %l2, %l1
      set 0, %l3
      cmp %l2, %l3
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
      sub %l1, 1, %l3
      mov %l3, %l1
      set 0, %l2
      cmp %l3, %l2
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
      .size main, .-main
      .common readMePrzButDontTouch,4,4

      .align 4
      .global convertToDecimal
      .type convertToDecimal, #function
      .proc 04
convertToDecimal:
      save %sp, -112, %sp
      mov %i0, %l2
      set 0, %l1
      set 0, %l0
      mov %l2, %o0
      mov %l0, %o1
      mov %l1, %o2
      call recursiveDecimalSum
      nop
      mov %o0, %l0
      mov %l0, %i0
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
      sra %l2, %g0, %o5
      sdivx %o5, 10, %l4
      sra %l4, %g0, %o5
      mulx %o5, 10, %l4
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
      sra %l2, %g0, %o5
      sdivx %o5, 10, %l2
      add %l1, 1, %l1
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
      .size recursiveDecimalSum, .-recursiveDecimalSum

      .align 4
      .global power
      .type power, #function
      .proc 04
power:
      save %sp, -112, %sp
      mov %i0, %l0
      mov %i1, %l1
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
      sub %l1, 1, %l4
      mov %l4, %l1
      set 0, %l3
      cmp %l4, %l3
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
      .size power, .-power

      .align 4
      .global wait
      .type wait, #function
      .proc 04
wait:
      save %sp, -112, %sp
      mov %i0, %l0
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
      sub %l0, 1, %l2
      mov %l2, %l0
      set 0, %l1
      cmp %l2, %l1
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
      .size wait, .-wait
