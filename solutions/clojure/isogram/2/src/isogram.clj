(ns isogram)


(defn- prune [text]
  (-> text
      (clojure.string/replace #"\s|-" "")
      clojure.string/lower-case))


(defn isogram? [text]
  (->> text
       prune
       frequencies
       vals
       (every? #(<= % 1))
       boolean))

