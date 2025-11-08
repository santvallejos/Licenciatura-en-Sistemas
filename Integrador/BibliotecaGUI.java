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
    
    // Colores modernos - Paleta profesional
    private final Color COLOR_PRIMARIO = new Color(37, 99, 235);       // Azul #2563EB
    private final Color COLOR_PRIMARIO_HOVER = new Color(29, 78, 216); // Azul hover #1D4ED8
    private final Color COLOR_SECUNDARIO = new Color(59, 130, 246);    // Azul claro #3B82F6
    private final Color COLOR_SECUNDARIO_HOVER = new Color(37, 99, 235); // Azul hover
    private final Color COLOR_EXITO = new Color(34, 197, 94);          // Verde #22C55E
    private final Color COLOR_EXITO_HOVER = new Color(22, 163, 74);    // Verde hover
    private final Color COLOR_ADVERTENCIA = new Color(251, 146, 60);   // Naranja #FB923C
    private final Color COLOR_ADVERTENCIA_HOVER = new Color(249, 115, 22); // Naranja hover
    private final Color COLOR_FONDO = new Color(249, 250, 251);        // Gris #F9FAFB
    private final Color COLOR_TEXTO = new Color(30, 41, 59);           // Gris oscuro #1E293B
    private final Color COLOR_TEXTO_LIGHT = new Color(100, 116, 139);  // Gris medio
    private final Color COLOR_BORDER = new Color(226, 232, 240);       // Gris borde #E2E8F0
    
    // Fuentes modernas
    private final Font FONT_TITULO = new Font("Segoe UI", Font.BOLD, 32);
    private final Font FONT_SUBTITULO = new Font("Segoe UI", Font.PLAIN, 15);
    private final Font FONT_BOTON = new Font("Segoe UI", Font.BOLD, 15);
    private final Font FONT_LABEL = new Font("Segoe UI", Font.PLAIN, 14);
    private final Font FONT_CAMPO = new Font("Segoe UI", Font.PLAIN, 14);
    
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
        setSize(1000, 700); // Ventana más grande para mejor visualización
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
        JPanel panelPrincipal = new JPanel(new BorderLayout(0, 0));
        panelPrincipal.setBackground(COLOR_FONDO);
        panelPrincipal.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        
        // Crear y agregar los componentes
        panelPrincipal.add(crearPanelSuperior(), BorderLayout.NORTH);
        
        // Panel con padding para el contenido central
        JPanel contenedorCentral = new JPanel(new BorderLayout());
        contenedorCentral.setBackground(COLOR_FONDO);
        contenedorCentral.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));
        contenedorCentral.add(crearPanelCentral(), BorderLayout.CENTER);
        
        panelPrincipal.add(contenedorCentral, BorderLayout.CENTER);
        
        add(panelPrincipal);
    }
    
    /**
     * Crea el panel superior con el título y información
     */
    private JPanel crearPanelSuperior()
    {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(COLOR_PRIMARIO);
        panel.setBorder(BorderFactory.createEmptyBorder(25, 30, 25, 30));
        
        // Título con icono más grande
        JLabel lblTitulo = new JLabel("📚 " + biblioteca.getNombre());
        lblTitulo.setFont(FONT_TITULO);
        lblTitulo.setForeground(Color.WHITE);
        
        // Información con estilo mejorado
        JLabel lblInfo = new JLabel("Sistema de Gestión Bibliotecaria • Administra socios, libros y préstamos");
        lblInfo.setFont(FONT_SUBTITULO);
        lblInfo.setForeground(new Color(219, 234, 254)); // Azul muy claro
        
        // Panel para el texto
        JPanel panelTexto = new JPanel(new GridLayout(2, 1, 0, 8));
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
        gbc.insets = new Insets(15, 15, 15, 15); // Más espacio entre botones
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        
        // Crear los botones con iconos mejorados y colores hover
        JButton btnAgregarSocio = crearBoton("👤 Agregar Socio", COLOR_PRIMARIO, COLOR_PRIMARIO_HOVER);
        JButton btnAgregarLibro = crearBoton("📖 Agregar Libro", COLOR_SECUNDARIO, COLOR_SECUNDARIO_HOVER);
        JButton btnPrestarLibro = crearBoton("📤 Prestar Libro", COLOR_EXITO, COLOR_EXITO_HOVER);
        JButton btnDevolverLibro = crearBoton("📥 Devolver Libro", COLOR_ADVERTENCIA, COLOR_ADVERTENCIA_HOVER);
        JButton btnListarSocios = crearBoton("👥 Listar Socios", COLOR_PRIMARIO, COLOR_PRIMARIO_HOVER);
        JButton btnListarLibros = crearBoton("📚 Listar Libros", COLOR_SECUNDARIO, COLOR_SECUNDARIO_HOVER);
        
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
     * Crea un botón personalizado con estilo moderno y efecto hover
     */
    private JButton crearBoton(String texto, Color color, Color colorHover)
    {
        JButton boton = new JButton(texto);
        boton.setFont(FONT_BOTON);
        boton.setBackground(color);
        boton.setForeground(Color.WHITE);
        boton.setFocusPainted(false);
        boton.setBorderPainted(false);
        boton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        boton.setPreferredSize(new Dimension(220, 90));
        
        // Borde sutil redondeado
        boton.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(COLOR_BORDER, 1),
            BorderFactory.createEmptyBorder(15, 20, 15, 20)
        ));
        
        // Efecto hover mejorado
        boton.addMouseListener(new MouseAdapter()
        {
            public void mouseEntered(MouseEvent e) {
                boton.setBackground(colorHover);
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
        dialogo.setSize(500, 400);
        dialogo.setLocationRelativeTo(this);
        
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBackground(Color.WHITE);
        panel.setBorder(BorderFactory.createEmptyBorder(25, 30, 25, 30));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        
        // Tipo de socio
        gbc.gridx = 0; gbc.gridy = 0;
        panel.add(crearEtiqueta("Tipo de Socio:"), gbc);
        
        gbc.gridx = 1;
        String[] tipos = {"Estudiante", "Docente"};
        JComboBox<String> cmbTipo = new JComboBox<>(tipos);
        cmbTipo.setFont(FONT_CAMPO);
        cmbTipo.setBackground(Color.WHITE);
        cmbTipo.setPreferredSize(new Dimension(250, 38));
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
        dialogo.setSize(500, 400);
        dialogo.setLocationRelativeTo(this);
        
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBackground(Color.WHITE);
        panel.setBorder(BorderFactory.createEmptyBorder(25, 30, 25, 30));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
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
        dialogo.setSize(500, 300);
        dialogo.setLocationRelativeTo(this);
        
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBackground(Color.WHITE);
        panel.setBorder(BorderFactory.createEmptyBorder(25, 30, 25, 30));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
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
        dialogo.setSize(500, 250);
        dialogo.setLocationRelativeTo(this);
        
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBackground(Color.WHITE);
        panel.setBorder(BorderFactory.createEmptyBorder(25, 30, 25, 30));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
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
        etiqueta.setFont(FONT_LABEL);
        etiqueta.setForeground(COLOR_TEXTO);
        return etiqueta;
    }
    
    /**
     * Crea un campo de texto con estilo moderno
     */
    private JTextField crearCampoTexto()
    {
        JTextField campo = new JTextField(20);
        campo.setFont(FONT_CAMPO);
        campo.setPreferredSize(new Dimension(250, 38));
        campo.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(COLOR_BORDER, 1),
            BorderFactory.createEmptyBorder(8, 12, 8, 12)
        ));
        return campo;
    }
    
    /**
     * Crea un botón para diálogos con estilo personalizado
     */
    private JButton crearBotonDialogo(String texto, Color color)
    {
        JButton boton = new JButton(texto);
        boton.setFont(new Font("Segoe UI", Font.BOLD, 13));
        boton.setBackground(color);
        boton.setForeground(Color.WHITE);
        boton.setFocusPainted(false);
        boton.setBorderPainted(false);
        boton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        boton.setPreferredSize(new Dimension(130, 40));
        
        // Efecto hover
        boton.addMouseListener(new MouseAdapter()
        {
            public void mouseEntered(MouseEvent e) {
                if (color.equals(COLOR_EXITO)) {
                    boton.setBackground(COLOR_EXITO_HOVER);
                } else if (color.equals(COLOR_ADVERTENCIA)) {
                    boton.setBackground(COLOR_ADVERTENCIA_HOVER);
                } else if (color.equals(COLOR_PRIMARIO)) {
                    boton.setBackground(COLOR_PRIMARIO_HOVER);
                }
            }
            public void mouseExited(MouseEvent e) {
                boton.setBackground(color);
            }
        });
        
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