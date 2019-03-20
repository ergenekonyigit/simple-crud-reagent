(ns simple-crud.routes
  (:import goog.history.Html5History)
  (:require [goog.events :as events]
            [goog.history.EventType :as EventType]
            [secretary.core :as secretary :include-macros true]
            [simple-crud.db :refer [app-state]]
            [simple-crud.components.home :refer [home]]
            [simple-crud.components.about :refer [about]]))

(defn hook-browser-navigation! []
  (doto (Html5History.)
    (events/listen
     EventType/NAVIGATE
     (fn [event]
       (secretary/dispatch! (.-token event))))
    (.setEnabled true)))


(defn app-routes []
  (secretary/set-config! :prefix "#")

  (secretary/defroute "/" []
    (swap! app-state assoc :page :home))

  (secretary/defroute "/about" []
    (swap! app-state assoc :page :about))

  (hook-browser-navigation!))


(defmulti current-page #(@app-state :page))

(defmethod current-page :home []
  [home])

(defmethod current-page :about []
  [about])

(defmethod current-page :default []
  [:div ])

