(declare-const a Int)
(declare-const b Int)
(declare-const c Int)
(declare-const d Int)
(declare-const delta Int)
(declare-const k Int)
(declare-const temp Int)
(assert (not (= (- (pow b 2) (* (* 3 a) c)) 0)))
(assert (> (- (pow b 2) (* (* 3 a) c)) 0))
(assert (not (<= (abs (div (div (- (- (* (* (* 9 a) b) c) (* 2 (pow b 3))) (* (* 27 (pow a 2)) d)) 2) (sqrt (abs (pow (- (pow b 2) (* (* 3 a) c)) 3))))) 1)))
(check-sat)
(model)
