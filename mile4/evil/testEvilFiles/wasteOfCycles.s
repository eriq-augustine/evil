!Sparc v9 Assembly file compiled by Evan Ralston and Eriq Augustine

      .file "wasteOfCycles.s"
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
      ba TAG9
      nop
TAG9:
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
      call function
      nop
      mov %o0, %l0
      set 0, %l0
      sethi %hi(.LLC1), %o5
      or %o5, %lo(.LLC1), %o0
      mov %l0, %o1
      call printf, 0
      nop
      set 0, %l0
      mov %l0, %i0
      ret
      restore
      ba TAG10
      nop
TAG10:
      ret
      restore
      .size main, .-main
      .common readMePrzButDontTouch,4,4

      .align 4
      .global function
      .type function, #function
      .proc 04
function:
      save %sp, -112, %sp
      mov %i0, %l0
      ba TAG1
      nop
TAG1:
      set 0, %l1
      cmp %l0, %l1
      set 0, %l1
      movle %icc, 1, %l1
      cmp %l1, 1
      be TAG2
      nop
      ba TAG3
      nop
TAG2:
      set 0, %l1
      mov %l1, %i0
      ret
      restore
      ba TAG3
      nop
TAG3:
      set 0, %l1
      sra %l0, %g0, %o5
      sra %l0, %g0, %o4
      mulx %o5, %o4, %l2
      cmp %l1, %l2
      set 0, %l2
      movl %icc, 1, %l2
      cmp %l2, 1
      be TAG4
      nop
      ba TAG6
      nop
TAG4:
      add %l1, %l0, %l2
      sethi %hi(.LLC0), %o5
      or %o5, %lo(.LLC0), %o0
      mov %l2, %o1
      call printf, 0
      nop
      set 1, %l2
      add %l1, %l2, %l1
      ba TAG5
      nop
TAG5:
      sra %l0, %g0, %o5
      sra %l0, %g0, %o4
      mulx %o5, %o4, %l2
      cmp %l1, %l2
      set 0, %l2
      movl %icc, 1, %l2
      cmp %l2, 1
      be TAG4
      nop
      ba TAG6
      nop
TAG6:
      set 1, %l1
      sub %l0, %l1, %l0
      mov %l0, %o0
      call function
      nop
      mov %o0, %l0
      mov %l0, %i0
      ret
      restore
      ba TAG7
      nop
TAG7:
      ret
      restore
      .size function, .-function
