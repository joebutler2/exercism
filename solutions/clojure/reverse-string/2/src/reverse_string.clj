(ns reverse-string)

(defn reverse-string [input-string]
  (reduce (fn [string char] (str char string)) "" input-string))
