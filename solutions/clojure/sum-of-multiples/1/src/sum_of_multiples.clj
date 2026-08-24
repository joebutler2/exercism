(ns sum-of-multiples)

(defn sum-of-multiples [multiples upper-bound]
  (let [of-range (range upper-bound)]
    (->>
      (map
        (fn [multiple]
          (filter #(zero? (mod % multiple)) of-range))
        multiples)
      (flatten)   
      (into #{})
      (reduce +))))

