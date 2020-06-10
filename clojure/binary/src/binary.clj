(ns binary)

(defn parse-bit [string]
  (case string
    "1" 1
    "0" 0))

(defn parse-bits
  "This will take a binary string and convert it to a list of integers,
  ordered by the least significant digit to the most significant digit."
  [binary-string]
  (->> binary-string
       clojure.string/reverse
       (re-seq #"\d")
       (map parse-bit)))

(defn to-decimal [binary-string]
  (let [bits (parse-bits binary-string)
        bits-count (count binary-string)
        indexed-map (zipmap (range bits-count) bits)]
    (int
      (reduce-kv
        (fn [m k bit]
          (+ m (* bit (Math/pow 2 k))))
        0
        indexed-map))))

