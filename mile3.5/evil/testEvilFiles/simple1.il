@function main
@local main:a
@local main:funfun

main:
        jumpi TAG1
TAG1:
        Loading funfun from heap to r0
        Loading member:i from structure at r0 to r1
        mov r1, r2
        jumpi TAG2
TAG2:
        ret

