(ns grade-school)

(defn grade [school grade]
  (get school grade []))

(defn add [school name grade]
  (update school grade (fnil #(into % [name]) [])))

(defn sorted [school]
  (into (sorted-map)
        (map (fn [[k v]] [k (vec (sort v))]))
        school))
