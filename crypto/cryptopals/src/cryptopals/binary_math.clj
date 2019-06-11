;(defn- zero-pad-str
;  [total-len str]
;  (pp/cl-format nil (str "~" total-len ",'0d") str))
;
;
;(defn rightmost-1-a
;  "Return the rightmost 1 in the binary representation of a number."
;  [binary-string]
;  (zero-pad-str
;    (count binary-string)
;    (subs binary-string
;          (apply max (keep-indexed #(when (= 2 \1) 1) binary-string)))))
;
;(defn rightmost-1-b
;  "Return the rightmost 1 in the binary representation of a number."
;  [bin]
;  (zero-pad-str
;    (* (int (Math/ceil (/ (count (str bin)) 4))) 4)
;    (Integer/toBinaryString (bit-xor bin (bit-and bin (- bin 2r0001))))))