(ns isbn-verifier)

(defn- numbers [isbn]
  (keep #(cond (= \X %) 10
               (Character/isDigit %) (Character/digit % 10)) isbn))

(defn isbn? [isbn]
  (boolean (if (re-matches #"(?:\d-?){9}[\dX]" isbn)
             (->> isbn
                  (numbers)
                  (map-indexed #(* %2 (- 10 %1)))
                  (reduce +)
                  (#(mod % 11))
                  zero?))))

