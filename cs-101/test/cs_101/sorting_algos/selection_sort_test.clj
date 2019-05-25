(ns cs-101.sorting-algos.selection_sort_test
  (:require [clojure.test :refer :all]
            [cs-101.sorting-algos.sample_data :refer :all]
            [cs-101.sorting-algos.selection-sort :refer :all]))

(deftest selection-sort
  (testing "dat selection sort works?"
    (is (= (dat-selection-sort (vec sample-coll)) (sort sample-coll)))))
