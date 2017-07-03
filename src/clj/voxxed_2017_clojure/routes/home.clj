(ns voxxed-2017-clojure.routes.home
  (:require [voxxed-2017-clojure.layout :as layout]
            [compojure.core :refer [defroutes GET POST]]
            [ring.util.http-response :as response]
            [clojure.java.io :as io]))

(defonce todos (atom []))

(defn get-todos []
  (response/content-type
    (response/ok @todos)
    "Application/json; charset=utf-8"))

(defn add-todo [request]
  (response/content-type
    (response/ok (swap! todos conj {:title (:title (request :params)), :desc (:desc (request :params))}))
    "Application/json; charset=utf-8"))

(defn home-page []
  (layout/render "home.html"))

(defroutes home-routes
           (GET "/" []
             (home-page))
           (GET "/todo" []
             (get-todos))
           (POST "/todo" request
             (add-todo request))

           (GET "/docs" []
             (-> (response/ok (-> "docs/docs.md" io/resource slurp))
                 (response/header "Content-Type" "text/plain; charset=utf-8"))))

