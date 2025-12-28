#| 
    A partir de un valor atómico y una lista heterogénea, desarrollar una función que permita
    ingresar la lista, el valor atómico y ejecutar las funciones que se solicitan.
    Recordar que una lista es heterogénea cuando puede contener átomos, listas, o ambos tipos
    de elementos,
    1. Una función predicado, la que a partir de la lista ingresada como parámetro, determine
    si la misma contiene únicamente valores atómicos.
    2. Una función, la que a partir de la lista y el valor atómico, determine la cantidad de
    valores que sean menores o iguales al valor atómico
    3. Una función, la que a partir de la lista y el valor atómico, devuelva una nueva lista
    formada por sublistas, donde cada sublista estrá formada por el elemento de la lista
    original junto con el resultado de la división entre el elemento de la lista y el valor
    atómico, siempre y cuando el elemento de la lista original sea mayor a cero.
    Por ejemplo, si la lista contiene ( 16 ( 2 3) -2 40 S (D F)) y el valor atómico= 2, la función
    debe devolver ( (16 8) (40 20))
|#

(defun lista-atomica (lista)
    (cond
        ((endp lista) T)
        ((atom (car lista)) (lista-atomica (cdr lista)))
        ((listp (car lista)) nil)
        (T lista-atomica (cdr lista))
    )
);defun

(defun cantidad-menores (lista valor)
    (cond
        ((endp lista) 0)
        ((and (numberp (car lista)) (<= (car lista) valor)) (+ 1 (cantidad-menores (cdr lista) valor)))
        (t (cantidad-menores (cdr lista) valor))
    );cond
);defun

(defun crear-sublistas-division (lista valor)
    (cond
        ((endp lista) nil)
        ((and (numberp (car lista)) (> (car lista) 0)) (cons (list (car lista) (floor (/ (car lista) valor))) (crear-sublistas-division (cdr lista) valor)))
        (t (crear-sublistas-division (cdr lista) valor))
    );cond
);defun