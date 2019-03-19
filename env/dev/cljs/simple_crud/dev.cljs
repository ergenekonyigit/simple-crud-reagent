(ns ^:figwheel-no-load simple-crud.dev
  (:require
    [simple-crud.core :as core]
    [devtools.core :as devtools]))


(enable-console-print!)

(devtools/install!)

(core/init!)
