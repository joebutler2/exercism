(ns anagram
  (:require [clojure.string :as str]))

(defn anagrams-for [word prospect-list]
  (let [lowered-word (str/lower-case word)
        sorted-word (sort lowered-word)]
    (filter
      #(= sorted-word (sort (str/lower-case %)))
      (->> prospect-list (remove #(= (str/lower-case %) lowered-word))))))
