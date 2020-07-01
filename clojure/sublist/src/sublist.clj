(ns sublist)

(defn indexed
  "Return a list of Tuples, with the indicies in the first position
   and the values in the second position."
  [list] (map-indexed vector list))

(defn list->bool-map [list] (zipmap list (repeat false)))
(defn all-true? [map] (->> (vals map) (every? true?)))

(defn out-of-order?
  "We use the boolean map to see if one of the later values
   were seen. If it's valid then the numbers would only appear in order."
  [map]
  (if (some true? (vals map))
    (reduce-kv
      (fn [acc k v]
        (if (false? acc)
          (if (true? v) (reduced true))
          v))
      nil
      map)
    ))

(defn is-sublist? [list1 list2]
  (let [bool-map (list->bool-map list1)]
    (->>
      list2 
      (reduce
        #(cond
           (all-true? %1) (reduced %1)
           (out-of-order? %1) bool-map
           :else (if (contains? %1 %2)
             (assoc %1 %2 true)
             bool-map))
        bool-map)
      (all-true?))))

(defn is-superlist? [list1 list2]
  (is-sublist? list2 list1))

(defn classify [list1 list2]
  (cond
    (or (= list1 list2) 
      (every? empty? [list1 list2])) :equal
    (or
      (and (empty? list1) (not-empty list2))
      (is-sublist? list1 list2)) :sublist
    (or
      (and (not-empty list1) (empty? list2))
      (is-superlist? list1 list2)):superlist
    (not= list1 list2) :unequal
))
