/**
 * Universidad del Valle de Guatemala
 * @author Angie Nadissa Vela López, 23764
 * @description Clase que modela a un estudiante universitario, aca se guarda toda su información
 * @date creación 02/09/2023 última modificación 28/08/23
 */

 import java.util.ArrayList;

public class Estudiante {

    private String nombre;
    private String apellido;
    private int carnet;
    private String fechaNacimiento;
    private String correo;
    private String sede;
    private ArrayList<Examen> arrayExamenes;

    public Estudiante(String nombre, String apellido, int carnet, String fechaNacimiento, String correo, String sedeEstudiante){
        this.nombre = nombre;
        this.apellido = apellido;
        this.carnet = carnet;
        this.fechaNacimiento = fechaNacimiento;
        this.correo = correo;
        this.sede = sedeEstudiante;
    }

    /** 
     * @return String
     */
    public String getNombre() {
        return nombre;
    }
    
    /** 
     * @param nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    /** 
     * @return String
     */
    public String getApellido() {
        return apellido;
    }
    
    /** 
     * @param apellido
     */
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    
    /** 
     * @return int
     */
    public int getCarnet() {
        return carnet;
    }

    
    /** 
     * @return String
     */
    public String getFechaNacimiento() {
        return fechaNacimiento;
    }
    
    /** 
     * @param fechaNacimiento
     */
    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
    
    /** 
     * @return String
     */
    public String getCorreo() {
        return correo;
    }
    
    /** 
     * @param correo
     */
    public void setCorreo(String correo) {
        this.correo = correo;
    }
    
    /** 
     * @return String
     */
    public String getSede() {
        return sede;
    }

    
    /** 
     * @return ArrayList<Examen>
     */
    //ver si son necesarios
    public ArrayList<Examen> getArrayExamenes() {
        return arrayExamenes;
    }
    
    /** 
     * @param arrayExamenes
     */
    public void setArrayExamenes(ArrayList<Examen> arrayExamenes) {
        this.arrayExamenes = arrayExamenes;
    }

    
    /** 
     * @return String
     */
    public String toString(){
        String cadena = "";
        return cadena;
    }
}
