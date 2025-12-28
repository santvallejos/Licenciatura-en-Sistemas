
(defun rotar-derecha (lista)
    (let ((primer-elemento (list (car lista))) (resto-lista (cdr lista)))
        (print (append resto-lista primer-elemento))
    );let
);defun

(defun rotar-izquierda (lista)
    (let ((ultimo-elemento (list (car (reverse lista)))) (antes-ultimo (reverse (cdr (reverse lista)))))
        (print (append ultimo-elemento antes-ultimo))
    );let
);defun