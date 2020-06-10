(ns roman-numerals)


(defn repeat-str [string n]
  (-> n
    (repeat string)
    clojure.string/join))


(defn one? [n] (= 1 n))


(defn handle-I
  "I in roman represents 1."
  [[n roman]]
  (let [quotient (/ n 1)]
    (cond
      (pos? quotient) [0 (str roman (repeat-str "I" (Math/ceil quotient)))]
      :else [n roman])))


(defn handle-V [[n roman]]
  (let [quotient (/ n 5)]
    (cond
      (one? quotient) [0 (str roman "V")]
      (= 4/5 quotient) [0 (str roman "IV")]
      (< 1 quotient) [(mod n 5) (str roman "V")]
      :else [n roman])))


(defn handle-X
  [[n roman]]
  (let [quotient (/ n 10)]
    (cond
      (one? quotient) [0 (str roman "X")]
      (= 9/10 quotient) [0 (str roman "IX")]
      (< 1 quotient) [(mod n 10) (str roman (repeat-str "X" (int quotient)))]
      :else [n roman])))


(defn handle-L
  "L in roman represents 50 or multiples of 50."
  [[n roman]]
  (let [quotient (/ n 50)]
    (cond
      (one? quotient) [0 (str roman "L")]
      (< 1 quotient) [(mod n 50) (str roman (repeat-str "L" (int quotient)))]
      (<= 40 n) [(- n 40) (str roman "XL")]
      :else [n roman])))


(defn handle-C
  "C in roman represents 100 or multiples of 100."
  [[n roman]]
  (let [quotient (/ n 100)]
    (cond
      (one? quotient) [0 (str roman "C")]
      (< 1 quotient) [(mod n 100) (str roman (repeat-str "C" (int quotient)))]
      (<= 90 n) [(- n 90) (str roman "XC")]
      :else [n roman])))


(defn handle-D
  "D in roman represents 500 or multiples of 500."
  [[n roman]]
  (let [quotient (/ n 500)]
    (cond
      (one? quotient) [0 (str roman "D")]
      (< 1 quotient) [(mod n 500) (str roman (repeat-str "D" (int quotient)))]
      (<= 400 n) [(- n 400) (str roman "CD")]
      :else [n roman])))


(defn handle-M
  "M in roman represents 1000 or multiples of 1000."
  [n]
  (let [quotient (/ n 1000)]
    (cond
      (one? quotient) [0 "M"]
      (< 1 quotient) [(mod n 1000) (repeat-str "M" (int quotient))]
      (<= 900 n) [(- n 900) "CM"]
      :else [n ""])))

(defmacro handle-roman [roman-char factor prefix-char prefix-value]
  (let [fn-name (symbol (str  "handle-" roman-char "-macro"))]
    `(defn ~fn-name
       [[~'n ~'result]]
       (let [quotient# (/ ~'n ~factor)
             remainder# (mod ~'n ~factor)]
         (cond
           (one? quotient#) [0 (str ~'result ~roman-char)]
           (and (< 1 quotient#)
                (<= ~prefix-value remainder#))
                [(- remainder# ~prefix-value)
                 (str ~'result (repeat-str ~roman-char (int quotient#)) ~prefix-char ~roman-char)]
           (< 1 quotient#) [remainder# (str ~'result (repeat-str ~roman-char (int quotient#)))]
           (<= ~prefix-value ~'n) [(- ~'n ~prefix-value) (str ~'result ~prefix-char ~roman-char)]
           :else [~'n ~'result])))))


(handle-roman "M" 1000 "C" 900)
(handle-roman "D" 500 "C" 400)
(handle-roman "C" 100 "X" 90)
(handle-roman "L" 50 "X" 40)
(handle-roman "X" 10 "I" 9)
(handle-roman "V" 5 "I" 4)
(handle-roman "I" 1 "I" 1)


(defn numerals-macro [n]
  (-> [n ""]
    handle-M-macro ; M = 1000
    handle-D-macro ; D = 500
    handle-C-macro ; C = 100
    handle-L-macro ; L = 50
    handle-X-macro ; X = 10
    handle-V-macro ; V = 5
    handle-I-macro ; I = 1
    last))

(defn numerals [n]
  (-> n
    handle-M ; M = 1000
    handle-D ; D = 500
    handle-C ; C = 100
    handle-L ; L = 50
    handle-X ; X = 10
    handle-V ; V = 5
    handle-I ; I = 1
    last))

