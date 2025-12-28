#| 
    La cantidad de lluvia caída correspondientes al mes de Abril y al mes de Junio se registran en
    dos listas diferentes de la siguiente manera:
    • lluvia_abril: Cada elemento de la lista corresponde a la cantidad de lluvia caída 1 día,
    por lo que esta lista tendrá 30 elementos.
    • Lluvia_junio: Cada elemento de la lista corresponde a la cantidad de lluvia caída 1 día,
    por lo que esta lista tendrá 30 elementos
    NOTA: la cantidad de lluvia caída se registran en la misma unidad de medida: mm (milímetros).
    1. Desarrollar una función, la que a partir de la lista que contiene la cantidad de lluvia
    caída en el mes de Junio, la que será ingresada por el operador, devuelva una nueva
    lista formada por mensajes solamente para los días en que ha llovido. Donde el
    mensaje será “débil", cuando cae menos de 2 mm, "moderada" de 2,1 hasta 15 mm y
    "fuerte" para el resto de los casos.
    2. A partir de la lista de la lluvia caída en el mes de Abril, la que es ingresada como
    parámetro, definir una función predicado que evalúe si llovió el último día del mes.
    3. Desarrollar una función, la que a partir de las dos listas ingresadas como parámetro,
    determine en que mes se ha acumulado más lluvia.
|#

(defun categorisar-lluvia ()
    (let (lluvia_junio)
        (print "Ingrese la cantidad de lluvia caída en el mes de junio:")
        (setq lluvia_junio (read))
        (if (consp lluvia_junio)
            (print (contruir-lista-lluvia-categorizada lluvia_junio))
            (print "La lista ingresada no es válida")
        );if
    );let
);defun

(defun llovio-ultimo-dia (lista)
    (if (and (= (length lista) 30) (> (car (reverse lista)) 0))
        t
        nil
    ) 
);defun

(defun mes-con-mas-lluvia (lista1 lista2)
    (if (> (sumar-lista lista1) (sumar-lista lista2))
        (print "El mes de abril tiene más lluvia")
        (print "El mes de junio tiene más lluvia")
    );if
);defun

#| Funciones utiles |#
(defun contruir-lista-lluvia-categorizada (lista)
    (cond
        ((endp lista) nil)
        ((and (numberp (car lista)) (< (car lista) 2)) (cons 'débil (contruir-lista-lluvia-categorizada (cdr lista))))
        ((and (numberp (car lista)) (<= (car lista) 15)) (cons 'moderado (contruir-lista-lluvia-categorizada (cdr lista))))
        (t (cons 'fuerte (contruir-lista-lluvia-categorizada (cdr lista))))
    );cond
);defun

(defun sumar-lista (lista)
    (cond
        ((endp lista) 0)
        ((numberp (car lista)) (+ (car lista) (sumar-lista (cdr lista))))
        (t (sumar-lista (cdr lista)))
    );cond
);defun