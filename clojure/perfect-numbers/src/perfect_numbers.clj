(ns perfect-numbers)

(defn factor-of? [n f]
  (zero? (mod n f)))

(defn factors [n]
  ; inc the halfpoint since `range` is exclusive
  (filter #(factor-of? n %) (range 1 (inc (/ n 2)))))

(defn sum [coll] (reduce + 0 coll))

(defn factors-sum [n]
  (sum (factors n)))

(defn classify [n]
  (if (pos? n)
    (case (compare (factors-sum n) n)
      -1 :deficient
      0  :perfect
      1  :abundant)
    (throw (IllegalArgumentException.))))
