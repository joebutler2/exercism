(ns acronym
    (:require [clojure.string :as string]))

(defn acronym [word]
  (if (empty? word)
    word
      (-> word
        (string/replace #"(\w)([A-Z][a-z]+)" "$1 $2")
        (string/split #"\s|-")
        (->> 
          (map #(string/replace % #":" ""))
          (map #(string/upper-case (first %))))
        (string/join))))

