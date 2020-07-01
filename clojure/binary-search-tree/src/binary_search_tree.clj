(ns binary-search-tree)

(defrecord Node [value left right])


(defn value [root]
  (:value root))


(defn singleton [a_value]
  (Node. a_value nil nil))


(defn left [root]
  (:left root))


(defn right [root]
  (:right root))


(defn insert [new_value {:keys [value left right] :as tree}]
  (cond
    (nil? tree) (Node. new_value nil nil)
    (<= new_value value) (Node. value (insert new_value left) right)
    (> new_value value) (Node. value left (insert new_value right))))


(defn print-node [node level]
  (let [indent (-> (repeat level " ") (clojure.string/join))]
    (prn (str indent (value node)))))


(defn print-tree
  ([root] (print-tree root 0))
  ([root level]
   (if (when-let [node (left root)] (value node)) (print-tree (left root) (inc level)))
   (if (pos? (value root)) (print-node root level))
   (if (when-let [node (right root)] (value node)) (print-tree (right root) (inc level)))))


(defn to-list 
  ([root] (to-list root []))
  ([root result]
   (concat
     (when-let [value (left root)] (to-list value))
     (when-let [value (value root)] (conj result value))
     (when-let [value (right root)] (to-list value)))))


(defn from-list [list]
  (reduce (fn [acc item] (insert item acc)) nil list))

