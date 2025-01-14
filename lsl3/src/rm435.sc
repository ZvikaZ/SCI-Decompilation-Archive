;;; Sierra Script 1.0 - (do not remove this comment)
(script# 435)
(include game.sh)
(use Main)
(use Face)
(use Intrface)
(use Game)
(use System)

(public
	rm435 0
)
(synonyms
	(babe cheri)
)

(local
	local0
	local1
)
(instance rm435 of Room
	(properties
		picture 435
	)
	
	(method (init)
		(super init:)
		(self setRegions: FACE setLocales: GIRL setScript: RoomScript)
		(NotifyScript 71 1 149 45)
		(NotifyScript 71 2 180 45)
		(NotifyScript 71 3 149 42)
		(NotifyScript 71 4 178 42)
		(NotifyScript 71 5 163 61)
		(NotifyScript 71 6 164 78)
	)
)

(instance RoomScript of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0)
			(1
				(if local0
					(if (!= showroomState SRknowsAboutDeed)
						(= showroomState SRknowsAboutDeed)
						(= lawyerState LSfree)
						(= newspaperState NSshowroom)
						(theGame changeScore: 25)
					)
				else
					(EgoSays 435 30)
					(PersonSays 435 31)
				)
				(AnimateFace 2 55)
				(= cycles 33)
			)
			(2 (curRoom newRoom: 420))
		)
	)
	
	(method (handleEvent event &tmp item)
		(if
		(or (!= (event type?) saidEvent) (event claimed?))
			(return)
		)
		(cond 
			((Said 'bang') (Print 435 0) (PersonSays 435 1) (AnimateFace 4 4))
			(
				(or
					(Said '/land,deed,dowry')
					(Said '//land,deed,dowry')
				)
				(HandsOff)
				(EgoSays 435 2)
				(PersonSays 435 3)
				(= local0 1)
				(AnimateFace 2 33)
				(= state 0)
				(= cycles 22)
			)
			(
				(or
					(Said '(out<go),dance,show,date/')
					(Said 'get/babe/building')
					(Said 'ask/babe/date')
					(Said
						'go/area,backdrop,comedian,club,date,exit,bar,show,dance'
					)
				)
				(EgoSays 435 4)
				(PersonSays 435 5)
			)
			((Said 'address/babe,babe')
				(if (not local1)
					(= local1 1)
					(EgoSays 435 6)
					(PersonSays 435 7)
				else
					(EgoSays 435 8)
					(PersonSays 435 9)
				)
				(AnimateFace 2 20)
			)
			((Said 'show/ball') (EgoSays 435 10) (PersonSays 435 11) (AnimateFace 2 20))
			((or (Said 'enjoy/ya') (Said '/enjoy/ya')) (EgoSays 435 12) (PersonSays 435 13) (AnimateFace 5 44))
			(
				(or
					(Said 'cease/look')
					(Said 'look<cease')
					(Said 'look/area')
					(Said 'done,bye,exit,exit,done,exit,go')
				)
				(self changeState: 1)
			)
			((Said '/building,land,bush,bush') (PersonSays 435 14))
			((Said '/dance,show') (EgoSays 435 15) (PersonSays 435 16))
			((Said 'look>')
				(cond 
					((Said '/calf') (PersonSays 435 17) (AnimateFace 3 22))
					((Said '/ear') (Print 435 18))
					((Said '/boob') (Print 435 19) (PersonSays 435 20) (AnimateFace 6 12))
					((Said '[/area,casino,hotel,babe]') (Print 435 21) (PersonSays 435 22) (AnimateFace 2 33))
				)
			)
			((Said 'give>')
				(= item (inventory saidMe:))
				(event claimed: FALSE)
				(cond 
					((Said '[/!*]') (Print 435 23))
					((not item) (Print 435 24))
					((not (item ownedBy: ego)) (DontHave))
					((== item (inventory at: iBeachTowel))
						(PersonSays 435 25)
						(SetItemOwner iBeachTowel)
						(theGame changeScore: -10)
						(AnimateFace 2)
					)
					((== item (inventory at: iSoap))
						(PersonSays 435 26)
						(SetItemOwner iSoap)
						(theGame changeScore: -10)
						(AnimateFace 2)
					)
					((== item (inventory at: iGinsuKnife))
						(PersonSays 435 27)
						(SetItemOwner iGinsuKnife)
						(theGame changeScore: -10)
						(AnimateFace 2)
					)
					((== item (inventory at: iOrchids)) (PersonSays 435 28) (AnimateFace 4))
					(else (PersonSays 435 29))
				)
				(event claimed: TRUE)
			)
		)
	)
)
