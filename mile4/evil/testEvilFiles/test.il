@function main
@local main:x

@function test

test:
        jumpi TAG1
TAG1:
        loadi 1, r0
        add null, r0, r1
        mov r1, r2
        jumpi TAG2
TAG2:
        ret

main:
        jumpi TAG4
TAG4:
        loadi 3, r5
        loadinarg r5
        call test (test)
        jumpi TAG5
TAG5:
        ret

