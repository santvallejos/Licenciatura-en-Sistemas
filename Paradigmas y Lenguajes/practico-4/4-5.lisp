#| 
    A partir de una lista que es ingresada por el operador, definir una función que devuelva una
    nueva lista conteniendo dos sublistas. La primer sublista estará formada por los elementos de
    la lista original que son números pares. La segunda sublista estará formada por los elementos
    de la lista original que son números impares.
|#

(defun lista-par-impar ()
    (let (lista)
        (print "Ingrese la lista:")
        (setq lista (read))
        (if (consp lista)
            (print (construir-lista lista))
            (print "La lista ingresada no es valida")
        );if
    );let
);defun

(defun construir-lista (lista)
    (list (lista-par lista) (lista-impar lista))
);defun

(defun lista-par (lista)
    (cond 
        ((endp lista) nil)
        ((and (numberp (car lista)) (evenp (car lista))) (cons (car lista) (lista-par (cdr lista))))
        (T (lista-par (cdr lista)))
    );cond
);defun

(defun lista-impar (lista)
    (cond 
        ((endp lista) nil)
        ((and (numberp (car lista)) (oddp (car lista))) (cons (car lista) (lista-impar (cdr lista))))
        (T (lista-impar (cdr lista)))
    );cond
);defun

(lista-par-impar)