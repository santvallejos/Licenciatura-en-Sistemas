#| 
    Definir una función, la que a partir de una lista heterogénea ingresada como parámetro, devuelva
    una nueva lista formada por las longitudes de aquellos elementos que sean sublistas.
|#

(defun longitud-lista-heterogenea (lista)
    (mapcar (lambda (x) (if (listp x) (length x))) lista)
);defun