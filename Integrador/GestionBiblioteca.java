import javax.swing.SwingUtilities;
import javax.swing.JOptionPane;

/**
 * Clase principal para la gestión de biblioteca.
 * Punto de entrada principal de la aplicación.
 * 
 * Inicializa la interfaz gráfica que a su vez maneja
 * la conexión a la base de datos automáticamente.
 * 
 * Puede usarse para generar un archivo JAR ejecutable.
 * 
 * IMPORTANTE: Para que funcione correctamente necesitas:
 * - El driver PostgreSQL (postgresql-42.7.8.jar) en el classpath
 * - Conexión a internet para acceder a la base de datos remota
 * 
 * @author Sistema de Biblioteca
 * @version 2.0
 */
public class GestionBiblioteca 
{
    /**
     * Método principal que inicia la aplicación.
     * 
     * Proceso:
     * 1. Muestra mensaje de bienvenida
     * 2. Lanza la interfaz gráfica
     * 3. La interfaz maneja la conexión a la BD y el cierre
     * 4. Maneja errores apropiadamente
     * 
     * @param args argumentos de línea de comandos (no se utilizan)
     */
    public static void main(String[] args)
    {
        // Mostrar información de inicio en consola
        mostrarBienvenida();
        
        // Lanzar la interfaz gráfica en el hilo de eventos de Swing
        SwingUtilities.invokeLater(() -> {
            try
            {
                // Crear la interfaz (ella misma se encarga de la BD y del cierre)
                new BibliotecaGUI();
                
                System.out.println("✅ Aplicación iniciada correctamente");
            }
            catch (Exception e)
            {
                System.err.println("❌ Error crítico al iniciar la aplicación:");
                System.err.println(e.getMessage());
                e.printStackTrace();
                
                JOptionPane.showMessageDialog(
                    null,
                    "Error crítico al iniciar la aplicación:\n" + e.getMessage(),
                    "Error Fatal",
                    JOptionPane.ERROR_MESSAGE
                );
                
                System.exit(1);
            }
        });
    }
    
    /**
     * Muestra mensaje de bienvenida en la consola.
     */
    private static void mostrarBienvenida()
    {
        System.out.println("╔═══════════════════════════════════════════════════╗");
        System.out.println("║   📚 SISTEMA DE GESTIÓN DE BIBLIOTECA - UNNE    ║");
        System.out.println("║              Versión 2.0 - 2024                  ║");
        System.out.println("╚═══════════════════════════════════════════════════╝");
        System.out.println();
        System.out.println("🚀 Iniciando aplicación...");
        System.out.println("⏳ Conectando a la base de datos...");
        System.out.println();
    }
}