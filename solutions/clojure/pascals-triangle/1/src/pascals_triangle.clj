(ns pascals-triangle)


(def triangle
  (iterate
    (fn [prev] 
      (case (count prev)
        1 [1 1]
        (let [result
              (->> prev
                   (partition 2 1)
                   (map (fn [[a b]] (+' a b)))
                   (into [1]))]
          (conj result 1))))
    [1]))


(defn row [nth-row]
  (nth triangle (dec nth-row)))

