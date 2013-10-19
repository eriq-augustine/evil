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
      call computeFib
      nop
      mov %o0, %l0
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
      .global computeFib
      .type computeFib, #function
      .proc 04
computeFib:
      save %sp, -112, %sp
      mov %i0, %l0
      set 0, %l1
      cmp %l0, %l1
      set 0, %l1
      move %icc, 1, %l1
      cmp %l1, 1
      be TAG2
      nop
      ba TAG3
      nop
TAG3:
      set 2, %l1
      cmp %l0, %l1
      set 0, %l1
      movle %icc, 1, %l1
      cmp %l1, 1
      be TAG4
      nop
      ba TAG5
      nop
TAG5:
      sub %l0, 1, %l1
      mov %l1, %o0
      call computeFib
      nop
      mov %o0, %l1
      sub %l0, 2, %l0
      mov %l0, %o0
      call computeFib
      nop
      mov %o0, %l0
      add %l1, %l0, %l0
      mov %l0, %i0
      ret
      restore
TAG4:
      set 1, %l0
      mov %l0, %i0
      ret
      restore
TAG2:
      set 0, %l0
      mov %l0, %i0
      ret
      restore
TAG7:
      .size computeFib, .-computeFib
