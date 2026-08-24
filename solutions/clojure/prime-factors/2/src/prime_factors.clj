(ns prime-factors)

(defn of
  ([n]
   (if (> n 1)
     (of n 2 [])
     []))

  ([n divisor acc]
   (if (= 1 (/ n divisor))
     (vec (conj acc divisor))
     (if (zero? (mod n divisor))
       (recur (/ n divisor) divisor (conj acc divisor))
       (recur n (inc divisor) acc)))))

