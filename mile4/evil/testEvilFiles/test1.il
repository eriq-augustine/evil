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
        jumpi TAG1
TAG1:
        loadai null, a, r0
        loadai r0, a, r1
        loadai r1, a, r2
        loadai r2, a, r3
        ret
        jumpi TAG2
TAG2:
        ret

foo:
        jumpi TAG4
TAG4:
        loadi 0, r8
        comp null, r8
        loadi 0, r9
        movle 1, r9
        compi r9, 1
        cbreq TAG5, TAG6
TAG6:
        loadi 1, r11
        sub null, r11, r12
        loadinarg r12
        call foo (foo)
        mult null, r13, r14
        ret
        jumpi TAG7
TAG5:
        loadi 1, r10
        ret
        jumpi TAG7
TAG7:
        jumpi TAG8
TAG8:
        ret

g:
        jumpi TAG10
TAG10:
        loadi 3, r16
        ret
        jumpi TAG11
TAG11:
        ret

main:
        jumpi TAG13
TAG13:
        loadi 2, r21
        mov r21, r22
        loadi 0, r23
        compi r23, 1
        cbreq TAG14, TAG15
TAG14:
        loadi 1, r24
        print r24
        jumpi TAG15
TAG15:
        loadi 1, r25
        loadinarg r26
        call g (g)
        comp null, r27
        loadi 0, r28
        movgt 1, r28
        compi r28, 1
        cbreq TAG16, TAG17
TAG17:
        loadi 3, r30
        print r30
        jumpi TAG18
TAG16:
        loadi 1, r29
        print r29
        jumpi TAG18
TAG18:
        loadi 1, r31
        compi r31, 1
        cbreq TAG19, TAG21
TAG19:
        loadi 7, r32
        print r32
        jumpi TAG20
TAG20:
        loadi 1, r33
        compi r33, 1
        cbreq TAG19, TAG21
TAG21:
        loadi 1, r34
        new B, [a], r35
        loadinarg r35
        call g (g)
        new B, [a], r37
        loadinarg r37
        call f (f)
        loadi 0, r38
        ret
        jumpi TAG22
TAG22:
        ret

