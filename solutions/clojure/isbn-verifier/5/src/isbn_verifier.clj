(ns isbn-verifier)

(defn- char-digit [cur-char]
  "ISBNs can contain the character X, this will transform it to 10."
  (if (= \X cur-char) 10 (Character/digit cur-char 10)))

(defn- calculate-total [isbn]
  (->> isbn
    (map-indexed #(* (char-digit %2) (- 10 %1)))
    (reduce + 0)))

(defn isbn? [raw-isbn] ;; <- arglist goes here
  (let [isbn (clojure.string/replace raw-isbn #"-|[A-W]|Y|Z" "")]
    (if (re-matches #"\d{9}X?|\d{10}" isbn)
      (zero? (mod (calculate-total isbn) 11))
      false)))

