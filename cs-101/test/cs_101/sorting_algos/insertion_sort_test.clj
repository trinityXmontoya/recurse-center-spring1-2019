(ns cs-101.sorting-algos.insertion_sort_test
  (:require [clojure.test :refer :all]
            [cs-101.sorting-algos.sample_data :refer :all]
            [cs-101.sorting-algos.insertion_sort :refer :all]))

(deftest insertion-sort
  (testing "dat insertion sort works?"
    (is (= (dat-insertion-sort sample-coll) (sort sample-coll)))))
