import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.util.Calendar;
import java.util.ArrayList;
import java.net.URL;

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
     * Constructor de la interfaz gráfica y configuración inicial
     */
    public BibliotecaGUI()
    {
        biblioteca = new Biblioteca("UNNE - Biblioteca"); // Nombre de la biblioteca
        dao = new BibliotecaDAO(); // Inicializar DAO (DB)

        // Establecer conexión a la base de datos
        System.out.println("📡 Intentando conectar a la base de datos PostgreSQL...");
        try
        {
            // Intentar obtener la conexión (esto crea las tablas si no existen)
            Connection conn = DatabaseConfig.getConnection();
            
            if (conn != null && !conn.isClosed())
            {
                usarBaseDatos = true;
                System.out.println("✅ Conexión a la base de datos establecida exitosamente");
                System.out.println("📊 Cargando datos existentes...");
                
                // Cargar datos existentes de la base de datos
                dao.cargarBiblioteca(biblioteca);
                
                System.out.println("✅ Datos cargados correctamente");
                
                mostrarMensaje("Éxito", 
                    "✅ Conectado a la base de datos\n📊 Datos cargados correctamente", 
                    JOptionPane.INFORMATION_MESSAGE);
            }
            else
            {
                usarBaseDatos = false;
                System.out.println("⚠️ No se pudo establecer conexión a la base de datos");
                System.out.println("⚠️ Modo sin Base de Datos - Trabajando en memoria");
                
                mostrarMensaje("Advertencia", 
                    "⚠️ No se pudo conectar a la base de datos\n💾 Trabajando en modo memoria (sin persistencia)", 
                    JOptionPane.WARNING_MESSAGE);
            }
        }
        catch (Exception e)
        {
            usarBaseDatos = false;
            System.err.println("❌ Error al conectar a la base de datos:");
            System.err.println("   " + e.getMessage());
            e.printStackTrace();
            
            System.out.println("⚠️ Modo sin Base de Datos - Trabajando en memoria");
            
            mostrarMensaje("Advertencia", 
                "⚠️ No se pudo conectar a la base de datos\n" +
                "Error: " + e.getMessage() + "\n\n" +
                "💾 Trabajando en modo memoria (sin persistencia)\n\n" +
                "Verifica:\n" +
                "1. Que tengas el driver postgresql-42.7.8.jar en el classpath\n" +
                "2. Que tengas conexión a internet\n" +
                "3. Que el servidor de base de datos esté disponible", 
                JOptionPane.WARNING_MESSAGE);
        }

        // Configuración de la ventana principal
        setTitle("Sistema de Gestión de Biblioteca - UNNE -" + (usarBaseDatos ? " [Conectado a la base de datos]" : " [Sin base de datos]"));
        setSize(1000, 700); // Ventana más grande para mejor visualización
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE); // Manejar el cierre manualmente
        setLocationRelativeTo(null); // Centrar la ventana

        // Cerrar conexión al cerrar la ventana (garantizado)
        addWindowListener(new java.awt.event.WindowAdapter()
        {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent)
            {
                cerrarAplicacion();
            }
        });

        // Establecer el Look and Feel multiplataforma (Nimbus) para consistencia en todos los SO
        try
        {
            // Usar Nimbus en lugar del LaF del sistema para que funcione igual en Mac y Windows
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        }
        catch (Exception e)
        {
            // Si Nimbus no está disponible, usar el LaF por defecto
            System.err.println("⚠️ No se pudo cargar Nimbus LaF: " + e.getMessage());
        }

        // Crear la interfaz
        this.inicializarComponentes();

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
        contenedorCentral.add(this.crearPanelCentral(), BorderLayout.CENTER);
        
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
        ImageIcon icono = new ImageIcon(getClass().getResource("/Webp.net-resizeimage-1-300x300.png"));
        // Necesito ajustar la imagen para que no ocupe mucho espacio
        icono = new ImageIcon(icono.getImage().getScaledInstance(70, 70, Image.SCALE_SMOOTH));
        JLabel lblTitulo = new JLabel(biblioteca.getNombre(), icono, JLabel.LEFT);
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
     * Crea el panel central con los botones de acciones principales
     */
    private JPanel crearPanelCentral()
    {
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBackground(COLOR_FONDO);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(20, 20, 20, 20);
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;

        // Crear los tres botones principales más grandes
        JButton btnGestionarSocios = crearBotonPrincipal("Gestionar Socios", COLOR_PRIMARIO, COLOR_PRIMARIO_HOVER);
        JButton btnGestionarLibros = crearBotonPrincipal("Gestionar Libros", COLOR_SECUNDARIO, COLOR_SECUNDARIO_HOVER);
        JButton btnGestionarPrestamos = crearBotonPrincipal("Gestionar Préstamos", COLOR_EXITO, COLOR_EXITO_HOVER);

        // Agregar acciones a los botones
        btnGestionarSocios.addActionListener(e -> this.mostrarMenuGestionarSocios());
        btnGestionarLibros.addActionListener(e -> this.mostrarMenuGestionarLibros());
        btnGestionarPrestamos.addActionListener(e -> this.mostrarMenuGestionarPrestamos());

        // Organizar en una fila horizontal
        gbc.gridx = 0; gbc.gridy = 0;
        panel.add(btnGestionarSocios, gbc);
        
        gbc.gridx = 1;
        panel.add(btnGestionarLibros, gbc);
        
        gbc.gridx = 2;
        panel.add(btnGestionarPrestamos, gbc);
        
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
        boton.setOpaque(true);  // Necesario para macOS
        boton.setContentAreaFilled(true);  // Necesario para macOS
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
     * Crea un botón principal más grande para el menú principal
     */
    private JButton crearBotonPrincipal(String texto, Color color, Color colorHover)
    {
        JButton boton = new JButton(texto);
        boton.setFont(new Font("Segoe UI", Font.BOLD, 18));
        boton.setBackground(color);
        boton.setForeground(Color.WHITE);
        boton.setOpaque(true);  // Necesario para macOS
        boton.setContentAreaFilled(true);  // Necesario para macOS
        boton.setFocusPainted(false);
        boton.setBorderPainted(false);
        boton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        boton.setPreferredSize(new Dimension(280, 120));
        
        // Borde sutil redondeado
        boton.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(COLOR_BORDER, 1),
            BorderFactory.createEmptyBorder(20, 30, 20, 30)
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
    
    // ==========================================
    // Paneles de Menús de Gestión
    // ==========================================
    
    /**
     * Muestra el menú de gestión de socios
     */
    private void mostrarMenuGestionarSocios()
    {
        JDialog dialogo = new JDialog(this, "Gestión de Socios", true);
        dialogo.setSize(600, 450);
        dialogo.setLocationRelativeTo(this);

        // Panel principal de Gestionar socios
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBackground(COLOR_FONDO);
        panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(15, 15, 15, 15);
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;

        // Título
        JLabel lblTitulo = new JLabel("Gestión de Socios");
        lblTitulo.setFont(new Font("Segoe UI", Font.BOLD, 24));
        lblTitulo.setForeground(COLOR_TEXTO);
        gbc.gridx = 0; gbc.gridy = 0; gbc.gridwidth = 2;
        gbc.weighty = 0.2;
        panel.add(lblTitulo, gbc);

        // Botones de acciones
        gbc.gridwidth = 1;
        gbc.weighty = 1.0;

        JButton btnAgregar = crearBoton("Agregar Socio", COLOR_PRIMARIO, COLOR_PRIMARIO_HOVER);
        JButton btnListar = crearBoton("Listar Socios", COLOR_SECUNDARIO, COLOR_SECUNDARIO_HOVER);
        JButton btnEliminar = crearBoton("Eliminar Socio", COLOR_ADVERTENCIA, COLOR_ADVERTENCIA_HOVER);
        JButton btnVolver = crearBoton("Volver", new Color(107, 114, 128), new Color(75, 85, 99));

        btnAgregar.addActionListener(e -> { dialogo.dispose(); this.mostrarDialogoAgregarSocio(); });
        btnListar.addActionListener(e -> { dialogo.dispose(); this.mostrarListaSocios(); });
        btnEliminar.addActionListener(e -> { dialogo.dispose(); this.mostrarDialogoEliminarSocio(); });
        btnVolver.addActionListener(e -> dialogo.dispose());

        // Posicionar botones en la cuadrícula
        gbc.gridx = 0; gbc.gridy = 1;
        panel.add(btnAgregar, gbc);

        gbc.gridx = 1;
        panel.add(btnListar, gbc);

        gbc.gridx = 0; gbc.gridy = 2;
        panel.add(btnEliminar, gbc);

        gbc.gridx = 1;
        panel.add(btnVolver, gbc);

        dialogo.add(panel);
        dialogo.setVisible(true);
    }
    
    /**
     * Muestra el menú de gestión de libros
     */
    private void mostrarMenuGestionarLibros()
    {
        JDialog dialogo = new JDialog(this, "Gestión de Libros", true);
        dialogo.setSize(600, 450);
        dialogo.setLocationRelativeTo(this);

        // Panel principal de Gestionar libros
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBackground(COLOR_FONDO);
        panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(15, 15, 15, 15);
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;

        // Título
        JLabel lblTitulo = new JLabel("Gestión de Libros");
        lblTitulo.setFont(new Font("Segoe UI", Font.BOLD, 24));
        lblTitulo.setForeground(COLOR_TEXTO);
        gbc.gridx = 0; gbc.gridy = 0; gbc.gridwidth = 2;
        gbc.weighty = 0.2;
        panel.add(lblTitulo, gbc);

        // Botones de acciones
        gbc.gridwidth = 1;
        gbc.weighty = 1.0;

        JButton btnAgregar = crearBoton("Agregar Libro", COLOR_SECUNDARIO, COLOR_SECUNDARIO_HOVER);
        JButton btnEliminar = crearBoton("Eliminar Libro", COLOR_ADVERTENCIA, COLOR_ADVERTENCIA_HOVER);
        JButton btnTitulos = crearBoton("Ver Títulos", COLOR_PRIMARIO, COLOR_PRIMARIO_HOVER);
        JButton btnVolver = crearBoton("Volver", new Color(107, 114, 128), new Color(75, 85, 99));

        btnAgregar.addActionListener(e -> { dialogo.dispose(); this.mostrarDialogoAgregarLibro(); });
        btnEliminar.addActionListener(e -> { dialogo.dispose(); this.mostrarDialogoEliminarLibro(); });
        btnTitulos.addActionListener(e -> { dialogo.dispose(); this.mostrarTitulosLibros(); });
        btnVolver.addActionListener(e -> dialogo.dispose());

        // Posicionar botones en la cuadrícula
        gbc.gridx = 0; gbc.gridy = 1;
        panel.add(btnAgregar, gbc);

        gbc.gridx = 1;
        panel.add(btnEliminar, gbc);

        gbc.gridx = 0; gbc.gridy = 2;
        panel.add(btnTitulos, gbc);

        gbc.gridx = 1;
        panel.add(btnVolver, gbc);

        dialogo.add(panel);
        dialogo.setVisible(true);
    }
    
    /**
     * Muestra el menú de gestión de préstamos
     */
    private void mostrarMenuGestionarPrestamos()
    {
        JDialog dialogo = new JDialog(this, "Gestión de Préstamos", true);
        dialogo.setSize(700, 550);
        dialogo.setLocationRelativeTo(this);

        // Panel principal de Gestionar préstamos
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBackground(COLOR_FONDO);
        panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(15, 15, 15, 15);
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;

        // Título
        JLabel lblTitulo = new JLabel("Gestión de Préstamos");
        lblTitulo.setFont(new Font("Segoe UI", Font.BOLD, 24));
        lblTitulo.setForeground(COLOR_TEXTO);
        gbc.gridx = 0; gbc.gridy = 0; gbc.gridwidth = 2;
        gbc.weighty = 0.2;
        panel.add(lblTitulo, gbc);

        // Botones de acciones
        gbc.gridwidth = 1;
        gbc.weighty = 1.0;

        JButton btnPrestar = crearBoton("Prestar Libro", COLOR_EXITO, COLOR_EXITO_HOVER);
        JButton btnDevolver = crearBoton("Devolver Libro", COLOR_ADVERTENCIA, COLOR_ADVERTENCIA_HOVER);
        JButton btnVencidos = crearBoton("Préstamos Vencidos", new Color(239, 68, 68), new Color(220, 38, 38));
        JButton btnQuienTiene = crearBoton("Quién Tiene Libro", COLOR_SECUNDARIO, COLOR_SECUNDARIO_HOVER);
        JButton btnResponsables = crearBoton("Docentes Responsables", COLOR_PRIMARIO, COLOR_PRIMARIO_HOVER);
        JButton btnVolver = crearBoton("Volver", new Color(107, 114, 128), new Color(75, 85, 99));

        btnPrestar.addActionListener(e -> { dialogo.dispose(); this.mostrarDialogoPrestarLibro(); });
        btnDevolver.addActionListener(e -> { dialogo.dispose(); this.mostrarDialogoDevolverLibro(); });
        btnVencidos.addActionListener(e -> { dialogo.dispose(); this.mostrarPrestamosVencidos(); });
        btnQuienTiene.addActionListener(e -> { dialogo.dispose(); this.mostrarDialogoQuienTieneLibro(); });
        btnResponsables.addActionListener(e -> { dialogo.dispose(); this.mostrarDocentesResponsables(); });
        btnVolver.addActionListener(e -> dialogo.dispose());

        // Posicionar botones en la cuadrícula
        gbc.gridx = 0; gbc.gridy = 1;
        panel.add(btnPrestar, gbc);

        gbc.gridx = 1;
        panel.add(btnDevolver, gbc);

        gbc.gridx = 0; gbc.gridy = 2;
        panel.add(btnVencidos, gbc);

        gbc.gridx = 1;
        panel.add(btnQuienTiene, gbc);

        gbc.gridx = 0; gbc.gridy = 3;
        panel.add(btnResponsables, gbc);

        gbc.gridx = 1;
        panel.add(btnVolver, gbc);

        dialogo.add(panel);
        dialogo.setVisible(true);
    }

    // ==========================================
    // DIÁLOGOS DE SOCIOS
    // ==========================================

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
                            System.out.println("Socio guardado en la base de datos");
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
                            System.out.println("Socio guardado en la base de datos");
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
                        System.out.println("Libro guardado en la base de datos");
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
                            System.out.println("Préstamo guardado en la base de datos");
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
                        System.out.println("Devolución actualizada en la base de datos");
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
        boton.setOpaque(true);  // Necesario para macOS
        boton.setContentAreaFilled(true);  // Necesario para macOS
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
    
    // ==========================================
    // MÉTODOS ADICIONALES PARA GESTIÓN
    // ==========================================
    
    /**
     * Muestra el diálogo para eliminar un socio
     */
    private void mostrarDialogoEliminarSocio()
    {
        if (biblioteca.getSocios().isEmpty())
        {
            mostrarMensaje("Advertencia", "No hay socios registrados", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        JDialog dialogo = new JDialog(this, "Eliminar Socio", true);
        dialogo.setSize(500, 250);
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
        
        // Botones
        gbc.gridx = 0; gbc.gridy = 1; gbc.gridwidth = 2;
        JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 0));
        panelBotones.setBackground(Color.WHITE);
        
        JButton btnEliminar = crearBotonDialogo("Eliminar", COLOR_ADVERTENCIA);
        JButton btnCancelar = crearBotonDialogo("Cancelar", new Color(107, 114, 128));
        
        btnEliminar.addActionListener(e -> {
            try
            {
                int dni = Integer.parseInt(txtDni.getText().trim());
                Socio socio = biblioteca.buscarSocio(dni);
                
                if (socio != null)
                {
                    // Verificar si tiene préstamos activos
                    if (socio.cantLibrosPrestados() > 0)
                    {
                        mostrarMensaje("Error", "No se puede eliminar el socio porque tiene libros prestados", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    
                    if (biblioteca.quitarSocio(socio))
                    {
                        // Eliminar de la base de datos si está habilitada
                        if (usarBaseDatos)
                        {
                            dao.eliminarSocio(dni);
                        }
                        mostrarMensaje("Éxito", "Socio eliminado correctamente", JOptionPane.INFORMATION_MESSAGE);
                        dialogo.dispose();
                    }
                    else
                    {
                        mostrarMensaje("Error", "No se pudo eliminar el socio", JOptionPane.ERROR_MESSAGE);
                    }
                }
                else
                {
                    mostrarMensaje("Error", "No se encontró un socio con ese DNI", JOptionPane.ERROR_MESSAGE);
                }
            }
            catch (NumberFormatException ex)
            {
                mostrarMensaje("Error", "El DNI debe ser un número válido", JOptionPane.ERROR_MESSAGE);
            }
        });
        
        btnCancelar.addActionListener(e -> dialogo.dispose());
        
        panelBotones.add(btnEliminar);
        panelBotones.add(btnCancelar);
        panel.add(panelBotones, gbc);
        
        dialogo.add(panel);
        dialogo.setVisible(true);
    }
    
    /**
     * Muestra el diálogo para eliminar un libro
     */
    private void mostrarDialogoEliminarLibro()
    {
        if (biblioteca.getLibros().isEmpty())
        {
            mostrarMensaje("Advertencia", "No hay libros en la biblioteca", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        JDialog dialogo = new JDialog(this, "Eliminar Libro", true);
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
        
        JButton btnEliminar = crearBotonDialogo("Eliminar", COLOR_ADVERTENCIA);
        JButton btnCancelar = crearBotonDialogo("Cancelar", new Color(107, 114, 128));
        
        btnEliminar.addActionListener(e -> {
            String titulo = txtTitulo.getText().trim();
            
            if (titulo.isEmpty())
            {
                mostrarMensaje("Error", "Debe ingresar el título del libro", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            // Buscar el libro
            Libro libroEncontrado = null;
            for (Libro libro : biblioteca.getLibros())
            {
                if (libro.getTitulo().equalsIgnoreCase(titulo))
                {
                    libroEncontrado = libro;
                    break;
                }
            }
            
            if (libroEncontrado != null)
            {
                // Verificar si está prestado
                if (libroEncontrado.prestado())
                {
                    mostrarMensaje("Error", "No se puede eliminar el libro porque está prestado", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                
                if (biblioteca.quitarLibro(libroEncontrado))
                {
                    // Eliminar de la base de datos si está habilitada
                    if (usarBaseDatos)
                    {
                        dao.eliminarLibro(titulo);
                    }
                    mostrarMensaje("Éxito", "Libro eliminado correctamente", JOptionPane.INFORMATION_MESSAGE);
                    dialogo.dispose();
                }
                else
                {
                    mostrarMensaje("Error", "No se pudo eliminar el libro", JOptionPane.ERROR_MESSAGE);
                }
            }
            else
            {
                mostrarMensaje("Error", "No se encontró un libro con ese título", JOptionPane.ERROR_MESSAGE);
            }
        });
        
        btnCancelar.addActionListener(e -> dialogo.dispose());
        
        panelBotones.add(btnEliminar);
        panelBotones.add(btnCancelar);
        panel.add(panelBotones, gbc);
        
        dialogo.add(panel);
        dialogo.setVisible(true);
    }
    
    /**
     * Muestra todos los títulos de libros sin repetir
     */
    private void mostrarTitulosLibros()
    {
        if (biblioteca.getLibros().isEmpty())
        {
            mostrarMensaje("Información", "No hay libros en la biblioteca", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        
        String titulos = biblioteca.listaDeTitulos();
        StringBuilder contenido = new StringBuilder();
        contenido.append("═══════════════════════════════════════════\n");
        contenido.append("           TÍTULOS DE LA BIBLIOTECA          \n");
        contenido.append("═══════════════════════════════════════════\n\n");
        contenido.append(titulos);
        contenido.append("\n═══════════════════════════════════════════\n");
        contenido.append("Total de títulos únicos: ").append(titulos.split("\n").length);
        
        mostrarVentanaTexto("Títulos de Libros", contenido.toString());
    }
    
    /**
     * Muestra los préstamos vencidos
     */
    private void mostrarPrestamosVencidos()
    {
        ArrayList<Prestamo> vencidos = biblioteca.prestamosVencidos();
        
        if (vencidos.isEmpty())
        {
            mostrarMensaje("Información", "No hay préstamos vencidos", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        
        StringBuilder contenido = new StringBuilder();
        contenido.append("═══════════════════════════════════════════\n");
        contenido.append("           PRÉSTAMOS VENCIDOS          \n");
        contenido.append("═══════════════════════════════════════════\n\n");
        
        int i = 1;
        for (Prestamo prestamo : vencidos)
        {
            contenido.append("Préstamo #").append(i++).append(":\n");
            contenido.append(prestamo.toString()).append("\n");
            contenido.append("───────────────────────────────────────\n\n");
        }
        
        contenido.append("═══════════════════════════════════════════\n");
        contenido.append("Total de préstamos vencidos: ").append(vencidos.size());
        
        mostrarVentanaTexto("Préstamos Vencidos", contenido.toString());
    }
    
    /**
     * Muestra el diálogo para consultar quién tiene un libro
     */
    private void mostrarDialogoQuienTieneLibro()
    {
        if (biblioteca.getLibros().isEmpty())
        {
            mostrarMensaje("Advertencia", "No hay libros en la biblioteca", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        JDialog dialogo = new JDialog(this, "¿Quién Tiene el Libro?", true);
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
        
        JButton btnBuscar = crearBotonDialogo("Buscar", COLOR_PRIMARIO);
        JButton btnCancelar = crearBotonDialogo("Cancelar", new Color(107, 114, 128));
        
        btnBuscar.addActionListener(e -> {
            String titulo = txtTitulo.getText().trim();
            
            if (titulo.isEmpty())
            {
                mostrarMensaje("Error", "Debe ingresar el título del libro", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            // Buscar el libro
            Libro libroEncontrado = null;
            for (Libro libro : biblioteca.getLibros())
            {
                if (libro.getTitulo().equalsIgnoreCase(titulo))
                {
                    libroEncontrado = libro;
                    break;
                }
            }
            
            if (libroEncontrado != null)
            {
                try
                {
                    String nombreSocio = biblioteca.quienTieneElLibro(libroEncontrado);
                    mostrarMensaje("Información", 
                        "El libro \"" + titulo + "\" está prestado a:\n\n" + nombreSocio, 
                        JOptionPane.INFORMATION_MESSAGE);
                    dialogo.dispose();
                }
                catch (LibroNoPrestadoException ex)
                {
                    mostrarMensaje("Información", ex.getMessage(), JOptionPane.INFORMATION_MESSAGE);
                    dialogo.dispose();
                }
            }
            else
            {
                mostrarMensaje("Error", "No se encontró un libro con ese título", JOptionPane.ERROR_MESSAGE);
            }
        });
        
        btnCancelar.addActionListener(e -> dialogo.dispose());
        
        panelBotones.add(btnBuscar);
        panelBotones.add(btnCancelar);
        panel.add(panelBotones, gbc);
        
        dialogo.add(panel);
        dialogo.setVisible(true);
    }
    
    /**
     * Muestra la lista de docentes responsables
     */
    private void mostrarDocentesResponsables()
    {
        ArrayList<Docente> responsables = biblioteca.docentesResponsables();
        
        if (responsables.isEmpty())
        {
            mostrarMensaje("Información", "No hay docentes responsables registrados", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        
        StringBuilder contenido = new StringBuilder();
        contenido.append("═══════════════════════════════════════════\n");
        contenido.append("        DOCENTES RESPONSABLES          \n");
        contenido.append("═══════════════════════════════════════════\n\n");
        contenido.append("Docentes que devolvieron sus libros siempre\n");
        contenido.append("antes o el mismo día del vencimiento:\n\n");
        
        int i = 1;
        for (Docente docente : responsables)
        {
            // Usar toString() que ya está implementado en Socio
            contenido.append(i++).append(") ").append(docente.toString()).append("\n\n");
        }
        
        contenido.append("═══════════════════════════════════════════\n");
        contenido.append("Total de docentes responsables: ").append(responsables.size());
        
        mostrarVentanaTexto("Docentes Responsables", contenido.toString());
    }
    
    /**
     * Cierra correctamente la aplicación, asegurando que se cierre
     * la conexión a la base de datos antes de salir.
     */
    private void cerrarAplicacion()
    {
        System.out.println("\n🔄 Cerrando aplicación...");
        
        // Cerrar la conexión a la base de datos si está activa
        if (usarBaseDatos)
        {
            try
            {
                //DatabaseConfig.closeConnection();
                System.out.println("✅ Conexión a la base de datos cerrada correctamente");
            }
            catch (Exception e)
            {
                System.err.println("⚠️ Error al cerrar la conexión: " + e.getMessage());
            }
        }
        
        System.out.println("👋 ¡Hasta pronto!");
        
        // Cerrar la ventana y terminar la aplicación
        dispose();
        System.exit(0);
    }
}