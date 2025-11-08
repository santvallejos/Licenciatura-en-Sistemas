import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Calendar;

/**
 * Interfaz gráfica principal para el sistema de gestión de biblioteca.
 * Permite administrar socios, libros y préstamos de manera visual e intuitiva.
 * 
 * @author Sistema de Biblioteca
 * @version 1.0
 */
public class BibliotecaGUI extends JFrame
{
    // Componentes principales
    private Biblioteca biblioteca;
    private BibliotecaDAO dao; // DAO para persistencia
    private boolean usarBaseDatos = false; // Flag para activar/desactivar BD
    
    // Colores personalizados para la interfaz
    private final Color COLOR_PRIMARIO = new Color(41, 128, 185);      // Azul
    private final Color COLOR_SECUNDARIO = new Color(52, 152, 219);    // Azul claro
    private final Color COLOR_EXITO = new Color(46, 204, 113);         // Verde
    private final Color COLOR_ADVERTENCIA = new Color(230, 126, 34);   // Naranja
    private final Color COLOR_FONDO = new Color(236, 240, 241);        // Gris claro
    private final Color COLOR_TEXTO = new Color(44, 62, 80);           // Gris oscuro
    
    /**
     * Constructor de la interfaz gráfica
     */
    public BibliotecaGUI()
    {
        // Inicializar la biblioteca
        biblioteca = new Biblioteca("Biblioteca Central");
        dao = new BibliotecaDAO();
        
        // Intentar conectar a la base de datos
        try
        {
            if (DatabaseConfig.testConnection())
            {
                usarBaseDatos = true;
                System.out.println("✅ Modo con Base de Datos ACTIVADO");
                
                // Cargar datos existentes de la base de datos
                dao.cargarBiblioteca(biblioteca);
                
                mostrarMensaje("Éxito", 
                    "Conectado a la base de datos\nDatos cargados correctamente", 
                    JOptionPane.INFORMATION_MESSAGE);
            }
        }
        catch (Exception e)
        {
            usarBaseDatos = false;
            System.out.println("⚠️ Modo sin Base de Datos - Trabajando en memoria");
            mostrarMensaje("Advertencia", 
                "No se pudo conectar a la base de datos\nTrabajando en modo memoria (sin persistencia)", 
                JOptionPane.WARNING_MESSAGE);
        }
        
        // Configuración de la ventana principal
        setTitle("Sistema de Gestión de Biblioteca" + (usarBaseDatos ? " [BD Activa]" : " [Sin BD]"));
        setSize(900, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Centrar la ventana
        
        // Cerrar conexión al cerrar la ventana
        addWindowListener(new java.awt.event.WindowAdapter()
        {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent)
            {
                if (usarBaseDatos)
                {
                    DatabaseConfig.closeConnection();
                }
            }
        });
        
        // Establecer el Look and Feel del sistema
        try
        {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        
        // Crear la interfaz
        inicializarComponentes();
        
        setVisible(true);
    }
    
    /**
     * Inicializa todos los componentes de la interfaz
     */
    private void inicializarComponentes()
    {
        // Panel principal con BorderLayout
        JPanel panelPrincipal = new JPanel(new BorderLayout(10, 10));
        panelPrincipal.setBackground(COLOR_FONDO);
        panelPrincipal.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        // Crear y agregar los componentes
        panelPrincipal.add(crearPanelSuperior(), BorderLayout.NORTH);
        panelPrincipal.add(crearPanelCentral(), BorderLayout.CENTER);
        
        add(panelPrincipal);
    }
    
    /**
     * Crea el panel superior con el título y información
     */
    private JPanel crearPanelSuperior()
    {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(COLOR_PRIMARIO);
        panel.setBorder(BorderFactory.createEmptyBorder(15, 20, 15, 20));
        
        // Título
        JLabel lblTitulo = new JLabel("📚 " + biblioteca.getNombre());
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 28));
        lblTitulo.setForeground(Color.WHITE);
        
        // Información
        JLabel lblInfo = new JLabel("Sistema de Gestión Bibliotecaria");
        lblInfo.setFont(new Font("Arial", Font.PLAIN, 14));
        lblInfo.setForeground(new Color(236, 240, 241));
        
        // Panel para el texto
        JPanel panelTexto = new JPanel(new GridLayout(2, 1, 0, 5));
        panelTexto.setOpaque(false);
        panelTexto.add(lblTitulo);
        panelTexto.add(lblInfo);
        
        panel.add(panelTexto, BorderLayout.WEST);
        
        return panel;
    }
    
    /**
     * Crea el panel central con los botones de acciones
     */
    private JPanel crearPanelCentral()
    {
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBackground(COLOR_FONDO);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        
        // Crear los botones con iconos
        JButton btnAgregarSocio = crearBoton("👤 Agregar Socio", COLOR_PRIMARIO);
        JButton btnAgregarLibro = crearBoton("📖 Agregar Libro", COLOR_SECUNDARIO);
        JButton btnPrestarLibro = crearBoton("📤 Prestar Libro", COLOR_EXITO);
        JButton btnDevolverLibro = crearBoton("📥 Devolver Libro", COLOR_ADVERTENCIA);
        JButton btnListarSocios = crearBoton("👥 Listar Socios", COLOR_PRIMARIO);
        JButton btnListarLibros = crearBoton("📚 Listar Libros", COLOR_SECUNDARIO);
        
        // Agregar acciones a los botones
        btnAgregarSocio.addActionListener(e -> mostrarDialogoAgregarSocio());
        btnAgregarLibro.addActionListener(e -> mostrarDialogoAgregarLibro());
        btnPrestarLibro.addActionListener(e -> mostrarDialogoPrestarLibro());
        btnDevolverLibro.addActionListener(e -> mostrarDialogoDevolverLibro());
        btnListarSocios.addActionListener(e -> mostrarListaSocios());
        btnListarLibros.addActionListener(e -> mostrarListaLibros());
        
        // Primera fila
        gbc.gridx = 0; gbc.gridy = 0;
        panel.add(btnAgregarSocio, gbc);
        
        gbc.gridx = 1;
        panel.add(btnAgregarLibro, gbc);
        
        // Segunda fila
        gbc.gridx = 0; gbc.gridy = 1;
        panel.add(btnPrestarLibro, gbc);
        
        gbc.gridx = 1;
        panel.add(btnDevolverLibro, gbc);
        
        // Tercera fila
        gbc.gridx = 0; gbc.gridy = 2;
        panel.add(btnListarSocios, gbc);
        
        gbc.gridx = 1;
        panel.add(btnListarLibros, gbc);
        
        return panel;
    }
    
    /**
     * Crea un botón personalizado con estilo
     */
    private JButton crearBoton(String texto, Color color)
    {
        JButton boton = new JButton(texto);
        boton.setFont(new Font("Arial", Font.BOLD, 16));
        boton.setBackground(color);
        boton.setForeground(Color.WHITE);
        boton.setFocusPainted(false);
        boton.setBorderPainted(false);
        boton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        boton.setPreferredSize(new Dimension(200, 80));
        
        // Efecto hover
        boton.addMouseListener(new MouseAdapter()
        {
            public void mouseEntered(MouseEvent e) {
                boton.setBackground(color.brighter());
            }
            public void mouseExited(MouseEvent e) {
                boton.setBackground(color);
            }
        });
        
        return boton;
    }
    
    /**
     * Muestra el diálogo para agregar un nuevo socio
     */
    private void mostrarDialogoAgregarSocio()
    {
        JDialog dialogo = new JDialog(this, "Agregar Nuevo Socio", true);
        dialogo.setSize(450, 350);
        dialogo.setLocationRelativeTo(this);
        
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBackground(Color.WHITE);
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(8, 8, 8, 8);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        
        // Tipo de socio
        gbc.gridx = 0; gbc.gridy = 0;
        panel.add(crearEtiqueta("Tipo de Socio:"), gbc);
        
        gbc.gridx = 1;
        String[] tipos = {"Estudiante", "Docente"};
        JComboBox<String> cmbTipo = new JComboBox<>(tipos);
        cmbTipo.setFont(new Font("Arial", Font.PLAIN, 14));
        panel.add(cmbTipo, gbc);
        
        // DNI
        gbc.gridx = 0; gbc.gridy = 1;
        panel.add(crearEtiqueta("DNI:"), gbc);
        
        gbc.gridx = 1;
        JTextField txtDni = crearCampoTexto();
        panel.add(txtDni, gbc);
        
        // Nombre
        gbc.gridx = 0; gbc.gridy = 2;
        panel.add(crearEtiqueta("Nombre:"), gbc);
        
        gbc.gridx = 1;
        JTextField txtNombre = crearCampoTexto();
        panel.add(txtNombre, gbc);
        
        // Campo adicional (Carrera/Área)
        gbc.gridx = 0; gbc.gridy = 3;
        JLabel lblAdicional = crearEtiqueta("Carrera:");
        panel.add(lblAdicional, gbc);
        
        gbc.gridx = 1;
        JTextField txtAdicional = crearCampoTexto();
        panel.add(txtAdicional, gbc);
        
        // Cambiar etiqueta según tipo seleccionado
        cmbTipo.addActionListener(e -> {
            String tipo = (String) cmbTipo.getSelectedItem();
            lblAdicional.setText(tipo.equals("Estudiante") ? "Carrera:" : "Área:");
        });
        
        // Botones
        gbc.gridx = 0; gbc.gridy = 4; gbc.gridwidth = 2;
        JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 0));
        panelBotones.setBackground(Color.WHITE);
        
        JButton btnGuardar = crearBotonDialogo("Guardar", COLOR_EXITO);
        JButton btnCancelar = crearBotonDialogo("Cancelar", COLOR_ADVERTENCIA);
        
        btnGuardar.addActionListener(e -> {
            try
            {
                int dni = Integer.parseInt(txtDni.getText().trim());
                String nombre = txtNombre.getText().trim();
                String adicional = txtAdicional.getText().trim();
                
                if (nombre.isEmpty() || adicional.isEmpty())
                {
                    mostrarMensaje("Error", "Por favor complete todos los campos", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                
                String tipo = (String) cmbTipo.getSelectedItem();
                if (tipo.equals("Estudiante"))
                {
                    biblioteca.nuevoSocioEstudiante(dni, nombre, adicional);
                    // Guardar en BD si está activa
                    if (usarBaseDatos)
                    {
                        Socio socio = biblioteca.buscarSocio(dni);
                        if (socio != null && dao.guardarSocio(socio))
                        {
                            System.out.println("✅ Socio guardado en la base de datos");
                        }
                    }
                }
                else
                {
                    biblioteca.nuevoSocioDocente(dni, nombre, adicional);
                    // Guardar en BD si está activa
                    if (usarBaseDatos)
                    {
                        Socio socio = biblioteca.buscarSocio(dni);
                        if (socio != null && dao.guardarSocio(socio))
                        {
                            System.out.println("✅ Socio guardado en la base de datos");
                        }
                    }
                }
                
                mostrarMensaje("Éxito", "Socio agregado correctamente", JOptionPane.INFORMATION_MESSAGE);
                dialogo.dispose();
            }
            catch (NumberFormatException ex)
            {
                mostrarMensaje("Error", "El DNI debe ser un número válido", JOptionPane.ERROR_MESSAGE);
            }
        });
        
        btnCancelar.addActionListener(e -> dialogo.dispose());
        
        panelBotones.add(btnGuardar);
        panelBotones.add(btnCancelar);
        panel.add(panelBotones, gbc);
        
        dialogo.add(panel);
        dialogo.setVisible(true);
    }
    
    /**
     * Muestra el diálogo para agregar un nuevo libro
     */
    private void mostrarDialogoAgregarLibro()
    {
        JDialog dialogo = new JDialog(this, "Agregar Nuevo Libro", true);
        dialogo.setSize(450, 350);
        dialogo.setLocationRelativeTo(this);
        
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBackground(Color.WHITE);
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(8, 8, 8, 8);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        
        // Título
        gbc.gridx = 0; gbc.gridy = 0;
        panel.add(crearEtiqueta("Título:"), gbc);
        
        gbc.gridx = 1;
        JTextField txtTitulo = crearCampoTexto();
        panel.add(txtTitulo, gbc);
        
        // Edición
        gbc.gridx = 0; gbc.gridy = 1;
        panel.add(crearEtiqueta("Edición:"), gbc);
        
        gbc.gridx = 1;
        JTextField txtEdicion = crearCampoTexto();
        panel.add(txtEdicion, gbc);
        
        // Editorial
        gbc.gridx = 0; gbc.gridy = 2;
        panel.add(crearEtiqueta("Editorial:"), gbc);
        
        gbc.gridx = 1;
        JTextField txtEditorial = crearCampoTexto();
        panel.add(txtEditorial, gbc);
        
        // Año
        gbc.gridx = 0; gbc.gridy = 3;
        panel.add(crearEtiqueta("Año:"), gbc);
        
        gbc.gridx = 1;
        JTextField txtAnio = crearCampoTexto();
        panel.add(txtAnio, gbc);
        
        // Botones
        gbc.gridx = 0; gbc.gridy = 4; gbc.gridwidth = 2;
        JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 0));
        panelBotones.setBackground(Color.WHITE);
        
        JButton btnGuardar = crearBotonDialogo("Guardar", COLOR_EXITO);
        JButton btnCancelar = crearBotonDialogo("Cancelar", COLOR_ADVERTENCIA);
        
        btnGuardar.addActionListener(e -> {
            try
            {
                String titulo = txtTitulo.getText().trim();
                int edicion = Integer.parseInt(txtEdicion.getText().trim());
                String editorial = txtEditorial.getText().trim();
                int anio = Integer.parseInt(txtAnio.getText().trim());
                
                if (titulo.isEmpty() || editorial.isEmpty())
                {
                    mostrarMensaje("Error", "Por favor complete todos los campos", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                
                biblioteca.nuevoLibro(titulo, edicion, editorial, anio);
                
                // Guardar en BD si está activa
                if (usarBaseDatos) {
                    Libro libro = null;
                    for (Libro l : biblioteca.getLibros())
                    {
                        if (l.getTitulo().equals(titulo))
                        {
                            libro = l;
                            break;
                        }
                    }
                    if (libro != null && dao.guardarLibro(libro) != -1)
                    {
                        System.out.println("✅ Libro guardado en la base de datos");
                    }
                }
                
                mostrarMensaje("Éxito", "Libro agregado correctamente", JOptionPane.INFORMATION_MESSAGE);
                dialogo.dispose();
            }
            catch (NumberFormatException ex)
            {
                mostrarMensaje("Error", "Edición y Año deben ser números válidos", JOptionPane.ERROR_MESSAGE);
            }
        });
        
        btnCancelar.addActionListener(e -> dialogo.dispose());
        
        panelBotones.add(btnGuardar);
        panelBotones.add(btnCancelar);
        panel.add(panelBotones, gbc);
        
        dialogo.add(panel);
        dialogo.setVisible(true);
    }
    
    /**
     * Muestra el diálogo para prestar un libro
     */
    private void mostrarDialogoPrestarLibro()
    {
        if (biblioteca.getSocios().isEmpty() || biblioteca.getLibros().isEmpty())
        {
            mostrarMensaje("Advertencia", "Debe agregar socios y libros primero", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        JDialog dialogo = new JDialog(this, "Prestar Libro", true);
        dialogo.setSize(450, 280);
        dialogo.setLocationRelativeTo(this);
        
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBackground(Color.WHITE);
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(8, 8, 8, 8);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        
        // DNI del socio
        gbc.gridx = 0; gbc.gridy = 0;
        panel.add(crearEtiqueta("DNI del Socio:"), gbc);
        
        gbc.gridx = 1;
        JTextField txtDni = crearCampoTexto();
        panel.add(txtDni, gbc);
        
        // Título del libro
        gbc.gridx = 0; gbc.gridy = 1;
        panel.add(crearEtiqueta("Título del Libro:"), gbc);
        
        gbc.gridx = 1;
        JTextField txtTitulo = crearCampoTexto();
        panel.add(txtTitulo, gbc);
        
        // Botones
        gbc.gridx = 0; gbc.gridy = 2; gbc.gridwidth = 2;
        JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 0));
        panelBotones.setBackground(Color.WHITE);
        
        JButton btnPrestar = crearBotonDialogo("Prestar", COLOR_EXITO);
        JButton btnCancelar = crearBotonDialogo("Cancelar", COLOR_ADVERTENCIA);
        
        btnPrestar.addActionListener(e -> {
            try
            {
                int dni = Integer.parseInt(txtDni.getText().trim());
                String titulo = txtTitulo.getText().trim();
                
                Socio socio = biblioteca.buscarSocio(dni);
                if (socio == null)
                {
                    mostrarMensaje("Error", "Socio no encontrado", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                
                Libro libro = null;
                for (Libro l : biblioteca.getLibros())
                {
                    if (l.getTitulo().equalsIgnoreCase(titulo))
                    {
                        libro = l;
                        break;
                    }
                }
                
                if (libro == null)
                {
                    mostrarMensaje("Error", "Libro no encontrado", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                
                if (libro.prestado())
                {
                    mostrarMensaje("Error", "El libro ya está prestado", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                
                Calendar fechaActual = Calendar.getInstance();
                boolean prestado = biblioteca.prestarLibro(fechaActual, socio, libro);
                
                if (prestado)
                {
                    // Guardar en BD si está activa
                    if (usarBaseDatos) {
                        Prestamo ultimoPrestamo = libro.ultimoPrestamo();
                        if (ultimoPrestamo != null && dao.guardarPrestamo(ultimoPrestamo, libro.getTitulo())) {
                            System.out.println("✅ Préstamo guardado en la base de datos");
                        }
                    }
                    
                    mostrarMensaje("Éxito", "Libro prestado correctamente", JOptionPane.INFORMATION_MESSAGE);
                    dialogo.dispose();
                }
                else
                {
                    mostrarMensaje("Error", "No se pudo prestar el libro. Verifique las condiciones del socio.", JOptionPane.ERROR_MESSAGE);
                }
            }
            catch (NumberFormatException ex)
            {
                mostrarMensaje("Error", "El DNI debe ser un número válido", JOptionPane.ERROR_MESSAGE);
            }
        });
        
        btnCancelar.addActionListener(e -> dialogo.dispose());
        
        panelBotones.add(btnPrestar);
        panelBotones.add(btnCancelar);
        panel.add(panelBotones, gbc);
        
        dialogo.add(panel);
        dialogo.setVisible(true);
    }
    
    /**
     * Muestra el diálogo para devolver un libro
     */
    private void mostrarDialogoDevolverLibro()
    {
        if (biblioteca.getLibros().isEmpty())
        {
            mostrarMensaje("Advertencia", "No hay libros en la biblioteca", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        JDialog dialogo = new JDialog(this, "Devolver Libro", true);
        dialogo.setSize(450, 220);
        dialogo.setLocationRelativeTo(this);
        
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBackground(Color.WHITE);
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(8, 8, 8, 8);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        
        // Título del libro
        gbc.gridx = 0; gbc.gridy = 0;
        panel.add(crearEtiqueta("Título del Libro:"), gbc);
        
        gbc.gridx = 1;
        JTextField txtTitulo = crearCampoTexto();
        panel.add(txtTitulo, gbc);
        
        // Botones
        gbc.gridx = 0; gbc.gridy = 1; gbc.gridwidth = 2;
        JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 0));
        panelBotones.setBackground(Color.WHITE);
        
        JButton btnDevolver = crearBotonDialogo("Devolver", COLOR_EXITO);
        JButton btnCancelar = crearBotonDialogo("Cancelar", COLOR_ADVERTENCIA);
        
        btnDevolver.addActionListener(e -> {
            try
            {
                String titulo = txtTitulo.getText().trim();
                
                Libro libro = null;
                for (Libro l : biblioteca.getLibros())
                {
                    if (l.getTitulo().equalsIgnoreCase(titulo))
                    {
                        libro = l;
                        break;
                    }
                }
                
                if (libro == null)
                {
                    mostrarMensaje("Error", "Libro no encontrado", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                
                biblioteca.devolverLibro(libro);
                
                // Actualizar en BD si está activa
                if (usarBaseDatos) {
                    Calendar fechaActual = Calendar.getInstance();
                    if (dao.actualizarDevolucion(libro.getTitulo(), fechaActual))
                    {
                        System.out.println("✅ Devolución actualizada en la base de datos");
                    }
                }
                
                mostrarMensaje("Éxito", "Libro devuelto correctamente", JOptionPane.INFORMATION_MESSAGE);
                dialogo.dispose();
            }
            catch (LibroNoPrestadoException ex)
            {
                mostrarMensaje("Error", ex.getMessage(), JOptionPane.ERROR_MESSAGE);
            }
        });
        
        btnCancelar.addActionListener(e -> dialogo.dispose());
        
        panelBotones.add(btnDevolver);
        panelBotones.add(btnCancelar);
        panel.add(panelBotones, gbc);
        
        dialogo.add(panel);
        dialogo.setVisible(true);
    }
    
    /**
     * Muestra la lista de socios en una ventana
     */
    private void mostrarListaSocios()
    {
        if (biblioteca.getSocios().isEmpty())
        {
            mostrarMensaje("Información", "No hay socios registrados", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        
        String lista = biblioteca.listaDeSocios();
        mostrarVentanaTexto("Lista de Socios", lista);
    }
    
    /**
     * Muestra la lista de libros en una ventana
     */
    private void mostrarListaLibros()
    {
        if (biblioteca.getLibros().isEmpty())
        {
            mostrarMensaje("Información", "No hay libros registrados", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        
        String lista = biblioteca.listaDeLibros();
        mostrarVentanaTexto("Lista de Libros", lista);
    }
    
    /**
     * Muestra una ventana con texto en un área de texto desplazable
     */
    private void mostrarVentanaTexto(String titulo, String contenido)
    {
        JDialog dialogo = new JDialog(this, titulo, true);
        dialogo.setSize(600, 400);
        dialogo.setLocationRelativeTo(this);
        
        JTextArea textArea = new JTextArea(contenido);
        textArea.setEditable(false);
        textArea.setFont(new Font("Monospaced", Font.PLAIN, 13));
        textArea.setMargin(new Insets(10, 10, 10, 10));
        
        JScrollPane scrollPane = new JScrollPane(textArea);
        
        JPanel panel = new JPanel(new BorderLayout());
        panel.add(scrollPane, BorderLayout.CENTER);
        
        JButton btnCerrar = crearBotonDialogo("Cerrar", COLOR_PRIMARIO);
        btnCerrar.addActionListener(e -> dialogo.dispose());
        
        JPanel panelBoton = new JPanel();
        panelBoton.add(btnCerrar);
        panel.add(panelBoton, BorderLayout.SOUTH);
        
        dialogo.add(panel);
        dialogo.setVisible(true);
    }
    
    /**
     * Crea una etiqueta con estilo personalizado
     */
    private JLabel crearEtiqueta(String texto)
    {
        JLabel etiqueta = new JLabel(texto);
        etiqueta.setFont(new Font("Arial", Font.BOLD, 14));
        etiqueta.setForeground(COLOR_TEXTO);
        return etiqueta;
    }
    
    /**
     * Crea un campo de texto con estilo personalizado
     */
    private JTextField crearCampoTexto()
    {
        JTextField campo = new JTextField(20);
        campo.setFont(new Font("Arial", Font.PLAIN, 14));
        return campo;
    }
    
    /**
     * Crea un botón para diálogos con estilo personalizado
     */
    private JButton crearBotonDialogo(String texto, Color color)
    {
        JButton boton = new JButton(texto);
        boton.setFont(new Font("Arial", Font.BOLD, 13));
        boton.setBackground(color);
        boton.setForeground(Color.WHITE);
        boton.setFocusPainted(false);
        boton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        boton.setPreferredSize(new Dimension(120, 35));
        
        return boton;
    }
    
    /**
     * Muestra un mensaje en un cuadro de diálogo
     */
    private void mostrarMensaje(String titulo, String mensaje, int tipo)
    {
        JOptionPane.showMessageDialog(this, mensaje, titulo, tipo);
    }
    
    /**
     * Método main para ejecutar la aplicación
     */
    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(() -> new BibliotecaGUI());
    }
}