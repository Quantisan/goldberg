(ns goldberg.demo
  (:use [clojure.pprint :only [pprint]]
        [overtone.live]
        [overtone.inst.synth]
        ))

;(def blues (scale [3 2 1 1 3 2]))
;(definst a-saw [freq 440]
;  (saw freq))
;
;(definst kick [freq 120 dur 0.3 width 0.5]
;  (let [freq-env (* freq (env-gen (perc 0 (* 0.99 dur))))
;        env (env-gen (perc 0.01 dur) 1 1 0 1 FREE) sqr (* (env-gen (perc 0 0.01)) (pulse (* 2 freq) width))
;        src (sin-osc freq-env)
;        drum (+ sqr (* env src))]
;    (compander drum drum 0.2 1 0.1 0.01 0.01)))
;
;(definst c-hat [amp 0.8 t 0.04]
;  (let [env (env-gen (perc 0.001 t) 1 1 0 1 FREE)
;        noise (white-noise)
;        sqr (* (env-gen (perc 0.01 0.04)) (pulse 880 0.2))
;        filt (bpf (+ sqr noise) 9000 0.5)]
;    (* amp env filt)))
;
;(def metro (metronome 80))
;
;(def notes [1 3 1 3 5 5])
;(def melody (into notes notes))
;(println melody)
;
;(defn player [beat]
;  (let [next-beat (inc beat)
;        position (rem beat (count notes))
;        n (notes position)
;        ]
;    (at (metro beat) (kick))
;    (at (metro beat) (c-hat))
;    (at (metro (+ 0.5 beat)) (c-hat))
;    (apply-at (metro next-beat) #'player next-beat [])))
;
;
;(defn play-notes [t beat-dur notes attacks]
;  (when notes
;    (let [note      (+ 12 (first notes))
;          attack    (first attacks)
;          amp       0.5
;          release   0.1
;          next-beat (+ t beat-dur)]
;      (at t (ping note amp attack ))
;      (apply-at next-beat #'play-notes next-beat beat-dur (next notes) (next attacks) []))))

;(stop)
;(play-notes (now) 300 (scale :c4 :major) (repeat 0.05))
;
;;(play-notes (now) 425 (cycle [40 42 44 45 47 49 51 52]) (repeat 0.4))
;;(stop)
;;;(player (metro))
;;(metro)
;;(c-hat )
;;(a-saw)
;;(ctl a-saw :freq 660)
;;(stop)
