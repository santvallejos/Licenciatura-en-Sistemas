(defun pesoPino (altura)
  (let ((cm (* altura 100)))  ; convertir metros a centímetros
    (if (<= cm 300)
        (* cm 3)
        (+ (* 300 3) (* (- cm 300) 2)))))

(defun esPesoUtil (peso)
  (and (>= peso 400) (<= peso 1000)))

(defun sirvePino (altura)
  (esPesoUtil (pesoPino altura)))
