(ns etl
  (:require [clojure.string :as str]))

(defn transform [source]
  (reduce-kv
    #(if (coll? %3)
       (reduce (fn [acc value] (assoc acc (str/lower-case value) %2)) %1 %3)
       (assoc %1 (str/lower-case %3) %2))
    {}
    source))
