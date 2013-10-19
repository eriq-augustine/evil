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
        storeret r2
        ret
        jumpi TAG2
TAG2:
        ret

