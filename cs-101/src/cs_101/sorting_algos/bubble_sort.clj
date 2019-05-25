(ns cs-101.sorting-algos.bubble_sort)

(defn dat-bubble-sort
  [coll]
  (loop [i 0
         coll coll]
    (if (>= i (- (count coll) 1))
      coll
      (let [next-i (inc i)]
        (recur
          next-i
          (let [current-el (nth coll i)
                next-el (nth coll next-i)]
            (println coll i current-el next-el)
            (if (> current-el next-el)
              (assoc (assoc coll i next-el) next-i current-el)
              coll)))))))