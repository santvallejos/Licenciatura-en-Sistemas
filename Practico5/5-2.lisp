#| 
    Determinar el resultado que arrojarían las siguientes funciones lambda
    Función LISP Resultado
    ((lambda (X) (if (> (car X) 0) 'POSITIVO)) '(5 6 7))                                        -----> POSITIVO
    ((lambda (X) (if (> (car X) 0) 'POSITIVO)) '(-5 6 7))                                       -----> NIL
    ((lambda (A) (reverse (cdr A))) '((2 3 4) a b c))                                           -----> (C B A)
    ((lambda (X) (if (numberp (car X)) (* 2 (car X)))) '(5 6 7))                                -----> 10
    ((lambda (X) (if (and (numberp (car X)) (evenp (car X))) (+ 10 (car X)))) '(4 6 7))         -----> 14
    ((lambda (X) (if (and (numberp (car X)) (evenp (car X))) (+ 10 (car X)) 0 )) '(7 6 7))      -----> 0
|#