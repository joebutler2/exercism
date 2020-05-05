(ns robot-name)

(def upper-case-chars
 (seq "ABCDEFGHIJKLMNOPQRSTUVWXYZ"))

(def char-combos
  (->>
    upper-case-chars
    (map #(map (fn [other-char] (str % other-char)) upper-case-chars))
    (flatten)))

(def num-combos
  (map #(format "%03d" %) (range 1000)))

(def combos
  (->>
    char-combos
    (map #(map (fn [num] (str % num)) num-combos))
    (flatten)))

(def used-names
  (atom #{}))

(defn possible-names
  ([] (possible-names (rand-nth combos)))
  ([new-name] 
      (if (contains? @used-names new-name)
        (possible-names (rand-nth combos))
        (do
          (swap! used-names #(conj % new-name))
          new-name))))

; Public API -----

(defrecord Robot [name])

(defn robot-name [robot]
  @(:name robot))

(defn reset-name [robot]
  (reset! (:name robot) (possible-names)))

(defn robot []
  (let [new-bot (->Robot (atom ""))]
    (reset-name new-bot)
    new-bot))

