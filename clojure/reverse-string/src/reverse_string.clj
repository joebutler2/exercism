(ns reverse-string)

(defn reverse-string [input-string]
  (->> input-string
       (re-seq #".")
       (reduce #(conj % %2) '())
       (clojure.string/join)))
