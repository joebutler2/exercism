(ns nucleotide-count)

(def nucleotide-counter
  {\A 0
   \T 0
   \C 0
   \G 0})

(defn nucleotide-counts [strand]
  (reduce
   #(assoc %1 %2 (inc (%1 %2)))
   nucleotide-counter
   strand))

(defn count-of-nucleotide-in-strand [nucleotide strand]
  (if-let [result ((nucleotide-counts strand) nucleotide)]
    result
    (throw (Throwable. "Oh no."))))

