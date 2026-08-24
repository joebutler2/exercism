(ns beer-song)

(defn- pluralize [num]
  (if (< 1 num) " bottles" " bottle"))

(defn- pronounize [num]
  (if (< 1 num) " one" " it"))

(defn- last-clause [num]
  (let [next-num (- num 1)]
   (if (< 0 next-num)
      (str next-num (pluralize next-num) " of beer on the wall.\n")
      "no more bottles of beer on the wall.\n")))

(defn verse
  "Returns the nth verse of the song."
  [num]
  (if  (< 0 num)
    (str num (pluralize num) " of beer on the wall, " num (pluralize num) " of beer.\n"
      "Take" (pronounize num) " down and pass it around, " (last-clause num))
    (str "No more bottles of beer on the wall, no more bottles of beer.\n"
      "Go to the store and buy some more, 99 bottles of beer on the wall.\n")))

(defn sing
  "Given a start and an optional end, returns all verses in this interval. If
  end is not given, the whole song from start is sung."
  ([start] (sing start 0))
  ([start end]
    (str (verse start)
      (if (<= end (- start 1)) (str "\n" (sing (- start 1) end))))))

"3 bottles of beer on the wall, 3 bottles of beer.\nTake one down and pass it around, 2 bottles of beer on the wall.\n\n2 bottles of beer on the wall, 2 bottles of beer.\nTake one down and pass it around, 1 bottle of beer on the wall.\n\n1 bottle of beer on the wall, 1 bottle of beer.\nTake it down and pass it around, no more bottles of beer on the wall.\n\nNo more bottles of beer on the wall, no more bottles of beer.\nGo to the store and buy some more, 99 bottles of beer on the wall.\n"
"3 bottles of beer on the wall, 3 bottles of beer.\nTake one down and pass it around, 2 bottles of beer on the wall.\n\n2 bottles of beer on the wall, 2 bottles of beer.\nTake one down and pass it around, 1 bottle of beer on the wall.\n\n1 bottle of beer on the wall, 1 bottle of beer.\nTake it down and pass it around, no more bottles of beer on the wall.\n\n"
