(ns rna-transcription
  (:use [clojure.string :only [split]]))

(defn strict-get [map key]
  (if-let [[key value] (find map key)]
    value
    (throw (AssertionError. (str key " not found.")))))

(defn to-rna [dna]
  (let [convert-map {"G" "C", "C" "G", "T" "A", "A" "U"}]
    (reduce #(str %1 (strict-get convert-map %2)) "" (split dna #"")))
)
