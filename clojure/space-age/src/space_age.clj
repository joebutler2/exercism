(ns space-age)
(declare on-earth)

(defn on-mercury [seconds]
  (-> seconds
    (on-earth)
    (/ 0.2408467)))


(defn on-venus [seconds]
  (-> seconds
    (on-earth)
    (/ 0.61519726)))


(defn on-earth [seconds]
  (/ seconds 31557600))

(defn on-mars [seconds]
  (-> seconds
    (on-earth)
    (/ 1.8808158)))

(defn on-jupiter [seconds]
  (-> seconds
    (on-earth)
    (/ 11.862615)))

(defn on-saturn [seconds]
  (-> seconds
    (on-earth)
    (/ 29.447498)))

(defn on-neptune [seconds]
  (-> seconds
    (on-earth)
    (/ 164.79132)))

(defn on-uranus [seconds]
  (-> seconds
    (on-earth)
    (/ 84.016846)))

