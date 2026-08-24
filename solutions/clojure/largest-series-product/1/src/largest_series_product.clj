(ns largest-series-product)

(defn char->int [cha] (Character/digit cha 10))

(defn any-non-digit? [nums] (not (every? #(Character/isDigit %) nums)))

(defn largest-product [size num]
  (cond
    (or (> size (count num))
        (any-non-digit? num)) (throw (Throwable. "Size is larger than the number string."))
    (zero? (count num)) 1
    :else (->> num
         (map char->int)
         (partition size 1)
         (map #(reduce (fn [acc num] (* acc num)) 1 %))
         (reduce max))))

