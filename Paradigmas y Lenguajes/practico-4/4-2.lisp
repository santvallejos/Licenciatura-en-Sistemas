#| 
    A partir de una lista con las Notas de los parciales de un alumno, que es ingresada por el
    operador, definir una función predicado llamada Aprobado. La función debe evaluar si la
    materia está aprobada. Una materia está aprobada si todas las notas son 4 o valores mayores
    a 4
|#

(defun evaluar-aprobado ()
    (let (notas)
        (print "Ingrese la lista de notas:")
        (setq notas (read))
        (if (listp notas)
            (print (aprobado notas))
            (print "La lista ingresada no es valida")
        );if
    );let
);defun

(defun aprobado (notas)
    (cond
        ((endp notas) t)
        #| Evaluar si a es numerico y si es mayor a 4 |#
        ((and (numberp (car notas)) (>= (car notas) 4)) (aprobado (cdr notas)))
        #| Evaluar si a es numerico y si es menor a 4 |#
        ((and (numberp (car notas)) (< (car notas) 4)) nil)
        (t (aprobado (cdr notas)))
    );cond
);defun

(evaluar-aprobado)