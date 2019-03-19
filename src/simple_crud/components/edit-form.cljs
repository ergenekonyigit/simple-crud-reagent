(ns simple-crud.components.edit-form
  (:require [reagent.core :as r]
            [clojure.string :as s]
            [simple-crud.db :refer [app-state]]
            [simple-crud.actions :refer [update-user reset]]))

(defn edit-form []
  (let [is-valid-user? #(and (not (s/blank? %1)) (not (s/blank? %2)))]
    (fn []
      (let [current-user (:current-user @app-state)]
        [:div
         [:label "Name"]
         [:input {:type :text
                  :id "name"
                  :name "name"
                  :value (:name current-user)
                  :on-change #(swap! app-state assoc-in [:current-user :name] (-> % .-target .-value))}]
         [:label "Username"]    
         [:input {:type :text
                  :id "username"
                  :name "username"
                  :value (:username current-user)
                  :on-change #(swap! app-state assoc-in [:current-user :username] (-> % .-target .-value))}]
         [:button {:class "button"
                   :on-click (fn [e]
                               (.preventDefault e)
                               (when (is-valid-user? (:name current-user) (:username current-user))
                                 (update-user (:id current-user) current-user)))}
          "Update User"]
         [:button {:class "button muted-button"
                   :style {:margin-left "10px"}
                   :on-click #(reset)}
          "Discard"]]))))
