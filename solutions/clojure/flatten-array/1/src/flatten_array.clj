(ns flatten-array)

(defn flatten [arr]
  (->> arr
       (reduce #(if (coll? %2)
                  (vec (concat % (flatten %2)))
                  (conj % %2))
               [])
       (remove nil?)))
