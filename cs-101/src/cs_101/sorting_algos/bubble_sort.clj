(ns cs-101.sorting-algos.bubble_sort)


(defn -bubble-step
  [coll]
  (loop [j 0
         coll coll]
    (if (>= j (- (count coll) 1))
      coll
      (let [next-j (inc j)]
        (recur
          next-j
          (let [current-el (nth coll j)
                next-el (nth coll next-j)]
            ;(println coll j current-el next-el)
            (if (> current-el next-el)
              (assoc (assoc coll j next-el) next-j current-el)
              coll))))))
  )


(defn dat-bubble-sort
  [coll]
  (loop [j 0
         coll coll]
    (if (>= j (- (count coll) 1))
      coll
      (recur (inc j) (-bubble-step coll)))))