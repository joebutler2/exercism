(ns matching-brackets)

(def to-match #{\{ \} \[ \] \( \)})
(def matching-pairs
  {\{ \}
   \[ \]
   \( \)})


(defn- check-matching [in-stack out-stack]
  (cond
    (empty? in-stack) (empty? out-stack)
    (= (get matching-pairs (peek in-stack) "NO MATCH")
       (peek out-stack)
       ) (recur (pop in-stack) (pop out-stack))
    :else (recur
            (pop in-stack)
            (conj out-stack (peek in-stack)))))


(defn valid? 
  ([input] (valid? input []))
  ([input stack]
   (if (empty? input)
     ; Second phase - Check the stack to check for matches
     (check-matching stack [])
     ; First phase - extract relevant chars
     (let [next (first input)]
       (if (contains? to-match next)
         (valid? (rest input) (conj stack next))
         (valid? (rest input) stack))))))

