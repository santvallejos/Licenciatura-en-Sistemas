#| 
    Realizar los cambios necesarios en la función definida en la Actividad N° 3, de tal manera que el
    resultado de cada evaluación realizada devuelva la leyenda SI o NO.
|#

(defun evaluar-lista()
    (let (lista)
        (print "Ingrese una lista:")
        (setq lista (read))
        (if (consp lista)
            (mapcar (lambda (x) (if (numberp x) 'si 'no)) lista)
        );if
    );let
);defun