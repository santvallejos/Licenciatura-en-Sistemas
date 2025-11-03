package vistas;

import modelos.Libro;
import javax.swing.*;
import java.awt.*;
/**
 * Diálogo para agregar o modificar libros
 * 
 * @version 1.0
*/
public class DialogoLibro extends JDialog
{
    private JTextField txtTitulo;
    private JSpinner spnEdicion;
    private JTextField txtEditorial;
    private JSpinner spnAnio;
    private JSpinner spnCantidadTotal;
    private JSpinner spnCantidadDisponible;
    private Libro libro;
    private boolean esModificacion;

    
}
