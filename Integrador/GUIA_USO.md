# 🚀 Guía Rápida de Uso - BibliotecaGUI

## Inicio Rápido

### Windows
1. **Doble clic** en `ejecutar.bat`
2. O abrir PowerShell y ejecutar:
   ```powershell
   cd Integrador
   javac *.java
   java BibliotecaGUI
   ```

## 📖 Tutorial Paso a Paso

### Primer Uso

#### 1️⃣ Registrar Socios
Antes de prestar libros, necesitas socios registrados:

**Para Estudiantes:**
- Click en `👤 Agregar Socio`
- Selecciona "Estudiante"
- DNI: 40123456
- Nombre: María García
- Carrera: Ingeniería en Sistemas
- Click "Guardar"

**Para Docentes:**
- Click en `👤 Agregar Socio`
- Selecciona "Docente"
- DNI: 20987654
- Nombre: Dr. Juan Pérez
- Área: Programación
- Click "Guardar"

#### 2️⃣ Agregar Libros
Añade libros a la colección:

- Click en `📖 Agregar Libro`
- Título: "Clean Code"
- Edición: 1
- Editorial: Prentice Hall
- Año: 2008
- Click "Guardar"

Agrega más libros:
- "Java: The Complete Reference" (9, Oracle Press, 2017)
- "Design Patterns" (1, Addison-Wesley, 1994)

#### 3️⃣ Prestar un Libro
- Click en `📤 Prestar Libro`
- DNI del Socio: 40123456
- Título del Libro: Clean Code
- Click "Prestar"

✅ **Mensaje de éxito:** "Libro prestado correctamente"

#### 4️⃣ Ver Estado Actual
**Ver Socios:**
- Click en `👥 Listar Socios`
- Verás:
  - Lista completa de socios
  - Tipo de socio (Estudiante/Docente)
  - Cantidad de libros prestados
  - Estadísticas totales

**Ver Libros:**
- Click en `📚 Listar Libros`
- Verás:
  - Todos los libros
  - Estado de préstamo (Sí/No)

#### 5️⃣ Devolver un Libro
- Click en `📥 Devolver Libro`
- Título del Libro: Clean Code
- Click "Devolver"

✅ **Mensaje de éxito:** "Libro devuelto correctamente"

## 🎯 Reglas del Sistema

### Límites de Préstamo
- **Estudiantes:** Máximo 3 libros simultáneos (días: según configuración)
- **Docentes:** Sin límite de libros, 5 días de préstamo base

### Validaciones Automáticas
El sistema valida automáticamente:
- ✅ Que el socio exista en el sistema
- ✅ Que el libro esté disponible (no prestado)
- ✅ Que el socio no tenga préstamos vencidos
- ✅ Que el estudiante no exceda el límite de 3 libros
- ✅ Docentes responsables obtienen días adicionales

### Mensajes de Error Comunes

**"Socio no encontrado"**
- Verifica el DNI ingresado
- Asegúrate de haber registrado el socio primero

**"Libro no encontrado"**
- Verifica el título exacto del libro
- Asegúrate de haber agregado el libro primero

**"El libro ya está prestado"**
- El libro debe ser devuelto antes de prestarlo nuevamente
- Usa "Listar Libros" para ver qué libros están disponibles

**"No se pudo prestar el libro"**
- El estudiante puede tener 3 libros prestados
- El socio puede tener préstamos vencidos

## 🎨 Características de la Interfaz

### Código de Colores
- 🔵 **Azul**: Gestión de socios
- 🔷 **Azul claro**: Gestión de libros
- 🟢 **Verde**: Préstamos
- 🟠 **Naranja**: Devoluciones

### Efectos Visuales
- **Hover**: Los botones se iluminan al pasar el mouse
- **Diálogos modales**: Las ventanas de entrada aparecen centradas
- **Validación en tiempo real**: Mensajes claros de éxito/error

## 💡 Consejos de Uso

### Para Principiantes
1. **Comienza simple**: Agrega 1-2 socios y libros primero
2. **Prueba el flujo completo**: Agregar → Prestar → Listar → Devolver
3. **Lee los mensajes**: El sistema te guía con mensajes claros

### Para Usuarios Avanzados
- Usa DNIs reales para simular un sistema real
- Prueba los límites (3 libros para estudiantes)
- Experimenta con préstamos vencidos

## 🔧 Solución de Problemas

### La ventana no se abre
```powershell
# Verifica que Java esté instalado
java -version

# Si no está instalado, descarga JDK desde:
# https://www.oracle.com/java/technologies/downloads/
```

### Errores de compilación
```powershell
# Borra archivos .class antiguos
Remove-Item *.class

# Recompila todo
javac *.java
```

### Los emojis no se ven
- Normal en algunos sistemas Windows
- El texto descriptivo es claro sin emojis
- No afecta la funcionalidad

## 📚 Casos de Uso Ejemplo

### Caso 1: Biblioteca Escolar
```
Socios:
- Estudiante 1: Ana López, Matemática
- Estudiante 2: Carlos Ruiz, Física
- Docente 1: Prof. Martínez, Ciencias

Libros:
- Cálculo I
- Física General
- Química Orgánica

Flujo:
1. Ana pide "Cálculo I"
2. Carlos pide "Física General"
3. Prof. Martínez pide "Química Orgánica"
4. Ana devuelve "Cálculo I"
5. Carlos pide "Cálculo I"
```

### Caso 2: Biblioteca Universitaria
```
Socios:
- 5 Estudiantes de diferentes carreras
- 3 Docentes de distintas áreas

Libros:
- 10 libros de programación
- 5 libros de matemática
- 3 libros de física

Operaciones comunes:
- Préstamos simultáneos
- Devoluciones escalonadas
- Consulta de disponibilidad
```

## 🎓 Aprendizaje del Código

### Archivos Clave
- **BibliotecaGUI.java**: Interfaz gráfica (este archivo)
- **Biblioteca.java**: Lógica de negocio
- **Socio.java**: Clase abstracta base
- **Estudiante.java** y **Docente.java**: Clases derivadas

### Conceptos Implementados
1. **Swing Components**: JFrame, JDialog, JButton, etc.
2. **Layout Managers**: BorderLayout, GridBagLayout, FlowLayout
3. **Event Handling**: ActionListener, MouseListener
4. **Colores personalizados**: new Color(R, G, B)
5. **Validaciones**: Try-catch, if-else
6. **Mensajes al usuario**: JOptionPane

### Para Modificar
**Cambiar colores:**
```java
private final Color COLOR_PRIMARIO = new Color(41, 128, 185);
// Cambia los valores RGB (0-255)
```

**Cambiar tamaño de ventana:**
```java
setSize(900, 600);
// Cambia ancho y alto en píxeles
```

**Agregar más funcionalidades:**
1. Busca el método `crearPanelCentral()`
2. Agrega un nuevo botón
3. Crea el método del diálogo correspondiente

## 📞 Soporte

Para dudas sobre:
- **Java/Swing**: Consulta la documentación oficial de Oracle
- **POO**: Revisa las clases base (Socio, Libro, Prestamo)
- **Lógica**: Analiza la clase Biblioteca

## ✨ Próximas Mejoras Sugeridas

- [ ] Búsqueda de socios por nombre
- [ ] Búsqueda de libros por título/autor
- [ ] Historial de préstamos
- [ ] Reportes en PDF
- [ ] Base de datos persistente
- [ ] Filtros por fecha
- [ ] Notificaciones de vencimiento

---

**¡Disfruta usando el Sistema de Gestión de Biblioteca!** 📚✨
