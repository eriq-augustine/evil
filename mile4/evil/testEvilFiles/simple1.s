!Sparc Assembly file compiled by Evan Ralston and Eriq Augustine

      .file "simple1.s"
      .section ".text"

      .global a
      .section ".data"
      .align 4
      .type a, #object
      .size a, 4
a:
      .long 5

      .align 4
      .global main
      .type main, #function
      .proc 04
main:
save %sp, -800, %sp
