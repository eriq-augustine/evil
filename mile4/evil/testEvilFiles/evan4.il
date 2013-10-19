@function main
@function funfnu
@local main:b
@local main:a

@local funfnu:b
@local funfnu:a

funfnu:
        loadinargument b, 0, r1
        loadinargument a, 1, r0
        jumpi TAG1
TAG1:
        loadai r0, b, r2
        compi r2, 1
        cbreq TAG2, TAG3
TAG2:
        loadai r0, i, r3
        print r3
        jumpi TAG3
TAG3:
        loadai r1, b, r4
        compi r4, 1
        cbreq TAG4, TAG5
TAG4:
        loadai r1, i, r5
        print r5
        jumpi TAG5
TAG5:
        loadai r0, i, r6
        loadai r1, i, r7
        add r6, r7, r8
        print r8
        loadai r0, i, r9
        loadai r1, i, r10
        add r9, r10, r11
        storeret r11
        ret
        jumpi TAG6
TAG6:
        ret

main:
        jumpi TAG8
TAG8:
        new a, [i, b], r14
        mov r14, r15
        new a, [i, b], r16
        mov r16, r17
        loadi 4, r18
        storeai r18, r15, i
        loadi 5, r19
        storeai r19, r17, i
        loadi 1, r20
        storeai r20, r15, b
        loadi 0, r21
        storeai r21, r17, b
        loadai r15, i, r22
        loadai r17, i, r23
        add r22, r23, r24
        print r24
        storeoutargument r15, 0
        storeoutargument r17, 1
        call funfnu
        loadret r26
        print r26
        jumpi TAG9
TAG9:
        ret

