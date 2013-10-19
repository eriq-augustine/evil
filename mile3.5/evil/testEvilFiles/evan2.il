@function main
@local main:b
@local main:a

main:
        jumpi TAG1
TAG1:
        loadi 5, r0
        mov r0, r1
        loadi 6, r2
        mov r2, r3
        add r1, r3, r4
        print r4
        jumpi TAG2
TAG2:
        ret

