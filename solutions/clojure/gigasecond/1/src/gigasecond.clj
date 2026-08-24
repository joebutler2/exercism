(ns gigasecond
  (:import [java.time LocalDateTime]))


(def gigasecondf 1000000000)


(defn date->result [date]
  [(.getYear date) (-> date .getMonth .getValue) (.getDayOfMonth date)])


(defn from
  "This function adds a gigasecond to the provided date. Is NOT thread-safe!"
  [year month day]
  (-> (LocalDateTime/of year month day 0 0)
      (.plusSeconds gigasecondf)
      (date->result)))
