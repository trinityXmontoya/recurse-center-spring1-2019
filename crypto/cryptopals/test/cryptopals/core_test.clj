(ns cryptopals.core-test
  (:require [clojure.test :refer :all]
            [cryptopals.core :refer :all]))

(deftest hex-to-base64-test
  (is
    (= (hex-to-base64 "49276d206b696c6c696e6720796f757220627261696e206c696b65206120706f69736f6e6f7573206d757368726f6f6d")
       "SSdtIGtpbGxpbmcgeW91ciBicmFpbiBsaWtlIGEgcG9pc29ub3VzIG11c2hyb29t")))

(deftest fixed-xor-test
  (is
    (= (fixed-xor "1c0111001f010100061a024b53535009181c" "686974207468652062756c6c277320657965")
       "746865206b696420646f6e277420706c6179")))

(deftest single-byte-xor-cypher-test
  (is (= (single-byte-xor-cypher "1b37373331363f78151b7f2b783431333d78397828372d363c78373e783a393b3736")
         {:char "58"
          :msg "Cooking MC's like a pound of bacon"
          :score 2.2270678629629628})))

(deftest single-character-xor-from-file-test
  (is (= (single-character-xor-from-file "resources/1.4.txt")
         {:char "35"
          :msg "Now that the party is jumping\n"
          :score 2.0510947629629626})))



;(deftest rightmost-1-a-test
;  (are [binary res] (= res (rightmost-1-a binary))
;                    "1010" "0010"
;                    "1100" "0100"
;                    "0001" "0001"))
;
;(deftest rightmost-1-b-test
;  (are [binary res] (= res (rightmost-1-b binary))
;                    2r1010 "0010"
;                    2r1100 "0100"
;                    2r0001 "0001"))