@function main
@function fnu
@local main:stA

@local fnu:inA

fnu:
        loadinargument inA, 0, r0
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
        new a, [val, a], r5
        mov r5, r4
        loadi 5, r6
        storeai r6, r4, val
        storeoutargument r4, 0
        call fnu
        loadret r8
        loadai r8, val, r9
        print r9
        loadi 999, r10
        loadi -1, r11
        mult r10, r11, r11
        println r11
        jumpi TAG5
TAG5:
        ret

