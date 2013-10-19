@function main
@function function
@local main:num

@local function:n
@local function:j
@local function:i

function:
        loadinargument n, 0, r0
        jumpi TAG1
TAG1:
        loadi 0, r4
        comp r0, r4
        loadi 0, r5
        movle 1, r5
        compi r5, 1
        cbreq TAG2, TAG3
TAG2:
        loadi 0, r6
        storeret r6
        ret
        jumpi TAG3
TAG3:
        loadi 0, r7
        mov r7, r3
        mult r0, r0, r8
        comp r3, r8
        loadi 0, r9
        movlt 1, r9
        compi r9, 1
        cbreq TAG4, TAG6
TAG4:
        add r3, r0, r10
        mov r10, r2
        print r2
        loadi 1, r11
        add r3, r11, r12
        mov r12, r3
        jumpi TAG5
TAG5:
        mult r0, r0, r13
        comp r3, r13
        loadi 0, r14
        movlt 1, r14
        compi r14, 1
        cbreq TAG4, TAG6
TAG6:
        loadi 1, r16
        sub r0, r16, r17
        storeoutargument r17, 0
        call function
        loadret r18
        storeret r18
        ret
        jumpi TAG7
TAG7:
        ret

main:
        jumpi TAG9
TAG9:
        storeglobal r23, readMePrzButDontTouch
        computeglobaladdress readMePrzButDontTouch, r23
        read r23
        loadglobal readMePrzButDontTouch, r23
        storeoutargument r23, 0
        call function
        loadi 0, r26
        println r26
        loadi 0, r27
        storeret r27
        ret
        jumpi TAG10
TAG10:
        ret

