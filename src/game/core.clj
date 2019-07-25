(ns game.core
  (:require [quil.core :as q]
            [quil.middleware :as m])
  (:use
    [game.sprites :only [load-tile-map draw-tile]])
  (:gen-class))

(defn setup []
  (q/background 0)
  (q/frame-rate 30)
  {:game {}})

(defn draw [state])

(defn process-input [state key-information]
   (println (:key key-information))
  state)

(defn -main []
  (q/defsketch game-sketch
    :title "game"
    :size (let [[width height] [512 512]]
            [width height])
    :setup setup
    :draw draw
    :key-pressed process-input
    :middleware [m/fun-mode]))
