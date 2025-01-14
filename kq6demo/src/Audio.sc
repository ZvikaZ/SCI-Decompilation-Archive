;;; Sierra Script 1.0 - (do not remove this comment)
(script# 95)
(include game.sh)
(use System)


(local
	local0
)
(class Audio of Object
	(properties
		number 0
		loop 1
		paused 0
		doNotStop 0
		stopped 1
	)
	
	(method (play param1)
		(= local0 0)
		(cond 
			((DoAudio Play number)
				(= stopped 0)
				(if (IsObject param1) (= local0 param1))
				(self check:)
			)
			(
			(and (IsObject param1) (!= (= local0 param1) 0)) (local0 cue:))
		)
	)
	
	(method (stop)
		(= stopped TRUE)
		(DoAudio Stop)
	)
	
	(method (pause)
		(if (not paused) (DoAudio Pause) (self paused: TRUE))
	)
	
	(method (resume)
		(if paused (DoAudio Resume) (self paused: FALSE))
	)
	
	(method (setLoop param1)
		(self loop: param1)
	)
	
	(method (setRate param1)
		(if argc (DoAudio Rate param1))
	)
	
	(method (check &tmp temp0)
		(if
		(and (not stopped) (== (DoAudio Loc) -1) (== loop 1))
			(= doNotStop FALSE)
			(= stopped TRUE)
			(if (!= local0 0)
				(= temp0 local0)
				(= local0 0)
				(temp0 cue:)
			)
		)
		(if
			(and
				(not stopped)
				(== (DoAudio Loc) -1)
				(or (> loop 1) (== loop -1))
			)
			(self play:)
		)
	)
)
