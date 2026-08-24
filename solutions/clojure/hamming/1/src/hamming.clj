(ns hamming)

(defn- count-distance [strand1 strand2]
  (reduce
    #(if (= (get strand1 %2) (get strand2 %2)) %1 (inc %1)) 
    0
    (range 0 (count strand1))))

(defn distance [strand1 strand2]
  (cond
    (or (and (empty? strand1) (empty? strand2)) (= strand1 strand2)) 0
    (not= (count strand1) (count strand2)) nil
    :else (count-distance strand1 strand2)))
