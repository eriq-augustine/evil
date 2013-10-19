@function main
@function fnu

@local fnu:stB
@local fnu:stA

fnu:
        jumpi TAG1
TAG1:
        new a, [val, a], r3
        mov r3, r2
        new a, [val, a], r4
        mov r4, r0
        storeglobal r5, readMePrzButDontTouch
        computeglobaladdress readMePrzButDontTouch, r5
        read r5
        loadglobal readMePrzButDontTouch, r5
        storeai r5, r0, val
        storeai r0, r2, a
        storeret r2
        ret
        jumpi TAG2
TAG2:
        ret

main:
        jumpi TAG4
TAG4:
        call fnu
        loadret r9
        loadai r9, a, r10
        loadai r10, val, r11
        println r11
        loadi 1, r12
        storeret r12
        ret
        jumpi TAG5
TAG5:
        ret

