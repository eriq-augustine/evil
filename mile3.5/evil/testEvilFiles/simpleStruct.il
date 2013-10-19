@function main
@local main:ref

main:
        jumpi TAG1
TAG1:
        new myStruct, [i, b, st], r0
        mov r0, r1
        loadi 7, r2
        storeai r2, r1, i
        loadai r1, i, r3
        print r3
        jumpi TAG2
TAG2:
        ret

