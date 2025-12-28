Objetivo: Que el alumno logre:
- Interpretar diagramas de clases representados en UML
- Aprender a definir clases, con sus constructores y métodos
- Interpretar la visibilidad de los elementos (pública, privada, etc.)
- Definir métodos de acceso a las variables miembro (get/set)
- Aprender a instanciar objetos, y que éstos interactúen, mediante envío de mensajes
- Adquirir buenas prácticas de desarrollo de software, como lo es la documentación (en los ejercicios entregados en el
laboratorio se exigirá el uso de documentación utilizando javadoc)
- Ejercitar idioma inglés. Con el propósito de estimular la adquisición de competencias transversales en el proceso de
formación profesional, según lo expresado en los objetivos del programa de la asignatura, se incluye enunciado en inglés.
Conceptos teóricos: Abstracción, encapsulamiento, ocultamiento, visibilidad, objeto, clase, doble encapsulamiento, mensaje,
método, protocolo, firma, comportamiento.
Consigna: En cada ejercicio deberá
a - Crear el código JAVA correspondiente a los diagramas de Clase.
b - Aunque no se indique, debe implementar los Observadores y Mutadores (Accessors: getters y setters)
c - Si el protocolo de la clase indica set públicos, respetarlos. Caso contrario, se asumen todos privados.
d - Importante: donde el diagrama de Clase no indique tipo de valor de retorno, debe ser tipo void.
e - Agregar documentación utilizando la herramienta provista por java (javadoc)
f - Crear una clase ejecutable, en la que se instancien varios objetos de las clases definidas y se utilicen los distintos
métodos para verificar su correcto funcionamiento.
g- En los ejercicios. 1 y 2 los datos se ingresarán como constantes. Ejercicios 3 y 4 ingresar los datos como argumentos del
método main(). Ejercicios restantes: ingresar los datos por teclado, utilizando la clase Scanner.

Ejercicios:

1. El diagrama de clase adjunto representa una abstracción del
concepto “persona”.
Implemente en java la clase Persona. El método edad()
devuelve la cantidad de años cumplidos a la fecha,
considerando para el cálculo sólo la diferencia entre años. La
salida impresa del método mostrar() debe ser la siguiente (los
valores en negrita dependen del estado del objeto):
Nombre y Apellido: Juan Perez
DNI: 35123456 Edad: 22 años
Nota: Para trabajar con fechas, agregar:
import java.util.*;
Para saber el año actual usar:
Calendar fechaHoy = new GregorianCalendar();
int anioHoy = fechaHoy.get(Calendar.YEAR);
Para más información sobre la clase Calendar buscar en la documentación de JAVA.
http://docs.oracle.com/javase/6/docs/api/.

2. Una droguería que
comercia con laboratorios
que producen
medicamentos modeló la
clase Laboratorio
representada en el
diagrama de clases
adjunto.
Implemente en java la
clase Laboratorio.
La salida impresa del
método mostrar() debe
ser la siguiente (los valores en negrita dependen del estado del objeto):Persona
-nroDni: int
-nombre: String
-apellido: String
-anioNacimiento: int
+Persona(p_dni: int, p_nombre: String, p_apellido: String, p_anio: int)
-setDNI(p_dni: int): void
-setNombre(p_nombre: String): void
-setApellido(p_apellido: String): void
-setAnioNacimiento(p_anio: int): void
+getDNI(): int
+getNombre(): String
+getApellido(): String
+getAnioNacimiento(): int
+edad(): int
+nomYApe(): String
+apeYNom(): String
+mostrar(): void
Programación Orientada a Objetos Práctico Nro. 2
2
Laboratorio: Colgate S.A.
Domicilio: Junín 5204 - Teléfono: 54-11 -4239-8447
Nota:
o Observe que la clase tiene dos formas de instanciarse. (Constructores sobrecargados)
o Los atributos que no figuran en el constructor deben tener un modo de acceso público, debido a que la empresa puede
variar su política o reglas de negocio con el tiempo. Con este propósito se agregan los métodos nuevaCompraMin() y
nuevoDiaEnttrega() , que permiten modificar esos datos, asignándole un nuevo valor.