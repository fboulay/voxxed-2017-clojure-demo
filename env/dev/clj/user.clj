(ns user
  (:require [mount.core :as mount]
            [voxxed-2017-clojure.figwheel :refer [start-fw stop-fw cljs]]
            voxxed-2017-clojure.core))

(defn start []
  (mount/start-without #'voxxed-2017-clojure.core/repl-server))

(defn stop []
  (mount/stop-except #'voxxed-2017-clojure.core/repl-server))

(defn restart []
  (stop)
  (start))


