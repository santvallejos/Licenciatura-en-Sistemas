#| 
    Definir la función ambos-enteros que solicite al operador el ingreso de dos Listas
    no vacías: LISTA1 y LISTA2. La función deberá devolver una nueva Lista con el resultado de
    evaluar elemento a elemento ambas Listas, indicando en forma de sublista ambos elementos, si
    coinciden en que sean números enteros. 
|#

(defun ambos-enteros ()
    (let ((lista1) (lista2))
        (print "Ingrese la primera lista:")
        (setq lista1 (read))
        (print "Ingrese la segunda lista:")
        (setq lista2 (read))
        (if (and (consp lista1) (consp lista2))
            (mapcar (lambda (x y)
                (if (and (numberp x) (numberp y) (integerp x) (integerp y))
                    (list x y))); Crear sublista si ambos son enteros
                lista1 lista2); Parámetros de recorrido
        );if
    );let
);defun