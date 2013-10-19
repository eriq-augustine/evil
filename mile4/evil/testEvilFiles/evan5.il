@function main
@function funfnu
@local main:a

@local funfnu:value

funfnu:
        loadinargument value, 0, r0
        jumpi TAG1
TAG1:
        loadi 1, r1
        sub r0, r1, r2
        storeret r2
        ret
        jumpi TAG2
TAG2:
        ret

main:
        jumpi TAG4
TAG4:
        new a, [i, a], r4
        mov r4, r5
        new a, [i, a], r6
        storeai r6, r5, a
        new a, [i, a], r7
        loadai r5, a, r8
        storeai r7, r8, a
        loadi 11, r9
        loadai r5, a, r10
        loadai r10, a, r11
        storeai r9, r11, i
        loadai r5, a, r12
        loadai r12, a, r13
        loadai r13, i, r14
        loadi 0, r15
        comp r14, r15
        loadi 0, r16
        movgt 1, r16
        compi r16, 1
        cbreq TAG5, TAG7
TAG5:
        loadai r5, a, r18
        loadai r18, a, r19
        loadai r19, i, r20
        storeoutargument r20, 0
        call funfnu
        loadret r21
        loadai r5, a, r22
        loadai r22, a, r23
        storeai r21, r23, i
        loadai r5, a, r24
        loadai r24, a, r25
        loadai r25, i, r26
        println r26
        jumpi TAG6
TAG6:
        loadai r5, a, r27
        loadai r27, a, r28
        loadai r28, i, r29
        loadi 0, r30
        comp r29, r30
        loadi 0, r31
        movgt 1, r31
        compi r31, 1
        cbreq TAG5, TAG7
TAG7:
        jumpi TAG8
TAG8:
        ret

