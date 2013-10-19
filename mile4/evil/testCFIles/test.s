	.file	"test.c"
	.comm	a,4,4
	.text
.globl main
	.type	main, @function
main:
	pushl	%ebp
	movl	%esp, %ebp
	movl	$5, a
	movl	a, %eax
	popl	%ebp
	ret
	.size	main, .-main
	.ident	"GCC: (GNU) 4.4.1 20090725 (Red Hat 4.4.1-2)"
	.section	.note.GNU-stack,"",@progbits
