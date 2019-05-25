(ns cs-101.sorting-algos.bubble_sort_test
  (:require [clojure.test :refer :all]
            [cs-101.sorting-algos.sample_data :refer :all]
            [cs-101.sorting-algos.bubble_sort :refer :all]))

(deftest bubble-sort
  (testing "dat bubble sort works?"
    (is (= (dat-bubble-sort (vec sample-coll)) (sort sample-coll)))))
