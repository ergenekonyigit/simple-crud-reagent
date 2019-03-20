(ns simple-crud.components.home
  (:require [simple-crud.db :refer [app-state]]
            [simple-crud.components.add-form :refer [add-form]]
            [simple-crud.components.edit-form :refer [edit-form]]
            [simple-crud.components.user-table :refer [user-table]]))

(defn home []
  [:div.container
   [:h1 "Simple CRUD App with ClojureScript and Reagent"]
   [:a {:href "#/about"} "About"]
   [:div.flex-row
    [:div.flex-large
     (if (:editing @app-state)
       [:<>
        [:h2 "Edit User"]
        [edit-form (:current-user @app-state)]]
       [:<>
        [:h2 "Add User"]
        [add-form]])]
    [:div.flex-large
     [:h2 "View Users"]
     [user-table (:users @app-state)]]]])

