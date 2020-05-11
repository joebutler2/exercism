(ns meetup
  (:import [java.time LocalDate]
           [java.time Month]
           [java.time DayOfWeek]
           [java.time.temporal TemporalAdjusters]))


(def days-of-week
  {:monday (DayOfWeek/MONDAY)
   :tuesday (DayOfWeek/TUESDAY)
   :wednesday (DayOfWeek/WEDNESDAY)
   :thursday (DayOfWeek/THURSDAY)
   :friday (DayOfWeek/FRIDAY)
   :saturday (DayOfWeek/SATURDAY)
   :sunday (DayOfWeek/SUNDAY)})


(defn date->weekday [date]
  (-> date
    (.getDayOfWeek)
    (.toString)
    (.toLowerCase)))


(defn date->result [date]
  [(.getYear date) (-> date .getMonth .getValue) (.getDayOfMonth date)])


(defn next-occurrence [day date]
  (->> (get days-of-week day)
    (TemporalAdjusters/next)
    (.with date)))


(defn occurrences-for [day date] 
  (filter
    #(and
      (= (.getMonth %) (.getMonth date))
      (= (.getDayOfWeek %) (get days-of-week day))) 
   (take 6 (iterate (partial next-occurrence day) date))))


(defn teenth [occurrences]
  (->> occurrences
       (filter
         #(let [day (.getDayOfMonth %)]
            (and (> day 12) (< day 20))))
       first))


(defn get-occurrence-by-ordinal [occurrences ordinal]
 (case ordinal
   :first (first occurrences)
   :second (second occurrences)
   :third (nth occurrences 2)
   :fourth (nth occurrences 3)
   :last (last occurrences)
   :teenth (teenth occurrences)))


(defn meetup [month year day ordinal]
  (let [date (LocalDate/of year month 1)]
    (-> (occurrences-for day date)
        (get-occurrence-by-ordinal ordinal)
        date->result)))

