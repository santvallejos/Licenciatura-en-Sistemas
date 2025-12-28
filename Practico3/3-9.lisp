#| 
    Definir una función predicado para cada una de los ítems que se detallan a continuación. Cada
    función definida debe recibir como parámetro la lista contenida en la variable max_temp.
    a. Evaluar si la temperatura registrada el primer día está comprendida entre los 40 y 45 grados.
    b. Evaluar si en alguno de los días del mes la máxima fue de 40.
    c. Evaluar si la temperatura del primer y último día son IGUALES.
|#

(defun evaluar-temperaturas-de-la-lista ()
    (let (max_temp)
        (print "Ingrese la lista de temperaturas: ")
        (setq max_temp (read))
        (if (listp max_temp) 
            (funcionesClima max_temp)
            (print "No es una lista")
        );if
    );let
);defun

(defun funcionesClima (max_temp)
    (print "La temperatura del primer dia esta comprendida entre 40 y 45 grados: ")
    (print (entre40y45 max_temp))
    (print "En algun dia del mes la temperatura fue de 40: ")
    (print (temperatura40 max_temp))
    (print "La temperatura del primer y ultimo dia son iguales: ")
    (print (primerUltimoDiaIguales max_temp))
);defun

(defun entre40y45 (max_temp)
    (if (and (>= (car max_temp) 40) (<= (car max_temp) 45))
        T
        NIL
    );if
);defun

(defun temperatura40 (max_temp)
    (if (member 40 max_temp)
        T
        NIL
    );if
);defun

(defun primerUltimoDiaIguales (max_temp)
    (if (equal (car max_temp) (car (reverse max_temp)))
        T
        NIL
    );if
)

(evaluar-temperaturas-de-la-lista)