(ns cs-101.sorting-algos.utils)

; a coll w 1 el or less is already 'sorted'
(defn check-coll-size
  [coll f]
  (if (< (count coll) 2)
    coll
    (f coll)))