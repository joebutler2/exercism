; This solution is what I was originally aiming for
; https://exercism.io/tracks/clojure/exercises/crypto-square/solutions/371e76475959b9c3c74ac171
; I needed to spend more time with `partial` and `apply` to get 
; the desired result.

(ns crypto-square
  (:require [clojure.string :as string]))


(defn normalize-plaintext [input]
  (->> input
       (re-seq #"\d|\w")
       (map string/lower-case)
       string/join))


(defn square-size [input]
  (-> input
      normalize-plaintext
      count
      Math/sqrt
      Math/ceil
      int))


(defn plaintext-segments [input]
  (->> input
       normalize-plaintext
       (partition-all (square-size input))
       (map string/join)))


(defn ciphertext
  ([result segments]
   (if (every? empty? segments)
     result
     (ciphertext
       (str result (string/join (map first segments)))
       (map rest segments))))
  ([input]
   (let [segments (->> input
                       plaintext-segments
                       (map #(string/split % #"")))]
     (ciphertext "" segments))))


(defn normalize-ciphertext [input]
  (let [cipher (ciphertext input)
        cipher-length (count cipher)
        column-length (count (first (plaintext-segments input)))
        row-length (count (plaintext-segments input))
        buffered-chunks-length (- (* row-length column-length) cipher-length)
        chunk-delta (* row-length (- column-length buffered-chunks-length))]
    (->> cipher
         (map vector (range 1 (inc cipher-length)))
         (reduce
           (fn [acc [index item]]
             (let [dividend (if (<= index chunk-delta)
                              index
                              (- chunk-delta index))
                   divisor (if (<= index chunk-delta)
                             row-length
                             (dec row-length))
                   buffer (if (zero? (rem dividend divisor)) " " "")] 
               (str acc item buffer)))
           "")
         string/trimr)))

