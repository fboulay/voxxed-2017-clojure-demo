(ns voxxed-2017-clojure.core-test
  (:require [cljs.test :refer-macros [is are deftest testing use-fixtures]]
            [pjstadig.humane-test-output]
            [reagent.core :as reagent :refer [atom]]
            [voxxed-2017-clojure.core :as rc]))

(deftest test-home
  (is (= true true)))

