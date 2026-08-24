(ns armstrong-numbers)

(defn exp [x n]
  (reduce * (repeat n x)))

(defn digits [n]
  (if (pos? n)
    (conj (digits (quot n 10)) (mod n 10) )
    [])) 

(defn armstrong? [num] ;; <- arglist goes here
  (let [numList (digits num) numLength (count numList)]
      (= num (reduce #(+ %1 (exp %2 numLength)) 0 numList))))

