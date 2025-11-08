# 🚀 Guía Rápida: PostgreSQL en Render.com

## ✅ Tu configuración ya está lista!

Los datos de tu base de datos Render ya están configurados en `DatabaseConfig.java`. Solo necesitas el driver PostgreSQL para que funcione.

---

## 📦 Paso 1: Descargar el Driver PostgreSQL (2 minutos)

### Opción A: Descarga Directa (Recomendado)

1. **Ir a**: https://jdbc.postgresql.org/download/

2. **Buscar**: "PostgreSQL JDBC 4.2 Driver, 42.7.1"

3. **Descargar**: Click en `postgresql-42.7.1.jar`

4. **Copiar** el archivo a tu carpeta del proyecto:
   ```powershell
   # Copiar el JAR descargado a la carpeta Integrador
   Copy-Item "C:\Users\Usuario\Downloads\postgresql-42.7.1.jar" -Destination "C:\Users\Usuario\Desktop\Projects\Practico-POO-LSI\Integrador\"
   ```

### Opción B: Descarga desde Maven Central

1. **Ir a**: https://repo1.maven.org/maven2/org/postgresql/postgresql/42.7.1/

2. **Descargar**: Click en `postgresql-42.7.1.jar`

3. **Copiar** a la carpeta Integrador

---

## 🔧 Paso 2: Compilar y Ejecutar

### Método 1: Usar el Script (MÁS FÁCIL)

```powershell
cd "C:\Users\Usuario\Desktop\Projects\Practico-POO-LSI\Integrador"
.\ejecutar.bat
```

### Método 2: Manual

```powershell
# Ir al directorio
cd "C:\Users\Usuario\Desktop\Projects\Practico-POO-LSI\Integrador"

# Compilar con PostgreSQL driver
javac -cp ".;postgresql-42.7.1.jar" *.java

# Ejecutar
java -cp ".;postgresql-42.7.1.jar" BibliotecaGUI
```

---

## ✅ Verificar que Funciona

### 1. Al Iniciar la Aplicación

**Consola debe mostrar:**
```
✅ Conexión a PostgreSQL establecida
📍 Servidor: dpg-d47ogbripnbc73d1mcs0-a.oregon-postgres.render.com
📊 Base de datos: gestionbiblioteca_inwl
✅ Tablas de PostgreSQL verificadas/creadas
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
❌ Si dice **[Sin BD]** → Revisar configuración

### 3. Prueba Real

1. **Agregar un socio**:
   - Click en "👤 Agregar Socio"
   - Tipo: Estudiante
   - DNI: 12345678
   - Nombre: Juan Pérez
   - Carrera: Ingeniería
   - Guardar

2. **Cerrar** la aplicación

3. **Abrir** la aplicación nuevamente

4. **Click** en "👥 Listar Socios"

5. **✅ Si funciona**: Juan Pérez sigue ahí
   **❌ Si no funciona**: La lista está vacía → Revisar logs

---

## 📊 Tus Datos de Conexión (YA CONFIGURADOS)

```
Servidor:   dpg-d47ogbripnbc73d1mcs0-a.oregon-postgres.render.com
Puerto:     5432
Base de datos: gestionbiblioteca_inwl
Usuario:    santiago
Password:   X1hn47dyD7MZMIMDAsDg1uOndA2PuboY
```

Estos datos **ya están en `DatabaseConfig.java`** - no necesitas cambiar nada.

---

## 🗄️ Ver tus Datos en Render

### Opción 1: Dashboard de Render

1. **Ir a**: https://dashboard.render.com/

2. **Login** con tu cuenta

3. **Seleccionar** tu base de datos PostgreSQL

4. **Click** en "Connect" → "External Connection"

5. Puedes usar:
   - **pgAdmin** (herramienta gráfica)
   - **psql** (línea de comandos)
   - **DBeaver** (multiplataforma)

### Opción 2: psql (Línea de Comandos)

Si tienes PostgreSQL instalado localmente:

```powershell
# Usar el comando PSQL de Render
$env:PGPASSWORD="X1hn47dyD7MZMIMDAsDg1uOndA2PuboY"
psql -h dpg-d47ogbripnbc73d1mcs0-a.oregon-postgres.render.com -U santiago gestionbiblioteca_inwl
```

Luego puedes ejecutar:
```sql
-- Ver todas las tablas
\dt

-- Ver socios
SELECT * FROM socios;

-- Ver libros
SELECT * FROM libros;

-- Ver préstamos
SELECT * FROM prestamos;
```

### Opción 3: DBeaver (Recomendado - Interfaz Gráfica)

1. **Descargar** DBeaver: https://dbeaver.io/download/

2. **Instalar** y abrir

3. **Nueva Conexión** → PostgreSQL

4. **Configurar**:
   ```
   Host: dpg-d47ogbripnbc73d1mcs0-a.oregon-postgres.render.com
   Port: 5432
   Database: gestionbiblioteca_inwl
   Username: santiago
   Password: X1hn47dyD7MZMIMDAsDg1uOndA2PuboY
   ```

5. **Test Connection** → OK

6. **Finish** y explorar tus datos visualmente

---

## 🔍 Estructura de las Tablas PostgreSQL

### Tabla: `socios`
```sql
CREATE TABLE socios (
    dni INTEGER PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    tipo VARCHAR(20) NOT NULL,
    carrera_o_area VARCHAR(100),
    dias_prestamo INTEGER NOT NULL
);
```

### Tabla: `libros`
```sql
CREATE TABLE libros (
    id SERIAL PRIMARY KEY,          -- Auto-increment en PostgreSQL
    titulo VARCHAR(200) NOT NULL,
    edicion INTEGER NOT NULL,
    editorial VARCHAR(100) NOT NULL,
    anio INTEGER NOT NULL
);
```

### Tabla: `prestamos`
```sql
CREATE TABLE prestamos (
    id SERIAL PRIMARY KEY,
    fecha_retiro DATE NOT NULL,
    fecha_devolucion DATE,
    socio_dni INTEGER NOT NULL,
    libro_id INTEGER NOT NULL,
    FOREIGN KEY (socio_dni) REFERENCES socios(dni) ON DELETE CASCADE,
    FOREIGN KEY (libro_id) REFERENCES libros(id) ON DELETE CASCADE
);
```

---

## 🐛 Solución de Problemas

### ❌ "No se encontró el driver de PostgreSQL"

**Solución:**
1. Descargar: https://jdbc.postgresql.org/download/
2. Copiar `postgresql-42.7.1.jar` a la carpeta Integrador
3. Verificar: `dir postgresql-*.jar`
4. Compilar: `javac -cp ".;postgresql-42.7.1.jar" *.java`

---

### ❌ "The connection attempt failed"

**Causas posibles:**

1. **Sin internet**
   - Verifica tu conexión
   - Render requiere internet para conectar

2. **Firewall bloqueando el puerto 5432**
   - Temporalmente desactiva el firewall para probar
   - O agrega excepción para Java

3. **Base de datos en Render pausada** (plan gratuito)
   - Render pausa las BD gratuitas después de 90 días de inactividad
   - Solución: Ir al dashboard y reactivarla

---

### ❌ "password authentication failed for user 'santiago'"

**Solución:**
- Verifica que la password en `DatabaseConfig.java` sea exactamente:
  ```java
  private static final String PASSWORD = "X1hn47dyD7MZMIMDAsDg1uOndA2PuboY";
  ```
- Sin espacios extra, sin caracteres especiales adicionales

---

### ❌ "FATAL: database 'gestionbiblioteca_inwl' does not exist"

**Solución:**
- Verifica que el nombre de la base de datos sea correcto:
  ```java
  private static final String DATABASE = "gestionbiblioteca_inwl";
  ```

---

### ⚠️ "Modo sin Base de Datos"

**Solución:**
1. Verificar que el JAR de PostgreSQL esté en la carpeta
2. Compilar con: `javac -cp ".;postgresql-42.7.1.jar" *.java`
3. Ejecutar con: `java -cp ".;postgresql-42.7.1.jar" BibliotecaGUI`
4. Leer los logs de la consola para ver el error exacto

---

## 🎯 Ventajas de Render + PostgreSQL

✅ **PostgreSQL**: Base de datos más robusta y profesional
✅ **Render**: Más confiable que servicios gratuitos de MySQL
✅ **SSL**: Conexión segura automática
✅ **750 horas gratis/mes**: Suficiente para desarrollo
✅ **No se pausa**: Se mantiene activa con uso regular
✅ **Backups automáticos**: En planes pagos
✅ **Dashboard**: Interfaz web profesional
✅ **Escalable**: Puedes actualizar cuando necesites

---

## 📝 Diferencias MySQL vs PostgreSQL

### Sintaxis SQL

**Auto-increment:**
- MySQL: `id INT AUTO_INCREMENT PRIMARY KEY`
- PostgreSQL: `id SERIAL PRIMARY KEY` ✅

**Tipos de datos:**
- MySQL: `INT`, `VARCHAR`
- PostgreSQL: `INTEGER`, `VARCHAR` ✅

**Conexión:**
- MySQL: `jdbc:mysql://host:3306/db`
- PostgreSQL: `jdbc:postgresql://host:5432/db?sslmode=require` ✅

### Driver

**MySQL:**
- Driver: `com.mysql.cj.jdbc.Driver`
- JAR: `mysql-connector-j-8.2.0.jar`

**PostgreSQL:** ✅
- Driver: `org.postgresql.Driver`
- JAR: `postgresql-42.7.1.jar`

---

## 📚 Recursos Adicionales

### Documentación
- **PostgreSQL JDBC**: https://jdbc.postgresql.org/documentation/
- **Render Docs**: https://render.com/docs/databases
- **PostgreSQL**: https://www.postgresql.org/docs/

### Herramientas
- **DBeaver** (GUI): https://dbeaver.io/
- **pgAdmin** (GUI): https://www.pgadmin.org/
- **TablePlus** (GUI): https://tableplus.com/

### Tutoriales
- **SQL Tutorial**: https://www.postgresql.org/docs/current/tutorial.html
- **JDBC Tutorial**: https://docs.oracle.com/javase/tutorial/jdbc/

---

## ✅ Checklist Final

Antes de ejecutar:

- [ ] Driver PostgreSQL descargado (`postgresql-42.7.1.jar`)
- [ ] JAR copiado a la carpeta Integrador
- [ ] `DatabaseConfig.java` tiene tus datos de Render (ya está configurado)
- [ ] Conexión a internet activa
- [ ] Compilar con: `javac -cp ".;postgresql-42.7.1.jar" *.java`
- [ ] Ejecutar con: `java -cp ".;postgresql-42.7.1.jar" BibliotecaGUI`
- [ ] O usar: `.\ejecutar.bat`

---

## 🎉 ¡Listo!

Tu aplicación está configurada para usar **PostgreSQL en Render**:

✅ Base de datos en la nube profesional
✅ Gratis (750 horas/mes)
✅ Más confiable que MySQL gratuito
✅ Conexión segura con SSL
✅ Dashboard web para administración

**¡Tu biblioteca con PostgreSQL en la nube está lista!** 🚀📚☁️

---

## 📞 Soporte

Si tienes problemas:
1. **Lee los logs de la consola** - el error estará ahí
2. **Verifica el checklist** de arriba
3. **Prueba con DBeaver** - si funciona ahí, el servidor está bien
4. **Revisa el dashboard de Render** - asegúrate que la BD esté activa
