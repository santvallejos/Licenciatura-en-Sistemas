(defun mediano()
    (let ((v1) (v2) (v3))
        (print "Ingrese el primer valor: ")
        (setq v1 (read))
        (print "Ingrese el segundo valor: ")
        (setq v2 (read))
        (print "Ingrese el tercer valor: ")
        (setq v3 (read))
        (if (and (numberp v1) (numberp v2) (numberp v3))
            (encontarMediano v1 v2 v3)
            (print "Alguno de los valores ingresados no es un número")
        );if
    );let
);defun

(defun encontarMediano(v1 v2 v3)
    (let ((newMax (max v1 v2 v3)) (newMin (min v1 v2 v3)))
        (setq newMedio (- (+ v1 v2 v3) (+ newMax newMin)))
        (print "El valor mediano es: ")
        (print newMedio)
    );let
);defun

(mediano)