(ns simple-crud.db
  (:require [reagent.core :as r]
            [simple-crud.helpers :refer [uuid]]))

(defonce app-state (r/atom {:users [{:id (uuid) :name "Caitlyn Kerluke" :username "caitlyn.kerluke"}
                                    {:id (uuid) :name "Rowan Nikolaus" :username "rowan.nikolaus"}
                                    {:id (uuid) :name "Elton Douglas" :username "elton.douglas"}
                                    {:id (uuid) :name "Christophe Bartell" :username "christophe.bartell"}
                                    {:id (uuid) :name "Sam Pull" :username "sam.pull"}
                                    {:id (uuid) :name "Carson O. Gin" :username "carson.o.gin"}]
                            :editing false
                            :current-user {}}))
