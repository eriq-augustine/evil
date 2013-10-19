@function main
@function funfnu
@local main:a

@local funfnu:a

funfnu:
        loadinargument a, 0, r0
        jumpi TAG1
TAG1:
        storeglobal r0, readMePrzButDontTouch
        computeglobaladdress readMePrzButDontTouch, r0
        read r0
        loadglobal readMePrzButDontTouch, r0
        print r0
        jumpi TAG2
TAG2:
        ret

main:
        jumpi TAG4
TAG4:
        storeoutargument r4, 0
        call funfnu
        jumpi TAG5
TAG5:
        ret

