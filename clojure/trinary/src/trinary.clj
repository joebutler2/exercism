(ns trinary)

(defn parse-bit [string]
  (case string
    "2" 2
    "1" 1
    "0" 0))

(defn parse-bits
  "This will take a trinary string and convert it to a list of integers,
  ordered by the least significant digit to the most significant digit."
  [trinary-string]
  (->> trinary-string
       clojure.string/reverse
       (re-seq #"\d")
       (map parse-bit)))

(defn to-decimal [trinary-string]
  (if (re-find #"^\d+$" trinary-string)
    (let [bits (parse-bits trinary-string)
          bits-count (count trinary-string)
          indexed-map (zipmap (range bits-count) bits)]
      (int
        (reduce-kv
          (fn [m k bit]
            (+ m (* bit (Math/pow 3 k))))
          0
          indexed-map)))
    0 ; For invalid input return zero.
    ))


