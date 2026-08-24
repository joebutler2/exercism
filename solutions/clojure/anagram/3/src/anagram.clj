(ns anagram
  (:require [clojure.string :as str]))

(defn- anagram? [word]
  (let [lowered-word (str/lower-case word)
        sorted-word (sort lowered-word)]
    #(let [lowered-prospect (str/lower-case %)] 
       (and (not= lowered-word lowered-prospect)
            (= sorted-word (sort lowered-prospect))))))

(defn anagrams-for [word prospects]
  (filter (anagram? word) prospects))

