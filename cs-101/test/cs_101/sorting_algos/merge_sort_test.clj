(ns cs-101.sorting-algos.merge_sort_test
  (:require [clojure.test :refer :all]
            [cs-101.sorting-algos.sample_data :refer :all]
            [cs-101.sorting-algos.merge_sort :refer :all]))

(deftest merge-sort
  (testing "dat merge sort works?"
    (is (= (dat-merge-sort sample-coll) (sort sample-coll)))))
