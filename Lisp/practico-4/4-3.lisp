#| 
    A partir de una lista heterogénea que es ingresada por el operador, definir una función que
    permita el ingreso de dicha lista y pueda resolver cada una de las siguientes situaciones:
    • Definir una función que permita devolver una lista cuyos elementos serán sublistas.
    Cada sublista estará conformada por el elemento que sea una sublista de la lista
    ingresada por el operador junto con su longitud.
    • A partir de una lista heterogénea que es ingresada como parámetro, definir una función
    que devuelva una lista cuyos elementos son el resultado de evaluar uno a uno si cada
    uno elemento de la lista ingresada como parámetro es una sublista.
|#

(defun evaluar-lista-heterogenea ()
    (let (lista)
        (print "Ingrese la lista:")
        (setq lista (read))
        (if (consp lista)
            (progn
                (print (construir-sublistas lista))
                (print (lista-booleana lista))
            );progn
            (print "La lista ingresada no es valida")
        );if
    );let
);defun

(defun construir-sublistas (lista)
    (cond
        ((endp lista) nil)
        ((listp (car lista)) (cons (list (car lista) (length (car lista))) (construir-sublistas (cdr lista))))
        (t (construir-sublistas (cdr lista)))
    );cond
);defun

(defun lista-booleana (lista)
    (cond
        ((endp lista) nil)
        (t (cons (consp (car lista)) (lista-booleana (cdr lista))))
    );cond
);defun

(evaluar-lista-heterogenea)