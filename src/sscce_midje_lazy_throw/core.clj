(ns sscce-midje-lazy-throw.core)

(defn process-one
  [x]
  (try
    (/ x)
    (catch Exception e
      (throw (RuntimeException. "other")))))

(defn process-all
  [xs]
  (map process-one xs))

(defn update-atom
  [a xs]
  (reset! a {:k1 "new" :k2 (process-all xs)}))
