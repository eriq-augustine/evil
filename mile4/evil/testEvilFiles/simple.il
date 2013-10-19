@function main

main:
        jumpi TAG1
TAG1:
        loadi 5, r1
        storeret r1
        ret
        jumpi TAG2
TAG2:
        ret

