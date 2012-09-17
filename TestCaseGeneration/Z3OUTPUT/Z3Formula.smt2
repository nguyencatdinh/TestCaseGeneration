(declare-const X Int)
(declare-const Y Int)
(declare-const Z Int)
(declare-const mid Int)
(assert (not (or (or (<= X 0) (< Y 0)) (<= Z 0))))
(assert (not (or (and (>= X Y) (>= Y Z)) (and (>= Z Y) (>= Y X)))))
(assert (or (and (>= Y X) (>= X Z)) (and (>= Z X) (>= X Y))))
(assert (= (mod X 2) 0))
(assert (not (= (mod (div X 2) 3) 1)))
(check-sat)
(model)
