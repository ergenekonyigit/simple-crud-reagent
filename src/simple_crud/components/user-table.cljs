(ns simple-crud.components.user-table
  (:require [simple-crud.db :refer [app-state]]
            [simple-crud.actions :refer [edit-row delete-user]]))

(defn user-table [users]
  [:table
   [:thead
    [:tr
     [:th "Name"]
     [:th "Username"]
     [:th "Actions"]]]
   [:tbody
    (if (empty? users)
      [:tr
       [:td {:colSpan 3} "No Users"]]
      (for [user users]
        ^{:key (:id user)}
        [:tr
         [:td (:name user)]
         [:td (:username user)]
         [:td
          [:button {:on-click #(edit-row user)
                    :class "button muted-button"}
           "Edit"]
          [:button {:on-click #(delete-user (:id user))
                    :class "button muted-button"
                    :style {:margin-left "10px"}}
           "Delete"]]]))]])
