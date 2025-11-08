# 🚀 Guía Rápida: FreeSQLDatabase.com

## ⏱️ Configuración en 5 minutos

### Paso 1: Registrarse (2 minutos)

1. **Abrir el navegador** e ir a:
   ```
   https://www.freesqldatabase.com/
   ```

2. **Click** en el botón verde **"Start Free MySQL Account"**

3. **Completar el formulario**:
   ```
   Your Name:           Tu nombre completo
   Your Email:          tu_email@gmail.com  (⚠️ IMPORTANTE: Email válido)
   Database Name:       biblioteca_db       (o el nombre que prefieras)
   Username:            usuario_biblioteca  (o el usuario que prefieras)
   Password:            TuPasswordSegura123!
   Confirm Password:    TuPasswordSegura123!
   ```

4. **Marcar** "I agree to terms of service"

5. **Click** en **"Sign Up"**

6. **Mensaje de confirmación**: Verás "Account created successfully! Check your email."

---

### Paso 2: Revisar Email (1 minuto)

1. **Abrir tu correo** (Gmail, Outlook, etc.)

2. **Buscar** email de "FreeSQLDatabase" o "no-reply@freesqldatabase.com"
   - Si no lo ves, revisa la carpeta **Spam/Correo no deseado**
   - Puede tardar 1-2 minutos en llegar

3. **El email contendrá tus datos de conexión**:
   ```
   ================================
   Your MySQL Database Details
   ================================
   
   Server:          sql9.freesqldatabase.com
   Database Name:   sql9123456_biblioteca
   Database User:   sql9123456_admin
   Port Number:     3306
   Password:        TuPasswordSegura123!
   
   phpMyAdmin:      https://www.phpmyadmin.co/
   ================================
   ```

4. **⚠️ MUY IMPORTANTE**: 
   - **Copia estos datos** a un lugar seguro
   - **Guarda este email** - lo necesitarás después
   - El prefijo puede ser `sql9`, `sql10`, `sql11`, etc.

---

### Paso 3: Configurar la Aplicación (2 minutos)

1. **Abrir** el archivo `DatabaseConfig.java` en tu editor

2. **Buscar** las líneas 14-16 (sección de configuración)

3. **Comentar** las líneas de MySQL Local:
   ```java
   // Para MySQL Local - COMENTAR ESTAS LÍNEAS:
   // private static final String URL = "jdbc:mysql://localhost:3306/biblioteca_db";
   // private static final String USER = "root";
   // private static final String PASSWORD = "";
   ```

4. **Descomentar y configurar** con TUS datos del email:
   ```java
   // Para MySQL en la nube con FreeSQLDatabase.com:
   private static final String URL = "jdbc:mysql://sql9.freesqldatabase.com:3306/sql9123456_biblioteca";
   private static final String USER = "sql9123456_admin";
   private static final String PASSWORD = "TuPasswordSegura123!";
   ```

5. **⚠️ REEMPLAZAR**:
   - `sql9.freesqldatabase.com` → Tu servidor del email
   - `sql9123456_biblioteca` → Tu database name del email
   - `sql9123456_admin` → Tu database user del email
   - `TuPasswordSegura123!` → Tu password del email

6. **Guardar** el archivo (Ctrl + S)

---

### Paso 4: Descargar MySQL Connector (Si no lo tienes)

1. **Ir a**:
   ```
   https://dev.mysql.com/downloads/connector/j/
   ```

2. **Seleccionar**: "Platform Independent"

3. **Descargar**: El archivo ZIP (mysql-connector-j-X.X.XX.zip)

4. **Extraer** el ZIP

5. **Buscar** el archivo `mysql-connector-j-X.X.XX.jar`

6. **Copiar** el JAR a la carpeta `Integrador`:
   ```powershell
   Copy-Item "ruta\del\mysql-connector-j-8.2.0.jar" -Destination "C:\Users\Usuario\Desktop\Projects\Practico-POO-LSI\Integrador\"
   ```

---

### Paso 5: Compilar y Ejecutar

#### Opción A: Usando el script (MÁS FÁCIL)

```powershell
cd "C:\Users\Usuario\Desktop\Projects\Practico-POO-LSI\Integrador"
.\ejecutar.bat
```

#### Opción B: Manual

```powershell
# Ir al directorio
cd "C:\Users\Usuario\Desktop\Projects\Practico-POO-LSI\Integrador"

# Compilar
javac -cp ".;mysql-connector-j-8.2.0.jar" *.java

# Ejecutar
java -cp ".;mysql-connector-j-8.2.0.jar" BibliotecaGUI
```

---

## ✅ Verificar que Funciona

### 1. Al Iniciar

**Consola debe mostrar:**
```
✅ Conexión a la base de datos establecida
✅ Tablas de la base de datos verificadas/creadas
✅ Cargados 0 socios desde la base de datos
✅ Cargados 0 libros desde la base de datos
✅ Biblioteca cargada completamente desde la base de datos
```

**Ventana emergente:**
```
✓ Conectado a la base de datos
  Datos cargados correctamente
```

### 2. Título de la Ventana

Debe decir: **"Sistema de Gestión de Biblioteca [BD Activa]"**

✅ Si dice **[BD Activa]** → ¡Funciona!
❌ Si dice **[Sin BD]** → Hay un problema de configuración

### 3. Prueba Real

1. **Agregar un socio**:
   - Click en "👤 Agregar Socio"
   - Tipo: Estudiante
   - DNI: 12345678
   - Nombre: Juan Pérez
   - Carrera: Ingeniería
   - Guardar

2. **Cerrar** la aplicación completamente

3. **Abrir** la aplicación nuevamente

4. **Click** en "👥 Listar Socios"

5. **✅ Si funciona**: Verás a "Juan Pérez" en la lista
   **❌ Si no funciona**: La lista estará vacía → Revisar configuración

---

## 🔍 Ver tus Datos en phpMyAdmin

### Opción: Usar phpMyAdmin Web

1. **Ir a**: https://www.phpmyadmin.co/

2. **Login con tus datos del email**:
   ```
   Server:     sql9.freesqldatabase.com  (tu servidor)
   Username:   sql9123456_admin          (tu usuario)
   Password:   TuPasswordSegura123!       (tu password)
   ```

3. **Click** en "Go"

4. **En el panel izquierdo**: Verás tu base de datos

5. **Click** en las tablas para ver los datos:
   - `socios` → Ver todos los socios
   - `libros` → Ver todos los libros
   - `prestamos` → Ver todos los préstamos

---

## 🐛 Solución de Problemas

### ❌ "No se encontró el driver de MySQL"

**Problema**: Falta el archivo JAR del conector

**Solución**:
1. Descargar de: https://dev.mysql.com/downloads/connector/j/
2. Copiar el JAR a la carpeta Integrador
3. Compilar con: `javac -cp ".;mysql-connector-j-8.2.0.jar" *.java`

---

### ❌ "Access denied for user"

**Problema**: Credenciales incorrectas en `DatabaseConfig.java`

**Solución**:
1. Revisar el email de FreeSQLDatabase
2. Copiar EXACTAMENTE:
   - Database User (ejemplo: `sql9123456_admin`)
   - Password (tu password exacta)
3. Verificar que no haya espacios extra
4. Asegurarse de que las comillas estén correctas

**Ejemplo CORRECTO**:
```java
private static final String USER = "sql9123456_admin";  // ✅
private static final String PASSWORD = "MyPass123!";     // ✅
```

**Ejemplo INCORRECTO**:
```java
private static final String USER = " sql9123456_admin "; // ❌ espacios
private static final String PASSWORD = "MyPass123! ";    // ❌ espacio al final
```

---

### ❌ "Unknown database"

**Problema**: Nombre de base de datos incorrecto

**Solución**:
1. Revisar el email - buscar "Database Name"
2. Copiar el nombre COMPLETO (ejemplo: `sql9123456_biblioteca`)
3. Actualizar en `DatabaseConfig.java`:
   ```java
   private static final String URL = "jdbc:mysql://sql9.freesqldatabase.com:3306/sql9123456_biblioteca";
   //                                                                               ↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑
   //                                                                          Nombre COMPLETO con prefijo
   ```

---

### ❌ "Communications link failure"

**Problema**: No puede conectar al servidor

**Soluciones posibles**:

1. **Verificar conexión a internet**:
   ```powershell
   ping sql9.freesqldatabase.com
   ```
   Debe responder. Si no, verifica tu internet.

2. **Verificar el servidor correcto**:
   - Revisar el email
   - Puede ser `sql9`, `sql10`, `sql11`, etc.
   - Usar EXACTAMENTE el que recibiste

3. **Verificar firewall**:
   - El firewall puede estar bloqueando el puerto 3306
   - Temporalmente desactiva el firewall para probar

4. **Probar en phpMyAdmin primero**:
   - Si funciona en phpMyAdmin, el servidor está bien
   - El problema está en tu configuración Java

---

### ⚠️ "Modo sin Base de Datos"

**Problema**: La aplicación funciona pero no se conectó a la BD

**Qué hacer**:

1. **Leer la consola** al iniciar - mostrará el error exacto

2. **Verificar los 3 pasos**:
   - [ ] ¿El JAR está en la carpeta?
   - [ ] ¿DatabaseConfig.java tiene los datos correctos?
   - [ ] ¿Compilaste con el JAR en el classpath?

3. **Prueba manual**:
   ```powershell
   # Verificar que el JAR existe
   ls mysql-connector-j-*.jar
   
   # Si existe, compilar correctamente
   javac -cp ".;mysql-connector-j-8.2.0.jar" DatabaseConfig.java
   javac -cp ".;mysql-connector-j-8.2.0.jar" BibliotecaDAO.java
   javac -cp ".;mysql-connector-j-8.2.0.jar" BibliotecaGUI.java
   
   # Ejecutar
   java -cp ".;mysql-connector-j-8.2.0.jar" BibliotecaGUI
   ```

---

## 📋 Checklist Final

Antes de ejecutar, verifica:

- [ ] Registrado en FreeSQLDatabase.com
- [ ] Email recibido con los datos de conexión
- [ ] Datos guardados en lugar seguro
- [ ] MySQL Connector JAR descargado
- [ ] JAR copiado a la carpeta Integrador
- [ ] DatabaseConfig.java editado con TUS datos exactos
- [ ] Sin espacios extra en las credenciales
- [ ] Servidor correcto (sql9, sql10, etc.)
- [ ] Database Name completo con prefijo
- [ ] Password exacta del email
- [ ] Compilado con el JAR en classpath
- [ ] Ejecutado con el JAR en classpath

---

## 🎉 ¡Listo!

Si seguiste todos los pasos, tu aplicación ahora tiene:

✅ **Persistencia de datos** en la nube
✅ **Acceso desde cualquier lugar** con internet
✅ **Datos seguros** en servidores de FreeSQLDatabase
✅ **Gratis** y sin límite de tiempo
✅ **Panel web** para ver tus datos

---

## 📞 ¿Necesitas Ayuda?

Si algo no funciona:

1. **Revisa la consola** - el error exacto está ahí
2. **Verifica el email** - los datos son los correctos
3. **Prueba en phpMyAdmin** - si funciona ahí, el servidor está bien
4. **Lee la sección de problemas** arriba
5. **Revisa [GUIA_BASE_DATOS.md](GUIA_BASE_DATOS.md)** - guía completa

---

**¡Tu biblioteca en la nube está lista!** 🚀📚
