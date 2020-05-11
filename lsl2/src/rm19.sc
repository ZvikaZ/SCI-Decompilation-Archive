;;; Sierra Script 1.0 - (do not remove this comment)
(script# 19)
(include game.sh)
(use Main)
(use Intrface)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm19 0
)

(local
	local0
	chairLift
	monorail
	local3
	coaster
	parkFlags
)
(instance rm19 of Room
	(properties
		picture 19
		horizon 106
		north 15
		south 23
		west 23
	)
	
	(method (init)
		(Load VIEW 254)
		(super init:)
		((View new:)
			view: 254
			loop: 2
			cel: 0
			posn: 144 31
			addToPic:
		)
		((= chairLift (Prop new:))
			view: 254
			setLoop: 0
			posn: 60 15
			setCycle: Forward
			cycleSpeed: 2
			isExtra: 1
			init:
		)
		((= coaster (Prop new:))
			view: 254
			setLoop: 3
			setCel: 255
			posn: 149 13
			init:
			hide:
			setScript: coasterScript
		)
		((= parkFlags (Prop new:))
			view: 254
			setLoop: 4
			posn: 239 14
			setCycle: Forward
			cycleSpeed: 4
			isExtra: 1
			init:
		)
		((= monorail (Actor new:))
			view: 254
			setLoop: 1
			setPri: 2
			setStep: 4 1
			ignoreHorizon:
			ignoreActors:
			illegalBits: 0
			posn: -940 52
			init:
			setScript: monoScript
		)
		(cond 
			((== prevRoomNum 0) (ego posn: 318 160))
			((== prevRoomNum 15) (ego posn: 306 108))
			((== prevRoomNum 20) (ego posn: 318 160))
			((== prevRoomNum 23) (ego posn: 5 187))
		)
		(NormalEgo)
		(ego init:)
		(self setRegions: CITY setScript: rm19Script)
	)
)

(instance rm19Script of Script
	(properties)
	
	(method (doit)
		(super doit:)
		(if (== 2 (ego edgeHit?))
			(if (< (ego y?) 159)
				(curRoom newRoom: 15)
			else
				(curRoom newRoom: 20)
			)
		)
	)
	
	(method (handleEvent event)
		(if
		(or (!= (event type?) saidEvent) (event claimed?))
			(return)
		)
		(if (Said 'look<over,below/brick,fence') (Print 19 0))
		(if (Said '/brick,fence') (Print 19 1))
		(if (Said 'look[/airport]') (Print 19 2) (Print 19 3))
	)
)

(instance monoScript of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0 (= seconds (Random 2 21)))
			(1
				(monorail posn: -59 52 setMotion: MoveTo 380 53 self)
			)
			(2
				(monorail posn: -945 52)
				(self changeState: 0)
			)
		)
	)
)

(instance coasterScript of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0 (= seconds (Random 2 10)))
			(1
				(coaster cel: 0 show: setCycle: EndLoop self)
			)
			(2
				(coaster hide:)
				(self changeState: 0)
			)
		)
	)
)
