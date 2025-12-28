#| 
    El tamaño de los archivos guardados en una computadora se registran en dos listas diferentes
    de la siguiente manera:
    • arch_graficos (cada elemento de la lista contiene el tamaño de un archivo gráfico)
    • arch_texto (cada elemento de la lista contiene el tamaño de un archivo de texto)
    Se tiene también una variable que contiene un tamaño
    Desarrollar una función que permite ingresar las listas, la variable y ejecute las funciones que
    se solicitan en los puntos 1, 2 y 3.
    1. Desarrollar una función predicado que determine si el tamaño del primer archivo gráfico
    es igual al tamaño del último archivo gráfico
    2. Desarrollar una función que determine si los archivos gráficos ocupan más espacio que
    los archivos de texto.
    3. Definir una función, la que a partir de las dos listas y la variable, genere una nueva lista
    con el resultado de sumar los tamaños que se encuentran en la misma posición de la
    lista, siempre y cuando esa suma sea mayor al valor de la variable.
|#

(defun mayor-graficos (arch_graficos arch_texto)
    (if (> (sumar-lista arch_graficos) (sumar-lista arch_texto))
        t
        nil
    );if
);defun

(defun archivo-mas-pesado (arch_graficos arch_texto)
    (if (> (sumar-lista arch_graficos) (sumar-lista arch_texto))
        (print "El archivo de graficos es mas pesado")
        (print "El archivo de texto es mas pesado")
    );if
);defun

(defun contruir-lista (arch_graficos arch_texto variable)
    (print (sumar-dos-listas arch_graficos arch_texto variable))
);defun

#| Funciones utiles |#
(defun sumar-lista (lista)
    (cond
        ((endp lista) 0)
        ((numberp (car lista)) (+ (car lista) (sumar-lista (cdr lista))))
        (t (sumar-lista (cdr lista)))
    );cond
);defun

(defun sumar-dos-listas (lista1 lista2 variable)
    (cond
        ((or (endp lista1) (endp lista2)) nil)
        ((and (numberp (car lista1)) (numberp (car lista2)) (> (+ (car lista1) (car lista2)) variable)) (cons (+ (car lista1) (car lista2)) (sumar-dos-listas (cdr lista1) (cdr lista2) variable)))
        (t (sumar-dos-listas (cdr lista1) (cdr lista2) variable))
    );cond
);defun