(ns surds
  "Functions to perform arithmetic operations on surds"
  (:require [clojure.math.numeric-tower :as math]))

(use 'clojure.test)

;; All surds must be in the following form: (a + sqrt(b))/c
;; Represented as [a b c]

(defn evaluate
  "Evaluate a surd representation as a decimal"
  [surd]
  (/
   (+ (first surd) (math/sqrt (second surd)))
   (nth surd 2)))

(defn int-part
  "Take the floor of the surd and return an integer"
  [surd]
  (int (evaluate surd)))

(defn frac-part
  "Subtract an integer from a given surd"
  [surd integer]
  (vector (+ (* (nth surd 2) (* -1 integer)) (first surd)) 
          (second surd) 
          (nth surd 2)))

(defn reciprocal
  "Find the reciprocal of a surd"
  [surd]
  (vector (* -1 (first surd))
          (second surd)
          (/ (- (second surd) (math/expt (first surd) 2)) (nth surd 2))))

(deftest surd-tests
  (testing "Evaluating surds"
    (is (= (evaluate [-2 7 1]) 0.6457513110645907))
    (is (= (evaluate [2 7 1]) 4.645751311064591))
    (is (= (evaluate [2 7 3]) 1.5485837703548635)))
  (testing "Calculating integer parts"
    (is (= (int-part [0 7 1]) 2))
    (is (= (int-part [2 7 3]) 1))
    (is (= (int-part [2 7 1]) 4)))
  (testing "Calculating fractional parts"
    (is (= (frac-part [0 7 1] 2) [-2 7 1]))
    (is (= (frac-part [2 7 1] 4) [-2 7 1]))
    (is (= (frac-part [11 431 10] 3) [-19 431 10])))
  (testing "Calculating reciprocals"
    (is (= (reciprocal [-20 431 1]) [20 431 31]))
    (is (= (reciprocal [-11 431 31]) [11 431 10]))
    (is (= (reciprocal [-19 431 10]) [19 431 7]))))
