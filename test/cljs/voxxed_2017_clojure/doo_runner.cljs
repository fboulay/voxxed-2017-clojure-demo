(ns voxxed-2017-clojure.doo-runner
  (:require [doo.runner :refer-macros [doo-tests]]
            [voxxed-2017-clojure.core-test]))

(doo-tests 'voxxed-2017-clojure.core-test)

