@function main
@local main:b
@local main:a
@local main:k
@local main:j
@local main:i
@local main:h

@function g
@local g:m
@local g:k

@function f
@local f:l
@local f:k

@function foo

f:
        jmp TAG1
TAG1:
        ret
        jmp TAG2
TAG2:
        ret

foo:
        jmp TAG4
TAG4:
        loadi 0, r6
        comp r5, r6
        loadi 0, r7
        movle 1, r7
        compi r7, 1
        cbreq TAG5, TAG6
TAG6:
        loadi 1, r11
        sub r10, r11, r12
        loadinarg r12
        call foo (foo)
        mult r9, r13, r14
        ret
        jmp TAG7
TAG5:
        loadi 1, r8
        ret
        jmp TAG7
TAG7:
        jmp TAG8
TAG8:
        ret

g:
        jmp TAG10
TAG10:
        loadi 3, r15
        ret
        jmp TAG11
TAG11:
        ret

main:
        jmp TAG13
TAG13:
        loadi 2, r16
        r17 has the result from lvalue w/out dots
        mov r16, r17
        loadi 1, r19
        loadinarg r20
        call g (g)
        comp r18, r21
        loadi 0, r22
        movlt 1, r22
        compi r22, 1
        cbreq TAG14, TAG15
TAG14:
        loadi 1, r23
        print r23
        jmp TAG15
TAG15:
        loadi 1, r25
        loadinarg r26
        call g (g)
        comp r24, r27
        loadi 0, r28
        movgt 1, r28
        compi r28, 1
        cbreq TAG16, TAG17
TAG17:
        loadi 3, r30
        print r30
        jmp TAG18
TAG16:
        loadi 1, r29
        print r29
        jmp TAG18
TAG18:
        loadi 1, r31
        compi r31, 1
        cbreq TAG19, TAG21
TAG19:
        loadi 7, r32
        print r32
        jmp TAG20
TAG20:
        loadi 1, r33
        compi r33, 1
        cbreq TAG19, TAG21
TAG21:
        loadi 1, r34
        new B, r36
        loadinarg r35
        call g (g)
        new B, r39
        loadinarg r38
        call f (f)
        loadi 1, r40
        new B, r42
        loadinarg r41
        call g (g)
        new B, r45
        loadinarg r44
        call f (f)
        print r47
        loadi 0, r48
        ret
        jmp TAG22
TAG22:
        ret

