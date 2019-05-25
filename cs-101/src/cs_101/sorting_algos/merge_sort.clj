(ns cs-101.sorting-algos.merge_sort)

(defn dat-merge-sort
  [coll]
  (if (< (count coll) 2)
    coll
    (let [[left right] (split-at (/ (count coll) 2) coll)]
      (loop [final-coll []
             left (dat-merge-sort left)
             right (dat-merge-sort right)]
        (cond
          (empty? left)									 								(concat final-coll right)
          (empty? right) 								 							(concat final-coll left)
          (< (first left) (first right)) (recur (conj final-coll (first left)) (rest left) right)
          :else													 											 (recur (conj final-coll (first right)) left (rest right)))))))