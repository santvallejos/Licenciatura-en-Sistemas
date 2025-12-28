
#| 
    Para desarrollar esta actividad puede ayudarse de las resoluciones de la Actividad 1

    a. A partir de un determinado monto en pesos, que será ingresado por operador, definir una
    función que devuelva la cantidad de dólares que se pueden comprar con el monto ingresado.

    b. Recordando la fórmula que permite calcular el volumen de un cilindro, definir una función
    que permita el ingreso por teclado de las variables necesarias para ejecutar dicha función y
    obtener el valor del volumen.

    c. Recordando la fórmula que permite calcular el área del trapecio, definir una función que
    permita el ingreso por teclado de las variables necesarias para ejecutar dicha función y
    obtener el valor del área. 
|#

;a)
    (defun convertPesosToDolar (pesos)
        (let (totalDolar)
            (setq totalDolar (/ pesos 1044.50))
            (print "La cantidad de dólares es: ")
            (print totalDolar)
        );let
    );defun

    (defun my-convertPesosToDolar ()
        (let (pesos)
            (print "Ingrese la cantidad de pesos: ")
            (setq pesos (read))
            (if (numberp pesos) 
                (print (convertPesosToDolar pesos)) 
                (print "El valor ingresado no es un número")
            );if
        );let
    );defun

(my-convertPesosToDolar)

;b)
    (defun volCilindro (r h)
        (let (vol)
            (setq vol (* pi (expt r 2) h))
            (print "El volumen del cilindro es: ")
            (print vol)
        );let
    );defun

    (defun my-volCilindro ()
        (let ((r) (h))
            (print "Ingrese el radio: ")
            (setq r (read))
            (print "Ingrese la altura: ")
            (setq h (read))
            (if (and (numberp r) (numberp h))
                (print (volCilindro r h))
                (print "El o los valores ingresados no son números")
            );if
        );let
    );defun

(my-volCilindro)

;c)
    (defun areaTrapecio (b1 b2 h)
        (let (area)
            (setq area (* (/ (+ b1 b2) 2) h))
            (print "El área del trapecio es: ")
            (print area)
        );let 
    );defun

    (defun my-areaTrapecio ()
        (let ((b1) (b2) (h))
            (print "Ingrese la base mayor: ")
            (setq b1 (read))
            (print "Ingrese la base menor: ")
            (setq b2 (read))
            (print "Ingrese la altura: ")
            (setq h (read))
            (if (and (numberp b1) (numberp b2) (numberp h))
                (print (areaTrapecio b1 b2 h))
                (print "El o los valores ingresados no son números")
            );if
        );let
    );defun

(my-areaTrapecio)