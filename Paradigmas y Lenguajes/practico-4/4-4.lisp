#| 
    A partir de dos listas ingresadas como parámetros, definir una función que devuelva una nueva
    lista donde cada elemento sea el resultado de la diferencia de los elementos de la lista 1 con
    los elementos de la lista 2 que se encuentren en la misma posición
|#

(defun diferencia-listas (lista1 lista2)
    (cond
        ((or (endp lista1) (endp lista2)) nil)
        ((and (numberp (car lista1)) (numberp (car lista2)) (cons (- (car lista1) (car lista2)) (diferencia-listas (cdr lista1) (cdr lista2)))))
        (T (diferencia-listas (cdr lista1) (cdr lista2)))
    );cond
);defun