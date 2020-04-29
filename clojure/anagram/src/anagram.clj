(ns anagram
  (:require [clojure.string :as str]))

(defn- anagram? [word]
  (let [sorted-word (sort word)]
    #(= sorted-word (sort (str/lower-case %)))))

(defn- prune-prospects [word prospects]
  (remove
    #(= (str/lower-case %) word)
    prospects))

(defn anagrams-for [word prospects]
  (let [lowered-word (str/lower-case word)]
    (filter
      (anagram? lowered-word)
      (prune-prospects lowered-word prospects))))

