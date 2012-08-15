(ns goldberg.floyd
  (:use [clojure.pprint :only [pprint]]
        [overtone.live]
        [overtone.inst.synth]))

(definst kick [freq 120 dur 0.3 width 0.5]
  (let [freq-env (* freq (env-gen (perc 0 (* 0.99 dur))))
        env (env-gen (perc 0.01 dur) 1 1 0 1 FREE) sqr (* (env-gen (perc 0 0.01)) (pulse (* 2 freq) width))
        src (sin-osc freq-env)
        drum (+ sqr (* env src))]
    (compander drum drum 0.2 1 0.1 0.01 0.01)))

(definst c-hat [amp 0.8 t 0.04]
  (let [env (env-gen (perc 0.001 t) 1 1 0 1 FREE)
        noise (white-noise)
        sqr (* (env-gen (perc 0.01 0.04)) (pulse 880 0.2))
        filt (bpf (+ sqr noise) 9000 0.5)]
    (* amp env filt)))

(def metro (metronome 300))

(defn beat-player [beat]
  (let [next-beat (inc beat)]
    (at (metro beat) (kick))
    (at (metro (+ 0.5 beat)) (c-hat))
    (apply-at (metro next-beat) #'beat-player next-beat [])))

(defn melody-player [beat [pair & other-notes]]
  (let [next-beat (inc beat)]
    (if pair
      (let [[note timing] pair]
        (at (metro (+ beat timing)) (ping note 0.1 0.50))))
    (apply-at next-beat #'melody-player next-beat other-notes [])))

(stop)
(beat-player (metro))
(melody-player (metro) [[74 0.0] [76 0.0] 
                        nil [77 0.0] 
                        nil [76 0.0]
                        nil nil

                        [74 0.0] nil
                        [76 0.0] [77 0.0] 
                        nil [76 0.0]
                        nil nil

                        nil nil
                        nil nil
                        nil nil
                        nil nil

                        nil nil
                        nil nil
                        nil nil
                        nil nil
                        
                        [74 0.0] [76 0.0] 
                        nil [77 0.0] 
                        nil [76 0.0]
                        nil nil

                        [74 0.0] nil
                        [76 0.0] [77 0.0] 
                        nil nil
                        nil nil

                        nil nil
                        nil nil
                        nil nil
                        nil nil
                        ])
;(stop)
