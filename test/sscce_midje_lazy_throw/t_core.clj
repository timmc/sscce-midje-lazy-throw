(ns sscce-midje-lazy-throw.t-core
  (:require [midje.sweet :refer :all]
            [sscce-midje-lazy-throw.core :as src]))

(facts "updater"
  (fact "- normal behavior"
    (let [a (atom {:k1 "old" :k2 "old"})]
      (src/update-atom a [1]) => anything
      @a => {:k1 "new" :k2 [1]}))
  (fact "- with exception"
    (let [a (atom {:k1 "old" :k2 "old"})]
      (src/update-atom a [1 0 1]) => (throws RuntimeException "other")
      @a => {:k1 "old" :k2 "old"})))

;; $ lein midje
;;
;; FAIL "updater - - with exception" at (t_core.clj:13)
;;     Expected: {:k1 "old", :k2 "old"}
;;       Actual: {:k1 "new", :k2 ()}
;; FAILURE: 1 check failed.  (But 3 succeeded.)
;; Subprocess failed
