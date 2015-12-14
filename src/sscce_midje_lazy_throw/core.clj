(ns sscce-midje-lazy-throw.core)

(defn invert
  [xs]
  (map / xs))

(defn update-atom
  [a xs]
  (reset! a {:k1 "new" :k2 (invert xs)}))
