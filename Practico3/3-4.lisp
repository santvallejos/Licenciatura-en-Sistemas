#| 
    Definir una función llamada mi-segundo, la que a partir de una lista y un átomo ingresados por el
    operador deberá devolver una nueva lista donde el átomo ocupará la primera posición de la lista.
    (Recuerde que las posiciones comienzan a contarse desde la 0)
|#

(defun addAtomToList (newList newAtom)
    (print (cons newAtom newList))
);defun

(defun my-miSegundo ()
    (let ((newList) (newAtom))
        (print "Ingrese una lista: ")
        (setq newList (read))
        (print "Ingrese un átomo: ")
        (setq newAtom (read))
        (if (and (listp newList) (atom newAtom))
            (addAtomToList newList newAtom)
            (print "El valor ingresado no es una lista o un átomo")
        );if
    );let
);defun

(my-miSegundo)