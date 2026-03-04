(defun climaEnero ()
    (let (max_temp)
        (print "Ingrese las máximas temperatura para cada día del mes de enero: ")
        (setq max_temp (read))
        (if (listp max_temp)
            (funcionesClima max_temp)
            (print "No es una lista")
        );if
    );let
);defun

(defun funcionesClima (max_temp)
    (print "La temperatura del primer día del mes es: ")
    (print (tempPrimerDia max_temp))
    (print "La temperatura del último día del mes es: ")
    (print (tempUltimoDia max_temp))
    (print "La temperatura del tercer día del mes es: ")
    (print (tempTercerDia max_temp))
    (print "La temperatura del anteúltimo día del mes es: ")
    (print (tempAnteultimoDia max_temp))
);defun

(defun tempPrimerDia (max_temp)
    (car max_temp)
);defun

(defun tempUltimoDia (max_temp)
    (car (reverse max_temp))
);defun

(defun tempTercerDia (max_temp)
    (nth 2 max_temp)
);defun

(defun tempAnteultimoDia (max_temp)
    (nth (- (length max_temp) 2) max_temp)
);defun

(climaEnero)