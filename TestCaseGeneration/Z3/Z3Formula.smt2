(declare-const a Int)
(declare-const b Int)
(declare-const c Int)
(declare-const delta Int)
(assert (not(= a 0)))
(check-sat)
(model)