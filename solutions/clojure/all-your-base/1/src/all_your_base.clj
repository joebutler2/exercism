(ns all-your-base)

(defn- calculate-result
  ([remainder base] (calculate-result '() remainder base))
  ([result remainder base]
   (if (zero? remainder)
     result
     (calculate-result
       (cons (rem remainder base) result)
       (int (/ remainder base))
       base))))


(defn convert [base_a num-seq base_b]
  (cond
    (or (some #(>= % base_a) num-seq)
        (some neg? num-seq)
        (< base_a 2)
        (< base_b 2)) nil
    (empty? num-seq) num-seq
    (every? zero? num-seq) '(0)
    :else (let [base-10-integer
                (reduce
                  (fn [acc [number exp]]
                    (+ acc (* number (Math/pow base_a exp))))
                  0
                  (map vector (reverse num-seq) (range)))]
            (calculate-result (int base-10-integer) base_b))))

