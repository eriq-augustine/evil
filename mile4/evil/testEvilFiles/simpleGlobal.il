@function main

main:
        jumpi TAG1
TAG1:
        loadi 6, r0
        storeglobal r0, gl
        loadglobal gl, r1
        print r1
        jumpi TAG2
TAG2:
        ret

