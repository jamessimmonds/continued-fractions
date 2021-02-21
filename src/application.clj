(ns application
  (:require [clojure.pprint :as p]))

(load-file "./cont-frac.clj")

(defn cont-frac-stats
  [n]
  (let [cf (cont-frac/cont-frac-sqrt n)]
   {:n n
    :continued-fraction cf
    :period (- (count cf) 1)}))

(def cont-fracs (map cont-frac-stats (range 1000)))

(println "\n=== Continued fractions from 1 to 1,000 ===\n")

(p/print-table (sort-by :period cont-fracs))
