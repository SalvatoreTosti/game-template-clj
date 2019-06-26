(ns game.core
  (:require [quil.core :as q]
            [quil.middleware :as m])
  (:gen-class))

(defn setup []
  (q/background 0)
  (q/frame-rate 30)
  {:game {}})

(defn draw [state]
  state)

(defn process-input [state key-information]
   (println (:key key-information)))

(defn -main []
  (q/defsketch game-sketch
    :title "gloom"
    :size (let [[width height] [512 512]]
            [width height])
    :setup setup
    :draw draw
    :key-pressed process-input
    :middleware [m/fun-mode]))
