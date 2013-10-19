@function main

main:
        jumpi TAG1
TAG1:
        loadi 1, r1
        print r1
        loadi 0, r2
        storeret r2
        ret
        jumpi TAG2
TAG2:
        ret

