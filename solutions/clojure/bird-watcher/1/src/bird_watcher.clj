(ns bird-watcher)

(def last-week [0 2 5 3 7 8 4]
  )

(defn today [birds]
  (last birds)
  )

(defn inc-bird [birds]
  (assoc birds (- (count birds) 1) (inc (today birds)))
  )

(defn day-without-birds? [birds]
  (->> birds
    (some zero?)
    (some?))
  )

(defn n-days-count [birds n]
  (->> birds
    (take n)
    (reduce +))
  )

(defn busy-days [birds]
  (reduce (fn [acc number] (if (> number 4) (inc acc) acc)) 0 birds)
  )

(defn odd-week? [birds]
  (= birds (take (count birds) (cycle [1 0])))
  )
