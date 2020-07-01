(ns luhn)

(defn- fails-preconditions [digits]
  (->> (clojure.string/replace digits #"\s+" "")
       (re-matches #"^\d{2,}$")
       (nil?)))

(defn- luhn-calculation [digits]
  (->> digits
       (re-seq #"\d")
       (map #(Integer/parseInt %))
       (reverse)
       (map-indexed
         (fn [index item]
           (if (and (odd? index) (< item 9))
             (mod (* item 2) 9)
             item)))))

(defn valid? [digits]
  (if (fails-preconditions digits)
    false
    (let [post-digits (luhn-calculation digits)]
      (-> 
        (reduce + post-digits)
        (mod 10)
        (zero?)))))

