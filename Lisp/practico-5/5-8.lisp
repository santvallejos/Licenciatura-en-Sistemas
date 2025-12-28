#| 
    Definir una función, la que a partir de dos listas ingresadas como parámetro,
    devuelva una nueva lista que asocie cada elemento no-numérico de la LISTA1 con el último
    elemento de la LISTA2. 
|#

(defun asociar-no-numericos (lista1 lista2)
    (mapcar (lambda (x) 
    (if (not (numberp x)) (list x (car (reverse lista2)))));Funcion principal
    lista1);parametro de recorrido
);defun