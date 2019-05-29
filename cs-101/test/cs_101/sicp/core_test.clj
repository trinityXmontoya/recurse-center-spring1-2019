(ns cs-101.sicp.core-test
  (:require [clojure.test :refer :all]
            [cs-101.sicp.core :refer :all]))

(deftest exercise-1-3-test
  (testing "exercise-1-3"
    (is (= 13 (exercise-1-3 1 2 3)))))

(deftest dat-factorial-0-test
  (testing "dat-factorial-0"
    (are [n res] (= res (dat-factorial-0 n))
                    6 720
                    1 1
                    0 1
                    10 3628800)))

;(deftest dat-factorial-1-test
;  (testing "dat-factorial-1"
;    (are [n res] (= res (dat-factorial-1 n))
;                 6 720
;                 1 1
;                 0 1
;                 10 3628800)))

(deftest exercise-1-11-recursive-test
  (testing "exercise-1-11-recursive-test"
    (are [n res] (= res (exercise-1-11-recursive n))
                 3 4
                 5 25)))

;(deftest exercise-1-11-iterative-test
;  (testing "exercise-1-11-iterative-test"
;    (are [n res] (= res (exercise-1-11-iterative n))
;                 3 4
;                 5 25)))

(deftest exercise-1-12-test
  (testing "exercise-1-12-test"
    (are [n res] (= res (exercise-1-12 n))
                 0 `(1)
                 1 `(1 1)
                 2 `(1 2 1)
                 3 `(1 3 3 1)
                 4 `(1 4 6 4 1)
                 5 `(1 5 10 10 5 1)
                 6 `(1 6 15 20 15 6 1))))

(deftest exercise-1-12-block-structure-test
  (testing "exercise-1-12-block-structure-test"
    (are [n res] (= res (exercise-1-12-block-structure n))
                 0 `(1)
                 1 `(1 1)
                 2 `(1 2 1)
                 3 `(1 3 3 1)
                 4 `(1 4 6 4 1)
                 5 `(1 5 10 10 5 1)
                 6 `(1 6 15 20 15 6 1))))