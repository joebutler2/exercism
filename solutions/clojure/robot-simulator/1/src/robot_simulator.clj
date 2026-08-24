(ns robot-simulator)

(defn robot [position direction]
  {:coordinates position :bearing direction})

(defn turn-right [facing]
  (case facing
    :west :north
    :north :east
    :east :south
    :south :west))

(defn turn-left [facing]
  (case facing
    :west :south
    :north :west
    :east :north
    :south :east))

(defn advance [robot]
  (case (robot :bearing)
    :west (update-in robot [:coordinates :x] dec)
    :east (update-in robot [:coordinates :x] inc)
    :north (update-in robot [:coordinates :y] inc)
    :south (update-in robot [:coordinates :y] dec)))

(defn simulate [operations robot]
  (reduce (fn [acc bearing]
            (case bearing
              \L (update acc :bearing turn-left)
              \R (update acc :bearing turn-right)
              \A (advance acc)))
          robot operations))