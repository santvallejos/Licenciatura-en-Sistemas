(defun clasifico-triangulos ()
    (let ((v1) (v2) (v3))
        (print "Ingrese el valor del primer lado: ")
        (setq v1 (read))
        (print "Ingrese el valor del segundo lado: ") 
        (setq v2 (read))
        (print "Ingrese el valor del tercer lado: ")
        (setq v3 (read))
        (if (and (numberp v1) (numberp v2) (numberp v3))
            (evaluar-Triangulo v1 v2 v3)
            (print "No es un numero")
        );if
    );let
);defun

(defun evaluar-Triangulo(v1 v2 v3)
    (if (and
        (> (+ v2 v3) v1) (> v1 (- v2 v3)) (> v1 (- v3 v2))
        (> (+ v1 v3) v2) (> v2 (- v1 v3)) (> v2 (- v3 v1))
        (> (+ v1 v2) v3) (> v3 (- v1 v2)) (> v3 (- v2 v1))
        )
        (tipo-triangulo v1 v2 v3)
        (print "No es un triangulo")
    );if 
);defun

(defun tipo-triangulo(v1 v2 v3)
    (cond 
        ((and (= v1 v2) (= v2 v3)) (print "Equilatero"))
        ((or (= v1 v2) (= v1 v3) (= v2 v3)) (print "Isosceles"))
        (t (print "Escaleno"))
    );cond
);defun

(clasifico-triangulos)