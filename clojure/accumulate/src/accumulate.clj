(ns accumulate)


(defn accumulate 
  ([f coll] (if (empty? coll) coll (accumulate f coll [])))
  ([f coll result]
   (if (empty? coll)
     result
     (accumulate
       f
       (rest coll)
       (conj
         result
         (f (first coll)))))))

