(ns game.vector3)

(defn add [[x1 y1 z1] [x2 y2 z2]]
                     [(+ x1 x2) (+ y1 y2) (+ z1 z2)])

(defn scale [[x y z] scale]
  [(* scale x) (* scale y) (* scale z)])

(defn cross [[a1 a2 a3] [b1 b2 b3]]
  [(- (* a2 b3) (* a3 b2))
   (- (* a3 b1) (* a1 b3))
   (- (* a1 b2) (* a2 b1))])

(defn orientation [state]
  "returns orentation vectors with 6 degrees of freedom."
  (let [up (get-in state [:navigation-3d :up])
         down (scale up -1)
         forward (get-in state [:navigation-3d :straight])
         backward (scale forward -1)
         right (cross forward up)
         left (scale right -1)]
     {:up up
      :down down
      :forward forward
      :backward backward
      :left left
      :right right}))

(defn orientation-clamp-z [state]
    "returns orentation vectors clamped to current z position."
     (let [up (get-in state [:navigation-3d :up])
           down (scale up -1)
           forward (get-in state [:navigation-3d :straight])
           right (cross forward up)
           left (scale right -1)
           forward (cross left up)
           backward (scale forward -1)]
       {:up up
        :down down
        :forward forward
        :backward backward
        :left left
        :right right}))
