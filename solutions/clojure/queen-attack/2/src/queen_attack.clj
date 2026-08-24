(ns queen-attack)
(require '[clojure.string :as str])

(defn create-row [] (into [] (repeat 8 nil)))
(defn create-board [] (into [] (repeat 8 (create-row))))

(defn set-positions [{[wRow wCol] :w, [bRow bCol] :b} board]
  (as-> board b
        (if-not (nil? wRow) (assoc-in b [wRow wCol] :w) b)
        (if-not (nil? bRow) (assoc-in b [bRow bCol] :b) b)))

(defn board-string [positions]
  (->>
    (create-board)
    (set-positions positions)
    (map (fn [row] (str/join " " (map (fn [entry] (case entry
                                                    nil "_"
                                                    :w "W"
                                                    :b "B")) row))))
    (str/join "\n")
    (#(str % "\n"))))

(defn can-attack [{[wRow wCol] :w, [bRow bCol] :b}]
  (let [are-diagonal? (= (- bRow wRow) (- bCol wCol))]
    (or (= wRow bRow) (= wCol bCol) are-diagonal?)))
