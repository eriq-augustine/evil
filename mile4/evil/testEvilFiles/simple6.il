@function main

main:
        jumpi TAG1
TAG1:
        loadi 5, r1
        storeglobal r1, a
        loadglobal a, r2
        storeret r2
        ret
        jumpi TAG2
TAG2:
        ret

