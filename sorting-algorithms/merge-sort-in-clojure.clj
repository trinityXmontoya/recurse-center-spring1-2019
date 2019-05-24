(declare merge-two-sorted-colls-into-one-sorted-coll)

(defn dat-merge-sort
  [coll]
  (if (< (count coll) 2)
    coll
    (let [[left right] (split-at (/ (count coll) 2) coll)]
      (merge-two-sorted-colls-into-one-sorted-coll (dat-merge-sort left) (dat-merge-sort right)))))

(defn merge-two-sorted-colls-into-one-sorted-coll
  [left right]
  (loop [final-coll []
         left left
         right right]
      (cond
        (empty? left) 																			 (concat final-coll right)
        (empty? right) 																			(concat final-coll left)
        (< (first left) (first right)) 			(recur (conj final-coll (first left)) (rest left) right)
        :else 																												(recur (conj final-coll (first right)) left (rest right)))))

; sample coll
(def coll-size 999)
(def sample-coll (repeatedly coll-size #(rand-int 100000)))

; does it work?
(println (str "dat merge sort worked? " (= (dat-merge-sort sample-coll) (sort sample-coll))))

; how long does it take?
(println (str "for coll of size " coll-size))
(time (dat-merge-sort sample-coll))