(ns hexadecimal)

(def alpha-map
  {
   \a 10
   \b 11
   \c 12
   \d 13
   \e 14
   \f 15})


(defn- char-to-int [character]
  (if (Character/isDigit character)
    (Integer/parseInt (str character))
    (get alpha-map character)))

(defn- invalid? [hex]
  (not (re-matches #"^[\da-f]+$" hex)))

(defn hex-to-int [hex]
  (if (invalid? hex)
    0
    (->> hex
         reverse
         (map vector (range))
         (reduce
           (fn [acc [index alphanum]]
             (+ acc
                (* (Math/pow 16 index)
                   (char-to-int alphanum))))
           0)
         int)))


