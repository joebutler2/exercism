(ns collatz-conjecture)

(defmulti collatz (fn [num & args]
                   (if (pos? num)
                     (if (odd? num) :odd :even)
                     :negative)))

(defmethod collatz :even
  ([num] (collatz num 0))
  ([num steps]
   (if (= num 1)
     steps
     (collatz (/ num 2) (inc steps)))))

(defmethod collatz :odd
  ([num] (collatz num 0))
  ([num steps]
   (if (= num 1)
     steps
     (collatz (+ (* num 3) 1) (inc steps)))))
  
(defmethod collatz :negative [_]
  (throw (Throwable. "Please provide a positive integer")))
