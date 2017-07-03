(ns voxxed-2017-clojure.app
  (:require [voxxed-2017-clojure.core :as core]))

;;ignore println statements in prod
(set! *print-fn* (fn [& _]))

(core/init!)
