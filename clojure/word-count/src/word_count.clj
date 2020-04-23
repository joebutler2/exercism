(ns word-count
  (:require [clojure.string :as str]))

(defn- my-frequencies [words]
  (reduce
    #(update %1 %2 (fn [v] (inc v)))
    (zipmap words (repeat 0))
    words))

(defn word-count [s]
  (-> s
      (str/replace #"[,!&@\$%\^:]" "")
      (str/split #"\s+")
      (#(map str/lower-case %))
      (my-frequencies)))

