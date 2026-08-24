(ns triangle)

(defn- unique-sides-of [triangle num]
  (= num (count (into #{} triangle))))


(defn is-valid? [triangle]
  (let [all-pos? (every? #(< 0 %) triangle)
        [a b c] (sort triangle)] 
  (and all-pos?
       (>= (+ a b) c))))


(defn equilateral?
  [& triangle]
  "Returns true if all of the sides are equal."
  (and (is-valid? triangle)
       (unique-sides-of triangle 1)))


(defn isosceles?
  "Returns true if the triangle has at least 2 equal sides."
  [& triangle]
  (and (is-valid? triangle)
       (or (unique-sides-of triangle 1)
           (unique-sides-of triangle 2))))


(defn scalene?
  "Returns true if the triangle has no equal sides."
  [& triangle]
  (and (is-valid? triangle)
       (unique-sides-of triangle 3)))

