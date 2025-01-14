;;; Sierra Script 1.0 - (do not remove this comment)
(script# 96)
(include game.sh)
(use Main)
(use Intrface)
(use Sound)
(use Game)
(use Actor)
(use System)

(public
	rm96 0
)

(instance rm96 of Room
	(properties
		picture 96
	)
	
	(method (init)
		(Load VIEW 830)
		(Load SOUND 115)
		(super init:)
		(theSound play:)
		((View new:)
			view: 830
			ignoreActors:
			posn: 110 185
			addToPic:
		)
		(self setScript: rm96Script)
	)
)

(instance rm96Script of Script
	(properties)
	
	(method (doit)
		(super doit:)
	)
	
	(method (changeState newState)
		(switch (= state newState)
			(0 (= seconds 3))
			(1
				(Print 96 0 #at -1 15 #width 280)
				(= seconds 3)
			)
			(2
				(Print 96 1 #at -1 15 #width 280)
				(= seconds 3)
			)
			(3
				(Print 96 2 #at -1 15 #width 280)
				(= currentStatus egoDEAD)
			)
		)
	)
)

(instance theSound of Sound
	(properties
		number 115
	)
)
