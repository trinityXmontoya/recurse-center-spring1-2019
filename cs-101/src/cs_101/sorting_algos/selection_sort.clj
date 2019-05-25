(ns cs-101.sorting-algos.selection-sort
  (:require [cs-101.sorting-algos.utils :refer :all]))

(defn -find-and-swap-largest-el
  [coll i]
  (let [coll-to-check (take i coll)
        largest-el (apply max coll-to-check)
        largest-el-idx (.indexOf coll-to-check largest-el)
        last-el-idx (dec (count coll-to-check))]
    (if (= largest-el-idx last-el-idx)
      coll
      (let [last-el (nth coll-to-check last-el-idx)]
        (assoc
          (assoc coll last-el-idx largest-el)
          largest-el-idx
          last-el)))))

(defn -selection-sort
  [coll]
  (check-coll-size
    coll
    (fn [coll]
      (loop [i (count coll)
             coll coll]
        (if (= i 0)
          coll
          (recur
            (dec i)
            (-find-and-swap-largest-el coll i)))))))


(defn dat-selection-sort
  "Sorts values using the selection sort algorithm.
  Steps:
  |---------------+
  | [1 4 5 3 2]   |
  | [1 4 2 3 5]   |
  | [1 3 2 4 5]   |
  | [1 2 3 4 5]   |
  |---------------+"
  [coll]
  (-selection-sort coll))