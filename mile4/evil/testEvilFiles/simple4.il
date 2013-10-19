@function main
@function funfnu

@local funfnu:a

funfnu:
        loadinargument a, 0, r0
        jumpi TAG1
TAG1:
        storeret r0
        ret
        jumpi TAG2
TAG2:
        ret

main:
        jumpi TAG4
TAG4:
        loadi 7, r5
        storeoutargument r5, 0
        call funfnu
        loadret r6
        storeret r6
        ret
        jumpi TAG5
TAG5:
        ret

