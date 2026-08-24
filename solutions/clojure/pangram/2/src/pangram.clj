(ns pangram)

(def ^:const alphabet
  (into #{} (re-seq #"." "abcdefghijklmnopqrstuvwxyz")))


(defn pangram? [text]
  (= alphabet (->> text
                   clojure.string/lower-case
                   (re-seq #"[a-z]")
                   (reduce (fn [acc word] (conj acc word)) #{}))))

