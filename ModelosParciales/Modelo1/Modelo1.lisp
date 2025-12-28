(setq chico 15000)
(setq mediano 28000)
(setq grande 70000)

(defun crear-compra (monto)
    (let ()
        (setq cantChico (floor (/ monto chico)))
        (setq cantMediano (floor (/ monto mediano)))
        (setq cantGrande (floor (/ monto grande)))
        (print (list
                (list "Cantidad de 10L:" cantChico)
                (list "Cantidad de 20L:" cantMediano)
                (list "Cantidad de 50L:" cantGrande)
                ));print del list
    );let
);defun

(defun descuento (monto)
    (cond
        ((<= monto 75000) (print monto))
        ((and (> monto 75000) (<= monto 200000)) (print (- monto 30000)))
        (T (print (- monto 50000)))
    );cond
);defun

(defun compra-especifica (monto)
    (if (>= monto 310000)
        t
        nil
    );if
);defun

(defun compra-bidon ()
    (let (monto)
        (print "Ingrese el monto: ")
        (setq monto (read))
        (if (numberp monto)
            (progn
                (print "La compra que se puede realizar es: ")
                (crear-compra monto)
                (print "El total de la compra es: ")
                (descuento monto)
                (print "¿Se puede comprar 2 bidenoes de 10L y 4 de 50L?")
                (print (compra-especifica monto))
            );progn
            (print "El monto ingresado no es valido")
        );if
    );let
);defun

(compra-bidon)