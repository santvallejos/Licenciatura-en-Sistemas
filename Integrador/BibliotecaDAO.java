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
                     "VALUES (?, ?, ?, ?, ?)";
        
        try (Connection conn = DatabaseConfig.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)) 
            {
            
            pstmt.setInt(1, socio.getDni());
            pstmt.setString(2, socio.getNombre());
            pstmt.setString(3, socio.soyDeLaClase());
            
            // Determinar carrera o área según el tipo
            if (socio instanceof Estudiante)
            {
                pstmt.setString(4, ((Estudiante) socio).getCarrera());
            }
            else if (socio instanceof Docente)
            {
                pstmt.setString(4, ((Docente) socio).getArea());
            }
            
            pstmt.setInt(5, socio.getDiasPrestamo());
            
            int filasAfectadas = pstmt.executeUpdate();
            return filasAfectadas > 0;
            
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
        HashMap<Integer, Socio> socios = new HashMap<>();
        String sql = "SELECT * FROM socios";
        
        try (Connection conn = DatabaseConfig.getConnection();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql))
            {
            
            while (rs.next())
            {
                int dni = rs.getInt("dni");
                String nombre = rs.getString("nombre");
                String tipo = rs.getString("tipo");
                String carreraOArea = rs.getString("carrera_o_area");
                int diasPrestamo = rs.getInt("dias_prestamo");

                Socio socio;
                if (tipo.equals("Estudiante"))
                {
                    socio = new Estudiante(dni, nombre, carreraOArea);
                }
                else
                {
                    socio = new Docente(dni, nombre, carreraOArea);
                }

                socios.put(dni, socio);
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
        String sql = "SELECT * FROM socios WHERE dni = ?";
        
        try (Connection conn = DatabaseConfig.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql))
            {
            
            pstmt.setInt(1, dni);
            ResultSet rs = pstmt.executeQuery();
            
            if (rs.next())
            {
                String nombre = rs.getString("nombre");
                String tipo = rs.getString("tipo");
                String carreraOArea = rs.getString("carrera_o_area");

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
        String sql = "DELETE FROM socios WHERE dni = ?";
        
        try (Connection conn = DatabaseConfig.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql))
            {

            pstmt.setInt(1, dni);
            int filasAfectadas = pstmt.executeUpdate();
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
        String sql = "INSERT INTO libros (titulo, edicion, editorial, anio) VALUES (?, ?, ?, ?)";
        
        try (Connection conn = DatabaseConfig.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS))
            {
            
            pstmt.setString(1, libro.getTitulo());
            pstmt.setInt(2, libro.getEdicion());
            pstmt.setString(3, libro.getEditorial());
            pstmt.setInt(4, libro.getAnio());

            int filasAfectadas = pstmt.executeUpdate();

            if (filasAfectadas > 0)
            {
                // Obtener el ID generado
                ResultSet rs = pstmt.getGeneratedKeys();
                if (rs.next())
                {
                    return rs.getInt(1);
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
        Set<Libro> libros = new HashSet<>();
        String sql = "SELECT * FROM libros";
        
        try (Connection conn = DatabaseConfig.getConnection();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql))
            {
            
            while (rs.next())
            {
                String titulo = rs.getString("titulo");
                int edicion = rs.getInt("edicion");
                String editorial = rs.getString("editorial");
                int anio = rs.getInt("anio");
                
                Libro libro = new Libro(titulo, edicion, editorial, anio);
                libros.add(libro);
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
        String sql = "SELECT * FROM libros WHERE titulo = ?";

        try (Connection conn = DatabaseConfig.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql))
            {
            
            pstmt.setString(1, titulo);
            ResultSet rs = pstmt.executeQuery();
            
            if (rs.next())
            {
                int edicion = rs.getInt("edicion");
                String editorial = rs.getString("editorial");
                int anio = rs.getInt("anio");
                
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
        String sql = "SELECT id FROM libros WHERE titulo = ?";

        try (Connection conn = DatabaseConfig.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql))
            {

            pstmt.setString(1, titulo);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next())
            {
                return rs.getInt("id");
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
        String sql = "DELETE FROM libros WHERE titulo = ?";
        
        try (Connection conn = DatabaseConfig.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql))
            {

            pstmt.setString(1, titulo);
            int filasAfectadas = pstmt.executeUpdate();
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
        String sql = "INSERT INTO prestamos (fecha_retiro, fecha_devolucion, socio_dni, libro_id) " +
                     "VALUES (?, ?, ?, ?)";
        
        try (Connection conn = DatabaseConfig.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql))
            {
            
            // Convertir Calendar a Date de SQL
            Calendar fechaRetiro = prestamo.getFechaRetiro();
            java.sql.Date sqlFechaRetiro = new java.sql.Date(fechaRetiro.getTimeInMillis());
            pstmt.setDate(1, sqlFechaRetiro);
            
            // Fecha de devolución puede ser null
            if (prestamo.getFechaDevolucion() != null)
            {
                Calendar fechaDevolucion = prestamo.getFechaDevolucion();
                java.sql.Date sqlFechaDevolucion = new java.sql.Date(fechaDevolucion.getTimeInMillis());
                pstmt.setDate(2, sqlFechaDevolucion);
            }
            else
            {
                pstmt.setNull(2, Types.DATE);
            }

            pstmt.setInt(3, prestamo.getSocio().getDni());

            // Obtener el ID del libro
            int libroId = obtenerIdLibro(libroTitulo);
            if (libroId == -1)
            {
                System.err.println("❌ No se encontró el libro para guardar el préstamo");
                return false;
            }
            pstmt.setInt(4, libroId);

            int filasAfectadas = pstmt.executeUpdate();
            return filasAfectadas > 0;

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
        ArrayList<Prestamo> prestamos = new ArrayList<>();
        String sql = "SELECT p.* FROM prestamos p " +
                     "INNER JOIN libros l ON p.libro_id = l.id " +
                     "WHERE l.titulo = ?";
        
        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql))
             {

            pstmt.setString(1, libro.getTitulo());
            ResultSet rs = pstmt.executeQuery();

            while (rs.next())
            {
                // Crear Calendar para fecha de retiro
                Calendar fechaRetiro = Calendar.getInstance();
                java.sql.Date sqlFechaRetiro = rs.getDate("fecha_retiro");
                fechaRetiro.setTime(sqlFechaRetiro);

                // Buscar el socio
                int socioDni = rs.getInt("socio_dni");
                Socio socio = biblioteca.buscarSocio(socioDni);

                if (socio != null)
                {
                    Prestamo prestamo = new Prestamo(fechaRetiro, socio, libro);

                    // Si hay fecha de devolución, registrarla
                    java.sql.Date sqlFechaDevolucion = rs.getDate("fecha_devolucion");
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
                     "ORDER BY fecha_retiro DESC LIMIT 1";
        
        try (Connection conn = DatabaseConfig.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql))
            {
            
            java.sql.Date sqlFechaDevolucion = new java.sql.Date(fechaDevolucion.getTimeInMillis());
            pstmt.setDate(1, sqlFechaDevolucion);
            pstmt.setString(2, libroTitulo);
            
            int filasAfectadas = pstmt.executeUpdate();
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