(ns voxxed-2017-clojure.env
  (:require [selmer.parser :as parser]
            [clojure.tools.logging :as log]
            [voxxed-2017-clojure.dev-middleware :refer [wrap-dev]]))

(def defaults
  {:init
   (fn []
     (parser/cache-off!)
     (log/info "\n-=[voxxed-2017-clojure started successfully using the development profile]=-"))
   :stop
   (fn []
     (log/info "\n-=[voxxed-2017-clojure has shut down successfully]=-"))
   :middleware wrap-dev})
