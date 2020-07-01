(ns sieve)

; From http://www.learningclojure.com/2009/11/sieve-of-eratosthenes.html
(defn sieve
  ([n]
     (sieve (sorted-set) (apply sorted-set (range 2 (inc n))) (+ n 2)))
  ([primes candset end]
     (let [prime (first candset)]
       (if ( > (* prime prime) end)
         (into [] (clojure.set/union primes candset))
         (recur (conj primes prime)
                (clojure.set/difference candset (range prime end prime))
                end)))))

