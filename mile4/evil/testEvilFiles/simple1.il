@function main

main:
        jumpi TAG1
TAG1:
        new a, [i], r1
        storeglobal r1, a
        loadglobal a, r2
        storeglobal r3, readMePrzButDontTouch
        computeglobaladdress readMePrzButDontTouch, r3
        read r3
        loadglobal readMePrzButDontTouch, r3
        storeai r3, r2, i
        loadglobal a, r4
        loadai r4, i, r5
        print r5
        jumpi TAG2
TAG2:
        ret

