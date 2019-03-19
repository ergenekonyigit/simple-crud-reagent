(ns simple-crud.core
  (:require [reagent.core :as r]
            [simple-crud.routes :refer [app-routes current-page]]))

(defn app
  []
  (app-routes)
  (r/render [current-page] (.getElementById js/document "app")))


(defn init!
  []
  (app))
