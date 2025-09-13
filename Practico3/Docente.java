/**
 * Clase que representa a un docente con sus datos personales y salariales.
 * Permite calcular el sueldo total considerando el sueldo básico y la asignación familiar.
 * 
 * @author Sistema POO
 * @version 1.0
 */
public class Docente {
private String nombre;
private String grado;
private double sueldoBasico;
private double asignacionFamiliar;

/**
 * Constructor que inicializa un docente con todos sus datos.
 * 
 * @param p_nombre El nombre del docente
 * @param p_grado El grado académico del docente
 * @param p_sueldoBasico El sueldo básico del docente
 * @param p_asigFamiliar La asignación familiar del docente
 */
public Docente (String p_nombre, String p_grado, double p_sueldoBasico, double p_asigFamiliar){
  this.setnombre(p_nombre);
  this.setgrado(p_grado);
  this.setsueldoBasico(p_sueldoBasico);
  this.setasignacionFamiliar(p_asigFamiliar);
}

private void setnombre (String p_nombre) {
    this.nombre = p_nombre;
}
public String getnombre() {
    return this.nombre;
}
private void setgrado (String p_grado) {
    this.grado = p_grado;
}
public String getgrado() {
    return this.grado;
}
private void setsueldoBasico (double p_sueldoBasico) {
    this.sueldoBasico = p_sueldoBasico;
}
public double getsueldoBasico() {
    return this.sueldoBasico;
}

private void setasignacionFamiliar (double p_asigFamiliar) {
    this.asignacionFamiliar = p_asigFamiliar;
}

public double getasignacionFamiliar() {
    return this.asignacionFamiliar;
}

/**
 * Calcula el sueldo total del docente sumando el sueldo básico y la asignación familiar.
 * 
 * @return El sueldo total del docente
 */
public double calcularSueldo() {
 return this.getsueldoBasico() + this.getasignacionFamiliar();
}
}