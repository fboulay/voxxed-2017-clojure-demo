(ns voxxed-2017-clojure.core
  (:require [reagent.core :as r]
            [reagent.session :as session]
            [secretary.core :as secretary :include-macros true]
            [goog.events :as events]
            [goog.history.EventType :as HistoryEventType]
            [markdown.core :refer [md->html]]
            [voxxed-2017-clojure.ajax :refer [load-interceptors!]]
            [ajax.core :refer [GET POST]])
  (:import goog.History))

(defn get-todos [todos]
  (GET "/todo"
       {:handler #(reset! todos %)
        :response-format :transit}))

(defn todo-list [todos]
  [:div.content
   [:h3 "TODO list"]
   (.log js/console @todos)
   [:ul.list-group
    (for [{:keys [title desc]} @todos]
      ^{:key title}
      [:li.list-group-item
       [:div.text-primary title]
       [:div desc]])]])


(defn add-todo! [fields todos]
  (POST "/todo"
        {:params        @fields
         :handler       #(swap! todos conj {:title (:title @fields), :desc (:desc @fields)})
         :error-handler #(.error js/console (str "error:" %))}))

(defn todo-form [todos]
  (let [fields (r/atom {})]
    (fn []
      [:div.content
       [:div.form-group
        [:h3 "TODO form"]
        [:p "title:"
         [:input.form-control
          {:type      :text
           :name      :title
           :on-change #(swap! fields assoc :title (-> % .-target .-value))
           :value     (:title @fields)}]]
        [:p "Description:"
         [:textarea.form-control
          {:rows      4
           :cols      50
           :name      :desc
           :value     (:desc @fields)
           :on-change #(swap! fields assoc :desc (-> % .-target .-value))}]]
        [:input.btn.btn-primary {:type     :submit :value "Add todo"
                                 :on-click #(add-todo! fields todos)}]]])))

(defn home []
  (let [todos (r/atom nil)]
    (get-todos todos)
    (fn []
      [:div.row
       [:div.span12
        [todo-form todos]]
       [:div.span12
        [todo-list todos]]])))


(defn mount-components []
  (r/render [#'home] (.getElementById js/document "app")))

(defn init! []
  (load-interceptors!)
  (mount-components))
