(ns rococo.units
  (:refer-clojure :exclude [rem])
  (:require
    [garden.units :as units]))

(def unit? units/unit?)
(def length? units/length?)
(def angle? units/angle?)
(def time? units/time?)
(def frequency? units/frequency?)
(def resolution? units/resolution?)

(def px units/px)
(def px? units/px?)
(def px+ units/px+)
(def px* units/px*)
(def px- units/px-)
(def px-div units/px-div)

(def px-ops
  {:new px
   :? px?
   :+ px+
   :* px*
   :- px-
   (keyword "/") px-div})

(def pt units/pt)
(def pt? units/pt?)
(def pt+ units/pt+)
(def pt* units/pt*)
(def pt- units/pt-)
(def pt-div units/pt-div)

(def pt-ops
  {:new pt
   :? pt?
   :+ pt+
   :* pt*
   :- pt-
   (keyword "/") pt-div})

(def pc units/pc)
(def pc? units/pc?)
(def pc+ units/pc+)
(def pc* units/pc*)
(def pc- units/pc-)
(def pc-div units/pc-div)

(def pc-ops
  {:new pc
   :? pc?
   :+ pc+
   :* pc*
   :- pc-
   (keyword "/") pc-div})

(def percent units/percent)
(def percent? units/percent?)
(def percent+ units/percent+)
(def percent* units/percent*)
(def percent- units/percent-)
(def percent-div units/percent-div)

(def percent-ops
  {:new percent
   :? percent?
   :+ percent+
   :* percent*
   :- percent-
   (keyword "/") percent-div})

(def em units/em)
(def em? units/em?)
(def em+ units/em+)
(def em* units/em*)
(def em- units/em-)
(def em-div units/em-div)

(def em-ops
  {:new em
   :? em?
   :+ em+
   :* em*
   :- em-
   (keyword "/") em-div})

(def rem units/rem)
(def rem? units/rem?)
(def rem+ units/rem+)
(def rem* units/rem*)
(def rem- units/rem-)
(def rem-div units/rem-div)

(def rem-ops
  {:new rem
   :? rem?
   :+ rem+
   :* rem*
   :- rem-
   (keyword "/") rem-div})

(def s units/s)
(def s? units/s?)
(def s+ units/s+)
(def s* units/s*)
(def s- units/s-)
(def s-div units/s-div)

(def s-ops
  {:new s
   :? s?
   :+ s+
   :* s*
   :- s-
   (keyword "/") s-div})

(def ms units/ms)
(def ms? units/ms?)
(def ms+ units/ms+)
(def ms* units/ms*)
(def ms- units/ms-)
(def ms-div units/ms-div)

(def ms-ops
  {:new ms
   :? ms?
   :+ ms+
   :* ms*
   :- ms-
   (keyword "/") ms-div})

(defn ops-for [it]
  (cond
    (px? it) px-ops
    (pt? it) pt-ops
    (pc? it) pc-ops
    (percent? it) percent-ops
    (em? it) em-ops
    (rem? it) rem-ops
    (s? it) s-ops
    (ms? it) ms-ops))
