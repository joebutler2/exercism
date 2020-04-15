(ns reverse-string)

(defn reverse-string [input-string]
  (reduce #(str %2 %1) "" input-string))
