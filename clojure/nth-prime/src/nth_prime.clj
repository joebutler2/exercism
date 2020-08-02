(ns nth-prime)

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


(def MAX_SIZE (Math/pow 2 18))
(def primes ((memoize sieve) MAX_SIZE))


(defn nth-prime [position]
  (if (zero? position)
    (throw (IllegalArgumentException. "There is no zeroth prime."))
    (nth primes (dec position))))

