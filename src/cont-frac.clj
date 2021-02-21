(ns cont-frac
  "Algorithm for finding continued fraction representation of a square root"
  (:require [clojure.math.numeric-tower :as math]))

(use 'clojure.test)

(load-file "./surds.clj")

(defn find-cont-frac
  "Find continued fraction representation for a surd"
  [surd a_0]
  (let [a_n (surds/int-part surd)]
    (if (= a_n (* 2 a_0))
      (vector (* 2 a_0))
      (cons a_n (find-cont-frac (surds/reciprocal (surds/frac-part surd a_n)) a_0)))))

(defn cont-frac-sqrt
  "Find a continued fraction representation for a square root"
  [n]
  (if (= (mod (math/sqrt n) 1) 0) (vector (math/sqrt n))
   (let [surd (vector 0 n 1)]
    (find-cont-frac surd (surds/int-part surd)))))

(deftest surd-tests
  (testing "Calculating continued fractions for surds"
    (is (= (find-cont-frac [0 7 1] 2) [2 1 1 1 4]))
    (is (= (find-cont-frac [0 431 1] 20) [20 1 3 5 1 2 7 1 19 1 7 2 1 5 3 1 40])))
  (testing "Calculating continued fractions for square roots"
    (is (= (cont-frac-sqrt 15) [3 1 6]))
    (is (= (cont-frac-sqrt 222) [14 1 8 1 28]))
    (is (= (cont-frac-sqrt 1) [1]))
    (is (= (cont-frac-sqrt 16) [4]))
    (is (= (cont-frac-sqrt 300) [17 3 8 3 34]))))