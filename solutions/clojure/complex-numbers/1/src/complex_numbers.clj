(ns complex-numbers)

(defn sq [a] (* a a))

(defn real [[a _]] a)

(defn imaginary [[_ b]] b)

; sqrt(a^2 + b^2)
(defn abs [[a b]]
  (Math/sqrt (+ (sq a) (sq b))))

(defn conjugate [[a b]]
  [a (* b -1)])

; (a + i * b) + (c + i * d) = (a + c) + (b + d) * i
(defn add [[a b] [c d]]
  [(+ a c) (+ b d)])

(defn sub [[a b] [c d]]
  [(- a c) (- b d)])

; (a + i * b) * (c + i * d) = (a * c - b * d) + (b * c + a * d) * i.
(defn mul [[a b] [c d]]
  [(-  (* a c) (* b d))
   (+  (* b c) (* a d))])

; (a + i * b) / (c + i * d) =
;   (a * c + b * d)/(c^2 + d^2) + (b * c - a * d)/(c^2 + d^2) * i
(defn div [[a b] [c d]]
  (let [denom (float (+ (sq c) (sq d)))]
    [(/ (+ (* a c) (* b d)) denom)
     (/ (- (* b c) (* a d)) denom)]))
