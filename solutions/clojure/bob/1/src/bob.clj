(ns bob
  (:use [clojure.string :only (includes? trim upper-case ends-with?)]))

(defn response-for [s]
  (let [has-capital-chars (re-find #"[A-Z]+" s)
        all-upper-case (= s (upper-case s))]
    (cond
      (and (includes? s "?") all-upper-case has-capital-chars) "Calm down, I know what I'm doing!"
      (and (ends-with? (trim s) "?") (not (includes? s "\n"))) "Sure."
      (= (trim s) "") "Fine. Be that way!"
      (and all-upper-case has-capital-chars) "Whoa, chill out!"
      :else "Whatever."))
)
