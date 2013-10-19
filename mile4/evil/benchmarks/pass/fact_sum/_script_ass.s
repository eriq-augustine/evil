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
      set 0, %l3
      mov %l3, %l2
      set -1, %l4
      cmp %l3, %l4
      set 0, %l3
      movne %icc, 1, %l3
      cmp %l3, 1
      be TAG12
      nop
      ba TAG14
      nop
TAG12:
      sethi %hi(readMePrzButDontTouch), %o5
      or %o5, %lo(readMePrzButDontTouch), %o5
      st %l1, [%o5]
      sethi %hi(readMePrzButDontTouch), %o5
      or %o5, %lo(readMePrzButDontTouch), %o5
      mov %o5, %l1
      sethi %hi(.LLC2), %o5
      or %o5, %lo(.LLC2), %o0
      mov %l1, %o1
      call scanf
      nop
      sethi %hi(readMePrzButDontTouch), %o5
      or %o5, %lo(readMePrzButDontTouch), %o5
      ld [%o5], %l1
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
      mov %l1, %o0
      call fact
      nop
      mov %o0, %l3
      mov %l3, %l1
      mov %l0, %o0
      call fact
      nop
      mov %o0, %l4
      mov %l4, %l0
      mov %l3, %o0
      mov %l4, %o1
      call sum
      nop
      mov %o0, %l3
      sethi %hi(.LLC1), %o5
      or %o5, %lo(.LLC1), %o0
      mov %l3, %o1
      call printf, 0
      nop
      sethi %hi(readMePrzButDontTouch), %o5
      or %o5, %lo(readMePrzButDontTouch), %o5
      st %l2, [%o5]
      sethi %hi(readMePrzButDontTouch), %o5
      or %o5, %lo(readMePrzButDontTouch), %o5
      mov %o5, %l2
      sethi %hi(.LLC2), %o5
      or %o5, %lo(.LLC2), %o0
      mov %l2, %o1
      call scanf
      nop
      sethi %hi(readMePrzButDontTouch), %o5
      or %o5, %lo(readMePrzButDontTouch), %o5
      ld [%o5], %l2
      set -1, %l3
      cmp %l2, %l3
      set 0, %l3
      movne %icc, 1, %l3
      cmp %l3, 1
      be TAG12
      nop
      ba TAG14
      nop
TAG14:
      set 0, %l0
      mov %l0, %i0
      ret
      restore
      .size main, .-main
      .common readMePrzButDontTouch,4,4

      .align 4
      .global fact
      .type fact, #function
      .proc 04
fact:
      save %sp, -112, %sp
      mov %i0, %l0
      set 1, %l1
      cmp %l0, %l1
      set 0, %l1
      move %icc, 1, %l1
      set 0, %l2
      cmp %l0, %l2
      set 0, %l2
      move %icc, 1, %l2
      or %l1, %l2, %l1
      cmp %l1, 1
      be TAG5
      nop
      ba TAG6
      nop
TAG5:
      set 1, %l1
      mov %l1, %i0
      ret
      restore
      ba TAG6
      nop
TAG6:
      set 1, %l1
      cmp %l0, %l1
      set 0, %l1
      movle %icc, 1, %l1
      cmp %l1, 1
      be TAG7
      nop
      ba TAG8
      nop
TAG7:
      sra %l0, %g0, %o5
      mulx %o5, -1, %l1
      mov %l1, %o0
      call fact
      nop
      mov %o0, %l1
      mov %l1, %i0
      ret
      restore
      ba TAG8
      nop
TAG8:
      sub %l0, 1, %l1
      mov %l1, %o0
      call fact
      nop
      mov %o0, %l1
      sra %l0, %g0, %o5
      sra %l1, %g0, %o4
      mulx %o5, %o4, %l0
      mov %l0, %i0
      ret
      restore
      .size fact, .-fact

      .align 4
      .global sum
      .type sum, #function
      .proc 04
sum:
      save %sp, -112, %sp
      mov %i0, %l1
      mov %i1, %l0
      add %l1, %l0, %l0
      mov %l0, %i0
      ret
      restore
      .size sum, .-sum
