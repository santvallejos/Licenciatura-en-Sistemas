# 🗄️ Sistema con Persistencia de Datos

La aplicación ahora soporta **persistencia de datos** usando MySQL.

## 🎯 Modos de Funcionamiento

### 1. 💾 Modo CON Base de Datos
- ✅ Los datos se guardan automáticamente
- ✅ Al cerrar y abrir, los datos persisten
- ✅ Título de ventana: **"[BD Activa]"**
- ✅ Puede usarse local o en la nube

### 2. 🧠 Modo SIN Base de Datos (Solo Memoria)
- ⚠️ Los datos se pierden al cerrar
- ⚠️ Título de ventana: **"[Sin BD]"**
- ✅ Funciona sin configuración adicional

---

## ⚡ Inicio Rápido

### Sin configurar nada (Modo Memoria):
```powershell
javac *.java
java BibliotecaGUI
```
La aplicación funcionará, pero sin persistencia.

### Con Base de Datos (Recomendado):

**Paso 1:** Descargar MySQL Connector
- https://dev.mysql.com/downloads/connector/j/
- Copiar el JAR a esta carpeta

**Paso 2:** Configurar base de datos
- Lee la **[GUIA_BASE_DATOS.md](GUIA_BASE_DATOS.md)** completa
- Elige entre MySQL local o en la nube (GRATIS)

**Paso 3:** Ejecutar
```powershell
# Opción A: Usar el script
ejecutar.bat

# Opción B: Manual
javac -cp ".;mysql-connector-j-8.2.0.jar" *.java
java -cp ".;mysql-connector-j-8.2.0.jar" BibliotecaGUI
```

---

## 📁 Archivos Nuevos

| Archivo | Descripción |
|---------|-------------|
| `DatabaseConfig.java` | Configuración de conexión a BD |
| `BibliotecaDAO.java` | Acceso a datos (CRUD operations) |
| `BibliotecaGUI.java` | Actualizado con persistencia |
| `GUIA_BASE_DATOS.md` | Guía completa paso a paso |

---

## 🎨 ¿Qué cambia en la Interfaz?

### Nada visible, todo automático:
- Agregas un socio → Se guarda en BD automáticamente
- Agregas un libro → Se guarda en BD automáticamente
- Prestas un libro → Se guarda en BD automáticamente
- Devuelves un libro → Se actualiza en BD automáticamente

### Al iniciar:
- Carga automáticamente todos los datos de la BD
- Muestra un mensaje indicando si la conexión fue exitosa

---

## 🔍 ¿Cómo saber si funciona?

### 1. Mensaje al Iniciar
```
Conectado a la base de datos
Datos cargados correctamente
```

### 2. Título de la Ventana
```
Sistema de Gestión de Biblioteca [BD Activa]
```

### 3. Consola (Observa los mensajes)
```
✅ Conexión a la base de datos establecida
✅ Tablas de la base de datos verificadas/creadas
✅ Cargados X socios desde la base de datos
✅ Cargados Y libros desde la base de datos
✅ Socio guardado en la base de datos
```

### 4. Prueba Real
1. Agrega un socio
2. Cierra la aplicación
3. Abre la aplicación nuevamente
4. El socio sigue ahí ✅

---

## ☁️ Opciones de Base de Datos en la Nube (GRATIS)

### 🥇 Recomendado: FreeSQLDatabase.com
- **Más confiable y estable**
- **Totalmente gratis**
- **No requiere tarjeta de crédito**
- **Registro en 2 minutos**
- **Panel phpMyAdmin incluido**
- **Te envían los datos por email**
- https://www.freesqldatabase.com/

**Guía rápida:**
1. Regístrate en FreeSQLDatabase.com
2. Revisa tu email - recibirás:
   - Server (ejemplo: sql9.freesqldatabase.com)
   - Database Name (ejemplo: sql9XXXXX_biblioteca)
   - Username (ejemplo: sql9XXXXX_user)
   - Password (tu contraseña)
3. Edita `DatabaseConfig.java` con esos datos
4. ¡Listo!

### 🥈 Alternativa: db4free.net
- **Gratis pero menos confiable**
- **Puede tener problemas de disponibilidad**
- Usa FreeSQLDatabase si es posible
- https://www.db4free.net/

### 🥉 Avanzado: Railway.app
- **500 horas gratis/mes**
- **Mejor rendimiento**
- Requiere cuenta GitHub
- https://railway.app/

**Ver detalles completos en [GUIA_BASE_DATOS.md](GUIA_BASE_DATOS.md)**

---

## 🔧 Configuración Rápida

Edita `DatabaseConfig.java` líneas 14-16:

```java
// Para Base de Datos LOCAL
private static final String URL = "jdbc:mysql://localhost:3306/biblioteca_db";
private static final String USER = "root";
private static final String PASSWORD = "tu_password";

// Para Base de Datos EN LA NUBE (db4free.net)
// Descomenta estas líneas y comenta las anteriores:
// private static final String URL = "jdbc:mysql://db4free.net:3306/tu_db";
// private static final String USER = "tu_usuario";
// private static final String PASSWORD = "tu_password";
```

---

## 📊 Estructura de la Base de Datos

La aplicación crea automáticamente 3 tablas:

### `socios`
- dni (PK)
- nombre
- tipo (Estudiante/Docente)
- carrera_o_area
- dias_prestamo

### `libros`
- id (PK, auto-increment)
- titulo
- edicion
- editorial
- anio

### `prestamos`
- id (PK, auto-increment)
- fecha_retiro
- fecha_devolucion
- socio_dni (FK → socios)
- libro_id (FK → libros)

---

## 🎓 Conceptos Aprendidos

### Arquitectura de Capas
```
┌─────────────────────┐
│  BibliotecaGUI      │ ← Interfaz (Vista)
├─────────────────────┤
│  Biblioteca         │ ← Lógica de Negocio
├─────────────────────┤
│  BibliotecaDAO      │ ← Acceso a Datos
├─────────────────────┤
│  DatabaseConfig     │ ← Configuración
├─────────────────────┤
│  MySQL Database     │ ← Persistencia
└─────────────────────┘
```

### Patrones de Diseño
- **DAO (Data Access Object)**: Separación de lógica de datos
- **Singleton**: Conexión única a la BD
- **Try-with-resources**: Manejo automático de recursos

### Tecnologías
- **JDBC**: Conexión Java a BD
- **PreparedStatement**: Consultas seguras (previene SQL injection)
- **ResultSet**: Lectura de resultados

---

## 🚨 Solución Rápida de Problemas

### "Driver de MySQL no encontrado"
→ Descarga el conector JAR y agrégalo al classpath

### "Access denied for user"
→ Verifica usuario y contraseña en `DatabaseConfig.java`

### "Unknown database"
→ Crea la BD: `CREATE DATABASE biblioteca_db;`

### "Modo sin Base de Datos"
→ Revisa la configuración y los logs de la consola

**Ver más en [GUIA_BASE_DATOS.md](GUIA_BASE_DATOS.md)**

---

## 📚 Recursos

- **Guía Completa:** [GUIA_BASE_DATOS.md](GUIA_BASE_DATOS.md)
- **Guía de Uso:** [GUIA_USO.md](GUIA_USO.md)
- **Guía de GUI:** [README_GUI.md](README_GUI.md)
- **MySQL Docs:** https://dev.mysql.com/doc/

---

## ✨ Ventajas de la Nueva Versión

✅ **Persistencia**: Los datos no se pierden
✅ **Nube**: Acceso desde cualquier lugar
✅ **Escalable**: Preparada para más funcionalidades
✅ **Profesional**: Arquitectura en capas
✅ **Educativa**: Código comentado y claro
✅ **Flexible**: Funciona con o sin BD

---

**¡Tu biblioteca ahora es profesional con datos persistentes en la nube!** 🎉

Para más detalles, consulta **[GUIA_BASE_DATOS.md](GUIA_BASE_DATOS.md)**
