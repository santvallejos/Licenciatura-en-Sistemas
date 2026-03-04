#| 
    Definir una función; la que a partir de una lista ingresada por el operador; devuelva una nueva lista
    cuyos elementos sean el resultado de evaluar si cada elemento de la lista original es o no un
    elemento numérico.
|#

(defun evaluar-lista ()
    (let (lista)
        (print "Ingrese una lista:")
        (setq lista (read))
        (if (consp lista)
            (mapcar 'numberp lista)
        );if    
    );let
);defun