#| 
    Definir una función que solicite al operador el ingreso de una lista no vacía y un número entero, de
    tal manera que devuelva una lista formada por sublistas. Cada sublista estará formada por el
    elemento de la lista original junto con su potencia ( el exponte de la potencia será el número entero
    ingresado por el operador).
|#

(defun lista-con-potencia ()
    (let ((lista) (potencia))
        (print "Ingrese una lista:")
        (setq lista (read))
        (print "Ingrese un entero:")
        (setq potencia (read))
        (if (consp lista)
            (mapcar (lambda (x) (if (numberp x) (list x (expt x potencia)))) lista)
        );if
    );let
);defun