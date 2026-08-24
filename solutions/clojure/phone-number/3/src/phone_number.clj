(ns phone-number
  (:require [clojure.string :as s]))

(def invalid-result "0000000000")

(defn number [num-string]
  (let [phone-number (s/replace num-string #"[\s\(\)\.-]" "")
        length (count phone-number)]
    (condp = length
      10 phone-number
      11 (if (s/starts-with? phone-number "1") (subs phone-number 1 11) invalid-result)
      invalid-result)))

(defn area-code [num-string]
  (let [phone-number (number num-string)]
    (subs phone-number 0 3)))

(defn pretty-print [num-string]
  (let [phone-number (number num-string)
        [_ area fir sec] (re-find #"(\d{3})(\d{3})(\d{4})" phone-number)]
    (str "(" area ") " fir "-" sec)))
