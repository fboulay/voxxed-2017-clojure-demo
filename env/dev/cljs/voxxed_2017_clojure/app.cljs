(ns ^:figwheel-no-load voxxed-2017-clojure.app
  (:require [voxxed-2017-clojure.core :as core]
            [devtools.core :as devtools]))

(enable-console-print!)

(devtools/install!)

(core/init!)
