(ns voxxed-2017-clojure.env
  (:require [clojure.tools.logging :as log]))

(def defaults
  {:init
   (fn []
     (log/info "\n-=[voxxed-2017-clojure started successfully]=-"))
   :stop
   (fn []
     (log/info "\n-=[voxxed-2017-clojure has shut down successfully]=-"))
   :middleware identity})
