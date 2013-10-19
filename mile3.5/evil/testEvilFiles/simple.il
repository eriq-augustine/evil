@function main

main:
        jumpi TAG1
TAG1:
	loadi 2, r8
	storeglobal r8, glo
	computeglobaladdress glo, r3
	read r3
        loadai r8, 0, r0
        print r0
        jumpi TAG2
TAG2:
        ret

