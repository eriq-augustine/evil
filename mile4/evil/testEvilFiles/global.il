@function main

main:
        jumpi TAG1
TAG1:
        new a, [i], r1
        storeglobal r1, stA
        loadi 5, r2
        loadglobal stA, r3
        storeai r2, r3, i
        loadglobal stA, r4
        loadai r4, i, r5
        storeret r5
        ret
        jumpi TAG2
TAG2:
        ret

