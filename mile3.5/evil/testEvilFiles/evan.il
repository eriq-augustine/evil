@function main
@local main:a

main:
        jumpi TAG1
TAG1:
        new a, [i], r0
        mov r0, r1
        loadi 5, r2
        storeai r2, r1, i
        del r1
        loadai r1, i, r3
        println r3
        jumpi TAG2
TAG2:
        ret

