turtles-own [
  ;;for the first behaviour :
  leader                
  follower            
  speed
   
  ;; for the 2nd behaviour :
  visible-neighbors      ;; what birds can I see nearby?
  closest-neighbor       ;; who's the closest bird I can see?
  speedBis                  ;; what speed am I flying at?
  happy?                 ;; am I content with my current place?
]

to setup
  clear-all
  crt population
  [ set color magenta
    setxy random-xcor random-ycor
    set leader nobody
    set follower nobody 
    set speed 1]
  reset-ticks
end

to go
  
  if Comportement = 1 [
  ask turtles
  [ if leader = nobody
    [ attach-turtle ] ]
  ask turtles [ turn-turtle ]
  ask turtles [ fd speed ]
  ]
  
  if Comportement = 2 [
    ask turtles [
    set speed base-speed
    set visible-neighbors (other turtles in-cone vision-distance vision-cone)
    ifelse any? visible-neighbors
      [ adjust
        set happy? true ]
      [ set happy? false ] 
    recolor
    fd speed  ; fly forward!
  ]
  ]
  
  if Comportement = 3 [
    ask turtles [
     if leader = nobody
    [ attach-turtle ] ]
    ask turtles [ turn-turtle ]
    ask turtles [ fd speed ]
    ask turtles [
    set speed base-speed
    set visible-neighbors (other turtles in-cone vision-distance vision-cone)
    ifelse any? visible-neighbors
      [ adjust
        set happy? true ]
      [ set happy? false ] 
    recolor
    fd speed  ; fly forward!
    ]
    ]
  tick
  
end

;; for the first behaviour :
to attach-turtle  ;; turtle procedure
  ;; find a random patch to test inside the donut
  let xd near-radius + random (far-radius - near-radius)
  let yd near-radius + random (far-radius - near-radius)
  if random 2 = 0 [ set xd (- xd) ]
  if random 2 = 0 [ set yd (- yd) ]
  ;; check for free turtles on that patch
  let candidate one-of (turtles-at xd yd) with [follower = nobody]
  ;; if we didn't find a suitable turtle, stop
  if candidate = nobody [ stop ]
  ;; we're all set, so latch on!
  ask candidate [ set follower myself ]
  set leader candidate
  ;; change our color
  ifelse follower = nobody
  [ set color lime ]
  [ set color sky]
  ;; change our leader's color
  ask candidate
  [ ifelse leader = nobody
    [ set color yellow ]
    [ set color sky
      set speed base-speed * 0.9]]
end

to turn-turtle  ;; turtle procedure
  ;; if we are still unattached...
  ifelse leader = nobody
  ;; do a somewhat random glide
  [ rt random-float waver - random-float waver ]
  ;; otherwise follow the leader
  [ face leader ]
end

;;;; for the 2nd behaviour
to adjust ;; turtle procedure
  set closest-neighbor min-one-of visible-neighbors [distance myself]
  let closest-distance distance closest-neighbor
  ;; if I am too far away from the nearest bird I can see, then try to get near them
  if closest-distance > updraft-distance [
    turn-towards (towards closest-neighbor)
    ;; speed up to catch up
    set speed base-speed * (1 + speed-change-factor)
    set happy? false
    stop
  ]
  ;; if i am too close to the nearest bird slow down
  if closest-distance < too-close [
    set speedBis [speedBis] of closest-neighbor
    set heading [heading] of closest-neighbor
    ;; speed down to let the bird in front of me move away
    set speedBis base-speed * (1 - speed-change-factor)
    stop
  ]

  ;; if all three conditions are filled, adjust
  ;; to the speed and heading of my neighbor and take it easy
  set speedBis [speedBis] of closest-neighbor
  turn-towards [heading] of closest-neighbor
  set happy? true
end

to recolor ;; turtle procedure
  set color white
  ;;ifelse show-unhappy? [
   ;; ifelse happy?
     ;; [ set color white ]
      ;;[ set color red ]
  ;;][
    ;; This changes the bird's color some shade of yellow --
    ;; note that the color is based on WHO number, not RANDOM, so birds
    ;; won't change color if the SHOW-UNHAPPY? switch is flicked on and off
  ;;  set color yellow - 2 + (who mod 7)
  ;;]
end

to turn-towards [new-heading]  ;; turtle procedure
  turn-at-most (subtract-headings new-heading heading)
end

to turn-at-most [turn]  ;; turtle procedure
  ifelse abs turn > max-turn [
    ifelse turn >= 0
      [ rt max-turn ]
      [ lt max-turn ]
  ] [
    rt turn
  ]
end
