(ns spiral-matrix
  (:import [java.lang Math]))

(defn round [n]
  (Math/round (float n)))

(defn spiral [n]
  (case n
    0 '()
    1 '((1))
    (let [square-n (* n n)
          numbers (range 1 (inc square-n))]
      (->> (reduce
             (fn [acc number]
               (let [remainder (mod number n)
                     quotient (/ number n)
                     rows-count (count acc)
                     perimeter-end (- (* n 4) 4)]
                 (cond 
                   ; Initialize
                   (= 1 number) (conj acc [1])

                   ; Add to first row
                   (<= number n) (assoc acc 0 (conj (first acc) number))

                   ; Create new row
                   (< rows-count n) (conj acc [number])

                   ; Prepend entry on last row
                   (< (count (last acc)) n) (assoc acc (dec (count acc)) (into [] (cons number (last acc))))

                   ; Fill in the rest of the first column.
                   (<= number perimeter-end) (let [row (inc (- perimeter-end number))]
                                               (assoc acc row (vec (cons number (nth acc row)))))

                   ; Fill in the middle rows
                   ; subtract 2 from n since the first and last rows are filled.
                   :else (let [row-index (-> number
                                             (- 2)
                                             (/ n)
                                             Math/ceil
                                             int
                                             (- 2))
                               row (nth acc row-index)
                               column-index (cond
                                              (= (count row) 2) 1
                                              (zero? (mod row-index 2)) 1
                                              :else 2)]
                           (assoc acc row-index
                                  (let [[before after] (split-at (max column-index 1) row)]
                                    (vec (concat before [number] after))))))))
             []
             numbers)
           (map seq)))))

