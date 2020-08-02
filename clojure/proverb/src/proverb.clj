(ns proverb)


(defn- last-verse [words]
  (str "And all for the want of a " (first words) "."))


(defn- verse [words]
  (let [a-verse (str "For want of a " (first words) " the " (second words) " was lost.")]
    (if (< 2 (count words))
      [a-verse (verse (rest words))]
      [a-verse])))


(defn recite [words]
  (cond
    (empty? words) ""
    (= 1 (count words)) (last-verse words)
    :else (let [main-verses (into [] (flatten (verse words)))
                verses (conj main-verses (last-verse words))]
            (clojure.string/join "\n" verses))))

