(ns simple-crud.helpers
  (:require [clojure.string :as s]))

(defn uuid []
  (str (.-uuid (letfn [(f [] (.toString (rand-int 16) 16))
                       (g [] (.toString  (bit-or 0x8 (bit-and 0x3 (rand-int 15))) 16))]
                 (UUID.(s/join (concat 
                        (repeatedly 8 f) "-"
                        (repeatedly 4 f) "-4"
                        (repeatedly 3 f) "-"
                        (g) (repeatedly 3 f) "-"
                        (repeatedly 12 f))) nil)))))
