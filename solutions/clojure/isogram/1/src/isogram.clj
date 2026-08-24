(ns isogram)

(clojure.string/replace "éléphant" #"\s|-" "")

(defn isogram? [text]
  (let [pruned-text (-> text
                        (clojure.string/replace #"\s|-" "")
                        clojure.string/lower-case)]
    (->> pruned-text
         frequencies
         vals
         (every? #(<= % 1))
         boolean)))

