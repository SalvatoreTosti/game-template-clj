(defproject game-template-clj "0.1.0-SNAPSHOT"
  :description "Clojure game project template"
  :url "https://github.com/SalvatoreTosti/game-template-clj"
  :license {:name "MIT License"}
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [quil "3.0.0"]]
  :main ^:skip-aot game.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
