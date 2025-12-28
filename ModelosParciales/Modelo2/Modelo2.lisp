#| ##################################
    Ejercio N 1
    ################################## |#
(defun evaluar-pesos-cajas ()
    (let ((lista_cajas) (peso))
        (print "Ingrese la lista de pesos de las cajas:")
        (setq lista_cajas (read))
        (print "Ingrese un peso:")
        (setq peso (read))
        (if (and (consp lista_cajas) (numberp peso))
            (print (listar-pesos-mayor lista_cajas peso))
            (print "Los elementos ingresados no son correctos")
        );if
    );let
);defun

#| Una función predicado no puede ser con mapcar + lambda
    ya que este construye una lista, y la función predicado
    únicamente tiene que devolver T o nil.
|#
(defun listar-pesos-mayor (lista peso)
    (cond
        ((endp lista) T)
        ((and (numberp (car lista)) (> (car lista) peso)) (listar-pesos-mayor (cdr lista) peso))
        ((and (numberp (car lista)) (<= (car lista) peso)) nil)
        (T (listar-pesos-mayor (cdr lista) peso))
    );cond
);defun

#| ##################################
    Ejercio N 2 
    ################################## |#
(defun divir-lista (lista)
    (list (mayor-30 lista) (menor-30 lista));list
);defun

#| No ocupamos Mapcar + Lambda porque necesitamos saltearnos elementos |#
(defun mayor-30 (lista)
    (cond
        ((endp lista) nil)
        ((and (numberp (car lista)) (> (car lista) 30)) (cons (car lista) (mayor-30 (cdr lista))))
        (T (mayor-30 (cdr lista)))
    );cond
);defun

(defun menor-30 (lista)
    (cond
        ((endp lista) nil)
        ((and (numberp (car lista)) (<= (car lista) 30)) (cons (car lista) (menor-30 (cdr lista))))
        (T (menor-30 (cdr lista)))
    );cond
);defun

#| ##################################
    Ejercio N 3 
    ################################## |#
#| Como el ejercicio únicamente pide cuales son los pesos menores o igual al el valor
    ingresado, no se puede ocupar mapcar + lambda, por no tenemos que notifcar que el peso
    es mayor, entonces devemos saltear el elemento
|#
(defun indicar-pesos-cajas (lista peso)
    (cond
        ((endp lista) nil)
        ((and (numberp (car lista)) (< (car lista) peso)) (cons 'Menor (indicar-pesos-cajas (cdr lista) peso)))
        ((and (numberp (car lista)) (= (car lista) peso)) (cons 'Igual (indicar-pesos-cajas (cdr lista) peso)))
        (T (indicar-pesos-cajas (cdr lista) peso))
    );cond
);defun

#| ##################################
    Ejercio N 4 
    ################################## |#
(defun pesos-mayores (lista peso)
    #| Unicamente a mapcar le pasamos la/s lista/s que vamos a recorrer |#
    (mapcar (lambda (x) (if (and (numberp x) (> x peso)) T)) lista)
);defun

#| ##################################
    Ejercio N 5 
    ################################## |#
(defun clasificar-cajas (lista)
    (mapcar (lambda (x) 
                        (cond 
                            ((and (numberp x) (<= x 20)) (List x "Liviano"))
                            ((and (numberp x) (> x 20) (<= x 60)) (List x "Pesado"))
                            ((and (numberp x) (> x 60)) (List x "Muy Pesado"))
                            (T (List x "No es numerico")) #| Si necesitas validar si es númerico o no |#
                        )
    ) lista)
);defun