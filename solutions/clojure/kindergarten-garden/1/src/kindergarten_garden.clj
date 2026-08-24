(ns kindergarten-garden)

(def plant-map 
  {"R" :radishes
   "V" :violets
   "G" :grass
   "C" :clover})


(def children ["alice" "bob" "charlie" "david"
               "eve" "fred" "ginny" "harriet"
               "ileana" "joseph" "kincaid" "larry"])


(defn- santize-names [names]
  (->> names
       (map #(keyword (name (clojure.string/lower-case %))))
       (sort)
       (into [])))


(defn- parse-into-pairs-in-rows [plants]
  (->> (clojure.string/split plants #"\n")
       (map (fn [row]
              (->> (re-seq #"." row)
                   (map #(get plant-map %))
                   (partition 2))))))


(defn- order-plants [plants]
  (let [pairs-in-rows (parse-into-pairs-in-rows plants)]
    (map
      (fn [row1 row2] (concat row1 row2))
      (first pairs-in-rows)
      (last pairs-in-rows))))


(defn garden
  ([plants names]
   (let [ordered-plants (order-plants plants)]
     (zipmap (santize-names names) (into [] ordered-plants))))
  ([plants] (garden plants children)))

