(ns run-length-encoding
  (:use [clojure.string :only [split join]]))

(defn run-length-encode
  "encodes a string with run-length-encoding"
  [plain-text]
  (loop [remaining-input plain-text output "" occurences 1]
    (if (empty? remaining-input)
      output
      (let [cur-char (first remaining-input)
            the-rest (rest remaining-input)]
        (if (= cur-char (first the-rest))
          (recur the-rest output (inc occurences))
          (recur the-rest
                 (str output (if (< 1 occurences) occurences "") cur-char)
                 1))))))

(defn run-length-decode
  "decodes a run-length-encoded string"
  [cipher-text]
  (loop [remaining-input cipher-text output ""]
    (if (empty? remaining-input)
      output
      (let [to-repeat (re-find #"^\d\d?" (join remaining-input))
            cur-char (first remaining-input)
            the-rest (rest remaining-input)]
        (if to-repeat
            (recur (nth (iterate rest remaining-input) (+ 1 (count to-repeat)))
                   (str output
                        (join (repeat (Integer. to-repeat)
                                      (if (< 1 (count to-repeat))
                                             (second the-rest) (first the-rest))))))
            (recur the-rest (str output cur-char)))))))
