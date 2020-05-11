;;; Sierra Script 1.0 - (do not remove this comment)
(script# 54)
(include game.sh)
(use Main)
(use Door)
(use AirplaneActor)
(use Intrface)
(use Sound)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm54 0
)

(local
	whichBag
	airplane
	bag
	gate
	traveler
)

(enum
	subliminalMessage
	huntingRifle
	dirtyUnderwear
	deadCat
	pairOfMaces
	tommyGun
	nothingOfInterest
	computer
	john3_16
	nothingOfInterest2
	blueSuits
	machineGun
	theBomb
)

(instance theSound of Sound
	(properties
		number 5
		loop -1
	)
)

(instance rm54 of Room
	(properties
		picture 54
		horizon 5
		east 55
		west 53
	)
	
	(method (init)
		(Load VIEW 515)
		(Load VIEW 516)
		(super init:)
		((View new:)
			view: 516
			loop: 0
			cel: 0
			posn: 109 157
			setPri: 12
			addToPic:
		)
		(if ((inventory at: iSuitcase) ownedBy: curRoomNum)
			(Load VIEW 155)
			(Load SOUND 5)
			(Load FONT 7)
			(theSound init:)
			((= bag (Actor new:))
				view: 515
				setLoop: 0
				setCel: 0
				setPri: 5
				setStep: 2 1
				posn: 90 123
				illegalBits: 0
				ignoreActors:
				init:
				hide:
				setScript: bagScript
			)
		)
		((= airplane (Airplane new:))
			view: 511
			setCel: 0
			startX: 306
			startY: 22
			endX: 222
			endY: 22
			init:
		)
		((= traveler (Actor new:))
			view: 515
			setLoop: 3
			setPri: 2
			setStep: 1 1
			setCycle: Walk
			posn: 230 36
			illegalBits: 0
			ignoreActors:
			init:
			hide:
		)
		(cond 
			((== prevRoomNum 53) (ego posn: 1 154))
			((== prevRoomNum 55) (ego posn: 316 154))
			(else (ego posn: 316 154))
		)
		(NormalEgo)
		(ego init:)
		((= gate (AutoDoor new:))
			view: 515
			setLoop: 2
			posn: 15 156
			setPri: 11
			doorCtrl: 2
			doorBlock: 16384
			roomCtrl: 0
			msgLook: {The low blue gate leads back to the Customs Inspection area.}
			msgFunny: {Knock. Knock. (No one's there!)}
			init:
		)
		(self setRegions: AIRPORT setScript: rm54Script)
	)
)

(instance rm54Script of Script
	(properties)
	
	(method (doit)
		(super doit:)
	)
	
	(method (changeState newState)
		(switch (= state newState)
			(1
				(theGame changeScore: 5)
				(bag dispose:)
				(bagScript dispose:)
				(Print 54 25 #at -1 20 #width 222 #font 7)
				(theSound play:)
				(ego get: iSuitcase)
				(= suitcaseBombState bombHOLDING)
				(HandsOff)
				(ego view: 155 setLoop: 1)
				(Print 54 26 #draw)
				(= seconds 3)
			)
			(2
				(Print 54 27)
				(ego setMotion: MoveTo (ego x?) 154 self)
			)
			(3
				(ego
					setStep: 4 3
					setCycle: Walk
					setMotion: MoveTo 0 154 self
				)
			)
		)
	)
	
	(method (handleEvent event)
		(if
		(or (!= (event type?) saidEvent) (event claimed?))
			(return)
		)
		(if
		(and (not (ego has: iSuitcase)) (Said 'look/bag,baggage'))
			(if ((inventory at: iSuitcase) ownedBy: curRoomNum)
				(Print 54 0)
			else
				(Print 54 1)
			)
		)
		(if (Said 'look>')
			(if (Said '/belt,baggage,bag,belt') (Print 54 2))
			(if (Said '/man,cop') (Print 54 3))
			(if (Said '/art')
				(Print 54 4)
				(if (> filthLevel 10) (Print 54 5 #at -1 152))
			)
			(if (Said '[/airport]') (Print 54 6))
		)
		(if
			(or
				(Said 'awaken<up')
				(Said 'awaken,lagoon,attack,call/man,cop')
			)
			(Print 54 7)
		)
		(if (Said 'carry,(get<up),get/bag,baggage')
			(cond 
				((not ((inventory at: iSuitcase) ownedBy: curRoomNum)) (Print 54 8))
				((not (& (ego onControl:) $0008)) (PrintNotCloseEnough))
				((> (ego distanceTo: bag) 23) (Print 54 9))
				(else
					(bag hide:)
					(if (and (!= whichBag 0) (!= whichBag 8))
						(Print 54 10 #at -1 20 #draw)
					)
					(switch whichBag
						(subliminalMessage (Print 54 11))
						(huntingRifle (Print 54 12))
						(dirtyUnderwear (Print 54 13))
						(deadCat (Print 54 14) (Print 54 15))
						(pairOfMaces (Print 54 16))
						(tommyGun (Print 54 17))
						(nothingOfInterest (Print 54 18))
						(computer (Print 54 19) (Print 54 20))
						(john3_16
							(Print 54 21)
						)
						(nothingOfInterest2
							(Print 54 18)
						)
						(blueSuits
							(Print 54 22)
						)
						(machineGun
							(Print 54 23)
						)
						(theBomb
							(self changeState: 1)
							(return)
						)
					)
					(Print 54 24 #at -1 20)
					(bag show:)
				)
			)
		)
	)
)

(instance travelerScript of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0 (= seconds 3))
			(1
				(traveler
					posn: 230 36
					show:
					setMotion: MoveTo 291 37 self
				)
			)
			(2
				(traveler
					setLoop: (if (== (traveler loop?) 3) 4 else 3)
				)
				(self changeState: 0)
			)
		)
	)
)

(instance bagScript of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(bag
					posn: 90 123
					setCel: whichBag
					setLoop: 0
					show:
					setMotion: MoveTo 152 123 self
				)
			)
			(1
				(bag setLoop: 1 setMotion: MoveTo 303 123 self)
			)
			(2
				(if (> (++ whichBag) 12) (= whichBag 0))
				(bag hide:)
				(self changeState: 0)
			)
		)
	)
)
