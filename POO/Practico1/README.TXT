## Practico 1

El objetivo de esta serie es que el alumno se familiarice con la sintaxis básica del lenguaje de programación
y con el entorno de trabajo (BlueJ). Por lo tanto los ejercicios se resolverán de modo procedural,
efectuando los cálculos directamente en el método main(). NO se requiere documentación.

1. Crear la clase ejecutable “Operador”, que contenga el método main(). En él declarar las variables a y b de tipo
entero. Inicializarlas con los valores 8 y 3 respectivamente. Realizar y mostrar por pantalla las siguientes
operaciones aritméticas: suma, resta, multiplicación, división y resto.

2. Crear la clase “Multiplo”, que contenga el método main(), en el que se determinen y muestren por pantalla los
números múltiplos de 4 a partir de 42 y hasta el 150 inclusive. Usar la instrucción iterativa más apropiada.

**Conceptos Clave:**
- Ingreso de valores mediante argumentos de main()
- Uso del entorno BlueJ
- Métodos de conversión String a double/int


**¡Atención!**
La clase Math (paquete java.lang) se carga automáticamente:
- Métodos principales: `Math.sqrt()` y `Math.pow()`
 (Ver Material de lectura obligatoria -
Estructuras)

3. Crear una clase ejecutable denominada “Circunferencia”, en la que se calcule el perímetro de una
circunferencia, ingresando el radio de tipo entero a través del argumento del main().

4. Crear clase ejecutable “Triangulo”, declarar las variables a, b y c de tipo double, que corresponden a los lados
de un triángulo. Los valores deben ser ingresados por teclado como argumentos del método main(). Calcular y
mostrar el semiperímetro y el área del triángulo.

**Fórmulas:**
```
semiperímetro = (a + b + c)/2
área = √(s*(s-a)*(s-b)*(s-c))
```

**Nota de prueba:**  
Valores sugeridos: `a=2, b=2.7, c=3.5`

5. Crear una clase denominada “Ecuación” que calcule las raíces reales de una ecuación de segundo grado. Los
valores de los coeficientes a, b y c se ingresarán por teclado como argumentos del método main(). Considerar
que si el discriminante > 0 se deben calcular las 2 raíces, si el discriminante = 0 se debe calcular una sola raíz,
especificando por pantalla que x1 = x2. En caso de ser negativo, mostrar un mensaje indicando que se
encuentra frente a una solución compleja (numero imaginario).
Nota: probar con a= -1; b=500; c=-62500;

6. Crear una clase denominada TrianguloRectangulo, en la que se determine si un triangulo es rectángulo
(Teorema de Pitágoras → h2 = cateto12 + cateto22). Los lados se deben ingresar por teclado, utilizando el
argumento del main().
Nota: probar con hipotenusa = 5; cateto1 = 3; cateto2 = 4;
Conceptos: Uso de la clase Scanner. Arreglos. Estructura While. Estructura For. Métodos de ordenación.
Variables miembro MIN_VALUE y MAX_VALUE de las clases Integer y Double. Tabulador “\t”
import java.util.Scanner;
Scanner teclado = new Scanner(System.in);
String var1 = teclado.next(); int var2 = teclado.nextInt();

7. Modificar la clase Circunferencia para permitir que el usuario pueda calcular el perímetro de muchas
circunferencias, utilizando la estructura while. Modificar además el ingreso de datos, utilizando la clase
Scanner.

8. Crear una clase denominada OperarVector que permita ingresar por teclado (Scanner) 5 notas de alumnos, las
que serán almacenadas en un array de enteros. Calcular el promedio y determinar la mayor nota. El promedio
debe permitir resultado con decimales (aplicar cast a los elementos enteros cuando sea necesario para obtener
dicho resultado). Mostrar los elementos ingresados, separados por un tabulador. Mostrar el promedio y la
mayor nota con el mensaje respectivo.

9. Crear una clase denominada OrdenVector, que permita ingresar por teclado (Scanner) 4 elementos de tipo
doble, y almacenarlos en un array. Determinar el menor elemento y mostrarlo. Ordenar los elementos del
vector de menor a mayor. Mostrar los elementos ordenados, separados por un tabulador. Usar instrucción
FOR para el ingreso de datos. Utilizar método de la Burbuja.