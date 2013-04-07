pushq	%rbp
movq	%rsp, %rbp
movl	%edi, -4(%rbp)
movq	%rsi, -16(%rbp)
movl	-4(%rbp), %eax
addl	$1, %eax
leave
ret
