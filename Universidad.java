/**
 * Universidad del Valle de Guatemala
 * @author Angie Nadissa Vela López, 23764
 * @description Clase que administra el registro de estudiantes, asignación de notas 
 * y datos estadísticos de una universidad
 * @date creación 02/09/2023 última modificación 28/08/23
 */
import java.util.ArrayList;
import java.util.Arrays;


public class Universidad {

    private String sedeEstudiante;
    private ArrayList<String> arraySede;
    private ArrayList<Estudiante> arrayEstudiante;

    public Universidad(){
        sedeEstudiante = "";
        arraySede = new ArrayList<String>();
        arrayEstudiante = new ArrayList<Estudiante>();
    }
    
    public void registrarEstudiante(String nombre, String apellido, int carnet, String fechaNacimiento, String correo) {
        Estudiante nuevoEstudiante = new Estudiante(nombre, apellido, carnet, fechaNacimiento, correo, sedeEstudiante);
        arrayEstudiante.add(nuevoEstudiante);
        System.out.println("Estudiante registrado correctamente! ");
    }

    //si devuelve false entonces si se puede guardar la nota, porque no existe en la info del estudiante
    //si devuelve true no se puede guardar, el etudiante ya realizó el examen
    public boolean validarRegistroNotas(int carnet, String curso) {
        boolean flag = false;
        for(int i = 0; i < arrayEstudiante.size(); i++ ){
            //ver si esto funciona
            if((carnet == arrayEstudiante.get(i).getCarnet()) && (curso == arrayEstudiante.get(i).getArrayExamenes().get(i).getCurso())){
                flag = true;
            }
        }
        return flag;
    }

    public void registrarNotas(int carnet, String curso, int nota) {

        if(buscarEstudiante(carnet)){
            if(!validarRegistroNotas(carnet, curso)) {

                Examen nuevoExamen = new Examen(curso, nota);
                //ver si esto funciona
                arrayEstudiante.get(buscarIndexEstudiante(carnet)).getArrayExamenes().add(nuevoExamen);
                System.out.println("Nota registrada correctamente!");
            }else{
                System.out.println("Error, el estudiante ya realizó el examen del curso " + curso);
            }
        }else{
            System.out.println("Error, el estudiante no está registrado en la universidad");
        }
    }

    public void registrarSede(String sede){
        if(!sede.equals("")){
            arraySede.add(sede);
            System.out.println("Sede registrada correctamente!");
        }else{
            System.out.println("Error, campo vacío!");
        }
        
    }

    //indica si el estudiante esta registrado en la U para poder guardar su nota
    public boolean buscarEstudiante(int carnet){
        boolean flag = false;
        for (int i = 0; i < arrayEstudiante.size(); i++){
            if(carnet == arrayEstudiante.get(i).getCarnet()){
                flag = true;
            }
        }
        return flag;
    }

    public int buscarIndexEstudiante(int carnet){
        int index = -1;
        for (int i = 0; i < arrayEstudiante.size(); i++){
            if(carnet == arrayEstudiante.get(i).getCarnet()){
                index = i;
            }
        }
        return index;
    }

    public String mostrarSedes(){
        String cadenaSede = "";
        for (int i = 0 ; i < arraySede.size(); i++){
            cadenaSede += (i+1) + ". " + arraySede.get(i) + "\n";
        }
        return cadenaSede;
    }

    public void mostrarEstadisticas() {

    }

    //todo esto filtra por sedeESTUDIANTE
    public int notaMasAlta(String curso) {
        int nota = 0;
        nota = arrayEstudiante.get(0).getArrayExamenes().get(0).getNota();
        for(int  i = 0; i < arrayEstudiante.size(); i++){
            if(curso.equals(arrayEstudiante.get(i).getArrayExamenes().get(i).getCurso()) && sedeEstudiante.equals(arrayEstudiante.get(i).getSede())){
                if(arrayEstudiante.get(i).getArrayExamenes().get(i).getNota() > nota){
                    nota = arrayEstudiante.get(i).getArrayExamenes().get(i).getNota();
                }
            }
        }
        return nota;
    }

    public int notaMasBaja(String curso) {
        int nota = 0;
        nota = arrayEstudiante.get(0).getArrayExamenes().get(0).getNota();
        for(int  i = 0; i < arrayEstudiante.size(); i++){
            if(curso.equals(arrayEstudiante.get(i).getArrayExamenes().get(i).getCurso()) && sedeEstudiante.equals(arrayEstudiante.get(i).getSede())){
                if(arrayEstudiante.get(i).getArrayExamenes().get(i).getNota() < nota){
                    nota = arrayEstudiante.get(i).getArrayExamenes().get(i).getNota();
                }
            }
        }
        return nota;
    }

    public float calcularPromedio(String curso) {
        float prom = 0.0f;
        for(int  i = 0; i < arrayEstudiante.size(); i++){
            if(curso.equals(arrayEstudiante.get(i).getArrayExamenes().get(i).getCurso()) && sedeEstudiante.equals(arrayEstudiante.get(i).getSede())){
                prom += arrayEstudiante.get(i).getArrayExamenes().get(i).getNota();
            }
        }
        return prom;
    }

    public int calcularMediana(String curso) {
        int mediana = 0;
        ArrayList<Integer> notas = new ArrayList<>();
        for(int  i = 0; i < arrayEstudiante.size(); i++){
            if(curso.equals(arrayEstudiante.get(i).getArrayExamenes().get(i).getCurso()) && sedeEstudiante.equals(arrayEstudiante.get(i).getSede())){
                notas.add(arrayEstudiante.get(i).getArrayExamenes().get(i).getNota());
            }
        }
        Arrays.sort(notas);
        int n = notas.size();

        if (n % 2 == 0) {
            // Si la cantidad de notas es par, promedio de los dos valores centrales
            mediana = (notas.get(n / 2 - 1) + notas.get(n / 2)) / 2;
        } else {
            // Si la cantidad de notas es impar, el valor central
            mediana = notas.get(n / 2);
        }
        return mediana;
    }

    public int calcularModa(String curso){

        int maximoNumRepeticiones = 0;
        int moda = 0;
        ArrayList<Integer> notas = new ArrayList<>();
        for(int  i = 0; i < arrayEstudiante.size(); i++){
            if(curso.equals(arrayEstudiante.get(i).getArrayExamenes().get(i).getCurso()) && sedeEstudiante.equals(arrayEstudiante.get(i).getSede())){
                notas.add(arrayEstudiante.get(i).getArrayExamenes().get(i).getNota());
            }
        }
        for (int i = 0; i < notas.size(); i++) {
            int numRepeticiones = 0;
            
            for (int j = 0; j < notas.size(); j++) {
                if (notas.get(i) == notas.get(j)) {
                    numRepeticiones++;
                }

                if (numRepeticiones > maximoNumRepeticiones) {
                    moda = notas.get(i);
                    maximoNumRepeticiones = numRepeticiones;
                }
            }
        }

        return moda;
    } 

    public float calcularDesviacion(String curso) {
        return 0.0f;
    }

    public String getSedeEstudiante(){
        return sedeEstudiante;
    }

}
