;;; Sierra Script 1.0 - (do not remove this comment)
(script# LSL2)
(include game.sh) (include menu.sh)
(use Intrface)
(use Sound)
(use Save)
(use Motion)
(use Game)
(use Invent)
(use User)
(use Menu)
(use Actor)
(use System)

(public
	LSL2 0
	Face 1
	NormalEgo 2
	IsObjectOnControl 3
	AddViewToPic 4
	HandsOff 5
	HandsOn 6
	NotifyScript 7
	HaveMem 8
	RedrawCast 9
	proc0_10 10
	cls 11
	Ok 12
	ItIs 13
	YouAre 14
	NotNow 15
	NotClose 16
	AlreadyTook 17
	SeeNothing 18
	CantDo 19
	DontHave 20
	SetRegionTimer 21
)

(local
	ego
	theGame
	curRoom
	speed =  6
	quit
	cast
	regions
	timers
	sounds
	inventory
	addToPics
	curRoomNum
	prevRoomNum
	newRoomNum
	debugOn
	score
	possibleScore
	showStyle =  IRISOUT
	aniInterval
	theCursor
	normalCursor =  ARROW_CURSOR
	waitCursor =  HAND_CURSOR
	userFont =  USERFONT
	smallFont =  4
	lastEvent
	modelessDialog
	bigFont =  USERFONT
	volume =  12
	version =  {LSL2}
	locales
	curSaveDir
		global31
		global32
		global33
		global34
		global35
		global36
		global37
		global38
		global39
		global40
		global41
		global42
		global43
		global44
		global45
		global46
		global47
		global48
		global49
	aniThreshold =  10
	perspective
	features
	sortedFeatures
	sortedCast
	deleteCastMember
	skipFactor =  1
	;globals 57-99 are unused
		global57
		global58
		global59
		global60
		global61
		global62
		global63
		global64
		global65
		global66
		global67
		global68
		global69
		global70
		global71
		global72
		global73
		global74
		global75
		global76
		global77
		global78
		global79
		global80
		global81
		global82
		global83
		global84
		global85
		global86
		global87
		global88
		global89
		global90
		global91
		global92
		global93
		global94
		global95
		global96
		global97
		global98
	lastSysGlobal
	debugging
	currentStatus
	currentEgoView
	henchView
	gameSeconds
	gameMinutes
	gameHours
	ranking
	rgSeconds
	rgMinutes
	gameState
	global111
	global112
	oldSysTime
	global114
	roomSeconds
	global116
	global117
	global118
	speedTestQA
	machineSpeed
	gotHaircutInCity
	gotOnklunk
	filthLevel
	boughtSunscreen
	sunscreenState
	lifeboatLeverPulled
	henchwomanIsHere
	metMama
	woreWigAtSea
	hairDyedBlonde
	gotHaircutAtResort
	resortMazeNextRoom
	stuffedBra
	resortMazeVisits
	talkedToMaitreD
	gaveFlowerToKrishna
	passedCustoms
	suitcaseBombState
	missedFlight
	airportEntranceMessage
	boreState
	wearingParachute
	emergencyExitState
	avoidedBees
	snakeState
	passedQuicksand
	passedPiranhaWater
	endGameState
	global149
	triteStr
		global151
		global152
		global153
		global154
		global155
		global156
		global157
		global158
		global159
		global160
		global161
		global162
		global163
		global164
		global165
		global166
		global167
		global168
	tritePhrase
	str
		global171
		global172
		global173
		global174
		global175
		global176
		global177
		global178
		global179
		global180
		global181
		global182
		global183
		global184
		global185
		global186
		global187
		global188
		global189
		global190
		global191
		global192
		global193
		global194
		global195
		global196
		global197
		global198
		global199
		global200
		global201
		global202
		global203
		global204
		global205
		global206
		global207
		global208
		global209
		global210
		global211
		global212
		global213
		global214
		global215
		global216
		global217
		global218
		global219
		global220
		global221
		global222
		global223
		global224
		global225
		global226
		global227
		global228
		global229
		global230
		global231
		global232
		global233
		global234
		global235
		global236
		global237
		global238
		global239
		global240
		global241
		global242
		global243
		global244
		global245
		global246
		global247
		global248
		global249
		global250
		global251
		global252
		global253
		global254
		global255
		global256
		global257
		global258
		global259
		global260
		global261
		global262
		global263
		global264
		global265
		global266
		global267
		global268
		global269
		global270
		global271
		global272
		global273
		global274
		global275
		global276
		global277
		global278
		global279
		global280
		global281
		global282
		global283
		global284
		global285
		global286
		global287
		global288
		global289
		global290
		global291
		global292
		global293
		global294
		global295
		global296
		global297
		global298
		global299
		global300
		global301
		global302
		global303
		global304
		global305
		global306
		global307
		global308
		global309
		global310
		global311
		global312
		global313
		global314
		global315
		global316
		global317
		global318
		global319
		global320
		global321
		global322
		global323
		global324
		global325
		global326
		global327
		global328
		global329
		global330
		global331
		global332
		global333
		global334
		global335
		global336
		global337
		global338
		global339
		global340
		global341
		global342
		global343
		global344
		global345
		global346
		global347
		global348
		global349
		global350
		global351
		global352
		global353
		global354
		global355
		global356
		global357
		global358
		global359
		global360
		global361
		global362
		global363
		global364
		global365
		global366
		global367
		global368
		global369
		global370
		global371
		global372
		global373
		global374
		global375
		global376
		global377
		global378
		global379
		global380
		global381
		global382
		global383
		global384
		global385
		global386
		global387
		global388
		global389
		global390
		global391
		global392
		global393
		global394
		global395
		global396
		global397
		global398
		global399
		global400
		global401
		global402
		global403
		global404
		global405
		global406
		global407
		global408
		global409
		global410
		global411
		global412
		global413
		global414
		global415
		global416
		global417
		global418
		global419
		global420
		global421
		global422
		global423
		global424
		global425
		global426
		global427
		global428
		global429
		global430
		global431
		global432
		global433
		global434
		global435
		global436
		global437
		global438
		global439
		global440
		global441
		global442
		global443
		global444
		global445
		global446
		global447
		global448
		global449
		global450
		global451
		global452
		global453
		global454
		global455
		global456
		global457
		global458
		global459
		global460
		global461
		global462
		global463
		global464
		global465
		global466
		global467
		global468
		global469
	;end of str array
	introductoryPhrase
	lookedThroughKnothole
	tookSwimInShipPool
	boardedLifeboat
	satInGreenRoom
	servedAtResortRestaurant
	lookedAtJogger
	appliedSunscreen
	lookedAtRosella
	appliedSunscreenAgain
	wornParachute	;EO: This was not in the list, but is referenced when Larry
					;puts on the parachute for the first time. As a result,
					;this originally resulted in the points not being awarded
					;when the game is played in ScummVM.
)

(procedure (Face actor1 actor2)
	(DirLoop
		actor1
		(GetAngle
			(actor1 x?)
			(actor1 y?)
			(actor2 x?)
			(actor2 y?)
		)
	)
	(if (== argc 3)
		(DirLoop
			actor2
			(GetAngle
				(actor2 x?)
				(actor2 y?)
				(actor1 x?)
				(actor1 y?)
			)
		)
	)
)

(procedure (NormalEgo theLoop)
	(if (> argc 0) (ego loop: theLoop))
	(ego
		view: currentEgoView
		setLoop: -1
		setPri: -1
		setMotion: 0
		setStep: 3 2
		setCycle: Walk
		illegalBits: cWHITE
		cycleSpeed: 0
		moveSpeed: 0
		ignoreActors: 0
	)
	(= currentStatus egoNORMAL)
	(User canControl: TRUE canInput: TRUE)
)

(procedure (IsObjectOnControl obj event)
	(if (< argc 2) (= event (| keyDown mouseDown)))
	(switch (obj loop?)
		(0
			(OnControl
				(obj x?)
				(obj y?)
				(+ (obj x?) event)
				(+ (obj y?) 1)
			)
			(return)
		)
		(1
			(OnControl
				(- (obj x?) event)
				(obj y?)
				(obj x?)
				(+ (obj y?) 1)
			)
			(return)
		)
		(2
			(OnControl
				(obj x?)
				(obj y?)
				(+ (obj x?) 1)
				(+ (obj y?) event)
			)
			(return)
		)
		(3
			(OnControl
				(obj x?)
				(- (obj y?) event)
				(+ (obj x?) 1)
				(obj y?)
			)
			(return)
		)
	)
)

(procedure (AddViewToPic obj)
	(if obj
		((View new:)
			view: (obj view?)
			loop: (obj loop?)
			cel: (obj cel?)
			priority: (obj priority?)
			posn: (obj x?) (obj y?)
			addToPic:
		)
		(obj posn: (obj x?) (+ 1000 (obj y?)))
	)
)

(procedure (HandsOff)
	(User canControl: FALSE canInput: FALSE)
	(ego setMotion: 0)
)

(procedure (HandsOn)
	(User canControl: TRUE canInput: TRUE)
	(ego setMotion: 0)
)

(procedure (NotifyScript i)
	(= i (ScriptID i))
	(i notify: &rest)
)

(procedure (HaveMem howMuch)
	(return (> (MemoryInfo FreeHeap) howMuch))
)

(procedure (RedrawCast)
	(Animate (cast elements?) FALSE)
)

(procedure (proc0_10 param1 param2)
	(param1 loop: param2 changeState:)
)

(procedure (cls)
	(if modelessDialog
		(modelessDialog dispose:)
	)
)

(procedure (Ok)
	(Print 0 131)
)

(procedure (ItIs)
	(Print 0 132)
)

(procedure (YouAre)
	(Print 0 133)
)

(procedure (NotNow)
	(Print 0 134)
)

(procedure (NotClose)
	(Print 0 135)
)

(procedure (AlreadyTook)
	(Print 0 136)
)

(procedure (SeeNothing)
	(Print 0 137)
)

(procedure (CantDo)
	(Print 0 138)
)

(procedure (DontHave)
	(Print 0 139)
)

(procedure (SetRegionTimer state minutes seconds)
	;This sets the current game state and allotted time.
	;If you don't leave the region in time, the game is over.
	(= gameState state)
	(= rgSeconds (* 10 (+ seconds (* minutes 60))))
)

(instance LSL2 of Game
	(properties)
	
	(method (init &tmp temp0)
		(super init:)
		(= volume 15)
		(DoSound ChangeVolume volume)
		(StatusLine code: statusCode)
		(TheMenuBar init:)
		(scoreSnd init:)
		(deadSnd init:)
		(User echo: SPACEBAR blocks: 0)
		(= bigFont SYSFONT)
		(= possibleScore 500)
		(= currentEgoView 100)
		(= filthLevel 4)
		(= ranking {Novice})
		(= introductoryPhrase {"My name is Larry; Larry Laffer."})
		(= tritePhrase (Format @triteStr 0 0))
		(= version {1.002.000})
		(Load FONT smallFont)
		(Load FONT userFont)
		(Load FONT bigFont)
		(Load CURSOR normalCursor)
		(Load CURSOR waitCursor)
		(ego view: 100 setCycle: Walk)
		(Inventory
			empty: {Your leisure suit is empty!}
			add:
				NoInv
				Dollar_Bill
				Lottery_Ticket
				Cruise_Ticket
				Million_Dollar_Bill
				Swimsuit
				Wad_O__Dough
				Passport
				Grotesque_Gulp
				Sunscreen
				Onklunk
				Fruit
				Sewing_Kit
				Spinach_Dip
				Wig
				Bikini_Top
				Bikini_Bottom
				Knife
				Soap
				Matches
				Flower
				Hair_Rejuvenator
				Suitcase
				Airline_Ticket
				Parachute
				Bobby_Pin
				Pamphlet
				Airsick_Bag
				Stout_Stick
				Vine
				Ashes
				Sand
		)
		(if (GameIsRestarting)
			(StatusLine disable:)
			(TheMenuBar hide:)
			(self newRoom: 99)
		else
			(self newRoom: 90) ;EO: Skip the copy protection screen
			;(self newRoom: 10)
		)
	)
	
	(method (doit &tmp thisTime)
		(super doit:)
		(if (!= oldSysTime (= thisTime (GetTime TRUE)))
			(= oldSysTime thisTime)
			(++ roomSeconds)
			(if (== 60 (++ gameSeconds))
				(= gameSeconds 0)
				(if (== 60 (++ gameMinutes))
					(= gameMinutes 0)
					(++ gameHours)
				)
			)
		)
		(if (and gameState (> rgSeconds 0))
			(-- rgSeconds)
		)
		(if (== currentStatus egoDEAD)
			(curRoom setScript: dyingScript)
		)
	)
	
	(method (replay)
		(TheMenuBar draw:)
		(StatusLine enable:)
		(SetMenu soundI
			#text (if (DoSound SoundOn) {Turn Off} else {Turn On})
		)
		(super replay:)
	)
	
	(method (newRoom newRoomNumber)
		(DisposeScript JUMP)
		(DisposeScript EXTRA)
		(DisposeScript DOOR)
		(DisposeScript AIRPLANE_ACTOR)
		(DisposeScript BASS_SETTER)
		(= henchwomanIsHere FALSE)
		(= showStyle (Random 0 5))
		(= roomSeconds 0)
		(super newRoom: newRoomNumber)
		(if debugging
			(curRoom setLocales: DEBUG)
		)
	)
	
	(method (startRoom roomNum &tmp temp0)
		(super startRoom: roomNum)
	)
	
	(method (changeScore delta)
		(if (> delta 25)
			(= ranking {Big Hero})
		else
			(if (> delta 0) (scoreSnd play:))
			(switch (Random 1 22)
				(1 (= ranking {Novice}))
				(2 (= ranking {Kumquat}))
				(3 (= ranking {Dork}))
				(4 (= ranking {Putz}))
				(5 (= ranking {Lame-o}))
				(6 (= ranking {Schmuck}))
				(7 (= ranking {Pinhead}))
				(8 (= ranking {Dweeb}))
				(9 (= ranking {Nerd}))
				(10 (= ranking {Minion}))
				(11 (= ranking {Low-life}))
				(12 (= ranking {Sleeze}))
				(13 (= ranking {Slug}))
				(14 (= ranking {Cretin}))
				(15 (= ranking {Dullard}))
				(16 (= ranking {Schlemiel}))
				(17 (= ranking {Boor}))
				(18 (= ranking {Creep}))
				(19 (= ranking {Dim Bulb}))
				(20 (= ranking {Jerk}))
				(21 (= ranking {Hoser}))
				(22 (= ranking {Nimrod}))
			)
		)
		(super changeScore: delta)
	)
	
	(method (handleEvent event &tmp temp0 i [temp2 3])
		(super handleEvent: event)
		;EO: Any Said command with "/!" in it does not parse correctly, giving a "Bad Said Spec" error.
		(if
		(or (!= (event type?) saidEvent) (event claimed?))
			(return)
		)
		(if (Said 'praise/lord')
			(if (= debugging (^ debugging TRUE))
				(Print 0 5)
			else
				(Print 0 6)
			)
		)
		(cond 
			(
				(or
					(Said 'anynumber/')
					(Said '/anynumber')
					(Said '//anynumber')
				)
				(Print 0 7)
			)
			((and (ego has: iWadODough) (Said 'count/buck'))
				(Print 0 8)
			)
			(
			(or (Said 'give/bill,wad,million,buck') (Said 'bribe'))
				(cond 
					((ego has: iWadODough)
						(Print 0 9)
						(Print 0 10 #at -1 152)
					)
					((ego has: iDollarBill)
						(Print 0 11)
						(Print 0 12)
					)
					((ego has: iMillionDollarBill)
						(Print 0 13)
						(Print 0 14 #at -1 152)
					)
					(else
						(DontHave)
					)
				)
			)
			(
				(and
					(or (ego has: iSwimsuit) (ego has: iBikiniTop) (ego has: iBikiniBottom))
					(or
						(Said 'get/dress')
						(Said 'get<dress')
						(Said
							'wear,alter,(get<off),drain,(conceal<on)/job,bra,bra,bikini'
						)
					)
				)
				(Print 0 15)
			)
			((and (ego has: iPassport) (Said 'look/passport/*'))
				(Print 0 16)
			)
			((and (ego has: iGrotesqueGulp) (Said 'drink,apply/coke,coke'))
				(Print 0 17)
				(ego hide: put: iGrotesqueGulp -1)
				(Print 0 18 #draw)
				(= currentStatus egoDEAD)
			)
			((and (ego has: iFruit) (Said 'look,look/note,basket'))
				(Fruit showSelf:)
			)
			((and (ego has: iOnklunk) (Said 'give/onklunk'))
				(Print 0 19)
				(= currentStatus egoDEAD)
			)
			((and (ego has: iOnklunk) (Said 'play,apply/music,music,onklunk'))
				(Print 0 20)
				(Print 0 21 #at -1 152)
			)
			((and (ego has: iOnklunk) (Said 'conceal//(onklunk<in)>'))
				(= i (inventory saidMe:))
				(cond 
					((Said '[/!]')
						(Print 0 22)
					)
					((not i)
						(event claimed: TRUE)
						(CantDo)
					)
					((not (i ownedBy: ego))
						(DontHave)
					)
					(else
						(Print 0 23)
						(Print 0 24 #at -1 152)
					)
				)
			)
			((and (ego has: iKnife) (or (Said 'apply/gun') (Said 'attack')))
				(Print 0 25)
			)
			((and (ego has: iMatches) (Said 'apply,burn/match'))
				(if (ego has: iHairRejuvenator)
					(HandsOff)
					(Ok)
					(= currentStatus egoBLOWNUP)
					(curRoom newRoom: 152)
				else
					(Print 0 26)
					(ego put: iMatches -1)
					(theGame changeScore: -2)
				)
			)
			((and (ego has: iHairRejuvenator) (Said 'put,(put<on),pour,use,hide,rub,wear/rejuvenator>'))
				(cond 
					((Said '[/!]')
						(Print 0 27)
					)
					((Said '/i,head,hair')
						(Print 0 28)
					)
					(else
						(event claimed: TRUE)
						(Print 0 29)
						(ego put: iHairRejuvenator -1)
						(theGame changeScore: -2)
					)
				)
			)
			(
				(and
					(ego has: iHairRejuvenator)
					(ego has: iAirsickBag)
					(or
						(Said 'conceal/bag/bottle')
						(Said 'conceal/bottle/bag')
					)
				)
				(Print 0 30)
			)
			((and (ego has: iHairRejuvenator) (Said 'burn,light/bottle,rejuvenator'))
				(if (ego has: iMatches)
					(HandsOff)
					(Ok)
					(= currentStatus egoBLOWNUP)
					(curRoom newRoom: 152)
				else
					(Print 0 31)
				)
			)
			((Said 'open,(look<in)>')
				(= i (inventory saidMe:))
				(cond 
					((Said '[/!]')
						(Print 0 32)
					)
					((not i)
						(event claimed: TRUE)
						(CantDo)
					)
					((not (i ownedBy: ego))
						(DontHave)
					)
					(else
						(switch (inventory indexOf: i)
							(iCruiseTicket
								(Print 0 33)
							)
							(iSwimsuit
								(if (== currentEgoView 132)
									(Print 0 34)
								else
									(Print 0 35)
								)
							)
							(iWadODough
								(Print 0 36)
							)
							(iPassport
								(Print 0 37 #icon 7 1 0)
							)
							(iOnklunk
								(Print 0 38)
								(Print 0 39 #at -1 152)
							)
							(iSewingKit
								(Print 0 40)
							)
							(iWig
								(Print 0 41)
							)
							(iBikiniTop
								(Print 0 42)
							)
							(iBikiniBottom
								(Print 0 43)
							)
							(iHairRejuvenator
								(Print 0 44)
								(Print 0 44)
							)
							(iAirlineTicket
								(Print 0 45)
							)
							(iParachute
								(Print 0 46)
								(ego put: iParachute -1)
								(theGame changeScore: -3)
							)
							(iPamphlet
								(Print 0 47)
								(Print 0 48)
							)
							(iAirsickBag
								(Print 0 49)
							)
							(else
								(SeeNothing)
							)
						)
					)
				)
			)
			((Said 'hello')
				(Print 0 50)
			)
			((or (Said '/bye') (Said 'bye'))
				(Print 0 51)
			)
			((Said 'thank')
				(Print 0 52)
			)
			((Said 'bang')
				(Print 0 53)
				(Print 0 54 #at -1 152)
			)
			((Said 'attack')
				(Print 0 25)
			)
			((or (Said 'board/bathroom') (Said 'leak') (Said 'get/leak'))
				(if (== 100 (ego view?))
					(Print 0 55)
				else
					(NotNow)
				)
			)
			((Said 'climb>')
				(if (Said '/brick,building')
					(Print 0 56)
				else
					(Print 0 57)
					(event claimed: TRUE)
				)
			)
			((Said 'hop')
				(Print 0 58)
			)
			((Said 'holler')
				(Print 0 59)
			)
			((Said 'daydream')
				(Print 0 60)
			)
			((Said 'rob')
				(Print 0 61)
			)
			((Said 'cheat')
				(Print 0 62)
				(Print 0 63 #at -1 152)
				(= quit TRUE)
			)
			((Said '(conceal<on),wear>')
				(cond 
					((Said '[/!]')
						(Print 0 64)
					)
					((= i (inventory saidMe:))
						(if
						(not (ego has: (inventory indexOf: i)))
							(DontHave)
						else
							(Print 0 65)
						)
					)
					(else
						(Print 0 66)
						(event claimed: TRUE)
					)
				)
			)
			((Said 'conceal>')
				(cond 
					((Said '[/!]')
						(Print 0 67)
					)
					((= i (inventory saidMe:))
						(if (not (ego has: (inventory indexOf: i)))
							(DontHave)
						else
							(Print 0 68)
						)
					)
					(else
						(Print 0 69)
						(event claimed: TRUE)
					)
				)
			)
			((Said 'throw>')
				(cond 
					((Said '[/!]')
						(Print 0 70)
					)
					((= i (inventory saidMe:))
						(if (not (ego has: (inventory indexOf: i)))
							(DontHave)
						else
							(Print 0 68)
						)
					)
					(else
						(Print 0 71)
						(event claimed: TRUE)
					)
				)
			)
			((Said 'smell')
				(Print 0 72)
			)
			((Said 'wear/crown')
				(Print 0 73)
			)
			((Said '/microfiche')
				(Print 0 74)
			)
			((Said 'whistle')
				(Print 0 75)
				(Print 0 76 #at -1 152)
			)
			((Said 'laugh')
				(Print 0 77)
			)
			((Said 'eat')
				(Print 0 78)
			)
			((Said 'lie,bath,nap')
				(Print 0 79)
			)
			((Said 'aid')
				(Print 0 80)
			)
			((Said 'explore>')
				(if (Said '/bra,i')
					(Print 0 81)
					(inventory showSelf: ego)
				else
					(event claimed: TRUE)
					(Print 0 82)
				)
			)
			((or (Said '/key') (Said 'unbolt,bolt'))
				(Print 0 83)
			)
			((or (Said '/screw/you') (Said 'screw/you'))
				(Print 0 84)
			)
			((Said 'screw/*')
				(Print 0 85)
			)
			((Said 'jack')
				(Print 0 86)
			)
			((Said 'caress,caress,embrace,look/clit')
				(Print 0 87)
			)
			((Said 'eat/bimbo')
				(Print 0 88)
			)
			((Said 'drink')
				(Print 0 89)
			)
			((Said 'embrace')
				(Print 0 90)
			)
			((or (Said 'eat,copulate/i') (Said 'clit,crap,leak,copulate,fart,boob,ass,asshole'))
				(Print 0 91)
			)
			((Said '/hell')
				(Print 0 92)
			)
			((Said '/heck')
				(Print 0 93)
			)
			((Said 'look>')
				(cond 
					((Said '/*/man,bimbo,children>')
						(cond 
							((not (= i (inventory saidMe:)))
								(event claimed: TRUE)
								(Print 0 94)
							)
							((not (i ownedBy: ego))
								(DontHave)
							)
							(else
								(Print 0 95)
								(event claimed: TRUE)
							)
						)
					)
					((Said '/bra,i')
						(if (== 100 (ego view?))
							(Print 0 96)
							(Print 0 97 #at -1 152)
						)
						(Print 0 81)
						(inventory showSelf: ego)
					)
					(
						(Said
							'/billfold,(spray[<breath]),(lint[<bra]),(watch[<wrist])'
						)
						(Print 0 98)
					)
					((Said '/bush,palm')
						(Print 0 99)
					)
					((Said '/man,bimbo,children')
						(Print 0 100)
					)
					((Said '/brick,building')
						(Print 0 101)
					)
					((Said '/carpet,down')
						(Print 0 102)
					)
					((Said '/cloud,ceiling')
						(Print 0 103)
					)
					((Said '<in/cup')
						(Print 0 104)
					)
					((Said '/bikini')
						(if (or (ego has: iBikiniTop) (ego has: iBikiniBottom))
							(if (ego has: iBikiniTop)
								(Bikini_Top showSelf:)
							)
							(if (ego has: iBikiniBottom)
								(Bikini_Bottom showSelf:)
							)
						else
							(DontHave)
						)
					)
					((Said '/bill,million,buck,wad')
						(cond 
							((ego has: iDollarBill)
								(Dollar_Bill showSelf:)
							)
							((ego has: iMillionDollarBill)
								(Million_Dollar_Bill showSelf:)
							)
							((ego has: iWadODough)
								(Wad_O__Dough showSelf:)
							)
							(else (DontHave))
						)
					)
					((Said '/ticket')
						(cond 
							((ego has: iLotteryTicket)
								(Lottery_Ticket showSelf:)
							)
							((ego has: iCruiseTicket)
								(Cruise_Ticket showSelf:)
							)
							((ego has: iAirlineTicket)
								(Airline_Ticket showSelf:)
							)
							(else
								(DontHave)
							)
						)
					)
					((= i (inventory saidMe:))
						(if (i ownedBy: ego)
							(i showSelf:)
						else
							(DontHave)
						)
					)
					(else
						(switch (Random 42 44)
							(42 (Print 0 105))
							(43 (Print 0 106))
							(44 (SeeNothing))
						)
						(event claimed: TRUE)
					)
				)
			)
			((or (Said 'apply,buy/bill,million,buck,wad') (Said 'buy'))
				(if (or (ego has: iDollarBill) (ego has: iWadODough) (ego has: iMillionDollarBill))
					(Print 0 107)
				else
					(Print 0 108)
				)
			)
			((Said 'apply>')
				(= i (inventory saidMe:))
				(event claimed: FALSE)
				(cond 
					((Said '/ticket')
						(if (or (ego has: iLotteryTicket) (ego has: iCruiseTicket) (ego has: iAirlineTicket))
							(Print 0 109)
						else
							(Print 0 110)
						)
					)
					((Said '[/!]')
						(Print 0 111)
					)
					((not i)
						(event claimed: TRUE)
						(CantDo)
					)
					((not (i ownedBy: ego))
						(DontHave)
					)
					(else
						(Print 0 112)
						(event claimed: TRUE)
					)
				)
			)
			((Said 'give>')
				(= i (inventory saidMe:))
				(event claimed: FALSE)
				(cond 
					((Said '/*[/!]')
						(Print 0 113)
					)
					((Said '[/!]')
						(Print 0 114)
					)
					((not i)
						(event claimed: TRUE)
						(Print 0 115)
					)
					((not (i ownedBy: ego))
						(DontHave)
					)
					(else
						(Print 0 95)
						(event claimed: TRUE)
					)
				)
			)
			((Said 'get>')
				(cond 
					((Said '[/!]')
						(Print 0 116)
					)
					((and (= i (inventory saidMe:)) (i ownedBy: ego))
						(Print 0 117)
					)
					(else
						(switch (Random 33 35)
							(33 (Print 0 118))
							(34 (Print 0 119))
							(35 (Print 0 120))
						)
						(event claimed: TRUE)
					)
				)
			)
			((= i (inventory saidMe:))
				(if (not (i ownedBy: ego))
					(DontHave)
				else
					(Print 0 121)
				)
			)
			((Said 'call>')
				(if (Said '[/!]')
					(Print 0 113)
				else
					(Print 0 122)
					(Print 0 123 #at -1 152)
					(event claimed: TRUE)
				)
			)
			(
				(or
					(Said '/clit,crap,leak,copulate,asshole,boob,ass,asshole')
					(Said
						'//clit,crap,leak,copulate,asshole,boob,ass,asshole'
					)
				)
				(Print 0 124)
			)
			((or (Said '//bimbo') (Said '/bimbo/') (Said '/bimbo'))
				(Print 0 125)
			)
		)
	)
	
	(method (wordFail word)
		(Print (Format @str 0 1 word))
	)
	
	(method (syntaxFail)
		(Print 0 2)
	)
	
	(method (pragmaFail)
		(if (<= filthLevel 4)
			(Print 0 3)
		else
			(Print 0 4)
		)
	)
)

(class Iitem of InvItem
	
	(method (showSelf)
		(Print INVDESC view
			#title name
			#icon view 0 0
		)
	)
)

(instance NoInv of Iitem
	(properties)
)

(instance Dollar_Bill of Iitem
	(properties
		said '/(bill<buck)'
		owner 23
		view 1
		name "Dollar Bill"
	)
)

(instance Lottery_Ticket of Iitem
	(properties
		said '/ticket[<bucko]'
		owner 114
		view 2
		name "Lottery Ticket"
	)
)

(instance Cruise_Ticket of Iitem
	(properties
		said '/ticket[<cruise]'
		owner 103
		view 3
		name "Cruise Ticket"
	)
)

(instance Million_Dollar_Bill of Iitem
	(properties
		said '/((bill<buck)<million),(buck<million)'
		owner 104
		view 4
		name "Million Dollar Bill"
	)
)

(instance Swimsuit of Iitem
	(properties
		said '/job'
		owner 116
		view 5
	)
)

(instance Wad_O__Dough of Iitem
	(properties
		said '/buck,wad'
		owner 116
		view 6
		name "Wad O' Dough"
	)
)

(instance Passport of Iitem
	(properties
		said '/passport'
		owner 23
		view 7
	)
)

(instance Grotesque_Gulp of Iitem
	(properties
		said '/coke[<grotesque]'
		owner 114
		view 8
		name "Grotesque Gulp"
	)
)

(instance Sunscreen of Iitem
	(properties
		said '/lotion'
		owner 118
		view 9
	)
)

(instance Onklunk of Iitem
	(properties
		said '/onklunk'
		owner 115
		view 10
	)
)

(instance Fruit of Iitem
	(properties
		said '/basket'
		owner 32
		view 11
	)
)

(instance Sewing_Kit of Iitem
	(properties
		said '/kit[<sew]'
		owner 33
		view 12
		name "Sewing Kit"
	)
)

(instance Spinach_Dip of Iitem
	(properties
		said '/bread[<spinach]'
		owner 35
		view 13
		name "Spinach Dip"
	)
)

(instance Wig of Iitem
	(properties
		said '/wig'
		owner 37
		view 14
	)
)

(instance Bikini_Top of Iitem
	(properties
		said '/top[<bikini]'	;EO: Fixed Said Spec error
		owner 134
		view 15
		name "Bikini Top"
	)
)

(instance Bikini_Bottom of Iitem
	(properties
		said '/bottom[<bikini]'
		owner 41
		view 16
		name "Bikini Bottom"
	)
)

(instance Knife of Iitem
	(properties
		said '/gun'
		owner 43
		view 17
	)
)

(instance Soap of Iitem
	(properties
		said '/soap'
		owner 44
		view 18
	)
)

(instance Matches of Iitem
	(properties
		said '/match'
		owner 44
		view 19
	)
)

(instance Flower of Iitem
	(properties
		said '/flower'
		owner 40
		view 20
	)
)

(instance Hair_Rejuvenator of Iitem
	(properties
		said '/rejuvenator[<hair]'
		owner 45
		view 21
		name "Hair Rejuvenator"
	)
)

(instance Suitcase of Iitem
	(properties
		said '/baggage'
		owner 54
		view 22
	)
)

(instance Airline_Ticket of Iitem
	(properties
		said '/ticket[<airline,airline]'
		owner 52
		view 23
		name "Airline Ticket"
	)
)

(instance Parachute of Iitem
	(properties
		said '/parachute'
		owner 55
		view 24
	)
)

(instance Bobby_Pin of Iitem
	(properties
		said '/bobbypin[<bobby]'
		owner 55
		view 25
		name "Bobby Pin"
	)
)

(instance Pamphlet of Iitem
	(properties
		said '/pamphlet'
		owner 57
		view 26
	)
)

(instance Airsick_Bag of Iitem
	(properties
		said '/bag[<airsick]'
		owner 62
		view 27
		name "Airsick Bag"
	)
)

(instance Stout_Stick of Iitem
	(properties
		said '/stick'
		owner 71
		view 28
		name "Stout Stick"
	)
)

(instance Vine of Iitem
	(properties
		said '/landscape'
		owner 74
		view 29
	)
)

(instance Ashes of Iitem
	(properties
		said '/ash' ;EO: fixed decompiler goof
		owner 77
		view 30
	)
)

(instance Sand of Iitem
	(properties
		said '/beach'
		owner 75
		view 31
	)
)

(instance dyingScript of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(= currentStatus egoDEATHMESSAGE)
				(HandsOff)
				(Load SOUND 103)
				(= seconds 3)
			)
			(1
				(sounds eachElementDo: #dispose)
				(deadSnd play:)
				(if
					(Print 0 126
						#title {Oh, no! Not again?!}
						#font bigFont
						#icon vBEDismay 0 0
						#button {Keep On Muddling} 0
						#button {Order A Hintbook} 1
					)
					(Print 0 127)
				)
				(repeat
					(switch
						(Print 0 128
							#title {Al says:}
							#font bigFont
							#button {Restore} 1
							#button {Restart} 2
							#button {__Quit__} 3
						)
						(1
							(theGame restore:)
						)
						(2
							(theGame restart:)
						)
						(3
							(= quit TRUE)
							(break)
						)
					)
				)
			)
		)
	)
)

(instance statusCode of Code
	(properties)
	
	(method (doit strg)
		(Format strg 0 129
			score possibleScore 0 130
			ranking 0 130
		)
	)
)

(instance scoreSnd of Sound
	(properties
		number 7
		priority -10
		owner -1
	)
)

(instance deadSnd of Sound
	(properties
		number 103
		priority 255
	)
)
