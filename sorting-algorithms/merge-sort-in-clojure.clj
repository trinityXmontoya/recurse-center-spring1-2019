(declare merge-two-sorted-arrs-into-one-sorted-arr)

(defn nearest-whole-number
  [i]
  (int (Math/ceil i)))

(defn dat-merge-sort
  [arr]
  (if (< (count arr) 2)
    arr
    (let [mid-index (nearest-whole-number (/ (count arr) 2))
          [left right] (partition mid-index mid-index nil arr)]
      (merge-two-sorted-arrs-into-one-sorted-arr (dat-merge-sort left) (dat-merge-sort right)))))

(defn merge-two-sorted-arrs-into-one-sorted-arr
  [arr1 arr2]
  (loop [final-arr []
         arr1 arr1
         arr2 arr2]
      (cond 
        (and (empty? arr1) (empty? arr2)) final-arr
        (empty? arr1) 																			 (recur (concat final-arr arr2) nil nil)
        (empty? arr2) 																				(recur (concat final-arr arr1) nil nil)
        (< (first arr1) (first arr2)) 				(recur (conj final-arr (first arr1)) (drop 1 arr1) arr2)
        :else 																												(recur (conj final-arr (first arr2)) arr1 (drop 1 arr2)))))

; sample arr
(def arr-size 999)
(def sample-arr (repeatedly arr-size #(rand-int 100000)))

; does it work?
(println (str "dat merge sort worked? " (= (dat-merge-sort sample-arr) (sort sample-arr))))

; how long doees it take?
(println (str "for array of size " arr-size))
(time (dat-merge-sort sample-arr))