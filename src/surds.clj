(ns surds
  (:require [clojure.math.numeric-tower :as math]))

(use 'clojure.test)

(defn evaluate
  [surd]
  (/
   (+ (first surd) (math/sqrt (second surd)))
   (nth surd 2)))

(defn int-part
  [surd]
  (int (evaluate surd)))

(deftest surd-tests
  (testing "Evaluating surds"
    (is (= (evaluate [-2 7 1]) 0.6457513110645907))
    (is (= (evaluate [2 7 1]) 4.645751311064591))
    (is (= (evaluate [2 7 3]) 1.5485837703548635)))
  (testing "Calculating integer parts"
    (is (= (int-part [0 7 1]) 2))
    (is (= (int-part [2 7 3]) 1))
    (is (= (int-part [2 7 1]) 4))))