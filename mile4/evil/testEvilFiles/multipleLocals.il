@function main
@local main:stC
@local main:stB
@local main:stA

main:
        jumpi TAG1
TAG1:
        loadi 0, r4
        storeai r4, r3, a
        loadi 0, r5
        storeret r5
        ret
        jumpi TAG2
TAG2:
        ret

