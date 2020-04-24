(ns anagram
  (:require [clojure.string :as str]))

(defn anagrams-for [word prospect-list]
  (let [sorted-word (sort (str/lower-case word))]
    (filter #(and (not= % (str/lower-case  word)) (= sorted-word (sort (str/lower-case %)))) prospect-list))
)
