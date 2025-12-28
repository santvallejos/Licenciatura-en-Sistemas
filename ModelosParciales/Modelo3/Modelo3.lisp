#| ##################################
    Ejercio N 1
    ################################## |#
(defun funciones-prendas ()
    (let (lista_prendas)
        (print "Ingrese la lista de prendas de invierno:")
        (setq lista_prendas (read))
        (if (consp lista_prendas)
            (progn
                (print (promedio-precios lista_prendas))
                (print (prendas-mayor-3000 lista_prendas))
                (print (catalogar-prendas lista_prendas))
                (print (evaluar-stcok lista_prendas))
            (print "El dato ingresado no es valido")
        );if
    );let
);defun

#| ##################################
    Ejercio N 2
    ################################## |#
(defun promedio-precios (lista)
    (cond
        ((endp lista) 0)
        ((and (numberp (cadar lista)) (> (cadar lista) 0)) (float (/ (+ (cadar lista) (promedio-precios (cdr lista))) (+ 1 (promedio-precios(cdr lista))))))
        (T (promedio-precios (cdr lista)))
    );cond
);defun

#| 
    Ejercicio que funciona y devuelve el valor correcto
        (defun Suma(pL)
        (cond 
            ((endp pL) 0)
            ((and (consp (car pL)) (numberp (second (car pL)))) (+ (second (car pL)) (Suma (cdr pL))))
            (T (Suma (cdr pL)))
        )
    )

    (defun NStock(pL)
        (cond 
            ((endp pL) 0)
            ((and (consp (car pL)) (numberp (second (car pL))) (> (second (car pL)) 0)) (+ 1 (Nstock (cdr pL))))
            (T (Nstock (cdr pL)))
        )

    )

    (defun promedio-precios (pL)
        (float (/ (suma pL) (NStock pL)))
    )
|#

#| ##################################
    Ejercio N 3
    ################################## |#
(defun prendas-mayor-3000 (lista)
    (cond
        ((endp lista) nil)
        ((and (numberp (cadar lista)) (> (cadar lista) 3000)) (cons (caar lista) (prendas-mayor-3000 (cdr lista))))
        (T (prendas-mayor-3000 (cdr lista)))
    );cond
);defun

#| ##################################
    Ejercio N 4
    ################################## |#
(defun catalogar-prendas (lista)
    (mapcar (lambda (x)
                        (cond
                            ((endp x) nil)
                            ((and (numberp (cadr x)) (= (cadr x) 0)) (list (cadr x) "Sin stock"))
                            ((and (numberp (cadr x)) (<= (cadr x) 1000)) (list (cadr x) "Barato"))
                            (T (list (cadr x) "Caro"))
                        )
    ) lista)
);defun

#| ##################################
    Ejercio N 5
    ################################## |#
(defun evaluar-stcok (lista)
    (mapcar (lambda (x)
                        (if (and (numberp (cadr x)) (= (cadr x) 0))
                            "sin stock"
                            "con stock"
                        );if
    ) lista)
);defun