(ns cryptopals.core
  ;(:require)
  (:import (org.apache.commons.codec.binary Hex Base64)))

(defn foo
  "I don't do a whole lot."
  [x]
  (println x "Hello, World!"))


(defn hex-to-base64
  [hex-str]
  (slurp (Base64/encodeBase64 (Hex/decodeHex hex-str))))