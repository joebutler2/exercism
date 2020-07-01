(ns strain)

(defn retain [pred coll]
  (reduce
    (fn [acc elem]
      (if (pred elem)
        (conj acc elem)
        acc))
    []
    coll))


(defn discard [pred coll]
  (retain (complement pred) coll))

