/**
 * Universidad del Valle de Guatemala
 * @author Angie Nadissa Vela López, 23764
 * @description Clase que administra el registro de estudiantes, asignación de notas 
 * y datos estadísticos de una universidad
 * @date creación 02/09/2023 última modificación 28/08/23
 */
import java.util.ArrayList;


public class Universidad {

    private String sedeEstudiante;
    private ArrayList<String> arraySede;
    private ArrayList<Estudiante> arrayEstudiante;

    public Universidad(){
        sedeEstudiante = "";
        arraySede = new ArrayList<String>();
        //arrayEstudiante = new ArrayList<Estudiante>();
    }

    public void registrarEstudiante(String nombre, String apellido, int carnet, String fechaNacimiento, String correo) {

    }

    public boolean validarRegistroNotas(int carnet, String curso, int nota) {
        boolean flag = false;

        return flag;
    }

    public void registrarNotas(int carnet, String curso, int nota) {

    }

    public void registrarSede(String sede){

    }

    public boolean buscarEstudiante(int carnet){
        boolean flag = false;
        return flag;
    }

    public String mostrarSedes(){
        return "";
    }

    public void mostrarEstadisticas() {

    }

    public int notaMasAlta(String curso) {
        return 0;
    }

    public int notaMasBaja(String curso) {
        return 0;
    }

    public float calcularPromedio(String curso) {
        return 0.0f;
    }

    public int calcularMediana(String curso) {
        return 0;
    }

    public int calcularModa(String curso){
        return 0;
    } 

    public float calcularDesviacion(String curso) {
        return 0.0f;
    }

    public String getSedeEstudiante(){
        return "";
    }

}
