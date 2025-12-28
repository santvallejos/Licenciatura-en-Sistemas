(defun tempRegistrada ()
    (let ((tempAyer) (tempEnero) (tempFebrero))
        (print "Ingre la lista de temperaturas del mes de enero: ")
        (setq tempEnero (read))
        (print "Ingrese la lista de temperaturas del mes de febrero: ")
        (setq tempFebrero (read))
        (print "Ingrese la temperatura del dia de ayer: ")
        (setq tempAyer (read))
        (if (and (numberp tempAyer) (listp tempEnero) (listp tempFebrero))
            (evaluarTempRegistrada tempAyer tempEnero tempFebrero)
            (print "Error: La temperatura del dia de ayer debe ser un numero y las listas de temperaturas deben ser listas.")
        );if
    );let
);defun

(defun evaluarTempRegistrada (temp max_enero max_febrero)
    (if (or (member temp max_enero)
            (member temp max_febrero))
        T
        NIL)
);defun