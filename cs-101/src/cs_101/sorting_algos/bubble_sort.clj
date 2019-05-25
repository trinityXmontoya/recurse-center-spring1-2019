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


(defn dat-bubble-sort
  [coll]
  (check-coll-size
    coll
    (fn [coll]
      (loop [i (count coll)
             coll coll]
        (if (= i 0)
          coll
          (recur (dec i) (-bubble-step coll)))))))