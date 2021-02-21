(ns surds
  (:require [clojure.math.numeric-tower :as math]))

(use 'clojure.test)

(defn evaluate
  [surd]
  (/
   (+ (first surd) (math/sqrt (second surd)))
   (nth surd 2)))

(deftest surd-evaluation
  (testing "Evaluating surds"
    (is (= (evaluate [-2 7 1]) 0.6457513110645907))
    (is (= (evaluate [2 7 1]) 4.645751311064591))
    (is (= (evaluate [2 7 3]) 1.5485837703548635))))

;; (run-tests 'surds)