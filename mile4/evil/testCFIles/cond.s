	.file	"cond.c"
	.section	".rodata"
	.align 8
.LLC0:
	.asciz	"%d\n"
	.section	".text"
	.align 4
	.global main
	.type	main, #function
	.proc	04
main:
	!#PROLOGUE# 0
	save	%sp, -120, %sp
	!#PROLOGUE# 1
	st	%g0, [%fp-20]
	ld	[%fp-20], %g1
	cmp	%g1, 2
	bg	%icc, .LL2
	nop
	sethi	%hi(.LLC0), %g1
	or	%g1, %lo(.LLC0), %o0
	mov	-1, %o1
	call	printf, 0
	 nop
.LL2:
	ld	[%fp-20], %g1
	cmp	%g1, 1
	ble	%icc, .LL3
	nop
	sethi	%hi(.LLC0), %g1
	or	%g1, %lo(.LLC0), %o0
	mov	-2, %o1
	call	printf, 0
	 nop
.LL3:
	ld	[%fp-20], %g1
	mov	%g1, %i0
	return	%i7+8
	nop
	.size	main, .-main
	.ident	"GCC: (GNU) 3.4.3 (csl-sol210-3_4-branch+sol_rpath)"
