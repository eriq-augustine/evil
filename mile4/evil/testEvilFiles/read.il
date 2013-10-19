@function main
@local main:a

main:
        jumpi TAG1
TAG1:
        loadi 0, r2
        comp r1, r2
        loadi 0, r3
        movgt 1, r3
        compi r3, 1
        cbreq TAG2, TAG4
TAG2:
        storeglobal r1, readMePrzButDontTouch
        computeglobaladdress readMePrzButDontTouch, r1
        read r1
        loadglobal readMePrzButDontTouch, r1
        println r1
        jumpi TAG3
TAG3:
        loadi 0, r4
        comp r1, r4
        loadi 0, r5
        movgt 1, r5
        compi r5, 1
        cbreq TAG2, TAG4
TAG4:
        jumpi TAG5
TAG5:
        ret

