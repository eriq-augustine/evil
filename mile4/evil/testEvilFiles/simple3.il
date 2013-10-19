@function main
@function funfnu

@local funfnu:b
@local funfnu:a

funfnu:
        loadinargument b, 0, r1
        loadinargument a, 1, r0
        jumpi TAG1
TAG1:
        comp r0, r1
        loadi 0, r3
        movgt 1, r3
        compi r3, 1
        cbreq TAG2, TAG3
TAG3:
        sub r1, r0, r5
        storeret r5
        ret
        jumpi TAG4
TAG2:
        sub r0, r1, r4
        storeret r4
        ret
        jumpi TAG4
TAG4:
        jumpi TAG5
TAG5:
        ret

main:
        jumpi TAG7
TAG7:
        loadi 4, r10
        storeoutargument r10, 0
        loadi 10, r11
        storeoutargument r11, 1
        call funfnu
        loadret r12
        storeret r12
        ret
        jumpi TAG8
TAG8:
        ret

