@function main

main:
        jumpi TAG1
TAG1:
        new a, [a, b], r1
        storeglobal r1, a
        loadi 5, r2
        loadglobal a, r3
        storeai r2, r3, a
        loadi 1, r4
        loadglobal a, r5
        storeai r4, r5, b
        loadglobal a, r6
        loadai r6, b, r7
        compi r7, 1
        cbreq TAG2, TAG3
TAG3:
        loadi 7, r10
        loadglobal a, r11
        storeai r10, r11, a
        jumpi TAG4
TAG2:
        loadi 6, r8
        loadglobal a, r9
        storeai r8, r9, a
        jumpi TAG4
TAG4:
        loadglobal a, r12
        loadai r12, a, r13
        storeret r13
        ret
        jumpi TAG5
TAG5:
        ret

