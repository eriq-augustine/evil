	.file	"global.c"
	.section	".text"
	.align 4
	.global main
	.type	main, #function
	.proc	04
main:
	!#PROLOGUE# 0
	save	%sp, -112, %sp
	!#PROLOGUE# 1
	sethi	%hi(stA), %g1
	or	%g1, %lo(stA), %l0
	mov	4, %o0
	call	malloc, 0
	 nop
	mov	%o0, %g1
	st	%g1, [%l0]
	sethi	%hi(stA), %g1
	or	%g1, %lo(stA), %g1
	ld	[%g1], %o5
	mov	5, %g1
	st	%g1, [%o5]
	sethi	%hi(stA), %g1
	or	%g1, %lo(stA), %g1
	ld	[%g1], %g1
	ld	[%g1], %g1
	mov	%g1, %i0
	return	%i7+8
	nop
	.size	main, .-main
	.common	stA,4,4
	.ident	"GCC: (GNU) 3.4.3 (csl-sol210-3_4-branch+sol_rpath)"
