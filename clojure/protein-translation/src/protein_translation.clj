(ns protein-translation)

(def translate-codon
  {"AUG" "Methionine"
   "UGG" "Tryptophan"
   "UUU" "Phenylalanine"
   "UUC" "Phenylalanine"
   "UUA" "Leucine"
   "UUG" "Leucine"
   "UCU" "Serine"
   "UCC" "Serine"
   "UCA" "Serine"
   "UCG" "Serine" 
   "UAU" "Tyrosine"
   "UAC" "Tyrosine"
   "UGU" "Cysteine"
   "UGC" "Cysteine"
   "UAA" "STOP" 
   "UAG" "STOP" 
   "UGA" "STOP"})

(defn- codon-chars->protein [acc codon-chars]
  (let [codon (translate-codon codon-chars)]
    (if (= "STOP" codon)
      (reduced acc)
      (conj acc codon))))

(defn translate-rna [rna]
  (reduce codon-chars->protein [] (re-seq #"\w{3}" rna)))


