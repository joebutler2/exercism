(ns strain)


(defn retain [pred coll]
  (reduce
    (fn [acc elem]
      (if (pred elem)
        (conj acc elem)
        acc
        ))
    []
    coll))


(defn discard [pred coll]
  (reduce
    (fn [acc elem]
      (if-not (pred elem)
        (conj acc elem)
        acc
        ))
    []
    coll))

