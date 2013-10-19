@function main

@function fufu
@local fufu:a

fufu:
        loadinargument a, 0, r0
        jumpi TAG1
TAG1:
        loadi 5, r1
        storeai r1, r0, i
        storeret r0
        ret
        jumpi TAG2
TAG2:
        ret

main:
        jumpi TAG4
TAG4:
        new a, [i], r4
        storeoutargument r4, 0
        call fufu
        loadret r5
        loadai r5, i, r6
        print r6
        jumpi TAG5
TAG5:
        ret

