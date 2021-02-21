(ns tests)

(load-file "./surds.clj")
(load-file "./cont-frac.clj")

(use 'clojure.test)

(run-tests 'surds)
(run-tests 'cont-frac)