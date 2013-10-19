@function main
@local main:b
@local main:a
@local main:c

main:
        jumpi TAG1
TAG1:
        loadi 5, r4
        mov r4, r2
        loadi 6, r5
        mov r5, r0
        loadi 7, r6
        mov r6, r3
        add r2, r3, r7
        mov r7, r0
        storeret r0
        ret
        jumpi TAG2
TAG2:
        ret

