@function main
@local main:i

main:
        jumpi TAG1
TAG1:
        loadi 1, r2
        loadi 2, r3
        loadi 3, r4
        loadi 3, r5
        loadi 6, r6
        loadi 4, r7
        loadi 3, r8
        loadi 12, r9
        loadi 18, r10
        loadi 3, r11
        loadi 2, r12
        loadi 1, r13
        loadi 17, r14
        mov r14, r1
        loadi 5, r15
        loadi -5, r16
        mov r16, r1
        loadi 0, r17
        storeret r17
        ret
        jumpi TAG2
TAG2:
        ret

