(defn dat-merge-sort
  [coll]
  (if (< (count coll) 2)
    coll
    (let [[left right] (split-at (/ (count coll) 2) coll)]
      (loop [final-coll []
             left (dat-merge-sort left)
             right (dat-merge-sort right)]
        (cond
          (empty? left)									 (concat final-coll right)
          (empty? right) 								 (concat final-coll left)
          (< (first left) (first right)) (recur (conj final-coll (first left)) (rest left) right)
          :else													 (recur (conj final-coll (first right)) left (rest right)))))))

; sample coll
(def coll-size 999)
(def sample-coll (repeatedly coll-size #(rand-int 100000)))

; does it work?
(println (str "dat merge sort worked? " (= (dat-merge-sort sample-coll) (sort sample-coll))))

; how long does it take?
(println (str "for coll of size " coll-size))
(time (dat-merge-sort sample-coll))