#| 
    Definir una función llamada posición, que reciba como argumentos un elemento y una lista e
    indique la posición que ocupa el elemento en la lista.
|#

(defun buscar-elemento()
             (let ((lista) (elemento))
             (print "Ingrese la lista")
             (setq lista (read))
             (printa "Ingrese el elemento que desea buscar")
             (setq elemento (read))
             (position elemento lista)))