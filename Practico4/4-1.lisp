#| 
    Las máximas temperaturas del mes de enero se registraron en una lista contenida en la
    variable max_enero. Definir una función que permita el ingreso por teclado de dicha lista y
    pueda resolver cada una de las siguientes situaciones.
    • Se desea conocer la cantidad de días que se registró una temperatura menor a los 38°.
    • Se desea conocer el valor de la temperatura promedio de dicho mes. Definir una
    función que reciba como parámetro la lista y devuelva el valor deseado.
    • Se desea saber si las temperaturas registradas en la lista están ordenadas en forma
    ascendente (para ello definir una función predicado que verifique lo solicitado)
    • Se desea conocer cuales son las diferentes temperaturas registradas. Para ello defina
    una función que devuelva una lista sin las temperaturas repetidas de la lista original. Si
    el elemento está repetido debe aparecer una sola vez
|#

(defun temperaturas-mes ()
    (let (max_enero)
        (print "Ingrese las temperaturas del mes de enero: ")
        (setq max_enero (read))
        (if (listp max_enero)
            (progn
                (print "La cantidad de dias que se registro una temperatura menor a los 38° es: ")
                (print (cant-menor-temp38 max_enero))
                (print "El valor de la temperatura promedio de dicho mes es: ")
                (print (promedio-temp max_enero))
                (print "Las temperaturas son acencdentes?")
                (print (temp-acendente max_enero))
                (print "Las diferentes temperaturas registradas son: ")
                (print (list-sin-repetidos max_enero))
            )
            (print "No es una lista")
        );if
    );let
);defun

(defun cant-menor-temp38 (max_enero)
    (cond
        ((endp max_enero) 0)
        ((and (numberp (car max_enero))(< (car max_enero ) 38)) (+ 1 (cant-menor-temp38 (cdr max_enero))))
        (T (cant-menor-temp38 (cdr max_enero)))
    );cond
);defun

(defun promedio-temp (max_enero)
    (cond
        ((endp max_enero) 0)
        #| Float o floor para que no devuelva una fracción |#
        ((numberp (car max_enero)) (float (/ (+ (car max_enero) (promedio-temp (cdr max_enero))) (+ 1 (promedio-temp(cdr max_enero))))))
        (T (promedio-temp (cdr max_enero)))
    );cond
);defun

(defun temp-acendente (max_enero)
    (cond
        ((endp max_enero) T)
        #| Si a > b no es acendente |#
        ((and (numberp (car max_enero)) (numberp (cadr max_enero)) (> (car max_enero) (cadr max_enero))) nil)
        (T (temp-acendente (cdr max_enero)))
    );cond
);defun

(defun list-sin-repetidos (max_enero)
    (cond
        ((endp max_enero) nil)
        #| Como member devulve T si se encuentra en la lista
            y nil si no se encuentra, se puede usar not para
            invertir el resultado de member y asi saber si
            el elemento no se encuentra en la lista
        |#
        #| cons para la construccion del lista y llamamos recursivamente al resto de la lista |#
        ((and (numberp (car max_enero)) (not (member (car max_enero) (cdr max_enero)))) (cons (car max_enero) (list-sin-repetidos(cdr max_enero))))
        (T (list-sin-repetidos (cdr max_enero)))
    );cond
);defun

(temperaturas-mes)