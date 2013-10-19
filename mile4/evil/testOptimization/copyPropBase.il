@function main
@local main:b
@local main:a
@local main:d
@local main:c

main:
        jumpi TAG1
TAG1:
        loadi 5, r5
        mov r5, r2
        loadi 0, r6
        comp r2, r6
        loadi 0, r7
        movgt 1, r7
        compi r7, 1
        cbreq TAG2, TAG6
TAG2:
        mov r2, r0
        loadi 1, r8
        sub r0, r8, r9
        mov r9, r4
        loadi 1, r10
        compi r10, 1
        cbreq TAG3, TAG4
TAG3:
        println r0
        println r4
        jumpi TAG4
TAG4:
        loadi 1, r11
        add r4, r11, r12
        mov r12, r3
        loadi 1, r13
        sub r3, r13, r14
        mov r14, r2
        jumpi TAG5
TAG5:
        loadi 0, r15
        comp r2, r15
        loadi 0, r16
        movgt 1, r16
        compi r16, 1
        cbreq TAG2, TAG6
TAG6:
        loadi 0, r17
        storeret r17
        ret
        jumpi TAG7
TAG7:
        ret

