(ns cs-101.sorting-algos.bubble_sort
  (:require [cs-101.sorting-algos.utils :refer :all]))


(defn -bubble-step
  [coll]
  (loop [i 0
         coll coll]
    (if (= i (- (count coll) 1))
      coll
      (let [next-i (inc i)]
        (recur
          next-i
          (let [current-el (nth coll i)
                next-el (nth coll next-i)]
            (if (> current-el next-el)
              (assoc (assoc coll i next-el) next-i current-el)
              coll)))))))


(defn -bubble-sort
  [coll]
  (check-coll-size
    coll
    (fn [coll]
      (loop [i (count coll)
             coll coll]
        (if (= i 0)
          coll
          (recur (dec i) (-bubble-step coll)))))))

(defn dat-bubble-sort
  "Sorts values using the bubble sort algorithm.
  Steps:
  |---------------+
  | [1 4 5 3 2]   |
  | [1 4 3 5 2]   |
  | [1 3 4 5 2]   |
  | [1 3 4 2 5]   |
  | [1 3 2 4 5]   |
  | [1 2 3 4 5]   |
  |---------------+"
  [coll]
  (-bubble-sort coll))