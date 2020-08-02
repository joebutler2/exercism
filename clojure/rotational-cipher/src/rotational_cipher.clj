(ns rotational-cipher)


(defn- normalize-offset
  "Takes an offset and constrains it to a range of -25 to 25."
  ; See if we can agjust this to 27 so we don't have to subtract 1 later on
  [offset]
  (if (pos? offset) (mod offset 26) (mod offset -26)))


(defn- is-upper-case? [char-int]
  (= Character/UPPERCASE_LETTER (Character/getType (char char-int))))


(defn- is-lower-case? [char-int]
  (= Character/LOWERCASE_LETTER (Character/getType (char char-int))))


(defn- constrain-uppercase [char-int]
  (let [lower-bound 65
        upper-bound 90]
  (cond (> char-int upper-bound)
        (dec (+ lower-bound (- char-int upper-bound)))
        (< char-int lower-bound)
        (dec (+ upper-bound (- lower-bound char-int)))
        :else char-int)))


(defn- constrain-lowercase [char-int]
  (let [lower-bound 97
        upper-bound 122]
    (cond
      (> char-int upper-bound) (dec (+ lower-bound (- char-int upper-bound)))
      (< char-int lower-bound) (dec (+ upper-bound (- lower-bound char-int)))
      :else char-int)))


(defn- char-int->character [char-int offset]
  (let [normalized-offset (normalize-offset offset)
        new-char-int (+ char-int normalized-offset)]
    (char (cond
      (is-upper-case? char-int) (constrain-uppercase new-char-int)
      (is-lower-case? char-int) (constrain-lowercase new-char-int)
      :else new-char-int))))


(defn rotate [text offset]
  (reduce
    (fn [acc char-int]
      (str acc (if (int? char-int)
                 (char-int->character char-int offset)
                 char-int)))
    ""
    (map #(if (Character/isAlphabetic (int %)) (int %) %) text)))

