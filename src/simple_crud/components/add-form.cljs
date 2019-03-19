(ns simple-crud.components.add-form
  (:require [reagent.core :as r]
            [clojure.string :as s]
            [goog.dom :as dom]
            [simple-crud.actions :refer [add-user]]))

(defn add-form
  []
  (let [user (r/atom {:name "" :username ""})
        validate-user #(and (not (s/blank? %1)) (not (s/blank? %2)))]
    [:div
     [:label "Name"]
     [:input {:type :text
              :id "name"
              :name "name"
              :on-change #(swap! user assoc :name (-> % .-target .-value))}]
     [:label "Username"]
     [:input {:type :text
              :id "username"
              :name "username"
              :on-change #(swap! user assoc :username (-> % .-target .-value))}]
     [:button {:on-click (fn [e]
                         (.preventDefault e)
                         (when (validate-user (:name @user) (:username @user))
                           (add-user @user))
                         (set! (.-value (dom/getElement "name")) "")
                         (swap! user assoc :name "")
                         (set! (.-value (dom/getElement "username")) "")
                         (swap! user assoc :username ""))}
      "Add New User"]]))
