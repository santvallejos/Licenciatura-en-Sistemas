#| 
    En la compañía telefónica FunTel modelan la historia de llamadas del usuario mediante una
    lista conteniendo dos sublistas.
    • la primer sublista corresponde al tiempo de duraciones de llamadas (en minutos) en el
    horario normal
    • la segunda sublista corresponde al tiempo de duraciones de llamadas (en minutos) en
    el horario reducido
    Se necesita que desarrollen las siguientes funciones:
    1. cuandoHabloMas, que determine en que horario hablo mas. Si en los dos hablo la
    misma cantidad, responder IGUAL
    2. LLamadaMasLarga: que determine cuál fue la llamada más larga y en que horario
    3. LLamadaMasCorta: que determine cuál fue la llamada más corta y en que horario
|#

(defun cuandoHabloMas (lista)
    (cond
        #|  Pasamos el cadr porque si solo hacemos un cdr la lista que recibe
            La funcion sumar-lista es ((1 2 3)), entonces siempre va a ser
            mayor la lista normal
        |#
        ((> (sumar-lista (car lista)) (sumar-lista (cadr lista))) 'Normal)
        ((< (sumar-lista (car lista)) (sumar-lista (cadr lista))) 'Reducido)
        (t 'Igual)
    );cond
);defun

(defun LLamadaMasLarga (lista)
    (cond
        ((>= (max-number-lista (car lista)) (max-number-lista (cadr lista))) (list (max-number-lista (car lista)) 'Normal))
        (T (list (max-number-lista (cadr lista)) 'Reducido))
    );cond
);defun

(defun LLamadaMasCorta (lista)
    (cond
        ((<= (min-number-lista (car lista)) (min-number-lista (cadr lista))) (list (min-number-lista (car lista)) 'Normal))
        (T (list (min-number-lista (cadr lista)) 'Reducido))
    );cond
);defun

#| Funciones utiles |#
(defun sumar-lista (lista)
    (cond
        ((endp lista) 0)
        ((numberp (car lista)) (+ (car lista) (sumar-lista (cdr lista))))
        (t (sumar-lista (cdr lista)))
    );cond
);defun

(defun max-number-lista (lista)
    (cond
        ((endp lista) 0)
        ((numberp (car lista)) (max (car lista) (max-number-lista (cdr lista))))
        (t (max-number-lista (cdr lista)))
    );cond
);defun

(defun min-number-lista (lista)
    (cond
        ((endp lista) 0)
        ((numberp (car lista)) (min (car lista) (min-number-lista (cdr lista))))
        (t (min-number-lista (cdr lista)))
    );cond
);defun

(defun max-number-lista (lista)
    (cond
        ((endp (cdr lista)) (car lista))
        ((numberp (car lista)) (max (car lista) (max-number-lista (cdr lista))))
        (t (max-number-lista (cdr lista)))
    );cond
);defun

(defun min-number-lista (lista)
    (cond
        ((endp (cdr lista)) (car lista))
        ((numberp (car lista)) (min (car lista) (min-number-lista (cdr lista))))
        (t (min-number-lista (cdr lista)))
    );cond
);defun