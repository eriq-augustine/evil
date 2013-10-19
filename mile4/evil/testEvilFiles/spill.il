@function main
@function fnu

@local fnu:b
@local fnu:a
@local fnu:d
@local fnu:c

fnu:
        loadinargument a, 0, r0
        loadinargument b, 1, r1
        loadinargument c, 2, r2
        loadinargument d, 3, r3
        jumpi TAG1
TAG1:
        add r0, r1, r5
        sub r5, r2, r6
        add r6, r3, r7
        storeret r7
        ret
        jumpi TAG2
TAG2:
        ret

main:
        jumpi TAG4
TAG4:
        loadi 1, r14
        storeoutargument r14, 0
        loadi 2, r15
        storeoutargument r15, 1
        loadi 3, r16
        storeoutargument r16, 2
        loadi 4, r17
        storeoutargument r17, 3
        call fnu
        loadret r18
        print r18
        loadi 1, r20
        storeoutargument r20, 0
        loadi 2, r21
        storeoutargument r21, 1
        loadi 3, r22
        storeoutargument r22, 2
        loadi 4, r23
        storeoutargument r23, 3
        call fnu
        loadret r24
        storeret r24
        ret
        jumpi TAG5
TAG5:
        ret

