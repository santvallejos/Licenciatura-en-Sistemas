#| 
    Evaluar las siguientes funciones y determinar su resultado
    Función aplicada Resultado
    (mapcar 'atom '(a (b) () (()) “AA” 3))        ----> (T NIL T NIL T T)
    (mapcar 'listp '(a (b) () (()) "AA" 3))       ----> (NIL T NIL T NIL NIL)
    (mapcar '> '(5 8 3) '(4 9 2))                 ----> (T NIL T)
    (mapcar '< '(2 8 3) '(4 9 2) '(5 1 7))        ----> (T NIL NIL)
    (mapcar '> '(5 8 3) '(4 9) '(3 8 1))          ----> (T NIL NIL)
    (mapcar '+ '(1 2) '(3 4) '(2 2))              ----> (4 8)
    (mapcar '- '(1 8) '(3 4) '(2 2 9))            ----> (-4 2)
    (mapcar 'cons '(1 2) '((a b) (3 4) ((7 8))))  ----> ((1 A B) (2 3 4))
    (mapcar 'abs '(0 -8 10 3 -2.5 -1/4 ))         ----> (0 8 10 3 2.5 1/4)
    (mapcar 'length '((1 1 1) () ((8)) (a b)))    ----> (3 0 1 2)
    (mapcar 'list '(a b c d))                     ----> ((A) (B) (C) (D))
    (mapcar 'car '((2 3 4) (a b) ((c)) ) )        ----> (2 A (C))
|#