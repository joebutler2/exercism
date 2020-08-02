(ns isogram
  (:require [clojure.string :as string]))

(defn isogram? [text]
  (every? #(<= % 1)
          (-> text
              (string/replace #"\s|-" "")
              string/lower-case
              frequencies
              vals)))

