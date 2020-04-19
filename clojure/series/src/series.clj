(ns series)
(require '[clojure.string])

(defn- get-slice [string start-index length]
  (let [end (min (+ start-index length) (count string))]
    (reduce #(str %1 (get string %2))
      ""
      (range start-index end))))

(defn slices [string length]
  (if (>= (count string) length)
    (reduce
      #(let [index (clojure.string/index-of string %2)]
          (if-not (zero? length)
            (if (<= index (- (count string) length))
              (conj %1 (get-slice string index length))
              (reduced %1))
            (reduced [""]))) ; There should be a better way.
      []
      string)
    [])
)
