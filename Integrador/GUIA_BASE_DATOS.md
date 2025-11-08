# 🗄️ Guía de Configuración de Base de Datos

## 📋 Índice
1. [Requisitos Previos](#requisitos-previos)
2. [Opción 1: MySQL Local](#opción-1-mysql-local)
3. [Opción 2: MySQL en la Nube (GRATIS)](#opción-2-mysql-en-la-nube-gratis)
4. [Descargar el Conector MySQL](#descargar-el-conector-mysql)
5. [Configurar la Aplicación](#configurar-la-aplicación)
6. [Compilar y Ejecutar](#compilar-y-ejecutar)
7. [Solución de Problemas](#solución-de-problemas)

---

## 📦 Requisitos Previos

1. **Java JDK** instalado (versión 8 o superior)
2. **MySQL Connector/J** (Driver JDBC para MySQL)
3. Una base de datos MySQL (local o en la nube)

---

## 🏠 Opción 1: MySQL Local

### Paso 1: Instalar MySQL

**Windows:**
1. Descarga MySQL Community Server: https://dev.mysql.com/downloads/mysql/
2. Ejecuta el instalador
3. Durante la instalación:
   - Selecciona "Developer Default"
   - Configura la contraseña para el usuario `root`
   - Anota la contraseña (la necesitarás después)

**Verificar instalación:**
```powershell
mysql --version
```

### Paso 2: Crear la Base de Datos

```powershell
# Acceder a MySQL
mysql -u root -p
# Ingresa tu contraseña cuando te la pida
```

```sql
-- Crear la base de datos
CREATE DATABASE biblioteca_db;

-- Verificar que se creó
SHOW DATABASES;

-- Salir
EXIT;
```

### Paso 3: Configurar Credenciales

Edita el archivo `DatabaseConfig.java`:

```java
// Para MySQL Local
private static final String URL = "jdbc:mysql://localhost:3306/biblioteca_db";
private static final String USER = "root";
private static final String PASSWORD = "tu_password_aqui"; // ⚠️ IMPORTANTE: Pon tu contraseña
```

---

## ☁️ Opción 2: MySQL en la Nube (GRATIS)

### Servicios Gratuitos Recomendados

#### 🥇 1. FreeSQLDatabase.com (RECOMENDADO)

**Ventajas:**
- ✅ **Más confiable** que otros servicios gratuitos
- ✅ Completamente gratis
- ✅ No requiere tarjeta de crédito
- ✅ Panel de control phpMyAdmin incluido
- ✅ Registro rápido y simple
- ✅ Te envían los datos por email

**Pasos Detallados:**

1. **Registrarse:**
   - Ir a: https://www.freesqldatabase.com/
   - Click en el botón verde **"Start Free MySQL Account"**
   - Completar el formulario:
     - **Your Name:** Tu nombre
     - **Your Email:** Tu email (importante, te enviarán los datos aquí)
     - **Database Name:** Elige un nombre (ejemplo: `biblioteca_db`)
     - **Username:** Elige un usuario (ejemplo: `usuario_biblioteca`)
     - **Password:** Elige una contraseña segura
     - **Confirm Password:** Repite la contraseña
   - Acepta los términos de servicio
   - Click en **"Sign Up"**

2. **Revisar Email:**
   - Ve a tu correo electrónico
   - Busca el email de FreeSQLDatabase (puede tardar 1-2 minutos)
   - El email contendrá:
     ```
     Server: sql9.freesqldatabase.com
     Database Name: sql9XXXXX_biblioteca
     Database User: sql9XXXXX_user
     Port Number: 3306
     Password: tu_password
     phpMyAdmin: https://www.phpmyadmin.co/
     ```
   - **¡GUARDA ESTOS DATOS!** Los necesitarás para configurar

3. **Verificar en phpMyAdmin (Opcional):**
   - Ir a: https://www.phpmyadmin.co/
   - Login con:
     - Server: El servidor que recibiste (ejemplo: `sql9.freesqldatabase.com`)
     - Username: Tu usuario completo (ejemplo: `sql9XXXXX_user`)
     - Password: Tu contraseña
   - Verás tu base de datos en el panel izquierdo

4. **Configurar la Aplicación:**
   
   Edita `DatabaseConfig.java` y **reemplaza las líneas 14-16** con tus datos:
   
   ```java
   // Comenta estas líneas de MySQL Local:
   // private static final String URL = "jdbc:mysql://localhost:3306/biblioteca_db";
   // private static final String USER = "root";
   // private static final String PASSWORD = "";
   
   // Descomenta y configura con TUS DATOS de FreeSQLDatabase:
   private static final String URL = "jdbc:mysql://sql9.freesqldatabase.com:3306/sql9XXXXX_biblioteca";
   private static final String USER = "sql9XXXXX_user";
   private static final String PASSWORD = "tu_password_real";
   ```
   
   **⚠️ IMPORTANTE:** 
   - Reemplaza `sql9XXXXX_biblioteca` con el nombre exacto de tu base de datos
   - Reemplaza `sql9XXXXX_user` con tu usuario exacto
   - Reemplaza `tu_password_real` con tu contraseña
   - **NO** agregues espacios extra
   - El servidor puede ser `sql9`, `sql10`, `sql11`, etc. - usa el que recibiste

5. **Ejemplo Real:**
   
   Si recibiste este email:
   ```
   Server: sql10.freesqldatabase.com
   Database Name: sql10123456_biblioteca
   Database User: sql10123456_admin
   Password: MiPass123!
   ```
   
   Tu configuración sería:
   ```java
   private static final String URL = "jdbc:mysql://sql10.freesqldatabase.com:3306/sql10123456_biblioteca";
   private static final String USER = "sql10123456_admin";
   private static final String PASSWORD = "MiPass123!";
   ```

#### 🥈 2. db4free.net (Alternativa)

**Nota:** Este servicio puede tener problemas de disponibilidad. Usa FreeSQLDatabase.com si es posible.

**Ventajas:**
- ✅ Gratis
- ✅ No requiere tarjeta de crédito

**Pasos:**

1. **Registrarse:**
   - Ir a: https://www.db4free.net/
   - Click en "Sign up"
   - Completar el formulario:
     - Database Name: `biblioteca_tu_nombre` (ejemplo: `biblioteca_juan`)
     - Username: Tu usuario (ejemplo: `juan_usuario`)
     - Password: Tu contraseña (guárdala)
     - Email: Tu email
   - Click en "Sign up"

2. **Confirmar Email:**
   - Revisa tu correo
   - Click en el enlace de confirmación

3. **Configurar la Aplicación:**
   
   ```java
   private static final String URL = "jdbc:mysql://db4free.net:3306/biblioteca_tu_nombre";
   private static final String USER = "tu_usuario";
   private static final String PASSWORD = "tu_password";
   ```

#### 🥉 3. Railway.app (Avanzado)

**Ventajas:**
- ✅ 500 horas gratis al mes
- ✅ Mejor rendimiento
- ✅ Interfaz moderna

**Pasos:**

1. **Registrarse:**
   - Ir a: https://railway.app/
   - Sign up con GitHub
   - Click en "New Project"
   - Seleccionar "Provision MySQL"

2. **Obtener Credenciales:**
   - Click en el servicio MySQL
   - Tab "Connect"
   - Copiar:
     - MYSQL_URL (o armar con los datos individuales)
     - Host, Port, Database, Username, Password

3. **Configurar:**
   ```java
   private static final String URL = "jdbc:mysql://containers-us-west-XXX.railway.app:6789/railway";
   private static final String USER = "root";
   private static final String PASSWORD = "XXXXXXXXXXXXX";
   ```

---

## 📥 Descargar el Conector MySQL

### Opción A: Descarga Manual

1. **Descargar:**
   - Ir a: https://dev.mysql.com/downloads/connector/j/
   - Seleccionar "Platform Independent"
   - Descargar el archivo ZIP

2. **Extraer:**
   - Descomprimir el ZIP
   - Buscar el archivo `mysql-connector-j-X.X.XX.jar`

3. **Copiar al Proyecto:**
   ```powershell
   # Copiar el JAR a la carpeta Integrador
   Copy-Item "ruta\al\mysql-connector-j-X.X.XX.jar" -Destination "C:\Users\Usuario\Desktop\Projects\Practico-POO-LSI\Integrador\"
   ```

### Opción B: Maven (Avanzado)

Si usas Maven, agrega al `pom.xml`:
```xml
<dependency>
    <groupId>com.mysql</groupId>
    <artifactId>mysql-connector-j</artifactId>
    <version>8.2.0</version>
</dependency>
```

---

## ⚙️ Configurar la Aplicación

### 1. Editar DatabaseConfig.java

Abre `DatabaseConfig.java` y modifica las líneas 14-16:

```java
// ============================================
// CONFIGURACIÓN - MODIFICA ESTOS VALORES
// ============================================

// Para MySQL Local (OPCIÓN 1)
private static final String URL = "jdbc:mysql://localhost:3306/biblioteca_db";
private static final String USER = "root";
private static final String PASSWORD = "TU_PASSWORD_AQUI";

// Para MySQL en la nube (OPCIÓN 2 - Descomentar si usas la nube)
// private static final String URL = "jdbc:mysql://db4free.net:3306/tu_nombre_db";
// private static final String USER = "tu_usuario";
// private static final String PASSWORD = "tu_password";
```

### 2. Verificar Configuración

Asegúrate de:
- ✅ Reemplazar `TU_PASSWORD_AQUI` con tu contraseña real
- ✅ Reemplazar `tu_nombre_db` con el nombre de tu base de datos
- ✅ Reemplazar `tu_usuario` con tu usuario
- ✅ NO dejar espacios extra ni comillas dentro de las comillas

**❌ MAL:**
```java
private static final String PASSWORD = " mipassword "; // Espacios extra
private static final String PASSWORD = "mi password"; // Espacio en medio
```

**✅ BIEN:**
```java
private static final String PASSWORD = "mipassword123";
```

---

## 🚀 Compilar y Ejecutar

### Si tienes el JAR en la misma carpeta:

```powershell
# Navegar al directorio
cd "C:\Users\Usuario\Desktop\Projects\Practico-POO-LSI\Integrador"

# Compilar incluyendo el conector MySQL
javac -cp ".;mysql-connector-j-8.2.0.jar" *.java

# Ejecutar
java -cp ".;mysql-connector-j-8.2.0.jar" BibliotecaGUI
```

### Crear un script para facilitar (ejecutar.bat):

```batch
@echo off
echo ========================================
echo  Sistema de Gestion de Biblioteca
echo  Con Base de Datos MySQL
echo ========================================
echo.

SET MYSQL_JAR=mysql-connector-j-8.2.0.jar

if not exist %MYSQL_JAR% (
    echo ERROR: No se encontro %MYSQL_JAR%
    echo Descargalo de: https://dev.mysql.com/downloads/connector/j/
    pause
    exit /b 1
)

echo Compilando archivos...
javac -cp ".;%MYSQL_JAR%" *.java

if %errorlevel% neq 0 (
    echo.
    echo ERROR: No se pudo compilar el proyecto
    pause
    exit /b 1
)

echo.
echo Compilacion exitosa!
echo Iniciando aplicacion...
echo.
java -cp ".;%MYSQL_JAR%" BibliotecaGUI
```

---

## 🔧 Solución de Problemas

### ❌ Error: "No se encontró el driver de MySQL"

**Problema:** El archivo JAR no está en el classpath

**Solución:**
```powershell
# Verificar que el JAR existe
dir *.jar

# Si no está, descárgalo y cópialo a la carpeta
# Luego compila con:
javac -cp ".;mysql-connector-j-8.2.0.jar" *.java
```

### ❌ Error: "Access denied for user 'root'@'localhost'"

**Problema:** Contraseña incorrecta o usuario no existe

**Solución:**
1. Verifica la contraseña en MySQL:
   ```sql
   mysql -u root -p
   ```
2. Si no recuerdas la contraseña, restablécela
3. Actualiza `DatabaseConfig.java` con la contraseña correcta

### ❌ Error: "Unknown database 'biblioteca_db'"

**Problema:** La base de datos no existe

**Solución:**
```sql
-- Conectar a MySQL
mysql -u root -p

-- Crear la base de datos
CREATE DATABASE biblioteca_db;

-- Verificar
SHOW DATABASES;
```

### ❌ Error: "Communications link failure"

**Problema:** No se puede conectar al servidor MySQL

**Soluciones:**

1. **MySQL Local:**
   - Verificar que MySQL está corriendo:
     ```powershell
     # Windows
     Get-Service MySQL*
     
     # Si no está corriendo, iniciarlo:
     Start-Service MySQL80 # El nombre puede variar
     ```

2. **MySQL en la Nube:**
   - Verificar URL, puerto y credenciales
   - Verificar conexión a internet
   - Verificar firewall

### ❌ La aplicación funciona pero no guarda datos

**Problema:** La conexión a BD falló y está trabajando en memoria

**Solución:**
1. Observa los mensajes de la consola al iniciar
2. Si ves "⚠️ Modo sin Base de Datos", hay un problema de conexión
3. Revisa los pasos anteriores

### ⚠️ Advertencia: "Trabajando en modo memoria"

**Significado:** La aplicación funciona, pero los datos NO se guardan al cerrar

**Solución:** Configura correctamente la base de datos siguiendo esta guía

---

## 📊 Verificar que Funciona

### 1. Al Iniciar la Aplicación

Deberías ver en la consola:
```
✅ Conexión a la base de datos establecida
✅ Tablas de la base de datos verificadas/creadas
✅ Cargados 0 socios desde la base de datos
✅ Cargados 0 libros desde la base de datos
✅ Biblioteca cargada completamente desde la base de datos
```

Y un mensaje emergente:
```
Conectado a la base de datos
Datos cargados correctamente
```

### 2. El Título de la Ventana

Debe decir: **"Sistema de Gestión de Biblioteca [BD Activa]"**

Si dice **"[Sin BD]"**, la conexión falló.

### 3. Agregar Datos

1. Agrega un socio
2. Cierra la aplicación
3. Abre la aplicación nuevamente
4. Haz click en "Listar Socios"

**✅ Si funciona:** Verás el socio que agregaste antes
**❌ Si no funciona:** La lista estará vacía

---

## 🗃️ Ver Datos en MySQL

### Opción 1: Línea de Comandos

```sql
-- Conectar
mysql -u root -p

-- Usar la base de datos
USE biblioteca_db;

-- Ver socios
SELECT * FROM socios;

-- Ver libros
SELECT * FROM libros;

-- Ver préstamos
SELECT * FROM prestamos;
```

### Opción 2: MySQL Workbench (GUI)

1. Descargar: https://dev.mysql.com/downloads/workbench/
2. Instalar
3. Conectar a tu base de datos
4. Navegar por las tablas visualmente

### Opción 3: phpMyAdmin (Para servicios en la nube)

Algunos servicios ofrecen phpMyAdmin:
- db4free.net: https://www.db4free.net/phpMyAdmin/

---

## 🎯 Estructura de las Tablas

La aplicación crea automáticamente estas tablas:

### Tabla: `socios`
| Campo | Tipo | Descripción |
|-------|------|-------------|
| dni | INT | DNI del socio (PK) |
| nombre | VARCHAR(100) | Nombre completo |
| tipo | VARCHAR(20) | "Estudiante" o "Docente" |
| carrera_o_area | VARCHAR(100) | Carrera o Área |
| dias_prestamo | INT | Días de préstamo permitidos |

### Tabla: `libros`
| Campo | Tipo | Descripción |
|-------|------|-------------|
| id | INT | ID auto-incremental (PK) |
| titulo | VARCHAR(200) | Título del libro |
| edicion | INT | Número de edición |
| editorial | VARCHAR(100) | Editorial |
| anio | INT | Año de publicación |

### Tabla: `prestamos`
| Campo | Tipo | Descripción |
|-------|------|-------------|
| id | INT | ID auto-incremental (PK) |
| fecha_retiro | DATE | Fecha de préstamo |
| fecha_devolucion | DATE | Fecha de devolución (NULL si no devuelto) |
| socio_dni | INT | DNI del socio (FK) |
| libro_id | INT | ID del libro (FK) |

---

## 🔒 Seguridad

### ⚠️ IMPORTANTE: Contraseñas en Código

Para este proyecto educativo está bien tener la contraseña en el código, pero en proyectos reales:

**❌ NO hacer:**
- Subir código con contraseñas a GitHub
- Compartir credenciales en código

**✅ Hacer:**
- Usar variables de entorno
- Usar archivos de configuración (`.properties`)
- Agregar `.gitignore` para excluir credenciales

### Ejemplo con archivo de configuración:

`database.properties`:
```properties
db.url=jdbc:mysql://localhost:3306/biblioteca_db
db.user=root
db.password=tu_password
```

---

## 📚 Recursos Adicionales

- **MySQL Documentation:** https://dev.mysql.com/doc/
- **JDBC Tutorial:** https://docs.oracle.com/javase/tutorial/jdbc/
- **SQL Tutorial:** https://www.w3schools.com/sql/

---

## ✅ Checklist Final

Antes de ejecutar, verifica:

- [ ] MySQL instalado o servicio en la nube configurado
- [ ] Base de datos `biblioteca_db` creada (para local)
- [ ] Conector MySQL JAR descargado y en la carpeta del proyecto
- [ ] `DatabaseConfig.java` configurado con credenciales correctas
- [ ] Compilar con el JAR en el classpath
- [ ] Ejecutar con el JAR en el classpath

---

**¡Listo! Ahora tu biblioteca tiene persistencia de datos en la nube! 🎉**
