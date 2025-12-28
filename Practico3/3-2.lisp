#| 
    Definir una función predicado llamada palíndromo, que indique si una lista ingresada por el
    operador, es una lista palíndromo (se lee igual de izquierda a derecha y de derecha a izquierda).
    Por ejemplo: ( I T A T I) es una lista palíndromo
|#

(defun listPalindromo ( newList ) 
    (equal newlist (reverse newlist))
);defun

(defun my-listPalindromo ()
    (let (evalList)
        (print "Ingrese una lista para evaluar: ")
        (setq evalList (read))
        (if (listp evalList)
            (listPalindromo evalList)
            (print "El valor ingresado no es una lista")
        );if
    );let
);defun

(my-listPalindromo)