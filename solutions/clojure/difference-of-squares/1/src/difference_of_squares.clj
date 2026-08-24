(ns difference-of-squares)

(defn sum-of-squares [num]
  (->> (range 1 (+ num 1))
       (map #(Math/pow % 2))
       (reduce #(+ %1 %2))
       int))

(defn square-of-sum [num]
  (->>
    (range 1 (+ num 1))
    (reduce #(+ %1 %2))
    (#(Math/pow % 2))
    int))

(defn difference [num]
  (- (square-of-sum num)
     (sum-of-squares num)))
