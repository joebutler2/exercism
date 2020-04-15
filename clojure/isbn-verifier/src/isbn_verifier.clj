(ns isbn-verifier)

(defn- char-digit [char]
  "ISBNs can contain the character X, this will transform it to 10."
  (if (= \X char) 10 (Character/digit char 10)))

(defn isbn? [raw-isbn]
  (let [isbn (clojure.string/replace raw-isbn #"-|[A-W]|Y|Z" "")]
    (boolean (and (re-matches #"\d{9}X?|\d{10}" isbn)
      (->> isbn
        (map-indexed #(* (char-digit %2) (- 10 %1)))
        (reduce + )
        (#(mod % 11))
        zero?)))))

