import java.sql.*;
import java.util.*;

/**
 * Data Access Object (DAO) para gestionar las operaciones de base de datos.
 * Proporciona métodos para guardar, recuperar, actualizar y eliminar datos.
 * 
 * CRUD = Create, Read, Update, Delete
 * 
 * @version 1.0
 */
public class BibliotecaDAO {
    // ==========================================
    // MÉTODOS PARA SOCIOS
    // ==========================================
    
    /**
     * Guarda un socio en la base de datos.
     * 
     * @param socio El socio a guardar
     * @return true si se guardó correctamente, false en caso contrario
     */
    public boolean guardarSocio(Socio socio)
    {
        String sql = "INSERT INTO socios (dni, nombre, tipo, carrera_o_area, dias_prestamo) " +
                     "VALUES (?, ?, ?, ?, ?)"; // Consulta para insertar un socio
        
        try (Connection conn = DatabaseConfig.getConnection();
                PreparedStatement consulta = conn.prepareStatement(sql)) 
            {

            // Configurar parámetros de la consulta
            consulta.setInt(1, socio.getDni());
            consulta.setString(2, socio.getNombre());
            consulta.setString(3, socio.soyDeLaClase());

            if (socio instanceof Estudiante) // Si es estudiante
            {
                consulta.setString(4, ((Estudiante) socio).getCarrera()); // Castear a Estudiante y obtener carrera
            }
            else if (socio instanceof Docente)
            {
                consulta.setString(4, ((Docente) socio).getArea()); // Castear a Docente y obtener área
            }

            consulta.setInt(5, socio.getDiasPrestamo());

            int filasAfectadas = consulta.executeUpdate();// Ejecutar la consulta
            return filasAfectadas > 0; // Retornar true si se insertó al menos una fila
            
        }
        catch (SQLException e)
        {
            System.err.println("❌ Error al guardar socio: " + e.getMessage());
            return false;
        }
    }

    /**
     * Obtiene todos los socios de la base de datos.
     * 
     * @return HashMap con DNI como clave y Socio como valor
     */
    public HashMap<Integer, Socio> obtenerTodosSocios() {
        HashMap<Integer, Socio> socios = new HashMap<>(); // Mapa para almacenar socios con DNI como clave
        String sql = "SELECT * FROM socios"; // Consulta para obtener todos los socios de la tabla "socios"

        try (Connection conn = DatabaseConfig.getConnection();
                Statement stmt = conn.createStatement();
                ResultSet consulta = stmt.executeQuery(sql))
            {

            while (consulta.next())
            {
                // Obtener datos del socio desde el ResultSet
                int dni = consulta.getInt("dni");
                String nombre = consulta.getString("nombre");
                String tipo = consulta.getString("tipo");
                String carreraOArea = consulta.getString("carrera_o_area");

                Socio socio;
                if (tipo.equals("Estudiante"))
                {
                    socio = new Estudiante(dni, nombre, carreraOArea);
                }
                else
                {
                    socio = new Docente(dni, nombre, carreraOArea);
                }

                socios.put(dni, socio); // Agregar socio al diccionario
            }

            System.out.println("✅ Cargados " + socios.size() + " socios desde la base de datos");

        }
        catch (SQLException e)
        {
            System.err.println("❌ Error al obtener socios: " + e.getMessage());
        }
        return socios;
    }

    /**
     * Busca un socio por DNI en la base de datos.
     * 
     * @param dni DNI del socio a buscar
     * @return El socio encontrado o null si no existe
     */
    public Socio buscarSocio(int dni)
    {
        String sql = "SELECT * FROM socios WHERE dni = ?"; // Consulta para buscar un socio por DNI

        try (Connection conn = DatabaseConfig.getConnection();
                PreparedStatement consulta = conn.prepareStatement(sql))
            {

            consulta.setInt(1, dni);
            ResultSet resultado = consulta.executeQuery();

            if (resultado.next())
            {
                String nombre = resultado.getString("nombre");
                String tipo = resultado.getString("tipo");
                String carreraOArea = resultado.getString("carrera_o_area");

                if (tipo.equals("Estudiante"))
                {
                    return new Estudiante(dni, nombre, carreraOArea);
                }
                else
                {
                    return new Docente(dni, nombre, carreraOArea);
                }
            }
        }
        catch (SQLException e)
        {
            System.err.println("❌ Error al buscar socio: " + e.getMessage());
        }
        return null;
    }

    /**
     * Elimina un socio de la base de datos.
     * 
     * @param dni DNI del socio a eliminar
     * @return true si se eliminó correctamente, false en caso contrario
     */
    public boolean eliminarSocio(int dni)
    {
        String sql = "DELETE FROM socios WHERE dni = ?"; // Consulta para eliminar un socio por su DNI
        
        try (Connection conn = DatabaseConfig.getConnection();
                PreparedStatement consulta = conn.prepareStatement(sql))
            {

            consulta.setInt(1, dni);
            int filasAfectadas = consulta.executeUpdate();
            return filasAfectadas > 0;

        }
        catch (SQLException e)
        {
            System.err.println("❌ Error al eliminar socio: " + e.getMessage());
            return false;
        }
    }

    // ==========================================
    // MÉTODOS PARA LIBROS
    // ==========================================

    /**
     * Guarda un libro en la base de datos.
     * 
     * @param libro El libro a guardar
     * @return El ID generado para el libro, o -1 si hubo error
     */
    public int guardarLibro(Libro libro)
    {
        String sql = "INSERT INTO libros (titulo, edicion, editorial, anio) VALUES (?, ?, ?, ?)"; // Consulta para insertar un libro
        
        try (Connection conn = DatabaseConfig.getConnection();
                PreparedStatement consulta = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS))
            {

            // Configurar parámetros de la consulta
            consulta.setString(1, libro.getTitulo());
            consulta.setInt(2, libro.getEdicion());
            consulta.setString(3, libro.getEditorial());
            consulta.setInt(4, libro.getAnio());

            int filasAfectadas = consulta.executeUpdate(); // Ejecutar la consulta

            if (filasAfectadas > 0)
            {
                // Obtener el ID generado
                ResultSet respuesta = consulta.getGeneratedKeys();
                if (respuesta.next())
                {
                    return respuesta.getInt(1);
                }
            }
        }
        catch (SQLException e)
        {
            System.err.println("❌ Error al guardar libro: " + e.getMessage());
        }
        return -1;
    }

    /**
     * Obtiene todos los libros de la base de datos.
     * 
     * @return Set con todos los libros
     */
    public Set<Libro> obtenerTodosLibros()
    {
        Set<Libro> libros = new HashSet<>(); // Set para almacenar los libros
        String sql = "SELECT * FROM libros"; // Consulta para obtener todos los libros de la tabla "libros"
        
        try (Connection conn = DatabaseConfig.getConnection();
                Statement stmt = conn.createStatement();
                ResultSet respuesta = stmt.executeQuery(sql))
            {

            while (respuesta.next())
            {
                String titulo = respuesta.getString("titulo");
                int edicion = respuesta.getInt("edicion");
                String editorial = respuesta.getString("editorial");
                int anio = respuesta.getInt("anio");
                
                Libro libro = new Libro(titulo, edicion, editorial, anio);
                libros.add(libro);// Agregar cada libro a la colección
            }

            System.out.println("✅ Cargados " + libros.size() + " libros desde la base de datos");
        }
        catch (SQLException e)
        {
            System.err.println("❌ Error al obtener libros: " + e.getMessage());
        }

        return libros;
    }

    /**
     * Busca un libro por su título.
     * 
     * @param titulo Título del libro a buscar
     * @return El libro encontrado o null si no existe
     */
    public Libro buscarLibroPorTitulo(String titulo)
    {
        String sql = "SELECT * FROM libros WHERE titulo = ?"; // Consulta para buscar un libro por título

        try (Connection conn = DatabaseConfig.getConnection();
                PreparedStatement consulta = conn.prepareStatement(sql))
            {

            consulta.setString(1, titulo);
            ResultSet respuesta = consulta.executeQuery(); // Ejecutar la consulta

            if (respuesta.next())
            {
                int edicion = respuesta.getInt("edicion");
                String editorial = respuesta.getString("editorial");
                int anio = respuesta.getInt("anio");

                return new Libro(titulo, edicion, editorial, anio);
            }
        }
        catch (SQLException e)
        {
            System.err.println("❌ Error al buscar libro: " + e.getMessage());
        }

        return null;
    }
    
    /**
     * Obtiene el ID de un libro por su título.
     * 
     * @param titulo Título del libro
     * @return El ID del libro o -1 si no existe
     */
    public int obtenerIdLibro(String titulo)
    {
        String sql = "SELECT id FROM libros WHERE titulo = ?"; // Obtener ID del libro por título

        try (Connection conn = DatabaseConfig.getConnection();
                PreparedStatement consulta = conn.prepareStatement(sql))
            {

            consulta.setString(1, titulo);
            ResultSet respuesta = consulta.executeQuery();

            if (respuesta.next())
            {
                return respuesta.getInt("id");
            }
        }
        catch (SQLException e)
        {
            System.err.println("❌ Error al obtener ID del libro: " + e.getMessage());
        }

        return -1;
    }

    /**
     * Elimina un libro de la base de datos.
     * 
     * @param titulo Título del libro a eliminar
     * @return true si se eliminó correctamente, false en caso contrario
     */
    public boolean eliminarLibro(String titulo)
    {
        String sql = "DELETE FROM libros WHERE titulo = ?"; // Consulta para eliminar un libro por su título
        
        try (Connection conn = DatabaseConfig.getConnection();
                PreparedStatement consulta = conn.prepareStatement(sql))
            {

            consulta.setString(1, titulo);
            int filasAfectadas = consulta.executeUpdate();
            return filasAfectadas > 0;
        }
        catch (SQLException e)
        {
            System.err.println("❌ Error al eliminar libro: " + e.getMessage());
            return false;
        }
    }
    
    // ==========================================
    // MÉTODOS PARA PRÉSTAMOS
    // ==========================================
    
    /**
     * Guarda un préstamo en la base de datos.
     * 
     * @param prestamo El préstamo a guardar
     * @param libroTitulo Título del libro prestado
     * @return true si se guardó correctamente, false en caso contrario
     */
    public boolean guardarPrestamo(Prestamo prestamo, String libroTitulo)
    {
        String sqlGetLibroId = "SELECT id FROM libros WHERE titulo = ?"; // Obtener ID del libro por título
        String sqlInsertPrestamo = "INSERT INTO prestamos (fecha_retiro, fecha_devolucion, socio_dni, libro_id) " + "VALUES (?, ?, ?, ?)"; // Consulta para insertar un préstamo
        
        try (Connection conn = DatabaseConfig.getConnection())
            {

            // Primero, obtener el ID del libro
            int libroId = -1;
            try (PreparedStatement consultaLibro = conn.prepareStatement(sqlGetLibroId))
            {
                consultaLibro.setString(1, libroTitulo);
                ResultSet respuesta = consultaLibro.executeQuery();

                if (respuesta.next())
                {
                    libroId = respuesta.getInt("id");
                }
            }

            if (libroId == -1)
            {
                System.err.println("❌ No se encontró el libro para guardar el préstamo");
                return false;
            }

            // Ahora insertar el préstamo
            try (PreparedStatement consultaPrestamo = conn.prepareStatement(sqlInsertPrestamo))
            {
                // Convertir Calendar a Date de SQL
                Calendar fechaRetiro = prestamo.getFechaRetiro();
                java.sql.Date sqlFechaRetiro = new java.sql.Date(fechaRetiro.getTimeInMillis());

                // Configurar parámetros de la consulta
                consultaPrestamo.setDate(1, sqlFechaRetiro);

                // Fecha de devolución puede ser null
                if (prestamo.getFechaDevolucion() != null)
                {
                    Calendar fechaDevolucion = prestamo.getFechaDevolucion();
                    java.sql.Date sqlFechaDevolucion = new java.sql.Date(fechaDevolucion.getTimeInMillis());
                    consultaPrestamo.setDate(2, sqlFechaDevolucion);
                }
                else
                {
                    consultaPrestamo.setNull(2, Types.DATE);
                }

                consultaPrestamo.setInt(3, prestamo.getSocio().getDni());
                consultaPrestamo.setInt(4, libroId);

                int filasAfectadas = consultaPrestamo.executeUpdate(); // Ejecutar la consulta
                return filasAfectadas > 0;
            }
        }
        catch (SQLException e)
        {
            System.err.println("❌ Error al guardar préstamo: " + e.getMessage());
            return false;
        }
    }
    
    /**
     * Obtiene todos los préstamos de un libro específico.
     * 
     * @param libro El libro del cual obtener los préstamos
     * @param biblioteca La biblioteca que contiene los socios
     * @return ArrayList con todos los préstamos del libro
     */
    public ArrayList<Prestamo> obtenerPrestamosPorLibro(Libro libro, Biblioteca biblioteca)
    {
        ArrayList<Prestamo> prestamos = new ArrayList<>(); // Lista para almacenar los préstamos
        String sql = "SELECT p.* FROM prestamos p " +
                     "INNER JOIN libros l ON p.libro_id = l.id " +
                     "WHERE l.titulo = ?"; // Consulta para obtener préstamos por título de libro
        
        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement consultaPrestamo = conn.prepareStatement(sql))
             {

            consultaPrestamo.setString(1, libro.getTitulo());
            ResultSet respuesta = consultaPrestamo.executeQuery(); // Ejecutar la consulta

            while (respuesta.next())
            {
                // Crear Calendar para fecha de retiro
                Calendar fechaRetiro = Calendar.getInstance();
                java.sql.Date sqlFechaRetiro = respuesta.getDate("fecha_retiro");
                fechaRetiro.setTime(sqlFechaRetiro);

                // Buscar el socio
                int socioDni = respuesta.getInt("socio_dni");
                Socio socio = biblioteca.buscarSocio(socioDni);

                if (socio != null)
                {
                    Prestamo prestamo = new Prestamo(fechaRetiro, socio, libro);

                    // Si hay fecha de devolución, registrarla
                    java.sql.Date sqlFechaDevolucion = respuesta.getDate("fecha_devolucion");
                    if (sqlFechaDevolucion != null)
                    {
                        Calendar fechaDevolucion = Calendar.getInstance();
                        fechaDevolucion.setTime(sqlFechaDevolucion);
                        prestamo.registrarFechaDevolucion(fechaDevolucion);
                    }

                    prestamos.add(prestamo);
                }
            }
        }
        catch (SQLException e)
        {
            System.err.println("❌ Error al obtener préstamos: " + e.getMessage());
        }

        return prestamos;
    }
    
    /**
     * Actualiza la fecha de devolución de un préstamo.
     * 
     * @param libroTitulo Título del libro
     * @param fechaDevolucion Fecha de devolución
     * @return true si se actualizó correctamente, false en caso contrario
     */
    public boolean actualizarDevolucion(String libroTitulo, Calendar fechaDevolucion)
    {
        String sql = "UPDATE prestamos SET fecha_devolucion = ? " +
                     "WHERE libro_id = (SELECT id FROM libros WHERE titulo = ?) " +
                     "AND fecha_devolucion IS NULL " +
                     "ORDER BY fecha_retiro DESC LIMIT 1"; // Consulta para actualizar la fecha de devolución del préstamo más reciente
        
        try (Connection conn = DatabaseConfig.getConnection();
                PreparedStatement consulta = conn.prepareStatement(sql))
            {

            java.sql.Date sqlFechaDevolucion = new java.sql.Date(fechaDevolucion.getTimeInMillis());
            consulta.setDate(1, sqlFechaDevolucion);
            consulta.setString(2, libroTitulo);

            int filasAfectadas = consulta.executeUpdate(); // Ejecutar la consulta
            return filasAfectadas > 0;
        }
        catch (SQLException e)
        {
            System.err.println("❌ Error al actualizar devolución: " + e.getMessage());
            return false;
        }
    }
    
    // ==========================================
    // MÉTODO PARA CARGAR TODA LA BIBLIOTECA
    // ==========================================
    
    /**
     * Carga toda la información de la base de datos a una biblioteca.
     * 
     * @param biblioteca La biblioteca donde cargar los datos
     */
    public void cargarBiblioteca(Biblioteca biblioteca)
    {
        // Cargar socios
        HashMap<Integer, Socio> socios = obtenerTodosSocios();
        for (Socio socio : socios.values())
        {
            biblioteca.agregarSocio(socio);
        }

        // Cargar libros
        Set<Libro> libros = obtenerTodosLibros();
        for (Libro libro : libros)
        {
            biblioteca.agregarLibro(libro);

            // Cargar préstamos del libro
            ArrayList<Prestamo> prestamos = obtenerPrestamosPorLibro(libro, biblioteca);
            for (Prestamo prestamo : prestamos)
            {
                libro.agregarPrestamo(prestamo);
                prestamo.getSocio().agregarPrestamo(prestamo);
            }
        }

        System.out.println("✅ Biblioteca cargada completamente desde la base de datos");
    }
}