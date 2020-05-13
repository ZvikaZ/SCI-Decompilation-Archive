;;; Sierra Script 1.0 - (do not remove this comment)
(script# 102)
(include game.sh)
(use Main)
(use Intrface)
(use Motion)
(use Game)
(use User)
(use Actor)
(use System)

(public
	rm102 0
)

(local
	local0
	doorControl
	aProducer
	aDoorWest
	aDoorEast
	aTVwest
	aTVeast
)
(instance rm102 of Room
	(properties
		picture 102
	)
	
	(method (init)
		(Load VIEW 202)
		(Load VIEW 206)
		(Load VIEW 217)
		(super init:)
		((View new:)
			view: 202
			loop: 4
			cel: 0
			posn: 59 126
			setPri: 9
			ignoreActors:
			addToPic:
		)
		((View new:)
			view: 202
			loop: 4
			cel: 1
			posn: 262 128
			setPri: 9
			ignoreActors:
			addToPic:
		)
		((= aTVwest (Prop new:))
			view: 202
			setLoop: 2
			setCel: 0
			posn: 96 94
			setPri: 4
			setCycle: Forward
			isExtra: TRUE
			init:
		)
		((= aTVeast (Prop new:))
			view: 202
			setLoop: 3
			setCel: 1
			posn: 228 95
			setPri: 4
			setCycle: Forward
			isExtra: TRUE
			init:
		)
		(self setScript: rm102Script)
		(NormalEgo)
		(ego observeControl: cYELLOW cLMAGENTA)
		((= aDoorWest (Prop new:))
			view: 202
			posn: 83 115
			setPri: 4
			init:
		)
		((= aDoorEast (Prop new:))
			view: 202
			setLoop: 1
			posn: 250 116
			setPri: 4
			init:
		)
		(if (== prevRoomNum 103)
			(aDoorWest setCel: 255)
			(ego posn: 67 122 observeControl: cLMAGENTA ignoreActors:)
			(rm102Script changeState: 12)
		else
			(ego posn: 163 153)
			(rm102Script changeState: 1)
		)
		(ego init:)
	)
)

(instance rm102Script of Script
	(properties)
	
	(method (doit)
		(super doit:)
		(if
			(and
				(== currentStatus egoSITTING)
				(or (== state 20) (== state 1))
			)
			(self cue:)
		)
		(if (== doorControl cLMAGENTA) (ego ignoreControl: cLMAGENTA))
		(if (== doorControl cYELLOW) (ego ignoreControl: cYELLOW))
		(if (& (ego onControl:) cGREEN) (curRoom newRoom: 103))
		(if (& (ego onControl:) cMAGENTA) (curRoom newRoom: 104))
	)
	
	(method (changeState newState)
		(switch (= state newState)
			(1
				(HandsOn)
				(ego observeControl: cYELLOW cLMAGENTA)
			)
			(2 (= seconds (Random 10 30)))
			(3
				(if (!= currentStatus egoSITTING)
					(-- state)
					(= seconds 3)
				else
					(HandsOff)
					(= doorControl cYELLOW)
					(aDoorWest setCycle: EndLoop self)
				)
			)
			(4
				((= aProducer (Actor new:))
					view: 206
					loop: 0
					illegalBits: 0
					ignoreActors: 0
					setCycle: Walk
					posn: 60 119
					init:
					setMotion: MoveTo 80 120 self
				)
			)
			(5
				(aProducer
					setLoop: 2
					cel: 0
					setCycle: EndLoop
					setMotion: MoveTo 97 120 self
				)
			)
			(6
				(aProducer setLoop: 3 cel: 0 setCycle: EndLoop self)
			)
			(7
				(aProducer setLoop: 4 setCycle: Forward)
				(= seconds 3)
			)
			(8
				(Print 102 10 #at -1 20)
				(= seconds 2)
			)
			(9
				(Print 102 11 #at -1 20)
				(aProducer setLoop: 5 cycleSpeed: 2 setCycle: EndLoop self)
			)
			(10
				(User canInput: TRUE)
				(if (!= currentStatus egoSITTING) (User canControl: 1))
				(aProducer
					setLoop: 1
					setCycle: Walk
					cycleSpeed: 0
					ignoreActors: 1
					setMotion: MoveTo 60 120
				)
			)
			(11 (aProducer dispose:))
			(12
				(HandsOff)
				(ego illegalBits: 0 setMotion: MoveTo 120 123 self)
			)
			(13
				((= aProducer (Actor new:))
					view: 206
					loop: 0
					setCycle: Walk
					illegalBits: 0
					ignoreActors:
					posn: 60 119
					init:
					setMotion: MoveTo 80 120 self
				)
				(ego
					illegalBits: cWHITE
					observeControl: cYELLOW cLMAGENTA
					loop: 1
				)
			)
			(14
				(aProducer
					setLoop: 2
					cel: 0
					setCycle: EndLoop
					setMotion: MoveTo 97 120 self
				)
			)
			(15
				(aProducer setLoop: 3 cel: 0 setCycle: EndLoop self)
			)
			(16
				(aProducer setLoop: 4 cycleSpeed: 1 setCycle: Forward)
				(= seconds 3)
			)
			(17
				(Print 102 12 #at -1 15 #width 280)
				(Print 102 13 #at -1 20)
				(Print 102 14 #at -1 20)
				(ego get: iCruiseTicket)
				(theGame changeScore: 6)
				(aProducer setLoop: 5 setCycle: EndLoop self)
			)
			(18
				(aProducer
					setLoop: 1
					setCycle: Walk
					cycleSpeed: 0
					setMotion: MoveTo 36 120 self
				)
			)
			(19
				(aProducer posn: 264 121)
				(aDoorWest setCycle: BegLoop self)
			)
			(20
				(HandsOn)
				(aDoorWest stopUpd:)
				(= currentStatus egoNORMAL)
			)
			(21 (= seconds (Random 11 33)))
			(22
				(if (!= currentStatus egoSITTING)
					(-- state)
					(= seconds 3)
				else
					(HandsOff)
					(= doorControl cLMAGENTA)
					(aDoorEast setCycle: EndLoop self)
				)
			)
			(23
				(aProducer
					view: 217
					setCycle: Walk
					setMotion: MoveTo 219 122 self
				)
			)
			(24
				(aProducer loop: (+ (aProducer loop?) 2) setCycle: Forward)
				(= seconds 3)
			)
			(25
				(Print 102 15)
				(Print 102 16 #at -1 20)
				(Print 102 17)
				(aProducer loop: 0 setMotion: MoveTo 264 122 self)
			)
			(26
				(User canInput: TRUE)
				(if (== currentStatus egoNORMAL) (User canControl: TRUE))
				(aProducer dispose:)
				(Print 102 18 #at -1 152)
			)
		)
	)
	
	(method (handleEvent event)
		(if
		(or (!= (event type?) saidEvent) (event claimed?))
			(return)
		)
		(if (Said 'open/door')
			(if doorControl
				(ItIs)
			else
				(Print 102 0)
				(Print 102 1)
			)
		)
		(if (Said 'look>')
			(if (Said '/art,brick') (Print 102 2))
			(if (Said '/door')
				(if doorControl
					(Print 102 3)
					(Print 102 4 #at -1 152)
				else
					(Print 102 5)
					(Print 102 6 #at -1 152)
				)
			)
			(if (Said '/krod,bimbo,computer') (Print 102 7))
			(if (Said '/barstool') (Print 102 8))
			(if (Said '[/airport,krod,lobby,building]')
				(Print 102 9)
			)
		)
		(if (Said 'bath')
			(cond 
				((== currentStatus egoSITTING) (YouAre))
				((not (ego inRect: 101 90 255 99)) (NotClose))
				((!= currentStatus egoNORMAL) (NotNow))
				(else
					(if (not satInGreenRoom)
						(= satInGreenRoom TRUE)
						(theGame changeScore: 1)
					)
					(Ok)
					(ego setScript: sittingScript)
					(sittingScript changeState: 0)
				)
			)
		)
		(if
			(or
				(Said 'new,(new<up),(get<up)')
				(Said 'disembark[/barstool]')
			)
			(cond 
				((== currentStatus egoNORMAL) (YouAre))
				((!= currentStatus egoSITTING) (NotNow))
				(else
					(Ok)
					(ego setScript: sittingScript)
					(sittingScript changeState: 5)
				)
			)
		)
	)
)

(instance sittingScript of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= seconds (= cycles 0))
				(cond 
					((< (ego x?) 123) (ego setMotion: MoveTo 123 (ego y?) self))
					((> (ego x?) 200) (ego setMotion: MoveTo 200 (ego y?) self))
					(else (self cue:))
				)
			)
			(1
				(ego setMotion: MoveTo (ego x?) 92 self)
			)
			(2
				(ego
					view: 101
					setLoop: 0
					setCel: 0
					cycleSpeed: 2
					setCycle: EndLoop self
				)
			)
			(3
				(ego setCel: setMotion: 0 stopUpd:)
				(= currentStatus egoSITTING)
				(User canInput: TRUE)
				(= seconds (Random 2 6))
			)
			(4
				(ego setLoop: (Random 1 2))
				(if (== (ego cel?) 0)
					(ego setCycle: EndLoop)
				else
					(ego setCycle: BegLoop)
				)
				(-- state)
				(= seconds (Random 2 6))
			)
			(5
				(HandsOff)
				(= seconds (= cycles 0))
				(ego
					setLoop: 0
					setCel: 255
					setCycle: BegLoop self
					setMotion: 0
				)
			)
			(6
				(NormalEgo 2)
				(ego observeControl: cYELLOW cLMAGENTA)
			)
		)
	)
)
