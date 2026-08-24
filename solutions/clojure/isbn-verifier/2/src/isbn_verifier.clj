(ns isbn-verifier)

(defn isbn? [raw-isbn] ;; <- arglist goes here
  (let [isbn (clojure.string/replace raw-isbn #"-|[A-W]|Y|Z" "")
        check-digit-index (clojure.string/index-of isbn "X")
        is-check-digit-invalid (and (not (nil? check-digit-index)) (> 9 check-digit-index))]
    (if (or (not= 10 (count isbn)) is-check-digit-invalid)
      false
      (let [total
        (loop [acc 0 remaining-isbn isbn counter 10]
          (if (empty? remaining-isbn)
            acc
            (let [cur-char (first remaining-isbn)
                  the-rest (rest remaining-isbn)
                  cur-digit (if (= \X cur-char) 10 (Character/digit cur-char 10))]
              (recur (+ acc (* cur-digit counter)) the-rest (dec counter)))))]
        (= 0 (mod total 11))))))

