(defun registro-alumnos ()
    (let (listaAlumnos)
        (print "Ingrese la lista de Alumnos: ")
        (setq listaAlumnos (read))
        (if (listp listaAlumnos)
            (funciones-lista-alumnos listaAlumnos)
            (print "No es una lista")
        );if
    );let
);defun

(defun funciones-lista-alumnos (listaAlumnos)
    (print "La cantidad de alumnos que hay es: ")
    (print (length listaAlumnos))
    (print "El nro de libreta del primer alumno de la lista es: ")
    (print (caar listaAlumnos))
    (print "La nota del ultimo alumno de la lista es: ")
    (print (cadar  (reverse listaAlumnos)))
    (print "Ha regularizado la materia el primer alumno de la lista: ")
    (print (regularizo listaAlumnos))
);defun

(defun regularizo (listaAlumnos)
    (if (>= (cadar listaAlumnos) 6)
        T
        NIl
    );if
);defun

(registro-alumnos)