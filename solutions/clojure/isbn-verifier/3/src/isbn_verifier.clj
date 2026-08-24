(ns isbn-verifier)

(defn get-value [cur-char]
  (if (= \X cur-char) 10 (Character/digit cur-char 10)))

(defn isbn? [raw-isbn] ;; <- arglist goes here
  (let [isbn (clojure.string/replace raw-isbn #"-|[A-W]|Y|Z" "")]
    (if (not (re-matches #"\d{9}X?|\d{10}" isbn))
      false
      (as-> isbn val 
        (map-indexed (fn [index elem] (* (get-value elem) (- 10 index))) val)
        (reduce + 0 val)
        (= 0 (mod val 11))))))

