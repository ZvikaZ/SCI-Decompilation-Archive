;;; Sierra Script 1.0 - (do not remove this comment)
(script# 484)
(include game.sh)
(use Main)
(use Intrface)
(use Motion)
(use Game)
(use Invent)
(use Menu)
(use Actor)
(use System)

(public
	rm484 0
)

(local
	triedToLeaveNaked
	[str 200]
)
(instance aWine of View
	(properties
		y 115
		x 162
		view 480
		loop 4
		cel 3
	)
	
	(method (init)
		(super init:)
		(self setPri: 10 setCel: 3 ignoreActors: stopUpd:)
	)
)

(instance aDoor of Prop
	(properties
		y 65
		x 159
		view 480
		cycleSpeed 1
	)
	
	(method (init)
		(super init:)
		(self setPri: 3 ignoreActors: stopUpd:)
	)
)

(instance aPanties of View
	(properties
		y 131
		x 63
		view 480
		loop 1
	)
	
	(method (init)
		(super init:)
		(self setPri: 11 ignoreActors: stopUpd:)
	)
)

(instance aBra of View
	(properties
		y 131
		x 63
		view 480
		loop 1
		cel 1
	)
	
	(method (init)
		(super init:)
		(self setPri: 11 ignoreActors: stopUpd:)
	)
)

(instance aPantyhose of View
	(properties
		y 141
		x 63
		view 480
		loop 1
		cel 2
	)
	
	(method (init)
		(super init:)
		(self setPri: 11 ignoreActors: stopUpd:)
	)
)

(instance aDress of Prop
	(properties
		y 107
		x 39
		view 480
		loop 2
	)
	
	(method (init)
		(super init:)
		(self
			setPri: 11
			setCel: (if (CheckItemOwner iDress 484) 0 else 255)
			ignoreActors:
			stopUpd:
		)
	)
)

(instance atpTelescope of PicView
	(properties
		y 50
		x 160
		view 480
		loop 3
		priority 1
		signal ignrAct
	)
)

(instance rm484 of Room
	(properties
		picture 480
		south 470
	)
	
	(method (init)
		(super init:)
		(aWine init: setCel: (if (CheckItemOwner iBottleOfWine) 1 else 0))
		(aDoor init: setCel: 255 stopUpd:)
		(if (CheckItemOwner iPanties) (aPanties init:))
		(if (CheckItemOwner iBra) (aBra init:))
		(if (CheckItemOwner iPantyhose) (aPantyhose init:))
		(aDress init:)
		(addToPics add: atpTelescope doit:)
		(self setScript: RoomScript)
		(NormalEgo)
		(= currentStatus egoNORMAL)
		(if (== prevRoomNum 470)
			(ego posn: 159 188 loop: 3 init:)
		else
			(if (or (Btst fSkippedLoveScene) (== prevRoomNum 0))
				(Bclr fSkippedLoveScene)
				(systemWindow color: myTextColor back: myBackColor)
				(TheMenuBar draw: state: TRUE)
				(StatusLine enable:)
				(Bclr fAutoSaveDisabled)
				(Bclr fCursorHidden)
			)
			(= currentEgoView 800)
			(= playingAsPatti TRUE)
			(= currentEgo (Format @egoName 484 0))
			(= newspaperState NSlMissing)
			(SetItemOwner iMoney 450)
			((Inventory at: iMoney) view: 25)
			(Format ((Inventory at: iMoney) name?) 484 1)
			(SetItemOwner iMagicMarker 450)
			(SetItemOwner iGinsuKnife -1)
			(SetItemOwner iBeachTowel -1)
			(SetItemOwner iSpaKeycard -1)
			(ego get: iPenthouseKey)
			((Inventory at: iPenthouseKey) view: 30)
			(Format ((Inventory at: iPenthouseKey) name?) 484 2)
			(theGame setSpeed: oldSpeed)
			(Load VIEW 800)
			(ego
				view: 482
				posn: 160 59
				loop: 2
				baseSetter: SheetBase
				init:
			)
			(music number: 492 loop: global108 play:)
		)
	)
	
	(method (newRoom newRoomNumber)
		(music fade:)
		(super newRoom: newRoomNumber)
		(music fade:)
	)
)

(instance RoomScript of Script
	(properties)
	
	(method (doit)
		(super doit:)
		(if (& (ego onControl:) $0040)
			(if
			(and (not triedToLeaveNaked) (!= (ego view?) currentEgoView))
				(= triedToLeaveNaked TRUE)
				(Print 484 3)
			)
		else
			(= triedToLeaveNaked FALSE)
		)
		(if (!= (ego view?) 800)
			(ego observeControl: cLMAGENTA)
		else
			(ego ignoreControl: cLMAGENTA)
		)
	)
	
	(method (changeState newState)
		(switch (= state newState)
			(0)
			(1
				(Ok)
				(ego get: iDress view: 800)
				(theGame changeScore: 10)
				(Print 484 36)
				(aDress setCycle: EndLoop self)
				(++ state)
			)
			(2
				(Ok)
				(SetItemOwner iDress)
				(ego view: 482)
				(theGame changeScore: -10)
				(Print 484 37)
				(aDress setCycle: BegLoop self)
			)
			(3 (aDress stopUpd:))
		)
	)
	
	(method (handleEvent event)
		(if
		(or (!= (event type?) saidEvent) (event claimed?))
			(return)
		)
		(cond 
			((Said 'drain,(get<off)/dress')
				(cond 
					((!= currentStatus egoNORMAL) (GoodIdea))
					((not (ego has: iDress)) (DontHave))
					(
					(and (ego has: iBra) (ego has: iPanties) (ego has: iPantyhose)) (Print 484 4))
					((not (& (ego onControl:) cRED)) (Print 484 5))
					(else (self changeState: 2))
				)
			)
			(
				(Said
					'wear,drain,(on<backdrop),(alter<in),(backdrop<on),get>'
				)
				(cond 
					((!= currentStatus egoNORMAL) (GoodIdea) (event claimed: TRUE))
					((Said '/sheet')
						(if (== (ego view?) 482)
							(Print 484 6)
						else
							(Print 484 7)
						)
					)
					((Said '/beer,bottle')
						(cond 
							((not (CheckItemOwner iBottleOfWine)) (AlreadyTook))
							((not (ego inRect: 126 126 196 141)) (NotClose))
							(else
								(Ok)
								(aWine setCel: 0 stopUpd:)
								(theGame changeScore: 25)
								(ego get: iBottleOfWine)
							)
						)
					)
					((Said '/panties')
						(cond 
							((not (CheckItemOwner iPanties)) (AlreadyTook))
							((not (& (ego onControl:) cRED)) (Print 484 5))
							(else
								(Ok)
								(ego get: iPanties)
								(theGame changeScore: 20)
								(aPanties dispose:)
								(Print 484 8)
							)
						)
					)
					((Said '/bra')
						(cond 
							((not (CheckItemOwner iBra)) (AlreadyTook))
							((not (& (ego onControl:) cRED)) (Print 484 5))
							((ego has: iBra) (Print 484 9))
							(else
								(Ok)
								(ego get: iBra)
								(theGame changeScore: 20)
								(aBra dispose:)
								(Print 484 10)
							)
						)
					)
					((Said '/hose')
						(cond 
							((!= currentStatus egoNORMAL) (GoodIdea))
							((not (CheckItemOwner iPantyhose)) (AlreadyTook))
							((not (& (ego onControl:) cRED)) (Print 484 5))
							(else
								(Ok)
								(ego get: iPantyhose)
								(theGame changeScore: 20)
								(aPantyhose dispose:)
								(Print 484 11)
							)
						)
					)
					((Said '/dress')
						(cond 
							((!= currentStatus egoNORMAL) (GoodIdea))
							((not (CheckItemOwner iDress)) (AlreadyTook))
							((not (& (ego onControl:) cRED)) (Print 484 5))
							(else (self changeState: 1))
						)
					)
				)
			)
			((Said 'look<below') (Print 484 12))
			((Said 'naked,naked') (Print 484 13))
			((Said 'backdrop,decrease,drain,(get<off)/sheet') (Print 484 14))
			((Said '/sandal') (Print 484 15))
			((Said '/tray') (Print 484 16))
			((Said 'gamble/keyboard') (Print 484 17))
			((Said 'close/door') (Print 484 18))
			((Said 'look>')
				(cond 
					((Said '/lotion,(buffet<dressing),cloth')
						(cond 
							((CheckItemOwner iPantyhose) (Print 484 19))
							((CheckItemOwner iPanties) (Print 484 20))
							((CheckItemOwner iBra) (Print 484 21))
							(else (Print 484 22))
						)
						(if (CheckItemOwner iDress) (Print 484 23))
					)
					((Said '/buffet')
						(if (CheckItemOwner iBottleOfWine)
							(Print 484 24)
						else
							(Print 484 25)
						)
						(if
							(or
								(CheckItemOwner iPantyhose)
								(CheckItemOwner iPanties)
								(CheckItemOwner iBra)
							)
							(Print 484 26)
						else
							(Print 484 22)
						)
					)
					((Said '/tray')
						(if (CheckItemOwner iBottleOfWine)
							(Print 484 27)
						else
							(Print 484 25)
						)
					)
					((and (CheckItemOwner iBottleOfWine) (Said '/bottle')) (Print 484 27))
					((Said '/bed') (Print 484 28))
					((Said '/keyboard') (Print 484 29))
					((Said '/binocular') (Print 484 30))
					((Said '/burn') (Print 484 31))
					((Said '/bush') (Print 484 32))
					((Said '/balcony,look,cup') (Print 484 33))
					((Said '[/area]') (Print 484 34))
				)
			)
			((Said '/cloth') (Print 484 35))
		)
	)
)

(instance SheetBase of Code
	(properties)
	
	(method (doit)
		(ego brBottom: (+ (ego y?) 1))
		(ego brTop: (- (ego brBottom?) 2))
		(ego brLeft: (- (ego x?) 9))
		(ego brRight: (+ (ego x?) 9))
	)
)
