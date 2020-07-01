(ns octal)

(defn- to-num [character]
  (Integer/parseInt character))

(def octals (iterate #(* 8 %) 1))

(defn to-decimal [octal-string]
  (let [matches (re-matches #"^[0-7]+$" octal-string)
        octs (-> octal-string
                 (count)
                 (take octals)
                 (reverse))]
    (if (nil? matches)
      0
      (->> octal-string
           (re-seq #".")
           (map to-num)
           (map vector octs)
           (reduce
             (fn [acc [oct digit]]
               (+ acc (* digit oct)))
             0)))))

