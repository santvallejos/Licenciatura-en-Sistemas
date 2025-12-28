#| ##################################
    Ejercio N 1
    ################################## |#
(defun principal ()
    (let ((lista_cajas) (peso))
        (print "Ingrese la lista de cajas con sus pesos:")
        (setq lista_cajas (read))
        (print "Ingrese un valor de peso:")
        (setq peso (read))
        (if (and (consp lista_cajas) (numberp peso))
            (progn
                (print (mas-50-cajas lista_cajas))
                (print (peso-ultima-caja lista_cajas peso))
                (print (encontrar-caja-vacia lista_cajas))
                (print (cajas-menor-peso lista_cajas peso))
                (print (clasificar-cajas lista_cajas))
            )
        );if
    );let
);defun

#| ##################################
    Ejercio N 2
    ################################## |#
(defun mas-50-cajas (lista)
    (if (>= (contador lista) 50)
        t
        nil
    );if
);defun

#| ##################################
    Ejercio N 3
    ################################## |#
(defun peso-ultima-caja (lista peso)
    (cond
        ((endp lista) nil)
        ((and (numberp (cadar (reverse lista))) (<= (cadar (reverse lista)) peso)) (cadar (reverse lista)))
        (T (peso-ultima-caja (reverse (cdr (reverse lista))) peso))
    );cond
);defun

#| ##################################
    Ejercio N 4
    ################################## |#
(defun encontrar-caja-vacia (lista)
    (cond
        ((endp lista) nil)
        ((and (numberp (cadar lista)) (= (cadar lista) 0)) T)
        (T (encontrar-caja-vacia (cdr lista)))
    );cond
);defun

#| ##################################
    Ejercio N 5
    ################################## |#
(defun cajas-menor-peso (lista peso)
    (cond
        ((endp lista) nil)
        ((and (numberp (cadar lista)) (<= (cadar lista) peso)) (cons (cadar lista) (cajas-menor-peso (cdr lista) peso)))
        (T (cajas-menor-peso (cdr lista) peso))
    );cond
);defun

#| ##################################
    Ejercio N 6
    ################################## |#
(defun clasificar-cajas (lista)
    #| No se ocupa cadar porque mapcar no alisa con la lista, es decir no viene asi: ((1 2) (2 0) (3 8)) 
        viene ya asi: (1 2) (2 0) (3 8)
    |#
    (mapcar (lambda (x) (if (= (cadr x) 0) 'Vacio 'Lleno)) lista)
);defun

#| ##################################
    Funcione utiles
    ################################## |#
(defun contador (lista)
    (cond
        ((endp lista) 0)
        ((numberp (caar lista)) (+ 1 (contador (cdr lista))))
        (T (contador (cdr lista)))
    );cond
);defun

(principal)