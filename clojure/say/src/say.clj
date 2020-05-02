(ns say
  (:use [clojure.string :only [trim]]))

(def single-digit
  {0 "zero"
   1 "one"
   2 "two"
   3 "three"
   4 "four"
   5 "five"
   6 "six"
   7 "seven"
   8 "eight"
   9 "nine"})

(def tens-pre-twenty
  {0 "ten"
   1 "eleven"
   2 "twelve"
   3 "thirteen"
   4 "fourteen"
   5 "fifteen"
   6 "sixteen"
   7 "seventeen"
   8 "eighteen"
   9 "nineteen"})

(def tens-digit
  {2 "twenty"
   3 "thirty"
   4 "forty"
   5 "fifty"
   6 "sixty"
   7 "seventy"
   8 "eighty"
   9 "ninety"})

(def place-suffix
  {2 "thousand"
   3 "million"
   4 "billion"})

(defn number->vector
  "Splits a number into a vector in which each entry is a single digit."
  [x]
  (if (< x 10)
    [x]
    (conj (number->vector (quot x 10))
          (rem x 10))))

(defn handle-hundreds [num]
  (if ((fnil pos? 0) num)
    (str (get single-digit num) " hundred ")
    ""))

(defn handle-tens-and-ones [tens ones]
        (cond
             (= tens 1) (get tens-pre-twenty ones)
             (zero? ones) (get tens-digit tens)
             (zero? tens) (get single-digit ones)
             :else (str (get tens-digit tens) "-" (get single-digit ones)))
  )

(defn humanize-digits [numbers humanized-numbers]
  (if (> (count numbers) 1)
    (let [[ones tens hundreds] (reverse numbers)]
      (str humanized-numbers " "
           (handle-hundreds hundreds)
           (handle-tens-and-ones tens ones)))
    (get single-digit (first numbers))))

(defn humanize-suffix [numbers section]
  (if (some pos? numbers)
    (place-suffix section)
    ""))

(defn humanize [digits section humanized]
  (str (humanize-digits digits humanized) " " (humanize-suffix digits section)))

(defn split-number [num]
  (let [digits (number->vector num)
        length (count digits)
        initial-digits (if (zero? (mod length 3)) 3 (mod length 3))
        [initial remainder] (split-at initial-digits digits)
        section (int (Math/ceil (/ length 3)))]
    [initial remainder section]))

(defn process-valid-number
  ([num]
   (let [[initial remainder section] (split-number num)]
     (process-valid-number remainder (dec section) (humanize initial section ""))))

  ([digits section humanized]
   (if (pos? section)
     (let [[current remainder] (split-at 3 digits)]
       (process-valid-number remainder (dec section) (humanize current section humanized)))
     (trim humanized))))

(defn number [num]
  (cond (and (pos? num) (< num 999999999999))
        (process-valid-number num)
        (zero? num) "zero"
        :else (throw (IllegalArgumentException. "Wrong argument."))))

