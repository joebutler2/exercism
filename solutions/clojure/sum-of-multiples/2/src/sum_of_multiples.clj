(ns sum-of-multiples)

(defn sum-of-multiples [multiples upper-bound]
  (let [of-range (range upper-bound)]
    (->>
      (mapcat
        (fn [multiple]
          (filter #(zero? (mod % multiple)) of-range))
        multiples)
      (set)
      (reduce +))))

