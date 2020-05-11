;;; Sierra Script 1.0 - (do not remove this comment)
(script# 41)
(include game.sh)
(use Main)
(use Intrface)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm41 0
)

(local
	local0
	bikiniInRoom
	canFollowHenchwoman
	henchwomanApporaches
	bikini
	henchwoman
)
(instance rm41 of Room
	(properties
		picture 41
		horizon 5
	)
	
	(method (init)
		(Load VIEW 401)
		(Load VIEW 403)
		(super init:)
		((View new:)
			view: 401
			loop: 0
			cel: 0
			posn: 34 110
			setPri: 7
			addToPic:
		)
		((View new:)
			view: 401
			loop: 1
			cel: 0
			posn: 77 147
			setPri: 11
			addToPic:
		)
		((View new:)
			view: 401
			loop: 2
			cel: 0
			posn: 119 103
			setPri: 6
			addToPic:
		)
		((View new:)
			view: 401
			loop: 2
			cel: 1
			posn: 88 81
			setPri: 4
			addToPic:
		)
		((View new:)
			view: 401
			loop: 3
			cel: 1
			posn: 10 79
			setPri: 4
			addToPic:
		)
		((View new:)
			view: 401
			loop: 3
			cel: 0
			posn: 41 108
			setPri: 7
			addToPic:
		)
		((View new:)
			view: 403
			loop: 0
			cel: 0
			posn: 86 135
			setPri: 9
			addToPic:
		)
		((View new:)
			view: 403
			loop: 0
			cel: 1
			posn: 58 69
			setPri: 3
			addToPic:
		)
		((View new:)
			view: 403
			loop: 1
			cel: 0
			posn: 22 108
			setPri: 7
			addToPic:
		)
		((View new:)
			view: 403
			loop: 2
			cel: 0
			posn: 94 98
			setPri: 6
			addToPic:
		)
		(if (< (ego y?) 164) (ego y: 164))
		(NormalEgo)
		(ego init:)
		(self setRegions: BEACH setScript: rm41Script)
		(cond 
			(
				(and
					((inventory at: iBikiniBottom) ownedBy: curRoomNum)
					(== currentEgoView 149)
				)
				(= bikiniInRoom TRUE)
				(Load VIEW 400)
				((= bikini (View new:))
					view: 400
					ignoreActors:
					posn: 88 158
					stopUpd:
					init:
				)
			)
			((== currentEgoView 100)
				(self setRegions: HENCHWOMAN)
				(= henchwomanIsHere TRUE)
				(= henchView 402)
				(Load VIEW henchView)
				((= henchwoman (Actor new:))
					view: henchView
					illegalBits: 0
					setLoop: 4
					setPri: 12
					posn: 106 155
					cycleSpeed: 2
					init:
					setScript: henchScript
				)
				(NotifyScript HENCHWOMAN 1)
			)
		)
	)
)

(instance rm41Script of Script
	(properties)
	
	(method (doit)
		(super doit:)
		(if (== 2 (ego edgeHit?))
			(if (== henchwomanApporaches 0)
				(curRoom newRoom: 42)
			else
				(Print 41 0 #at 15 -1 #width 280)
				(= currentStatus egoCaptured)
				(curRoom newRoom: 95)
			)
		)
		(if (and henchwomanIsHere canFollowHenchwoman (> (ego x?) 300))
			(= canFollowHenchwoman 0)
			(= henchwomanApporaches 1)
			(curRoom east: 95)
			(Print 41 1)
		)
	)
	
	(method (handleEvent event)
		(if
		(or (!= (event type?) saidEvent) (event claimed?))
			(return)
		)
		(if (Said 'climb[<over]/boulder') (Print 41 2))
		(if (Said 'look>')
			(if (and henchwomanIsHere (Said '/bimbo'))
				(Print 41 3)
			)
			(if (Said '/children,man,bed,bimbo')
				(Print 41 4 #at -1 152 #font smallFont)
			)
			(if (Said '/palm')
				(Print 41 5)
				(if (> filthLevel 13) (Print 41 6 #at -1 152))
			)
			(if (Said '/boulder')
				(Print 41 7)
				(if bikiniInRoom (Print 41 8))
			)
			(if (Said '[/airport,boulder,beach]')
				(Print 41 9)
				(if bikiniInRoom (Print 41 8))
			)
		)
		(if henchwomanIsHere
			(if (Said 'get/towel') (Print 41 10))
			(if (Said 'call/bimbo')
				(if (not (ego inRect: 75 150 160 189))
					(PrintNotCloseEnough)
				else
					(Print (Format @str 41 11 introductoryPhrase))
					(if (not (henchScript state?))
						(henchScript changeState: 4)
					)
				)
			)
		)
		(if
			(or
				(Said
					'wear,(alter<in),(conceal<on)/job,(bra<bathing),bikini'
				)
				(Said 'alter,(get<off),drain/bra,bra')
				(Said
					'wear,(conceal<on)/job,(,bottom,(bra<bathing),bikini'
				)
				(Said 'get<naked')
				(Said 'naked')
				(Said 'alter,(get<off),drain/bra,bra')
			)
			(Print 41 12)
			(Print 41 13)
		)
		(if (Said 'get/bottom,bikini,(bottom<bikini)')
			(cond 
				((not bikiniInRoom) (Print 41 14))
				((not (ego inRect: 76 179 106 189)) (PrintNotCloseEnough))
				(else
					(Print 41 15)
					(= bikiniInRoom FALSE)
					(ego get: iBikiniBottom)
					(bikini dispose:)
					(theGame changeScore: 4)
				)
			)
		)
	)
)

(instance henchScript of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0 (= cycles (Random 30 50)))
			(1
				(henchwoman setCycle: Forward)
				(= cycles (Random 5 22))
			)
			(2
				(henchwoman setCel:)
				(= seconds 5)
			)
			(3
				(switch (Random 1 3)
					(1 (Print 41 16))
					(2 (Print 41 17))
					(3 (Print 41 18))
				)
				(Print 41 19 #at -1 152)
				(self changeState: 0)
			)
			(4
				(= cycles 0)
				(henchwoman setCel: 0)
				(Print 41 20 #at 15 -1 #width 280 #draw)
				(= seconds 5)
			)
			(5
				(henchwoman
					setAvoider: (Avoider new:)
					setStep: 3 2
					setLoop: -1
					setPri: -1
					cycleSpeed: 0
					loop: 0
					posn: 105 182
					setCycle: Walk
					setAvoider: Avoider
					setMotion: MoveTo 333 183 self
				)
				(= cycles 20)
			)
			(6
				(if (> (henchwoman x?) (ego x?))
					(Print 41 21)
				else
					(Print 41 22)
				)
				(= canFollowHenchwoman TRUE)
			)
			(7 (= seconds 10))
			(8
				(henchwoman dispose:)
				(= henchView 0)
				(= henchwomanIsHere FALSE)
				(= canFollowHenchwoman FALSE)
			)
		)
	)
)
