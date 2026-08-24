(ns phone-number
  (:require [clojure.string :as s]))

(def invalid-result "0000000000")

(defn number [num-string]
  (let [pure-num-string (s/replace num-string #"[\s\(\)\.-]" "")]
    (if (= (count pure-num-string) 10)
     pure-num-string
     (if (and (= (count pure-num-string) 11) (s/starts-with? pure-num-string "1"))
       (subs pure-num-string 1 11)
       invalid-result))))

(defn area-code [num-string]
  (let [pure-num-string (number num-string)]
      (if (> (count pure-num-string) 10)
        (subs pure-num-string 1 4)
        (subs pure-num-string 0 3))))

(defn pretty-print [num-string]
  (let [pure-num-string (number num-string)
        [_ area fir sec] (re-find #"(\d{3})(\d{3})(\d{4})" pure-num-string)]
      (str "(" area ") " fir "-" sec)))
