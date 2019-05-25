(ns cs-101.sorting-algos.merge_sort
  (:require [cs-101.sorting-algos.utils :refer :all]))

(defn -merge-sort
  [coll]
  (check-coll-size
    coll
    (fn [coll]
      (let [[left right] (split-at (/ (count coll) 2) coll)]
        (loop [final-coll []
               left (-merge-sort left)
               right (-merge-sort right)]
          (cond
            (empty? left)									 (concat final-coll right)
            (empty? right) 								 (concat final-coll left)
            (< (first left) (first right)) (recur (conj final-coll (first left)) (rest left) right)
            :else													 (recur (conj final-coll (first right)) left (rest right))))))))

(defn dat-merge-sort
  "Sorts values using the merge sort algorithm.
  Steps:
  |--------------------+
  | [5 1 4 3 2]        |
  | [5 1 4] [3 2]      |
  | [5 1] [4] [3] [2]  |
  | [1* 5] [4] [2* 3]  |
  | [1* 4*] [5] [2 3]  |
  | [1 4 5] [2 3]      |
  | [1*] [4 5] [2 3]   |
  | [1* 2*] [4 5] [3]  |
  | [1* 2* 3*] [4 5]   |
  | [1* 2* 3* 4* 5*]   |
  |--------------------+"
  [coll]
  (-merge-sort coll))