(ns allergies)


(def powers-of-2 (iterate (partial * 2) 2))


(def overflow-score (drop-while (partial > 256) powers-of-2))


(def value->allergy
  {
   128 :cats
   64 :pollen
   32 :chocolate
   16 :tomatoes
   8 :strawberries
   4 :shellfish
   2 :peanuts
   1 :eggs
   })


(defn allergies
  ([score]
   (let [offset (first (take-while #(< % score) overflow-score))
         final-score (if offset (- score offset) score)]
     (allergies final-score value->allergy [])))

  ([score remaining-allergies result]
   (let [[value allergy] (first remaining-allergies)
         other-allergies (rest remaining-allergies)]
     (if (nil? allergy)
       result
       (cond
         (= value score) (cons allergy result) 
         (< value score) (allergies 
                           (- score value)
                           other-allergies
                           (cons allergy result))
         :else (allergies score other-allergies result))))))


(defn allergic-to? [score allergy]
  (let [coll (into [] (allergies score))]
    (some #(= allergy %) coll)))


