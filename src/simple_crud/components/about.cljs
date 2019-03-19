(ns simple-crud.components.about)

(defn about
  []
  [:div.container
   [:h1 "About Page"]
   [:li
    [:a {:href "https://github.com/ergenekonyigit/simple-crud"
         :target "_blank"} "Github"]]
   [:h3 "Packages"]
   [:ul
    [:li "Clojure " [:code "1.10"]]
    [:li "ClojureScript " [:code "1.10.520"]]
    [:li "Reagent " [:code "0.8.1"]]
    [:li "Secretary " [:code "1.2.3"]]]
   [:a {:href "#/"} "Home"]])
