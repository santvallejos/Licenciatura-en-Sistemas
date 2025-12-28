#| 
    A partir de un determinado valor de temperatura, que será ingresado por el operador, definir una
    función llamada clima que me indique el estado del clima, teniendo en cuenta:
    Temperatura Clima
    < 0 Helado
    = 0 y < 10 Frio
    = 10 y < 20 Templado
    = 20 y < 30 Cálido
    > 30 Abrasador 
|#

(defun clima ()
    (let (temp)
        (print "Ingrese la temperatura: ")
        (setq temp (read))
        (cond
            ((not (numberp temp)) (print "No es un numero"))
            ((< temp 0) 'helado)
            ((< temp 10) 'frio)
            ((< temp 20) 'templado)
            ((< temp 30) 'calido)
            (t 'abrasador)
        );cond
    );let
);defun

(clima)