(ns binary-search)

(defn middle [a_seq]
  (int (/ (count a_seq) 2)))

(defn search-for
  ([term a_seq] (search-for term a_seq 0 (- (count a_seq) 1)))
  ([term a_seq lower-bound upper-bound]
     (if (<= lower-bound upper-bound)
       (let [mid (+ lower-bound (- upper-bound lower-bound))
             current ((vec a_seq) mid)]
       (cond
         (= term current) mid
         (> term current) (search-for term a_seq (inc mid) upper-bound)
         (< term current) (search-for term a_seq lower-bound (dec mid))))
       (throw (Throwable. "not found")))))

