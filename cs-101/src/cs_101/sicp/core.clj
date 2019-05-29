(ns cs-101.sicp.core)

(defn exercise-1-3
  "Define a procedure that takes three numbers as arguments and returns the sum of the squares of the two larger numbers."
  [x y z]
  (let [two-largest (drop 1 (sort [x y z]))]
    (apply + (map #(* % %) two-largest))))

;; inspired by 1.2.1 Linear Recursion + Iteration factorial fn
(defn dat-factorial-0
  [n]
  (reduce * (range 1 (inc n))))

;; not as clever as i thought cuz ^ will cause a stack overflow depending on how much memory you have allocated in the JVM.
;; back to recursion *sigh*
(defn dat-factorial-1
  [n]
  (let [total 0]
;    (if (< n 2)
;      n
;      (recur ))
 ))

;; oh yeah, using an internal anonymous fn so i don't have to make yr eyes bleed repeating this long ass fn name
(defn exercise-1-11-recursive
  "A function f is defined by the rule that f(n) = n if n<3 and f(n) = f(n - 1) + 2f(n - 2) + 3f(n - 3) if n> 3.
   Write a procedure that computes f by means of a recursive process"
  [x]
  ((fn f [n]
    (if (< n 3)
      n
      (+ (f (- n 1))
         (* 2 (f (- n 2)))
         (* 3 (f (- n 3))))))
    x))

(defn exercise-1-11-iterative
  "A function f is defined by the rule that f(n) = n if n<3 and f(n) = f(n - 1) + 2f(n - 2) + 3f(n - 3) if n> 3.
   Write a procedure that computes f by means of an iterative process"
  [x]
  ((fn f [n]
     (if (< n 3)
       n
       (loop
         [a (f (- 1 n))
          b (f (- 2 n))
          c (f (- 3 n))
          i n]
        (recur
          (+ a (* 2 b) (* 3 c))
          b
          c
          (dec i))
      ))
  )))