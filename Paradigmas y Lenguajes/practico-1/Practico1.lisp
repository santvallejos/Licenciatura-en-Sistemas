#| 
    Actividad N°1 
    Expresar como funciones LISP las siguientes fórmulas geométricas. Luego para cada una de
    ellas determinar la cantidad de átomos y/o sublistas en un cuadro como el que se muestra debajo
    del cuadro de fórmulas.
|#

#| 
    Rectangulo
                                        Siempre evaluaremos el primer nivel de la función
    Perim: (+ (* 2 a) (* 2 b)) -------> Atoms: 1 Sublist: 2 Lenght: 3
    Área: (* a b)              -------> Atoms: 3 Sublist: 0 Length: 3

    Cuadrado
    Perim: (* 4 a)      -------> Atoms: 3 Sublist: 0 Lenght: 3
    Área: (expt 2 a)    -------> Atoms: 3 Sublist: 0 Length: 3

    Paralelogramo
    Perim: (+ (* 2 a) (* 2 b))    -------> Atoms: 1 Sublist: 2 Lenght: 3
    Área: (* base altura)         -------> Atoms: 3 Sublist: 0 Length: 3

    Triangulo
    Perim: (+ a b c)                -------> Atoms: 3 Sublist: 0 Lenght: 3
    Área: (/ (* base altura) 2)     -------> Atoms: 2 Sublist: 1 Length: 3

    Circuferencia
    Perim: (* (* 2 pi) r)           -------> Atoms: 2 Sublist: 1 Lenght: 3
    Área: (* pi (expt 2 r))         -------> Atoms: 2 Sublist: 1 Length: 3

    Triangulo Rectangulo
    Teorema de Pitágoras: (= (+ (expt a 2) (expt b 2)) (expt c 2))  -------> Atoms: 1 Sublist: 2 Lenght: 3
    Área: (/ (* a b) 2)                                             -------> Atoms: 2 Sublist: 1 Length: 3

    Trapecio
    Área: (* (/ (+ b1 b2) 2) h)    -------> Atoms: 2 Sublist: 1 Length: 3

    Paralelepípedo
    Área L: (* (+ (* 2 a) (* 2 b)) h)                      -------> Atoms: 2 Sublist: 1 Length: 3
    Área T: (+ (* (+ (* 2 a) (* 2 b)) h) (* (* a b) 2))    -------> Atoms: 1 Sublist: 2 Length: 3
    Volumen: (* a b h)                                     -------> Atoms: 4 Sublist: 0 Length: 4

    Cilindro
    Área L: (* 2 pi r h)               -------> Atoms: 5 Sublist: 0 Length: 5
    Área T: (* (* 2 pi) r (+ r h))     -------> Atoms: 2 Sublist: 2 Length: 4
    Volumen: (* pi (expt 2 r) h)   -------> Atoms: 2 Sublist: 1 Length: 4
|#

#| 
    Actividad N°2

    Resolver las siguientes situaciones problemáticas utilizando funciones Lisp. (Pueden ayudarse
    realizando primeramente las soluciones como expresiones aritméticas y luego convertir las
    mismas a funciones lisp)
|#

#| 
    1. Calcular la cantidad de dólares que podemos comprar con $ 52.300 teniendo en cuenta la
        cotización DÓLAR BANCO NACIÓN = 1044,50
|#
    (/ 52300 1044.50)

#| 
    2. Representar 250 has en m2, sabiendo que 1 ha = 10.000 m2
|#

(* 250 10000)

#| 
    3. Las notas correspondientes a los exámenes finales de un alumno son las siguientes: 7, 5, 10
        y 8. Calcular su promedio y que porcentaje de materias aprobadas tiene, considerando que
        el total de materias en la carrera es 25.
|#

(/ (+ 7 5 10 8) 4) #| Promedio de las notas |#
(* (/ 3 25) 100)   #| Porcentaje de materias aprobadas |#

#| 
    4. Calcular la cantidad de estantes que tiene una biblioteca, sabiendo que tengo ubicado 30
        libros y que en cada estante entran 6 libros.
|#

(/ 30 6)

#| 
    5. Calcular la cantidad de aros que tiene Macarena guardados en 4 cajas. Cada caja tiene 8
        pares y en una de ellas tiene además un solo aro.
|#

(- (* 4 8) 1)

#| 
    6. Calcular la cantidad de estampillas que tiene Felipe en su álbum. El mismo tiene 14 páginas
        y cada página tiene 2 filas con 9 estampillas en cada fila.
|#

(* 14 (* 2 9)) #| en una página hay 18 estampillas |#

#| 
    7. Calcular la cantidad de plata que tiene ahorrada Pedro si tiene 6 monedas de $10, 4 billetes
        de $50, 1 billete de $500 y 5 billetes de $100. Si luego gasta ¼ de su dinero, ¿cuánto dinero
        le queda?
|#

(setq total (+ (* 6 10) (* 4 50) (* 1 500) (* 5 100))) #| Total de dinero |#
(- total (/ total 4) #| Cuarto de su dinero |# ) #| Dinero que le queda |#

#| 
    8. En un tanque hay 357 litros de agua, en otro 49800 centilitros y el tercero 1765 litros. Si se
        reparte toda el agua en envases de 20 litros ¿Cuántos envases habrá?
|#

(/ (+ 357 (* 49800 0.01) 1765) 20) #| Total de de envaces 131 |#

#| 
    9. En un almacén hay 62 sacos de papas. Cada saco pesa 85 kg. Si se venden la mitad de las
        papas ¿cuántos kilos quedarán sin vender?
|#

(/ (* 62 85) 2)

#| 
    10. Durante su primer año la estación de bomberos recibió 40 alertas. Al año siguiente recibió el
        20% más. ¿Cuántas alertas recibió en su corta historia?
|#

(+ 40 (* 40 0.20))