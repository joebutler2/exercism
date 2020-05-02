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

(def implicits
  {0 "zero"
   1 "one"
   2 "two"
   3 "three"
   4 "four"
   5 "five"
   6 "six"
   7 "seven"
   8 "eight"
   9 "nine"
   10 "ten"
   11 "eleven"
   12 "twelve"
   13 "thirteen"
   14 "fourteen"
   15 "fifteen"
   16 "sixteen"
   17 "seventeen"
   18 "eighteen"
   19 "nineteen"
   20 "twenty"
   21 "twenty-one"
   22 "twenty-two"
   23 "twenty-three"
   24 "twenty-four"
   25 "twenty-five"
   26 "twenty-six"
   27 "twenty-seven"
   28 "twenty-eight"
   29 "twenty-nine"
   30 "thirty"
   31 "thirty-one"
   32 "thirty-two"
   33 "thirty-three"
   34 "thirty-four"
   35 "thirty-five"
   36 "thirty-six"
   37 "thirty-seven"
   38 "thirty-eight"
   39 "thirty-nine"
   40 "forty"
   41 "forty-one"
   42 "forty-two"
   43 "forty-three"
   44 "forty-four"
   45 "forty-five"
   46 "forty-six"
   47 "forty-seven"
   48 "forty-eight"
   49 "forty-nine"
   50 "fifty"
   51 "fifty-one"
   52 "fifty-two"
   53 "fifty-three"
   54 "fifty-four"
   55 "fifty-five"
   56 "fifty-six"
   57 "fifty-seven"
   58 "fifty-eight"
   59 "fifty-nine"
   60 "sixty"
   61 "sixty-one"
   62 "sixty-two"
   63 "sixty-three"
   64 "sixty-four"
   65 "sixty-five"
   66 "sixty-six"
   67 "sixty-seven"
   68 "sixty-eight"
   69 "sixty-nine"
   70 "seventy"
   71 "seventy-one"
   72 "seventy-two"
   73 "seventy-three"
   74 "seventy-four"
   75 "seventy-five"
   76 "seventy-six"
   77 "seventy-seven"
   78 "seventy-eight"
   79 "seventy-nine"
   80 "eighty"
   81 "eighty-one"
   82 "eighty-two"
   83 "eighty-three"
   84 "eighty-four"
   85 "eighty-five"
   86 "eighty-six"
   87 "eighty-seven"
   88 "eighty-eight"
   89 "eighty-nine"
   90 "ninety"
   91 "ninety-one"
   92 "ninety-two"
   93 "ninety-three"
   94 "ninety-four"
   95 "ninety-five"
   96 "ninety-six"
   97 "ninety-seven"
   98 "ninety-eight"
   99 "ninety-nine"
   })

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
  (let [num (+ (* 10 tens) ones)]
    (if (pos? num)
      (get implicits num)
      "")))

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

