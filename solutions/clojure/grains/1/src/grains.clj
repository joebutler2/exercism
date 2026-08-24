(ns grains)

(defn math-sq [num]
  (* (bigint num) 2))

(defn gen-squares [num]
  (->> (iterate math-sq 1)
    (take num)))

(defn square [num]
  (last (gen-squares num)))

(defn total []
  (reduce + (gen-squares 64)))

