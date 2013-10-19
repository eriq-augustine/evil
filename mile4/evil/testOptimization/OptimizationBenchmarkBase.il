@function tailRecursion
@function iterativeFibonacci
@function tailRecursionHelper
@function deadCodeElimination
@function sum
@function randomCalculation
@function association
@function hoisting
@function recursiveFibonacci
@function main
@function constantFolding
@function constantPropagation
@function unswitching
@function integerDivide
@function interProceduralOptimization
@function doesntModifyGlobals
@function doubleIf
@function commonSubexpressionElimination
@local tailRecursion:value

@local iterativeFibonacci:number
@local iterativeFibonacci:result
@local iterativeFibonacci:i
@local iterativeFibonacci:sum
@local iterativeFibonacci:count
@local iterativeFibonacci:previous

@local tailRecursionHelper:sum
@local tailRecursionHelper:value

@local deadCodeElimination:b
@local deadCodeElimination:a
@local deadCodeElimination:e
@local deadCodeElimination:d
@local deadCodeElimination:c

@local sum:number
@local sum:total

@local randomCalculation:number
@local randomCalculation:i
@local randomCalculation:sum
@local randomCalculation:e
@local randomCalculation:d
@local randomCalculation:c
@local randomCalculation:b
@local randomCalculation:a

@local association:a

@local hoisting:i
@local hoisting:h
@local hoisting:g
@local hoisting:f
@local hoisting:e
@local hoisting:d
@local hoisting:c
@local hoisting:b
@local hoisting:a

@local recursiveFibonacci:number

@local main:result
@local main:input
@local main:i

@local constantFolding:a

@local constantPropagation:z
@local constantPropagation:y
@local constantPropagation:x
@local constantPropagation:w
@local constantPropagation:v
@local constantPropagation:u
@local constantPropagation:t
@local constantPropagation:s
@local constantPropagation:r
@local constantPropagation:q
@local constantPropagation:p
@local constantPropagation:o
@local constantPropagation:n
@local constantPropagation:m
@local constantPropagation:l
@local constantPropagation:k
@local constantPropagation:j
@local constantPropagation:i
@local constantPropagation:h
@local constantPropagation:g
@local constantPropagation:f
@local constantPropagation:e
@local constantPropagation:d
@local constantPropagation:c
@local constantPropagation:b
@local constantPropagation:a

@local unswitching:b
@local unswitching:a

@local integerDivide:a

@local interProceduralOptimization:a

@local doesntModifyGlobals:b
@local doesntModifyGlobals:a

@local doubleIf:b
@local doubleIf:a
@local doubleIf:d
@local doubleIf:c

@local commonSubexpressionElimination:z
@local commonSubexpressionElimination:y
@local commonSubexpressionElimination:x
@local commonSubexpressionElimination:w
@local commonSubexpressionElimination:v
@local commonSubexpressionElimination:u
@local commonSubexpressionElimination:t
@local commonSubexpressionElimination:s
@local commonSubexpressionElimination:r
@local commonSubexpressionElimination:q
@local commonSubexpressionElimination:p
@local commonSubexpressionElimination:o
@local commonSubexpressionElimination:n
@local commonSubexpressionElimination:m
@local commonSubexpressionElimination:l
@local commonSubexpressionElimination:k
@local commonSubexpressionElimination:j
@local commonSubexpressionElimination:i
@local commonSubexpressionElimination:h
@local commonSubexpressionElimination:g
@local commonSubexpressionElimination:f
@local commonSubexpressionElimination:e
@local commonSubexpressionElimination:d
@local commonSubexpressionElimination:c
@local commonSubexpressionElimination:b
@local commonSubexpressionElimination:a

constantFolding:
        jumpi TAG1
TAG1:
        loadi 8, r2
        loadi 9, r3
        mult r2, r3, r4
        loadi 4, r5
        div r4, r5, r6
        loadi 2, r7
        add r6, r7, r8
        loadi 5, r9
        loadi 8, r10
        mult r9, r10, r11
        sub r8, r11, r12
        loadi 9, r13
        add r12, r13, r14
        loadi 12, r15
        sub r14, r15, r16
        loadi 6, r17
        add r16, r17, r18
        loadi 9, r19
        sub r18, r19, r20
        loadi 18, r21
        sub r20, r21, r22
        loadi 23, r23
        loadi 3, r24
        mult r23, r24, r25
        loadi 23, r26
        div r25, r26, r27
        loadi 90, r28
        mult r27, r28, r29
        add r22, r29, r30
        mov r30, r0
        storeret r0
        ret
        jumpi TAG2
TAG2:
        ret

constantPropagation:
        jumpi TAG4
TAG4:
        loadi 4, r59
        mov r59, r58
        loadi 7, r60
        mov r60, r57
        loadi 8, r61
        mov r61, r56
        loadi 5, r62
        mov r62, r55
        loadi 11, r63
        mov r63, r54
        loadi 21, r64
        mov r64, r53
        add r58, r57, r65
        mov r65, r52
        add r56, r55, r66
        mov r66, r51
        add r54, r53, r67
        mov r67, r50
        add r52, r51, r68
        mov r68, r49
        mult r50, r49, r69
        mov r69, r48
        mult r51, r50, r70
        add r54, r70, r71
        sub r71, r48, r72
        mov r72, r47
        mult r50, r49, r73
        sub r51, r73, r74
        div r48, r47, r75
        add r74, r75, r76
        mov r76, r46
        add r54, r53, r77
        add r77, r52, r78
        add r78, r51, r79
        add r79, r50, r80
        sub r80, r49, r81
        mov r81, r45
        sub r45, r46, r82
        add r82, r51, r83
        sub r83, r58, r84
        sub r84, r57, r85
        mov r85, r44
        add r48, r47, r86
        sub r86, r52, r87
        sub r87, r51, r88
        mov r88, r43
        sub r57, r58, r89
        mult r89, r55, r90
        sub r90, r50, r91
        mov r91, r42
        mult r47, r56, r92
        mult r92, r55, r93
        add r93, r44, r94
        mov r94, r41
        mult r57, r58, r95
        mult r95, r56, r96
        div r96, r54, r97
        sub r97, r44, r98
        mov r98, r40
        add r50, r48, r99
        add r99, r56, r100
        sub r100, r43, r101
        mov r101, r39
        add r45, r44, r102
        mult r53, r58, r103
        sub r102, r103, r104
        mov r104, r38
        mult r58, r57, r105
        sub r105, r48, r106
        sub r106, r47, r107
        mov r107, r37
        sub r37, r40, r108
        mult r41, r55, r109
        sub r108, r109, r110
        mov r110, r36
        sub r44, r36, r111
        sub r111, r37, r112
        sub r112, r45, r113
        mov r113, r35
        mult r43, r35, r114
        mult r114, r39, r115
        sub r115, r36, r116
        mov r116, r33
        mult r35, r33, r117
        sub r36, r117, r118
        add r118, r48, r119
        mov r119, r32
        storeret r32
        ret
        jumpi TAG5
TAG5:
        ret

deadCodeElimination:
        jumpi TAG7
TAG7:
        loadi 4, r152
        mov r152, r147
        loadi 5, r153
        mov r153, r147
        loadi 7, r154
        mov r154, r147
        loadi 8, r155
        mov r155, r147
        loadi 6, r156
        mov r156, r146
        loadi 9, r157
        mov r157, r146
        loadi 12, r158
        mov r158, r146
        loadi 8, r159
        mov r159, r146
        loadi 10, r160
        mov r160, r151
        loadi 13, r161
        mov r161, r151
        loadi 9, r162
        mov r162, r151
        loadi 45, r163
        mov r163, r150
        loadi 12, r164
        mov r164, r150
        loadi 3, r165
        mov r165, r150
        loadi 23, r166
        mov r166, r149
        loadi 10, r167
        mov r167, r149
        loadi 11, r168
        storeglobal r168, global1
        loadi 5, r169
        storeglobal r169, global1
        loadi 9, r170
        storeglobal r170, global1
        add r147, r146, r171
        add r171, r151, r172
        add r172, r150, r173
        add r173, r149, r174
        storeret r174
        ret
        jumpi TAG8
TAG8:
        ret

sum:
        loadinargument number, 0, r180
        jumpi TAG10
TAG10:
        loadi 0, r183
        mov r183, r182
        loadi 0, r184
        comp r180, r184
        loadi 0, r185
        movgt 1, r185
        compi r185, 1
        cbreq TAG11, TAG13
TAG11:
        add r182, r180, r186
        mov r186, r182
        loadi 1, r187
        sub r180, r187, r188
        mov r188, r180
        jumpi TAG12
TAG12:
        loadi 0, r189
        comp r180, r189
        loadi 0, r190
        movgt 1, r190
        compi r190, 1
        cbreq TAG11, TAG13
TAG13:
        storeret r182
        ret
        jumpi TAG14
TAG14:
        ret

doesntModifyGlobals:
        jumpi TAG16
TAG16:
        loadi 1, r196
        mov r196, r194
        loadi 2, r197
        mov r197, r193
        add r194, r193, r198
        storeret r198
        ret
        jumpi TAG17
TAG17:
        ret

interProceduralOptimization:
        jumpi TAG19
TAG19:
        loadi 1, r203
        storeglobal r203, global1
        loadi 0, r204
        storeglobal r204, global2
        loadi 0, r205
        storeglobal r205, global3
        loadi 100, r207
        storeoutargument r207, 0
        call sum
        loadret r208
        mov r208, r201
        loadglobal global1, r209
        loadi 1, r210
        comp r209, r210
        loadi 0, r211
        moveq 1, r211
        compi r211, 1
        cbreq TAG20, TAG21
TAG21:
        loadglobal global2, r215
        loadi 2, r216
        comp r215, r216
        loadi 0, r217
        moveq 1, r217
        compi r217, 1
        cbreq TAG22, TAG23
TAG22:
        loadi 20000, r219
        storeoutargument r219, 0
        call sum
        loadret r220
        mov r220, r201
        jumpi TAG23
TAG23:
        loadglobal global3, r221
        loadi 3, r222
        comp r221, r222
        loadi 0, r223
        moveq 1, r223
        compi r223, 1
        cbreq TAG24, TAG25
TAG24:
        loadi 30000, r225
        storeoutargument r225, 0
        call sum
        loadret r226
        mov r226, r201
        jumpi TAG25
TAG25:
        jumpi TAG26
TAG20:
        loadi 10000, r213
        storeoutargument r213, 0
        call sum
        loadret r214
        mov r214, r201
        jumpi TAG26
TAG26:
        storeret r201
        ret
        jumpi TAG27
TAG27:
        ret

commonSubexpressionElimination:
        jumpi TAG29
TAG29:
        loadi 11, r255
        mov r255, r254
        loadi 22, r256
        mov r256, r253
        loadi 33, r257
        mov r257, r252
        loadi 44, r258
        mov r258, r250
        loadi 55, r259
        mov r259, r249
        loadi 66, r260
        mov r260, r248
        loadi 77, r261
        mov r261, r247
        mult r254, r253, r262
        mov r262, r246
        div r252, r250, r263
        mov r263, r245
        mult r249, r248, r264
        mov r264, r244
        mult r254, r253, r265
        div r252, r250, r266
        add r265, r266, r267
        mult r249, r248, r268
        sub r267, r268, r269
        add r269, r247, r270
        mov r270, r243
        mult r254, r253, r271
        div r252, r250, r272
        add r271, r272, r273
        mult r249, r248, r274
        sub r273, r274, r275
        add r275, r247, r276
        mov r276, r242
        mult r254, r253, r277
        div r252, r250, r278
        add r277, r278, r279
        mult r249, r248, r280
        sub r279, r280, r281
        add r281, r247, r282
        mov r282, r241
        mult r254, r253, r283
        div r252, r250, r284
        add r283, r284, r285
        mult r249, r248, r286
        sub r285, r286, r287
        add r287, r247, r288
        mov r288, r240
        mult r254, r253, r289
        div r252, r250, r290
        add r289, r290, r291
        mult r249, r248, r292
        sub r291, r292, r293
        add r293, r247, r294
        mov r294, r239
        mult r254, r253, r295
        div r252, r250, r296
        add r295, r296, r297
        mult r249, r248, r298
        sub r297, r298, r299
        add r299, r247, r300
        mov r300, r238
        mult r254, r253, r301
        div r252, r250, r302
        add r301, r302, r303
        mult r249, r248, r304
        sub r303, r304, r305
        add r305, r247, r306
        mov r306, r237
        mult r254, r253, r307
        div r252, r250, r308
        add r307, r308, r309
        mult r249, r248, r310
        sub r309, r310, r311
        add r311, r247, r312
        mov r312, r236
        mult r254, r253, r313
        div r252, r250, r314
        add r313, r314, r315
        mult r249, r248, r316
        sub r315, r316, r317
        add r317, r247, r318
        mov r318, r235
        mult r254, r253, r319
        div r252, r250, r320
        add r319, r320, r321
        mult r249, r248, r322
        sub r321, r322, r323
        add r323, r247, r324
        mov r324, r234
        mult r254, r253, r325
        div r252, r250, r326
        add r325, r326, r327
        mult r249, r248, r328
        sub r327, r328, r329
        add r329, r247, r330
        mov r330, r233
        mult r253, r254, r331
        div r252, r250, r332
        add r331, r332, r333
        mult r249, r248, r334
        sub r333, r334, r335
        add r335, r247, r336
        mov r336, r232
        mult r254, r253, r337
        div r252, r250, r338
        add r337, r338, r339
        mult r248, r249, r340
        sub r339, r340, r341
        add r341, r247, r342
        mov r342, r231
        mult r254, r253, r343
        add r247, r343, r344
        div r252, r250, r345
        add r344, r345, r346
        mult r249, r248, r347
        sub r346, r347, r348
        mov r348, r230
        mult r254, r253, r349
        div r252, r250, r350
        add r349, r350, r351
        mult r249, r248, r352
        sub r351, r352, r353
        add r353, r247, r354
        mov r354, r229
        div r252, r250, r355
        mult r254, r253, r356
        add r355, r356, r357
        mult r249, r248, r358
        sub r357, r358, r359
        add r359, r247, r360
        mov r360, r228
        add r254, r253, r361
        add r361, r252, r362
        add r362, r250, r363
        add r363, r249, r364
        add r364, r248, r365
        add r365, r247, r366
        add r366, r246, r367
        add r367, r245, r368
        add r368, r244, r369
        add r369, r243, r370
        add r370, r242, r371
        add r371, r241, r372
        add r372, r240, r373
        add r373, r239, r374
        add r374, r238, r375
        add r375, r237, r376
        add r376, r236, r377
        add r377, r235, r378
        add r378, r234, r379
        add r379, r233, r380
        add r380, r232, r381
        add r381, r231, r382
        add r382, r230, r383
        add r383, r229, r384
        add r384, r228, r385
        storeret r385
        ret
        jumpi TAG30
TAG30:
        ret

hoisting:
        jumpi TAG32
TAG32:
        loadi 1, r422
        mov r422, r421
        loadi 2, r423
        mov r423, r420
        loadi 3, r424
        mov r424, r419
        loadi 4, r425
        mov r425, r418
        loadi 0, r426
        mov r426, r412
        loadi 1000000, r427
        comp r412, r427
        loadi 0, r428
        movlt 1, r428
        compi r428, 1
        cbreq TAG33, TAG35
TAG33:
        loadi 5, r429
        mov r429, r417
        add r421, r420, r430
        add r430, r419, r431
        mov r431, r414
        add r419, r418, r432
        add r432, r414, r433
        mov r433, r413
        loadi 1, r434
        add r412, r434, r435
        mov r435, r412
        jumpi TAG34
TAG34:
        loadi 1000000, r436
        comp r412, r436
        loadi 0, r437
        movlt 1, r437
        compi r437, 1
        cbreq TAG33, TAG35
TAG35:
        storeret r420
        ret
        jumpi TAG36
TAG36:
        ret

doubleIf:
        jumpi TAG38
TAG38:
        loadi 1, r452
        mov r452, r448
        loadi 2, r453
        mov r453, r447
        loadi 3, r454
        mov r454, r451
        loadi 1, r455
        comp r448, r455
        loadi 0, r456
        moveq 1, r456
        compi r456, 1
        cbreq TAG39, TAG43
TAG39:
        loadi 20, r457
        mov r457, r447
        loadi 1, r458
        comp r448, r458
        loadi 0, r459
        moveq 1, r459
        compi r459, 1
        cbreq TAG40, TAG41
TAG41:
        loadi 1, r462
        mov r462, r448
        loadi 2, r463
        mov r463, r447
        loadi 3, r464
        mov r464, r451
        jumpi TAG42
TAG40:
        loadi 200, r460
        mov r460, r447
        loadi 300, r461
        mov r461, r451
        jumpi TAG42
TAG42:
        loadi 50, r465
        mov r465, r449
        jumpi TAG43
TAG43:
        storeret r449
        ret
        jumpi TAG44
TAG44:
        ret

integerDivide:
        jumpi TAG46
TAG46:
        loadi 3000, r472
        mov r472, r470
        loadi 2, r473
        div r470, r473, r474
        mov r474, r470
        loadi 4, r475
        mult r470, r475, r476
        mov r476, r470
        loadi 8, r477
        div r470, r477, r478
        mov r478, r470
        loadi 16, r479
        div r470, r479, r480
        mov r480, r470
        loadi 32, r481
        mult r470, r481, r482
        mov r482, r470
        loadi 64, r483
        div r470, r483, r484
        mov r484, r470
        loadi 128, r485
        mult r470, r485, r486
        mov r486, r470
        loadi 4, r487
        div r470, r487, r488
        mov r488, r470
        storeret r470
        ret
        jumpi TAG47
TAG47:
        ret

association:
        jumpi TAG49
TAG49:
        loadi 10, r492
        mov r492, r490
        loadi 2, r493
        mult r490, r493, r494
        mov r494, r490
        loadi 2, r495
        div r490, r495, r496
        mov r496, r490
        loadi 3, r497
        mult r497, r490, r498
        mov r498, r490
        loadi 3, r499
        div r490, r499, r500
        mov r500, r490
        loadi 4, r501
        mult r490, r501, r502
        mov r502, r490
        loadi 4, r503
        div r490, r503, r504
        mov r504, r490
        loadi 4, r505
        add r490, r505, r506
        mov r506, r490
        loadi 4, r507
        sub r490, r507, r508
        mov r508, r490
        loadi 50, r509
        mult r490, r509, r510
        mov r510, r490
        loadi 50, r511
        div r490, r511, r512
        mov r512, r490
        storeret r490
        ret
        jumpi TAG50
TAG50:
        ret

tailRecursionHelper:
        loadinargument value, 0, r514
        loadinargument sum, 1, r515
        jumpi TAG52
TAG52:
        loadi 0, r517
        comp r514, r517
        loadi 0, r518
        moveq 1, r518
        compi r518, 1
        cbreq TAG53, TAG54
TAG54:
        loadi 1, r520
        sub r514, r520, r521
        add r515, r514, r522
        storeoutargument r521, 0
        storeoutargument r522, 1
        call tailRecursionHelper
        loadret r523
        storeret r523
        ret
        jumpi TAG55
TAG53:
        storeret r515
        ret
        jumpi TAG55
TAG55:
        jumpi TAG56
TAG56:
        ret

tailRecursion:
        loadinargument value, 0, r526
        jumpi TAG58
TAG58:
        loadi 0, r529
        storeoutargument r526, 0
        storeoutargument r529, 1
        call tailRecursionHelper
        loadret r530
        storeret r530
        ret
        jumpi TAG59
TAG59:
        ret

unswitching:
        jumpi TAG61
TAG61:
        loadi 1, r535
        mov r535, r533
        loadi 2, r536
        mov r536, r532
        loadi 1000000, r537
        comp r533, r537
        loadi 0, r538
        movlt 1, r538
        compi r538, 1
        cbreq TAG62, TAG67
TAG62:
        loadi 2, r539
        comp r532, r539
        loadi 0, r540
        moveq 1, r540
        compi r540, 1
        cbreq TAG63, TAG64
TAG64:
        loadi 2, r543
        add r533, r543, r544
        mov r544, r533
        jumpi TAG65
TAG63:
        loadi 1, r541
        add r533, r541, r542
        mov r542, r533
        jumpi TAG65
TAG65:
        jumpi TAG66
TAG66:
        loadi 1000000, r545
        comp r533, r545
        loadi 0, r546
        movlt 1, r546
        compi r546, 1
        cbreq TAG62, TAG67
TAG67:
        storeret r533
        ret
        jumpi TAG68
TAG68:
        ret

randomCalculation:
        loadinargument number, 0, r549
        jumpi TAG70
TAG70:
        loadi 0, r558
        mov r558, r551
        loadi 0, r559
        mov r559, r552
        comp r551, r549
        loadi 0, r560
        movlt 1, r560
        compi r560, 1
        cbreq TAG71, TAG73
TAG71:
        loadi 4, r561
        mov r561, r557
        loadi 7, r562
        mov r562, r556
        loadi 8, r563
        mov r563, r555
        add r557, r556, r564
        mov r564, r554
        add r554, r555, r565
        mov r565, r553
        add r552, r553, r566
        mov r566, r552
        loadi 2, r567
        mult r551, r567, r568
        mov r568, r551
        loadi 2, r569
        div r551, r569, r570
        mov r570, r551
        loadi 3, r571
        mult r571, r551, r572
        mov r572, r551
        loadi 3, r573
        div r551, r573, r574
        mov r574, r551
        loadi 4, r575
        mult r551, r575, r576
        mov r576, r551
        loadi 4, r577
        div r551, r577, r578
        mov r578, r551
        loadi 1, r579
        add r551, r579, r580
        mov r580, r551
        jumpi TAG72
TAG72:
        comp r551, r549
        loadi 0, r581
        movlt 1, r581
        compi r581, 1
        cbreq TAG71, TAG73
TAG73:
        storeret r552
        ret
        jumpi TAG74
TAG74:
        ret

iterativeFibonacci:
        loadinargument number, 0, r590
        jumpi TAG76
TAG76:
        loadi 1, r597
        loadi -1, r598
        mult r597, r598, r598
        mov r598, r595
        loadi 1, r599
        mov r599, r591
        loadi 0, r600
        mov r600, r592
        comp r592, r590
        loadi 0, r601
        movlt 1, r601
        compi r601, 1
        cbreq TAG77, TAG79
TAG77:
        add r591, r595, r602
        mov r602, r593
        mov r591, r595
        mov r593, r591
        loadi 1, r603
        add r592, r603, r604
        mov r604, r592
        jumpi TAG78
TAG78:
        comp r592, r590
        loadi 0, r605
        movlt 1, r605
        compi r605, 1
        cbreq TAG77, TAG79
TAG79:
        storeret r591
        ret
        jumpi TAG80
TAG80:
        ret

recursiveFibonacci:
        loadinargument number, 0, r612
        jumpi TAG82
TAG82:
        loadi 0, r614
        comp r612, r614
        loadi 0, r615
        movle 1, r615
        loadi 1, r616
        comp r612, r616
        loadi 0, r617
        moveq 1, r617
        or r615, r617, r618
        compi r618, 1
        cbreq TAG83, TAG84
TAG84:
        loadi 1, r620
        sub r612, r620, r621
        storeoutargument r621, 0
        call recursiveFibonacci
        loadret r622
        loadi 2, r624
        sub r612, r624, r625
        storeoutargument r625, 0
        call recursiveFibonacci
        loadret r626
        add r622, r626, r627
        storeret r627
        ret
        jumpi TAG85
TAG83:
        storeret r612
        ret
        jumpi TAG85
TAG85:
        jumpi TAG86
TAG86:
        ret

main:
        jumpi TAG88
TAG88:
        storeglobal r631, readMePrzButDontTouch
        computeglobaladdress readMePrzButDontTouch, r631
        read r631
        loadglobal readMePrzButDontTouch, r631
        loadi 1, r633
        mov r633, r632
        comp r632, r631
        loadi 0, r634
        movlt 1, r634
        compi r634, 1
        cbreq TAG89, TAG91
TAG89:
        call constantFolding
        loadret r635
        mov r635, r629
        println r629
        call constantPropagation
        loadret r636
        mov r636, r629
        println r629
        call deadCodeElimination
        loadret r637
        mov r637, r629
        println r629
        call interProceduralOptimization
        loadret r638
        mov r638, r629
        println r629
        call commonSubexpressionElimination
        loadret r639
        mov r639, r629
        println r629
        call hoisting
        loadret r640
        mov r640, r629
        println r629
        call doubleIf
        loadret r641
        mov r641, r629
        println r629
        call integerDivide
        loadret r642
        mov r642, r629
        println r629
        call association
        loadret r643
        mov r643, r629
        println r629
        loadi 1000, r645
        div r631, r645, r646
        storeoutargument r646, 0
        call tailRecursion
        loadret r647
        mov r647, r629
        println r629
        call unswitching
        loadret r648
        mov r648, r629
        println r629
        storeoutargument r631, 0
        call randomCalculation
        loadret r650
        mov r650, r629
        println r629
        loadi 5, r652
        div r631, r652, r653
        storeoutargument r653, 0
        call iterativeFibonacci
        loadret r654
        mov r654, r629
        println r629
        loadi 1000, r656
        div r631, r656, r657
        storeoutargument r657, 0
        call recursiveFibonacci
        loadret r658
        mov r658, r629
        println r629
        loadi 1, r659
        add r632, r659, r660
        mov r660, r632
        jumpi TAG90
TAG90:
        comp r632, r631
        loadi 0, r661
        movlt 1, r661
        compi r661, 1
        cbreq TAG89, TAG91
TAG91:
        loadi 9999, r662
        println r662
        loadi 0, r663
        storeret r663
        ret
        jumpi TAG92
TAG92:
        ret

