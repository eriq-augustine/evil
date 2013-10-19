@function main
@function getIntList
@function biggest
@function biggestInList
@local main:list

@local getIntList:next
@local getIntList:list

@local biggest:num2
@local biggest:num1

@local biggestInList:list
@local biggestInList:big

getIntList:
        loadi 0, r2
        jumpi TAG1
TAG1:
        new IntList, [head, tail], r3
        mov r3, r2
        storeglobal r1, readMePrzButDontTouch
        computeglobaladdress readMePrzButDontTouch, r1
        read r1
        loadglobal readMePrzButDontTouch, r1
        loadi 1, r4
        loadi -1, r5
        mult r4, r5, r5
        comp r1, r5
        loadi 0, r6
        moveq 1, r6
        compi r6, 1
        cbreq TAG2, TAG3
TAG3:
        storeai r1, r2, head
        call getIntList
        loadret r7
        storeai r7, r2, tail
        storeret r2
        ret
        jumpi TAG4
TAG2:
        storeret r2
        ret
        jumpi TAG4
TAG4:
        jumpi TAG5
TAG5:
        ret

biggest:
        loadinargument num1, 0, r10
        loadinargument num2, 1, r11
        jumpi TAG7
TAG7:
        comp r10, r11
        loadi 0, r13
        movgt 1, r13
        compi r13, 1
        cbreq TAG8, TAG9
TAG9:
        storeret r11
        ret
        jumpi TAG10
TAG8:
        storeret r10
        ret
        jumpi TAG10
TAG10:
        jumpi TAG11
TAG11:
        ret

biggestInList:
        loadinargument list, 0, r16
        jumpi TAG13
TAG13:
        loadai r16, head, r19
        mov r19, r17
        loadai r16, tail, r20
        loadi 0, r21
        comp r20, r21
        loadi 0, r22
        movne 1, r22
        compi r22, 1
        cbreq TAG14, TAG16
TAG14:
        loadai r16, head, r24
        storeoutargument r17, 0
        storeoutargument r24, 1
        call biggest
        loadret r25
        mov r25, r17
        loadai r16, tail, r26
        mov r26, r16
        jumpi TAG15
TAG15:
        loadai r16, tail, r27
        loadi 0, r28
        comp r27, r28
        loadi 0, r29
        movne 1, r29
        compi r29, 1
        cbreq TAG14, TAG16
TAG16:
        storeret r17
        ret
        jumpi TAG17
TAG17:
        ret

main:
        loadi 0, r33
        jumpi TAG19
TAG19:
        call getIntList
        loadret r34
        mov r34, r33
        storeoutargument r33, 0
        call biggestInList
        loadret r36
        println r36
        loadi 0, r37
        storeret r37
        ret
        jumpi TAG20
TAG20:
        ret

