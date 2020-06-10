(ns raindrops)

(defn divisible-by [dividend]
  #(zero? (mod dividend %)))

(defn convert [number]
  (let [predicate (divisible-by number)
        result  (str
                  (if (predicate 3) "Pling")
                  (if (predicate 5) "Plang")
                  (if (predicate 7) "Plong")
                  )]
    (if (not-empty result)
      result
      (str number))))

