@function main
@function funfnu
@local main:b
@local main:a
@local main:c

@local funfnu:b
@local funfnu:a

funfnu:
        loadinargument a, 0, r0
        loadinargument b, 1, r1
        comp r0, r1
        loadi 0, r3
        movgt 1, r3
        compi r3, 1
        cbreq TAG2, TAG3
TAG3:
        println r1
        sub r1, r0, r5
        storeret r5
        ret
        ret
TAG2:
        println r0
        sub r0, r1, r4
        storeret r4
        ret
        ret
TAG4:

main:
        loadi 0, r11
        new a, [a, b], r12
        mov r12, r11
        loadi 1, r13
        loadi -1, r14
        mult r13, r14, r14
        storeai r14, r11, a
        loadi 1, r15
        storeai r15, r11, b
        loadi 5, r16
        mov r16, r10
        loadi 52, r17
        mov r17, r8
        loadai r11, b, r18
        compi r18, 1
        cbreq TAG8, TAG13
TAG8:
        comp r8, r10
        loadi 0, r19
        movgt 1, r19
        compi r19, 1
        cbreq TAG9, TAG10
TAG10:
        storeoutargument r10, 0
        storeoutargument r8, 1
        call funfnu
        loadret r23
        mov r23, r10
        loadi 0, r24
        storeai r24, r11, b
        jumpi TAG11
TAG9:
        storeoutargument r10, 0
        storeoutargument r8, 1
        call funfnu
        loadret r21
        mov r21, r8
        jumpi TAG11
TAG11:
        loadai r11, b, r25
        compi r25, 1
        cbreq TAG8, TAG13
TAG13:
        loadai r11, a, r26
        println r26
        loadi 2, r27
        loadi -1, r28
        mult r27, r28, r28
        storeglobal r28, foo
        loadglobal foo, r29
        println r29
        ret

