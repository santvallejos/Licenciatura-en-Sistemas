import java.sql.*;

/**
 * Clase de configuración para la conexión a la base de datos PostgreSQL.
 * Maneja la conexión y creación de tablas necesarias.
 * 
 * IMPORTANTE: Esta configuración usa PostgreSQL (NO MySQL).
 * Compatible con servicios en la nube como Render, Railway, Supabase, etc.
 * 
 * @version 2.0 - PostgreSQL
 */
public class DatabaseConfig {
    
    // ============================================
    // CONFIGURACIÓN POSTGRESQL - RENDER.COM
    // ============================================
    
    // Datos de conexión de Render PostgreSQL
    // IMPORTANTE: Reemplaza con TUS credenciales de Render
    private static final String HOST = "dpg-d47ogbripnbc73d1mcs0-a.oregon-postgres.render.com";
    private static final String PORT = "5432";
    private static final String DATABASE = "gestionbiblioteca_inwl";
    private static final String USER = "santiago";
    private static final String PASSWORD = "X1hn47dyD7MZMIMDAsDg1uOndA2PuboY";
    
    // URL de conexión PostgreSQL (construida automáticamente)
    private static final String URL = "jdbc:postgresql://" + HOST + ":" + PORT + "/" + DATABASE;
    
    // ============================================
    // NOTAS IMPORTANTES:
    // 1. Este código usa PostgreSQL (NO MySQL)
    // 2. Necesitas el driver PostgreSQL JDBC
    // 3. Descarga desde: https://jdbc.postgresql.org/download/
    // 4. O usa: postgresql-42.7.1.jar (u otra versión)
    // ============================================
    
    private static Connection connection = null;
    
    /**
     * Obtiene una conexión a la base de datos PostgreSQL.
     * Si no existe, la crea.
     * 
     * @return Connection - Conexión activa a la base de datos
     * @throws SQLException si hay error en la conexión
     */
    public static Connection getConnection() throws SQLException {
        if (connection == null || connection.isClosed()) {
            try {
                // Cargar el driver de PostgreSQL
                Class.forName("org.postgresql.Driver");
                
                // Establecer la conexión con SSL (requerido por Render)
                String urlWithSSL = URL + "?sslmode=require";
                connection = DriverManager.getConnection(urlWithSSL, USER, PASSWORD);
                
                System.out.println("✅ Conexión a PostgreSQL establecida");
                System.out.println("📍 Servidor: " + HOST);
                System.out.println("📊 Base de datos: " + DATABASE);
                
                // Crear las tablas si no existen
                crearTablas();
                
            } catch (ClassNotFoundException e) {
                System.err.println("❌ ERROR: No se encontró el driver de PostgreSQL");
                System.err.println("Descarga el conector desde: https://jdbc.postgresql.org/download/");
                System.err.println("Necesitas: postgresql-42.7.1.jar (o versión superior)");
                throw new SQLException("Driver de PostgreSQL no encontrado", e);
            } catch (SQLException e) {
                System.err.println("❌ ERROR: No se pudo conectar a PostgreSQL");
                System.err.println("Verifica:");
                System.err.println("  1. Que las credenciales sean correctas");
                System.err.println("  2. Que tengas conexión a internet");
                System.err.println("  3. Que el servicio Render esté activo");
                System.err.println("  4. Que el driver PostgreSQL esté en el classpath");
                throw e;
            }
        }
        return connection;
    }
    
    /**
     * Crea las tablas necesarias en PostgreSQL si no existen.
     * PostgreSQL usa sintaxis ligeramente diferente a MySQL.
     */
    private static void crearTablas() {
        try {
            Statement stmt = connection.createStatement();
            
            // Tabla de Socios
            String sqlSocios = 
                "CREATE TABLE IF NOT EXISTS socios (" +
                "dni INTEGER PRIMARY KEY," +
                "nombre VARCHAR(100) NOT NULL," +
                "tipo VARCHAR(20) NOT NULL," +  // 'Estudiante' o 'Docente'
                "carrera_o_area VARCHAR(100)," + // Carrera para Estudiante, Área para Docente
                "dias_prestamo INTEGER NOT NULL" +
                ")";
            stmt.executeUpdate(sqlSocios);
            
            // Tabla de Libros
            String sqlLibros = 
                "CREATE TABLE IF NOT EXISTS libros (" +
                "id SERIAL PRIMARY KEY," +  // SERIAL es el auto-increment de PostgreSQL
                "titulo VARCHAR(200) NOT NULL," +
                "edicion INTEGER NOT NULL," +
                "editorial VARCHAR(100) NOT NULL," +
                "anio INTEGER NOT NULL" +
                ")";
            stmt.executeUpdate(sqlLibros);
            
            // Tabla de Préstamos
            String sqlPrestamos = 
                "CREATE TABLE IF NOT EXISTS prestamos (" +
                "id SERIAL PRIMARY KEY," +
                "fecha_retiro DATE NOT NULL," +
                "fecha_devolucion DATE," +
                "socio_dni INTEGER NOT NULL," +
                "libro_id INTEGER NOT NULL," +
                "FOREIGN KEY (socio_dni) REFERENCES socios(dni) ON DELETE CASCADE," +
                "FOREIGN KEY (libro_id) REFERENCES libros(id) ON DELETE CASCADE" +
                ")";
            stmt.executeUpdate(sqlPrestamos);
            
            System.out.println("✅ Tablas de PostgreSQL verificadas/creadas");
            
            stmt.close();
            
        } catch (SQLException e) {
            System.err.println("❌ ERROR al crear las tablas: " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    /**
     * Cierra la conexión a la base de datos.
     */
    public static void closeConnection() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
                System.out.println("✅ Conexión a la base de datos cerrada");
            }
        } catch (SQLException e) {
            System.err.println("❌ ERROR al cerrar la conexión: " + e.getMessage());
        }
    }
    
    /**
     * Verifica si hay conexión a la base de datos.
     * 
     * @return true si hay conexión activa, false en caso contrario
     */
    public static boolean isConnected() {
        try {
            return connection != null && !connection.isClosed();
        } catch (SQLException e) {
            return false;
        }
    }
    
    /**
     * Prueba la conexión a la base de datos.
     * Útil para verificar la configuración.
     * 
     * @return true si la conexión es exitosa, false en caso contrario
     */
    public static boolean testConnection() {
        try {
            Connection conn = getConnection();
            return conn != null && !conn.isClosed();
        } catch (SQLException e) {
            System.err.println("❌ Prueba de conexión fallida: " + e.getMessage());
            return false;
        }
    }
}
