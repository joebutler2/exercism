(ns perfect-numbers)

(defn factors [n]
  ; inc the halfpoint since `range` is exclusive
  (filter #(zero? (mod n %)) (range 2 (inc(/ n 2)))))

(defn sum [coll] (reduce + 0 coll))

(defn factors-sum [n]
  (->> n
       (factors)
       (sum)
       (inc)))

(defn classify [n]
  (if (pos? n)
    (case (compare (factors-sum n) n)
      -1 :deficient
      0  :perfect
      1  :abundant)
    (throw (IllegalArgumentException.))))
