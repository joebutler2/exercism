(ns gigasecond
  (:import [java.time LocalDateTime]))


(def gigasecond 1000000000)


(defn date->result [date]
  [(.getYear date) (-> date .getMonth .getValue) (.getDayOfMonth date)])


(defn from [year month day]
  (-> (LocalDateTime/of year month day 0 0)
      (.plusSeconds gigasecond)
      (date->result)))
