(ns change)

; Naive first attempt that doesn't always find the optimal solution.

(defn issue [value coins]
  (let [coins (into (sorted-set) (filter #(<= % value) coins))]
    (cond
      (zero? value) '()
      (empty? coins) (throw (IllegalArgumentException. "cannot change"))
      (contains? coins value) (list value)
      :else 
      (->> (reduce
            (fn [acc start-coin]
              (loop [total (- value start-coin)
                     result (list start-coin)
                     potential-coins (filter #(<= % total) coins)]
                (if (<= total 0)
                  (conj acc result)
                  (let [max-coin (last potential-coins)
                        new-total (- total max-coin)]
                    (recur new-total (conj result max-coin) (filter #(<= % new-total) potential-coins))))))
            '()
            coins)
           (sort-by count)
           first
          ))))

