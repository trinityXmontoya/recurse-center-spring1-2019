(ns cs-101.sorting-algos.insertion_sort
  (:require [cs-101.sorting-algos.utils :refer :all]))


(defn -insertion-sort
  [coll]
  (check-coll-size
    coll
    (fn [coll]
      )))

(defn dat-insertion-sort
  "Sorts values using the insertion sort algorithm.
  Steps:
  |---------------+
  | [1 4 5 3 2]   |
  | [1 4 5 3 2]   |
  | [1 4 5 3 2]   |
  | [1 4 3 5 2]   |
  | [1 3 4 5 2]   |
  | [1 3 4 2 5]   |
  | [1 3 2 4 5]   |
  | [1 2 3 4 5]   |
  |---------------+"
  [coll]
  (-insertion-sort coll))