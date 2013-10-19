@function main

main:
        jumpi TAG1
TAG1:
        loadi 2, r1
        loadi -1, r2
        mult r1, r2, r2
        println r2
        jumpi TAG2
TAG2:
        ret

