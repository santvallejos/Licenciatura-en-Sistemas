# 📚 Sistema de Gestión de Biblioteca - Interfaz Gráfica

## Descripción
Interfaz gráfica desarrollada con Java Swing para gestionar una biblioteca de manera sencilla e intuitiva.

## 🎨 Características de la Interfaz

### Colores y Diseño
- **Azul Principal**: Botones de gestión de socios
- **Azul Claro**: Botones de gestión de libros
- **Verde**: Botones de préstamo
- **Naranja**: Botones de devolución
- **Fondo gris claro**: Para mejor legibilidad

### Funcionalidades

#### 1. 👤 Agregar Socio
Permite registrar nuevos socios en el sistema:
- **Tipos de socio**: Estudiante o Docente
- **Datos requeridos**: DNI, Nombre
- **Datos específicos**:
  - Estudiante: Carrera
  - Docente: Área

#### 2. 📖 Agregar Libro
Registra nuevos libros en la biblioteca:
- Título
- Edición (número)
- Editorial
- Año de publicación

#### 3. 📤 Prestar Libro
Realiza el préstamo de un libro a un socio:
- Ingresa el DNI del socio
- Ingresa el título del libro
- El sistema valida automáticamente:
  - Que el socio exista
  - Que el libro exista y esté disponible
  - Que el socio pueda pedir libros (sin préstamos vencidos)
  - Que el estudiante no exceda el límite de 3 libros

#### 4. 📥 Devolver Libro
Registra la devolución de un libro:
- Ingresa el título del libro a devolver
- El sistema registra automáticamente la fecha de devolución

#### 5. 👥 Listar Socios
Muestra una lista completa de todos los socios registrados con:
- DNI
- Nombre
- Tipo de socio (Estudiante/Docente)
- Cantidad de libros prestados
- Estadísticas por tipo de socio

#### 6. 📚 Listar Libros
Muestra todos los libros de la biblioteca indicando:
- Número de orden
- Título
- Estado (Prestado: Sí/No)

## 🚀 Cómo Ejecutar

### Compilar
```powershell
javac BibliotecaGUI.java Biblioteca.java Socio.java Estudiante.java Docente.java Libro.java Prestamo.java LibroNoPrestadoException.java
```

### Ejecutar
```powershell
java BibliotecaGUI
```

## 📝 Estructura del Código

La clase `BibliotecaGUI` está organizada de forma clara y sencilla:

### Componentes Principales
- **Colores**: Definidos como constantes al inicio de la clase
- **Constructor**: Inicializa la ventana y componentes
- **Métodos de creación**: Para paneles, botones y campos de texto
- **Métodos de acción**: Cada funcionalidad tiene su propio método
- **Métodos auxiliares**: Para mensajes y ventanas de texto

### Métodos Importantes

```java
// Crear componentes con estilo
crearBoton(String texto, Color color)
crearEtiqueta(String texto)
crearCampoTexto()

// Diálogos de funcionalidades
mostrarDialogoAgregarSocio()
mostrarDialogoAgregarLibro()
mostrarDialogoPrestarLibro()
mostrarDialogoDevolverLibro()

// Mostrar información
mostrarListaSocios()
mostrarListaLibros()
```

## 💡 Conceptos de Swing Utilizados

### Layout Managers
- **BorderLayout**: Para el diseño general (Norte, Centro, Sur)
- **GridBagLayout**: Para formularios con campos alineados
- **FlowLayout**: Para botones en paneles

### Componentes
- **JFrame**: Ventana principal
- **JDialog**: Ventanas de diálogo modales
- **JButton**: Botones con efectos hover
- **JTextField**: Campos de entrada de texto
- **JComboBox**: Lista desplegable para tipos de socio
- **JTextArea + JScrollPane**: Para mostrar listas largas

### Eventos
- **ActionListener**: Para responder a clicks en botones
- **MouseListener**: Para efectos visuales (hover)

## 🎯 Validaciones Implementadas

El sistema incluye validaciones para:
- ✅ Campos vacíos
- ✅ Formato de números (DNI, edición, año)
- ✅ Existencia de socios y libros
- ✅ Disponibilidad de libros
- ✅ Límites de préstamos por tipo de socio
- ✅ Préstamos vencidos

## 🔍 Ejemplo de Uso

1. **Iniciar la aplicación**: Ejecuta `java BibliotecaGUI`
2. **Agregar un socio**: Click en "👤 Agregar Socio"
   - Selecciona: Estudiante
   - DNI: 12345678
   - Nombre: Juan Pérez
   - Carrera: Ingeniería
3. **Agregar un libro**: Click en "📖 Agregar Libro"
   - Título: Java Programming
   - Edición: 1
   - Editorial: Oracle Press
   - Año: 2023
4. **Prestar el libro**: Click en "📤 Prestar Libro"
   - DNI: 12345678
   - Título: Java Programming
5. **Ver listas**: Click en "👥 Listar Socios" o "📚 Listar Libros"

## 🎨 Personalización

Puedes cambiar fácilmente los colores modificando estas constantes:

```java
private final Color COLOR_PRIMARIO = new Color(41, 128, 185);
private final Color COLOR_SECUNDARIO = new Color(52, 152, 219);
private final Color COLOR_EXITO = new Color(46, 204, 113);
private final Color COLOR_ADVERTENCIA = new Color(230, 126, 34);
```

## 📚 Recursos de Aprendizaje

- **BorderLayout**: [Oracle Docs](https://docs.oracle.com/javase/tutorial/uiswing/layout/border.html)
- **GridBagLayout**: [Oracle Docs](https://docs.oracle.com/javase/tutorial/uiswing/layout/gridbag.html)
- **Color en Java**: Usa `new Color(R, G, B)` donde R, G, B son números de 0-255
- **ActionListener**: Interface para manejar eventos de botones

## 🐛 Troubleshooting

**Problema**: No se ven los emojis en los botones
- **Solución**: Es normal en algunos sistemas. El texto descriptivo sigue siendo claro.

**Problema**: Los colores no se ven
- **Solución**: Verifica que tu JDK soporte Swing correctamente.

**Problema**: Error al compilar
- **Solución**: Asegúrate de compilar todos los archivos .java necesarios.

## 👨‍💻 Autor
Sistema de Gestión de Biblioteca - Práctico POO LSI
