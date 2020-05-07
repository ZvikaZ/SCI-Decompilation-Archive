;;; Sierra Script 1.0 - (do not remove this comment)
(script# POLYPATH)
(include game.sh)
(use Main)
(use Motion)
(use System)


;; Path around an arbitrary set of obstacles, all of which are
;; defined as Polygons and added to the obstacle list via the
;; Rooms setObstacle method. 07/24/90 J.M.H.


(class PolyPath	kindof Motion
	(properties
		value		2	; current location in path
		points	0	; pointer to path array allocated in the kernel
		xLast	0
		yLast	0
		obstacles 0
	)
	
	(method (init actor theX theY whoCares opt obstList &tmp [buffer 30])
		(if argc											 
			(= client actor)
			(if (> argc 1)
				(cond
					((>= argc 6)
						(= obstacles obstList)
					)
					((not (IsObject obstacles))
						(= obstacles (curRoom obstacles?))
					)
				)
				(if points (Memory MDisposePtr points))
				(= points 
					(AvoidPath 
						(actor x?)
						(actor y?) 
						(= xLast theX) (= yLast theY) 
						(if obstacles
							(obstacles elements?)
						)
						(if obstacles
							(obstacles size?)
						)
						(if (>= argc 5)
							opt
						else
							TRUE
						)
					)
				)
				(if (> argc 3)
					(= caller whoCares)
				)
			)
			(self setTarget:)
		)
		(super init:)
	)

	
	(method (dispose)
		(if points (Memory MDisposePtr points))
		(= points NULL)
		(super dispose:)
	)

	(method (setTarget)
		(if (!= (WordAt points value) $7777)
			(= x (WordAt points value))
			(= y (WordAt points (++ value)))
			(++ value)
		)
	)
	
	(method (moveDone)
		(if (== (WordAt points value) $7777)
			(super moveDone:)
		else
			(self init:)
		)
	)
)
