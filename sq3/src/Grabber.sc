;;; Sierra Script 1.0 - (do not remove this comment)
(script# GRABBER)
(include game.sh)
(use Main)
(use Intrface)
(use Game)

(public
	grabloc 0
)

(instance grabloc of Locale
	(properties)
	
	(method (handleEvent event)
		(super handleEvent: event)
		(if
		(or (!= (event type?) saidEvent) (event claimed?))
			(return)
		)
		(cond 
			(
				(and
					(> global132 3)
					(or
						(Said 'look/grabber,control,device')
						(Said 'look/button<claw,grabber,device')
					)
				)
				(Print 703 0)
			)
			((Said 'expectorate') (Print 703 1))
			((Said 'ass/hosebag') (Print 703 2))
			((Said 'kiss') (Print 703 3))
			((Said 'use/cable') (if (ego has: iWire) (Print 703 4) else (Print 703 5)))
			((Said 'tie') (Print 703 6))
			((Said 'holler,whistle,laugh[<out]') (Print 703 7))
			((Said 'listen') (Print 703 8))
			((Said 'cry[<out]') (Print 703 9))
			((Said 'clean') (Print 703 10))
			((Said 'write') (Print 703 11))
			((Said 'climb[<up,down]/banister,beam[<iron]') (Print 703 12))
			((Said 'use,climb,stand,erect,lean/ladder') (if (ego has: iLadder) (Print 703 13) else (DontHave)))
			((Said 'beat') (Print 703 14))
			((Said 'hang<from/banister,beam[<iron]') (Print 703 15))
			((Said 'climb<down[/*]') (Print 703 16))
			((Said 'look>')
				(cond 
					(
						(or
							(Said '[<down,below,at]/dirt,deck')
							(Said '<down,below,at[/dirt,deck]')
						)
						(Print 703 17)
					)
					((Said '/appendage,head,leg,body,self') (Print 703 18))
					((Said '/iron,scrap,debris,heap,garbage,ass') (Print 703 19))
					((Said '/conduit') (Print 703 20))
					(
						(or
							(Said '[<up,above,at]/ceiling')
							(Said '<up,above,at[/ceiling]')
						)
						(Print 703 21)
					)
					((Said '/claw[<grabber]')
						(if (or (== global132 4) (== global132 5))
							(Print 703 22)
						else
							(event claimed: FALSE)
						)
					)
					((Said '/motivator')
						(if (== motivatorState 3)
							(cond 
								((or (== global132 4) (== global132 5)) (Print 703 22))
								((== curRoomNum 13) (Print 703 23))
								(else (Print 703 24))
							)
						else
							(Print 703 24)
						)
					)
					((Said '/partition,console[<w,north,leech,w]') (Print 703 25))
					((Said '/banister,banister,beam[<iron]') (if (< global132 4) (Print 703 26) else (Print 703 27)))
					((Said '/lamp') (Print 703 28))
					((Said '/grate') (Print 703 29))
				)
			)
			((Said 'drop,hold[<in]/crystal/mouth') (Print 703 30))
			((Said 'eat,break/crystal[<glowing]') (Print 703 31))
			(
				(Said
					'sit,crawl,(get<off)[<down,on]/banister,banister,beam,conduit,bar'
				)
				(Print 703 32)
			)
			((Said 'use,get/motivator<motivator')
				(if (== motivatorState motivatorGRABBED)
					(Print 703 33)
				else
					(Print 703 34)
				)
			)
			((Said 'nap,(lie<down)[/deck]') (Print 703 35))
			((or (== global132 4) (== global132 5))
				(cond 
					((Said 'look/chair[<grabber,device]') (Print 703 36))
					((Said '(stand[<up]),(get<up,out,off)') (Print 703 37))
					((Said 'look/button[<claw]') (Print 703 38))
					((Said 'get[<up]/motivator')
						(if (== motivatorState motivatorGRABBED)
							(Print 703 39)
						else
							(Print 703 40)
						)
					)
					((Said 'look/control,console[<device,grabber]') (Print 703 41))
					(
						(or
							(Said
								'drag,press,use,manipulate,go[<forward,backward,back][/stick,throttle,control,knob]'
							)
							(Said
								'begin,manipulate,drive[<forward,backward,back]/grabber,device'
							)
						)
						(Print 703 42)
					)
					((Said 'release[/throttle,stick,control]') (Print 703 43))
					((Said 'look/claw[<grabber,device]') (Print 703 22))
					((Said 'climb') (Print 703 44))
					(
						(or
							(Said 'get,climb[<onto,on,to]/banister,beam')
							(Said 'get<up,on/banister,beam')
						)
						(Print 703 45)
					)
					(
					(Said 'get,jump,leap,climb[<onto,on,to]/conduit,bar') (Print 703 46))
					(
						(Said
							'stand,climb,get[<up,onto,off,down,on,out]/grabber,device,claw,banister,beam'
						)
						(Print 703 47)
					)
					((Said 'open/grate') (Print 703 48))
					((Said 'jump/craft') (Print 703 49))
					((Said 'jump[<down,up]') (Print 703 50))
				)
			)
		)
	)
)
