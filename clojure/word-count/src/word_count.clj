(ns word-count
  (:require [clojure.string :as str]))

(defn- my-frequencies [words]
  (reduce #(update % %2 (fnil inc 0)) {} words))

(defn word-count [s]
  (->> s
      (str/lower-case)
      (re-seq #"\w+")
      (my-frequencies)))

