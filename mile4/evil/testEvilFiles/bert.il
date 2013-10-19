@function buildTree
@function freeTree
@function printList
@function postOrder
@function treeprint
@function bintreesearch
@function inOrder
@function treeMain
@function main
@function freeList
@function pop
@function treeadd
@function concatLists
@function add
@function size
@function quickSortMain
@function treesearch
@function quickSort
@function get
@function myCopy
@local buildTree:list
@local buildTree:root
@local buildTree:i

@local freeTree:root

@local printList:list

@local postOrder:root
@local postOrder:temp

@local treeprint:root

@local bintreesearch:root
@local bintreesearch:target

@local inOrder:root
@local inOrder:temp

@local treeMain:list
@local treeMain:inList
@local treeMain:postList
@local treeMain:root

@local main:sortedList
@local main:element
@local main:i
@local main:copyList2
@local main:copyList1
@local main:myList

@local freeList:list

@local pop:list

@local treeadd:root
@local treeadd:toAdd
@local treeadd:temp

@local concatLists:second
@local concatLists:first
@local concatLists:temp

@local add:toAdd
@local add:list
@local add:newNode

@local size:list

@local quickSortMain:list

@local treesearch:root
@local treesearch:target

@local quickSort:list
@local quickSort:pivot
@local quickSort:temp
@local quickSort:less
@local quickSort:i
@local quickSort:greater

@local get:index
@local get:list

@local myCopy:src

concatLists:
        loadinargument second, 0, r1
        loadinargument first, 1, r0
        jumpi TAG1
TAG1:
        mov r0, r3
        comp r0, r4
        loadi 0, r5
        moveq 1, r5
        compi r5, 1
        cbreq TAG2, TAG3
TAG2:
        storeret r1
        ret
        jumpi TAG3
TAG3:
        loadai r3, next, r6
        comp r6, r7
        loadi 0, r8
        movne 1, r8
        compi r8, 1
        cbreq TAG4, TAG6
TAG4:
        loadai r3, next, r9
        mov r9, r3
        jumpi TAG5
TAG5:
        loadai r3, next, r10
        comp r10, r11
        loadi 0, r12
        movne 1, r12
        compi r12, 1
        cbreq TAG4, TAG6
TAG6:
        storeai r1, r3, next
        storeret r0
        ret
        jumpi TAG7
TAG7:
        ret

add:
        loadinargument toAdd, 0, r17
        loadinargument list, 1, r16
        jumpi TAG9
TAG9:
        new node, [data, next], r20
        mov r20, r18
        storeai r17, r18, data
        storeai r16, r18, next
        storeret r18
        ret
        jumpi TAG10
TAG10:
        ret

size:
        loadinargument list, 0, r24
        jumpi TAG12
TAG12:
        comp r24, r26
        loadi 0, r27
        moveq 1, r27
        compi r27, 1
        cbreq TAG13, TAG14
TAG13:
        loadi 0, r28
        storeret r28
        ret
        jumpi TAG14
TAG14:
        loadi 1, r29
        loadai r24, next, r31
        storeoutargument r31, 0
        call size
        add r29, r32, r33
        storeret r33
        ret
        jumpi TAG15
TAG15:
        ret

get:
        loadinargument index, 0, r36
        loadinargument list, 1, r35
        jumpi TAG17
TAG17:
        loadi 0, r38
        comp r36, r38
        loadi 0, r39
        moveq 1, r39
        compi r39, 1
        cbreq TAG18, TAG19
TAG18:
        loadai r35, data, r40
        storeret r40
        ret
        jumpi TAG19
TAG19:
        loadai r35, next, r42
        storeoutargument r42, 0
        loadi 1, r43
        sub r36, r43, r44
        storeoutargument r44, 1
        call get
        storeret r45
        ret
        jumpi TAG20
TAG20:
        ret

pop:
        loadinargument list, 0, r48
        jumpi TAG22
TAG22:
        loadai r48, next, r50
        mov r50, r48
        storeret r48
        ret
        jumpi TAG23
TAG23:
        ret

printList:
        loadinargument list, 0, r52
        jumpi TAG25
TAG25:
        comp r52, r54
        loadi 0, r55
        movne 1, r55
        compi r55, 1
        cbreq TAG26, TAG27
TAG26:
        loadai r52, data, r56
        println r56
        loadai r52, next, r58
        storeoutargument r58, 0
        call printList
        jumpi TAG27
TAG27:
        jumpi TAG28
TAG28:
        ret

treeprint:
        loadinargument root, 0, r61
        jumpi TAG30
TAG30:
        comp r61, r63
        loadi 0, r64
        movne 1, r64
        compi r64, 1
        cbreq TAG31, TAG32
TAG31:
        loadai r61, left, r66
        storeoutargument r66, 0
        call treeprint
        loadai r61, data, r68
        println r68
        loadai r61, right, r70
        storeoutargument r70, 0
        call treeprint
        jumpi TAG32
TAG32:
        jumpi TAG33
TAG33:
        ret

freeList:
        loadinargument list, 0, r73
        jumpi TAG35
TAG35:
        comp r73, r75
        loadi 0, r76
        movne 1, r76
        compi r76, 1
        cbreq TAG36, TAG37
TAG36:
        loadai r73, next, r78
        storeoutargument r78, 0
        call freeList
        del r73
        jumpi TAG37
TAG37:
        jumpi TAG38
TAG38:
        ret

freeTree:
        loadinargument root, 0, r81
        jumpi TAG40
TAG40:
        comp r81, r83
        loadi 0, r84
        moveq 1, r84
        xori r84, -1, r85
        compi r85, 1
        cbreq TAG41, TAG42
TAG41:
        loadai r81, left, r87
        storeoutargument r87, 0
        call freeTree
        loadai r81, right, r90
        storeoutargument r90, 0
        call freeTree
        del r81
        jumpi TAG42
TAG42:
        jumpi TAG43
TAG43:
        ret

postOrder:
        loadinargument root, 0, r93
        jumpi TAG45
TAG45:
        comp r93, r96
        loadi 0, r97
        movne 1, r97
        compi r97, 1
        cbreq TAG46, TAG47
TAG46:
        new node, [data, next], r98
        mov r98, r94
        loadai r93, data, r99
        storeai r99, r94, data
        storeai r100, r94, next
        loadai r93, left, r104
        storeoutargument r104, 0
        call postOrder
        storeoutargument r105, 0
        loadai r93, right, r107
        storeoutargument r107, 0
        call postOrder
        storeoutargument r108, 1
        call concatLists
        loadret r109
        storeoutargument r109, 0
        storeoutargument r94, 1
        call concatLists
        loadret r110
        storeret r110
        ret
        jumpi TAG47
TAG47:
        storeret r111
        ret
        jumpi TAG48
TAG48:
        ret

treeadd:
        loadinargument root, 0, r114
        loadinargument toAdd, 1, r115
        jumpi TAG50
TAG50:
        comp r114, r118
        loadi 0, r119
        moveq 1, r119
        compi r119, 1
        cbreq TAG51, TAG52
TAG51:
        new tnode, [data, left, right], r120
        mov r120, r116
        storeai r115, r116, data
        storeai r121, r116, left
        storeai r122, r116, right
        storeret r116
        ret
        jumpi TAG52
TAG52:
        loadai r114, data, r123
        comp r115, r123
        loadi 0, r124
        movlt 1, r124
        compi r124, 1
        cbreq TAG53, TAG54
TAG54:
        loadai r114, right, r129
        storeoutargument r129, 0
        storeoutargument r115, 1
        call treeadd
        storeai r130, r114, right
        jumpi TAG55
TAG53:
        loadai r114, left, r126
        storeoutargument r126, 0
        storeoutargument r115, 1
        call treeadd
        storeai r127, r114, left
        jumpi TAG55
TAG55:
        storeret r114
        ret
        jumpi TAG56
TAG56:
        ret

quickSort:
        loadinargument list, 0, r134
        jumpi TAG58
TAG58:
        mov r141, r137
        mov r142, r140
        storeoutargument r134, 0
        call size
        loadret r144
        loadi 1, r145
        comp r144, r145
        loadi 0, r146
        movle 1, r146
        compi r146, 1
        cbreq TAG59, TAG60
TAG59:
        storeret r134
        ret
        jumpi TAG60
TAG60:
        storeoutargument r134, 0
        loadi 0, r148
        storeoutargument r148, 1
        call get
        loadret r149
        storeoutargument r134, 0
        storeoutargument r134, 0
        call size
        loadret r152
        loadi 1, r153
        sub r152, r153, r154
        storeoutargument r154, 1
        call get
        loadret r155
        add r149, r155, r156
        loadi 2, r157
        div r156, r157, r158
        mov r158, r135
        mov r134, r136
        loadi 0, r159
        mov r159, r138
        comp r136, r160
        loadi 0, r161
        movne 1, r161
        compi r161, 1
        cbreq TAG61, TAG66
TAG61:
        storeoutargument r134, 0
        storeoutargument r138, 1
        call get
        loadret r163
        comp r163, r135
        loadi 0, r164
        movgt 1, r164
        compi r164, 1
        cbreq TAG62, TAG63
TAG63:
        storeoutargument r137, 0
        storeoutargument r134, 0
        storeoutargument r138, 1
        call get
        loadret r171
        storeoutargument r171, 1
        call add
        loadret r172
        mov r172, r137
        jumpi TAG64
TAG62:
        storeoutargument r140, 0
        storeoutargument r134, 0
        storeoutargument r138, 1
        call get
        loadret r167
        storeoutargument r167, 1
        call add
        loadret r168
        mov r168, r140
        jumpi TAG64
TAG64:
        loadai r136, next, r173
        mov r173, r136
        loadi 1, r174
        add r138, r174, r175
        mov r175, r138
        jumpi TAG65
TAG65:
        comp r136, r176
        loadi 0, r177
        movne 1, r177
        compi r177, 1
        cbreq TAG61, TAG66
TAG66:
        storeoutargument r134, 0
        call freeList
        storeoutargument r137, 0
        call quickSort
        storeoutargument r182, 0
        storeoutargument r140, 0
        call quickSort
        storeoutargument r184, 1
        call concatLists
        loadret r185
        storeret r185
        ret
        jumpi TAG67
TAG67:
        ret

quickSortMain:
        loadinargument list, 0, r192
        jumpi TAG69
TAG69:
        storeoutargument r192, 0
        call printList
        loadi 999, r196
        loadi -1, r197
        mult r196, r197, r197
        println r197
        storeoutargument r192, 0
        call printList
        loadi 999, r200
        loadi -1, r201
        mult r200, r201, r201
        println r201
        storeoutargument r192, 0
        call printList
        loadi 999, r204
        loadi -1, r205
        mult r204, r205, r205
        println r205
        storeret r192
        ret
        jumpi TAG70
TAG70:
        ret

treesearch:
        loadinargument root, 0, r207
        loadinargument target, 1, r208
        jumpi TAG72
TAG72:
        loadi 1, r210
        loadi -1, r211
        mult r210, r211, r211
        println r211
        comp r207, r212
        loadi 0, r213
        movne 1, r213
        compi r213, 1
        cbreq TAG73, TAG81
TAG73:
        loadai r207, data, r214
        comp r214, r208
        loadi 0, r215
        moveq 1, r215
        compi r215, 1
        cbreq TAG74, TAG75
TAG74:
        loadi 1, r216
        storeret r216
        ret
        jumpi TAG75
TAG75:
        loadai r207, left, r218
        storeoutargument r218, 0
        storeoutargument r208, 1
        call treesearch
        loadi 1, r220
        comp r219, r220
        loadi 0, r221
        moveq 1, r221
        compi r221, 1
        cbreq TAG76, TAG77
TAG76:
        loadi 1, r222
        storeret r222
        ret
        jumpi TAG77
TAG77:
        loadai r207, right, r224
        storeoutargument r224, 0
        storeoutargument r208, 1
        call treesearch
        loadi 1, r226
        comp r225, r226
        loadi 0, r227
        moveq 1, r227
        compi r227, 1
        cbreq TAG78, TAG79
TAG79:
        loadi 0, r229
        storeret r229
        ret
        jumpi TAG80
TAG78:
        loadi 1, r228
        storeret r228
        ret
        jumpi TAG80
TAG80:
        jumpi TAG81
TAG81:
        loadi 0, r230
        storeret r230
        ret
        jumpi TAG82
TAG82:
        ret

inOrder:
        loadinargument root, 0, r233
        jumpi TAG84
TAG84:
        comp r233, r236
        loadi 0, r237
        movne 1, r237
        compi r237, 1
        cbreq TAG85, TAG86
TAG86:
        storeret r251
        ret
        jumpi TAG87
TAG85:
        new node, [data, next], r238
        mov r238, r234
        loadai r233, data, r239
        storeai r239, r234, data
        storeai r240, r234, next
        loadai r233, left, r243
        storeoutargument r243, 0
        call inOrder
        storeoutargument r244, 0
        storeoutargument r234, 0
        loadai r233, right, r247
        storeoutargument r247, 0
        call inOrder
        storeoutargument r248, 1
        call concatLists
        loadret r249
        storeoutargument r249, 1
        call concatLists
        loadret r250
        storeret r250
        ret
        jumpi TAG87
TAG87:
        jumpi TAG88
TAG88:
        ret

bintreesearch:
        loadinargument root, 0, r254
        loadinargument target, 1, r255
        jumpi TAG90
TAG90:
        loadi 1, r257
        loadi -1, r258
        mult r257, r258, r258
        println r258
        comp r254, r259
        loadi 0, r260
        movne 1, r260
        compi r260, 1
        cbreq TAG91, TAG97
TAG91:
        loadai r254, data, r261
        comp r261, r255
        loadi 0, r262
        moveq 1, r262
        compi r262, 1
        cbreq TAG92, TAG93
TAG92:
        loadi 1, r263
        storeret r263
        ret
        jumpi TAG93
TAG93:
        loadai r254, data, r264
        comp r255, r264
        loadi 0, r265
        movlt 1, r265
        compi r265, 1
        cbreq TAG94, TAG95
TAG95:
        loadai r254, right, r270
        storeoutargument r270, 0
        storeoutargument r255, 1
        call bintreesearch
        storeret r271
        ret
        jumpi TAG96
TAG94:
        loadai r254, left, r267
        storeoutargument r267, 0
        storeoutargument r255, 1
        call bintreesearch
        storeret r268
        ret
        jumpi TAG96
TAG96:
        jumpi TAG97
TAG97:
        loadi 0, r272
        storeret r272
        ret
        jumpi TAG98
TAG98:
        ret

buildTree:
        loadinargument list, 0, r275
        jumpi TAG100
TAG100:
        mov r279, r276
        loadi 0, r280
        mov r280, r277
        storeoutargument r275, 0
        call size
        loadret r282
        comp r277, r282
        loadi 0, r283
        movlt 1, r283
        compi r283, 1
        cbreq TAG101, TAG103
TAG101:
        storeoutargument r276, 0
        storeoutargument r275, 0
        storeoutargument r277, 1
        call get
        loadret r286
        storeoutargument r286, 1
        call treeadd
        loadret r287
        mov r287, r276
        loadi 1, r288
        add r277, r288, r289
        mov r289, r277
        jumpi TAG102
TAG102:
        storeoutargument r275, 0
        call size
        loadret r291
        comp r277, r291
        loadi 0, r292
        movlt 1, r292
        compi r292, 1
        cbreq TAG101, TAG103
TAG103:
        storeret r276
        ret
        jumpi TAG104
TAG104:
        ret

treeMain:
        loadinargument list, 0, r296
        jumpi TAG106
TAG106:
        storeoutargument r296, 0
        call buildTree
        loadret r302
        mov r302, r299
        storeoutargument r299, 0
        call treeprint
        loadi 999, r305
        loadi -1, r306
        mult r305, r306, r306
        println r306
        storeoutargument r299, 0
        call inOrder
        loadret r308
        mov r308, r297
        storeoutargument r297, 0
        call printList
        loadi 999, r311
        loadi -1, r312
        mult r311, r312, r312
        println r312
        storeoutargument r297, 0
        call freeList
        storeoutargument r299, 0
        call postOrder
        loadret r316
        mov r316, r298
        storeoutargument r298, 0
        call printList
        loadi 999, r319
        loadi -1, r320
        mult r319, r320, r320
        println r320
        storeoutargument r298, 0
        call freeList
        storeoutargument r299, 0
        loadi 0, r324
        storeoutargument r324, 1
        call treesearch
        loadret r325
        println r325
        loadi 999, r326
        loadi -1, r327
        mult r326, r327, r327
        println r327
        storeoutargument r299, 0
        loadi 10, r329
        storeoutargument r329, 1
        call treesearch
        loadret r330
        println r330
        loadi 999, r331
        loadi -1, r332
        mult r331, r332, r332
        println r332
        storeoutargument r299, 0
        loadi 2, r334
        loadi -1, r335
        mult r334, r335, r335
        storeoutargument r335, 1
        call treesearch
        loadret r336
        println r336
        loadi 999, r337
        loadi -1, r338
        mult r337, r338, r338
        println r338
        storeoutargument r299, 0
        loadi 2, r340
        storeoutargument r340, 1
        call treesearch
        loadret r341
        println r341
        loadi 999, r342
        loadi -1, r343
        mult r342, r343, r343
        println r343
        storeoutargument r299, 0
        loadi 3, r345
        storeoutargument r345, 1
        call treesearch
        loadret r346
        println r346
        loadi 999, r347
        loadi -1, r348
        mult r347, r348, r348
        println r348
        storeoutargument r299, 0
        loadi 9, r350
        storeoutargument r350, 1
        call treesearch
        loadret r351
        println r351
        loadi 999, r352
        loadi -1, r353
        mult r352, r353, r353
        println r353
        storeoutargument r299, 0
        loadi 1, r355
        storeoutargument r355, 1
        call treesearch
        loadret r356
        println r356
        loadi 999, r357
        loadi -1, r358
        mult r357, r358, r358
        println r358
        storeoutargument r299, 0
        loadi 0, r360
        storeoutargument r360, 1
        call bintreesearch
        loadret r361
        println r361
        loadi 999, r362
        loadi -1, r363
        mult r362, r363, r363
        println r363
        storeoutargument r299, 0
        loadi 10, r365
        storeoutargument r365, 1
        call bintreesearch
        loadret r366
        println r366
        loadi 999, r367
        loadi -1, r368
        mult r367, r368, r368
        println r368
        storeoutargument r299, 0
        loadi 2, r370
        loadi -1, r371
        mult r370, r371, r371
        storeoutargument r371, 1
        call bintreesearch
        loadret r372
        println r372
        loadi 999, r373
        loadi -1, r374
        mult r373, r374, r374
        println r374
        storeoutargument r299, 0
        loadi 2, r376
        storeoutargument r376, 1
        call bintreesearch
        loadret r377
        println r377
        loadi 999, r378
        loadi -1, r379
        mult r378, r379, r379
        println r379
        storeoutargument r299, 0
        loadi 3, r381
        storeoutargument r381, 1
        call bintreesearch
        loadret r382
        println r382
        loadi 999, r383
        loadi -1, r384
        mult r383, r384, r384
        println r384
        storeoutargument r299, 0
        loadi 9, r386
        storeoutargument r386, 1
        call bintreesearch
        loadret r387
        println r387
        loadi 999, r388
        loadi -1, r389
        mult r388, r389, r389
        println r389
        storeoutargument r299, 0
        loadi 1, r391
        storeoutargument r391, 1
        call bintreesearch
        loadret r392
        println r392
        loadi 999, r393
        loadi -1, r394
        mult r393, r394, r394
        println r394
        storeoutargument r299, 0
        call freeTree
        jumpi TAG107
TAG107:
        ret

myCopy:
        loadinargument src, 0, r401
        jumpi TAG109
TAG109:
        comp r401, r403
        loadi 0, r404
        moveq 1, r404
        compi r404, 1
        cbreq TAG110, TAG111
TAG110:
        storeret r405
        ret
        jumpi TAG111
TAG111:
        storeoutargument r408, 0
        loadai r401, data, r409
        storeoutargument r409, 1
        call add
        loadret r410
        storeoutargument r410, 0
        loadai r401, next, r412
        storeoutargument r412, 0
        call myCopy
        storeoutargument r413, 1
        call concatLists
        loadret r414
        storeret r414
        ret
        jumpi TAG112
TAG112:
        ret

main:
        jumpi TAG114
TAG114:
        mov r423, r422
        loadi 0, r424
        mov r424, r419
        loadi 10, r425
        comp r419, r425
        loadi 0, r426
        movlt 1, r426
        compi r426, 1
        cbreq TAG115, TAG117
TAG115:
        storeglobal r418, readMePrzButDontTouch
        computeglobaladdress readMePrzButDontTouch, r418
        read r418
        loadglobal readMePrzButDontTouch, r418
        storeoutargument r422, 0
        storeoutargument r418, 1
        call add
        loadret r428
        mov r428, r422
        storeoutargument r422, 0
        call myCopy
        loadret r430
        mov r430, r421
        storeoutargument r422, 0
        call myCopy
        loadret r432
        mov r432, r420
        storeoutargument r421, 0
        call quickSortMain
        loadret r434
        mov r434, r417
        storeoutargument r417, 0
        call freeList
        storeoutargument r420, 0
        call treeMain
        loadi 1, r439
        add r419, r439, r440
        mov r440, r419
        jumpi TAG116
TAG116:
        loadi 10, r441
        comp r419, r441
        loadi 0, r442
        movlt 1, r442
        compi r442, 1
        cbreq TAG115, TAG117
TAG117:
        storeoutargument r422, 0
        call freeList
        storeoutargument r421, 0
        call freeList
        storeoutargument r420, 0
        call freeList
        loadi 0, r449
        storeret r449
        ret
        jumpi TAG118
TAG118:
        ret

