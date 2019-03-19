(ns simple-crud.actions
  (:require [simple-crud.db :refer [app-state]]
            [simple-crud.helpers :refer [uuid]]))


(defn reset
  []
  (swap! app-state assoc :editing false)
  (swap! app-state assoc :current-user {}))


(defn add-user
  "Add user to app-state"
  [user]
  (swap! app-state update :users
         conj {:id (or (:id user) (uuid))
               :name (:name user)
               :username (:username user)})
  (reset))


(defn edit-row
  "Edit selected row in users table"
  [user]
  (swap! app-state assoc :editing true)
  (swap! app-state assoc :current-user user))


(defn delete-user
  "Delete user from app-state"
  [id]
  (swap! app-state assoc :editing false)
  (swap! app-state assoc :users
         (vec (remove #(= (:id %) id) (:users @app-state)))))


(defn update-user
  "Update user in app-state"
  [id user]
  (swap! app-state assoc :editing false)
  (delete-user id)
  (add-user user)
  (reset))
