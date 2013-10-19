@function main
@local main:b
@local main:a
@local main:d
@local main:c

main:
        jumpi TAG1
TAG1:
        loadi 1, r5
        mov r5, r2
        loadi 2, r6
        mov r6, r0
        loadi 3, r7
        mov r7, r4
        add r0, r4, r8
        mov r8, r0
        loadi 3, r9
        loadi 4, r10
        add r9, r10, r11
        mov r11, r4
        add r4, r0, r12
        mov r12, r3
        storeret r2
        ret
        jumpi TAG2
TAG2:
        ret

