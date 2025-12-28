(defun calcular-pago-por-persona (precio-pizza cantidad-amigos)
  (let* ((porciones-necesarias (* cantidad-amigos 3))
         (pizzas-necesarias (ceiling porciones-necesarias 8)) ; redondea hacia arriba
         (costo-total (* precio-pizza pizzas-necesarias))
         (costo-por-persona (/ costo-total cantidad-amigos)))
    costo-por-persona))
