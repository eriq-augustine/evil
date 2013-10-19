	.file	"print.c"
	.section	".rodata"
	.align 8
.LLC0:
	.asciz	"%d"
	.section	".text"
	.align 4
	.global main
	.type	main, #function
	.proc	04
main:
	!#PROLOGUE# 0
	save	%sp, -112, %sp
	!#PROLOGUE# 1
	sethi	%hi(.LLC0), %g1
	or	%g1, %lo(.LLC0), %o0
	mov	1, %o1
	call	printf, 0
	 nop
	mov	%g1, %i0
	return	%i7+8
	nop
	.size	main, .-main
	.ident	"GCC: (GNU) 3.4.3 (csl-sol210-3_4-branch+sol_rpath)"
