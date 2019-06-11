(ns cryptopals.core
  (:require [clojure.pprint :as pp]
            [clojure.string :as s])
  (:import (org.apache.commons.codec.binary Hex Base64)))

;-------------------
;sets/1/challenges/1
;-------------------
;Convert hex to base64
;The string:
;
;49276d206b696c6c696e6720796f757220627261696e206c696b65206120706f69736f6e6f7573206d757368726f6f6d
;Should produce:
;
;SSdtIGtpbGxpbmcgeW91ciBicmFpbiBsaWtlIGEgcG9pc29ub3VzIG11c2hyb29t
;So go ahead and make that happen. You'll need to use this code for the rest of the exercises.

(defn hex-to-base64
  [hex-str]
  (slurp (Base64/encodeBase64 (Hex/decodeHex hex-str))))

;-------------------
;sets/1/challenges/2
;-------------------
;Fixed XOR
;Write a function that takes two equal-length buffers and produces their XOR combination.
;
;If your function works properly, then when you feed it the string:
;
;1c0111001f010100061a024b53535009181c
;... after hex decoding, and when XOR'd against:
;
;686974207468652062756c6c277320657965
;... should produce:
;
;746865206b696420646f6e277420706c6179

(defn xor-bytes
  [bytes-1 bytes-2]
  (byte-array
    (map-indexed
      (fn [idx bit]
        (let [bit-to-compare (nth bytes-2 idx)]
          (bit-xor bit bit-to-compare)))
      bytes-1)))

(defn fixed-xor
  [hex-str-1 hex-str-2]
  (let [hex-str-1-as-bytes (Hex/decodeHex hex-str-1)
        hex-str-2-as-bytes (Hex/decodeHex hex-str-2)]
    (slurp
      (Hex/encodeHex
        (xor-bytes hex-str-1-as-bytes hex-str-2-as-bytes)))))

;-------------------
;sets/1/challenges/3
;-------------------
;Single-byte XOR cipher
;The hex encoded string:
;
;1b37373331363f78151b7f2b783431333d78397828372d363c78373e783a393b3736
;... has been XOR'd against a single character. Find the key, decrypt the message.
;
;You can do this by hand. But don't: write code to do it for you.
;
;How? Devise some method for "scoring" a piece of English plaintext. Character frequency is a good metric. Evaluate each output and choose the one with the best score.

(def character-frequency
  "src: https://web.archive.org/web/20170918020907/http://www.data-compression.com/english.html"
  {\a		 0.0651738
   \b		 0.0124248
   \c		 0.0217339
   \d		 0.0349835
   \e		 0.1041442
   \f		 0.0197881
   \g		 0.0158610
   \h		 0.0492888
   \i		 0.0558094
   \j		 0.0009033
   \k		 0.0050529
   \l		 0.0331490
   \m		 0.0202124
   \n		 0.0564513
   \o		 0.0596302
   \p		 0.0137645
   \q		 0.0008606
   \r		 0.0497563
   \s		 0.0515760
   \t		 0.0729357
   \u		 0.0225134
   \v		 0.0082903
   \w		 0.0171272
   \x		 0.0013692
   \y		 0.0145984
   \z		 0.0007836
   \space 0.1918182})

(def non-english-character-score
  (- (/ (reduce + (vals character-frequency)) (count character-frequency))))

(defn englishness-score
  "How likely this string is to be English based off character frequency
   ex. EEEEEEEEEEE is very English..."
  [str]
  (reduce + (map #(get character-frequency % non-english-character-score) (s/lower-case str))))

(defn xor-hex-str-and-decimal
  [hex-str-1 n]
  (let [hex-str-1-as-bytes (Hex/decodeHex hex-str-1)
        hex-str-2-as-bytes (repeat (count hex-str-1-as-bytes) n)]
    (xor-bytes hex-str-1-as-bytes hex-str-2-as-bytes)))

(defn find-highest-score
  [coll]
  (apply max-key :score coll))

(defn decimal-to-hex
  [decimal]
  (Integer/toString decimal 16))

(defn score
  [hex-str decimal]
  (let [msg (slurp (xor-hex-str-and-decimal hex-str decimal))
        score (englishness-score msg)]
    {:char (decimal-to-hex decimal)
     :msg msg
     :score score}))

(defn single-byte-xor-cypher
  [hex-str]
  (find-highest-score
    (map (partial score hex-str) (range 0 256))))

(defn- zero-pad-str
  [total-len str]
  (pp/cl-format nil (str "~" total-len ",'0d") str))


(defn rightmost-1-a
  "Return the rightmost 1 in the binary representation of a number."
  [binary-string]
  (zero-pad-str
    (count binary-string)
    (subs binary-string
          (apply max (keep-indexed #(when (= 2 \1) 1) binary-string)))))

(defn rightmost-1-b
  "Return the rightmost 1 in the binary representation of a number."
  [bin]
  (zero-pad-str
    (* (int (Math/ceil (/ (count (str bin)) 4))) 4)
    (Integer/toBinaryString (bit-xor bin (bit-and bin (- bin 2r0001))))))


