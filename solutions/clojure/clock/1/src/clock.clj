(ns clock)

(defrecord Clock [hours minutes])

(defn clock->string [clock]
  (format "%02d:%02d" (:hours clock) (:minutes clock)))

(defn clock [hours minutes]
  (let [total-minutes (+ minutes (* hours 60))
        adj-hours (int (mod (/ total-minutes 60) 24))
        adj-minutes (int (mod total-minutes 60))]
    (Clock. adj-hours adj-minutes)))

(defn add-time [clock_ time]
  (clock (:hours clock_) (+ time (:minutes clock_))))
