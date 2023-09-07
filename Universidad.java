/**
 * Universidad del Valle de Guatemala
 * @author Angie Nadissa Vela López, 23764
 * @description Clase que administra el registro de estudiantes, asignación de notas 
 * y datos estadísticos de una universidad
 * @date creación 02/09/2023 última modificación 06/09/23
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Collections;


public class Universidad {

    private String sedeEstudiante;
    private ArrayList<String> arraySede;
    private ArrayList<Estudiante> arrayEstudiante;

    public Universidad(){
        sedeEstudiante = "";
        arraySede = new ArrayList<String>();
        arrayEstudiante = new ArrayList<Estudiante>();
    }
    
    
    /** 
     * @param nombre
     * @param apellido
     * @param carnet
     * @param fechaNacimiento
     * @param correo
     */
    public void registrarEstudiante(String nombre, String apellido, int carnet, String fechaNacimiento, String correo) {
        Estudiante nuevoEstudiante = new Estudiante(nombre, apellido, carnet, fechaNacimiento, correo, sedeEstudiante);
        arrayEstudiante.add(nuevoEstudiante);
        System.out.println("Estudiante registrado correctamente! ");
    }

    
    /** 
     * @param carnet
     * @param curso
     * @return boolean
     */
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

    
    /** 
     * @param opcion
     * @return String
     */
    public String devolverCurso(int opcion){
        String curso = "";

        if(opcion == 1){
            curso = "Matematica";
        }else if(opcion == 2){
            curso = "Lenguaje";
        }else if(opcion == 3){
            curso = "Quimica";
        }else if(opcion == 4){
            curso = "Fisica";
        }else if(opcion == 5){
            curso = "comprensionLec";
        }else if(opcion == 6){
            curso = "Estadistica";
        }

        return curso;
    }

    
    /** 
     * @param carnet
     * @param curso
     * @param nota
     */
    public void registrarNotas(int carnet, String curso, int nota) {

        if(buscarEstudiante(carnet)){
            if(validarRegistroNotas(carnet, curso)) {

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

    
    /** 
     * @param sede
     */
    public void registrarSede(String sede){
        if(!sede.equals("")){
            arraySede.add(sede);
            System.out.println("Sede registrada correctamente!");
            sedeEstudiante = sede;
        }else{
            System.out.println("Error, campo vacío!");
        }
        
    }

    
    /** 
     * @param carnet
     * @return boolean
     */
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

    
    /** 
     * @param carnet
     * @return int
     */
    public int buscarIndexEstudiante(int carnet){
        int index = -1;
        for (int i = 0; i < arrayEstudiante.size(); i++){
            if(carnet == arrayEstudiante.get(i).getCarnet()){
                index = i;
            }
        }
        return index;
    }

    
    /** 
     * @return String
     */
    public String mostrarSedes(){
        sedeEstudiante = "";
        String cadenaSede = "";
        for (int i = 0 ; i < arraySede.size(); i++){
            cadenaSede += (i+1) + ". " + arraySede.get(i) + "\n";
        }
        return cadenaSede;
    }

    
    /** 
     * @param indexSede
     */
    public void seleccionarSede(int indexSede){
        sedeEstudiante = arraySede.get(indexSede);   
    }

    public void mostrarEstadisticas() {
        System.out.println("\nESTADISTICAS GENERALES");
        System.out.println("\n*************************");

        System.out.println("\n\nMatematica");
        System.out.println("\nNota más alta: " + notaMasAlta("Matematica"));
        System.out.println("\nNota más baja: " + notaMasBaja("Matematica"));
        System.out.println("\nPromedio: " + calcularPromedio("Matematica"));
        System.out.println("\nMediana: " + calcularMediana("Matematica"));
        System.out.println("\nModa: " + calcularModa("Matematica"));
        System.out.println("\nDesviación estándar: " + calcularDesviacion("Matematica"));

        System.out.println("\n\nLenguaje");

        System.out.println("\nNota más alta: " + notaMasAlta("Lenguaje"));
        System.out.println("\nNota más baja: " + notaMasBaja("Lenguaje"));
        System.out.println("\nPromedio: " + calcularPromedio("Lenguaje"));
        System.out.println("\nMediana: " + calcularMediana("Lenguaje"));
        System.out.println("\nModa: " + calcularModa("Lenguaje"));
        System.out.println("\nDesviación estándar: " + calcularDesviacion("Lenguaje"));

        System.out.println("\n\nQuimica");

        System.out.println("\nNota más alta: " + notaMasAlta("Quimica"));
        System.out.println("\nNota más baja: " + notaMasBaja("Quimica"));
        System.out.println("\nPromedio: " + calcularPromedio("Quimica"));
        System.out.println("\nMediana: " + calcularMediana("Quimica"));
        System.out.println("\nModa: " + calcularModa("Quimica"));
        System.out.println("\nDesviación estándar: " + calcularDesviacion("Quimica"));

        System.out.println("\n\nFisica");

        System.out.println("\nNota más alta: " + notaMasAlta("Fisica"));
        System.out.println("\nNota más baja: " + notaMasBaja("Fisica"));
        System.out.println("\nPromedio: " + calcularPromedio("Fisica"));
        System.out.println("\nMediana: " + calcularMediana("Fisica"));
        System.out.println("\nModa: " + calcularModa("Fisica"));
        System.out.println("\nDesviación estándar: " + calcularDesviacion("Fisica"));

        System.out.println("\n\nComprension Lectora");

        System.out.println("\nNota más alta: " + notaMasAlta("comprensionLec"));
        System.out.println("\nNota más baja: " + notaMasBaja("comprensionLec"));
        System.out.println("\nPromedio: " + calcularPromedio("comprensionLec"));
        System.out.println("\nMediana: " + calcularMediana("comprensionLec"));
        System.out.println("\nModa: " + calcularModa("comprensionLec"));
        System.out.println("\nDesviación estándar: " + calcularDesviacion("comprensionLec"));

        System.out.println("\n\nEstadistica");

        System.out.println("\nNota más alta: " + notaMasAlta("Estadistica"));
        System.out.println("\nNota más baja: " + notaMasBaja("Estadistica"));
        System.out.println("\nPromedio: " + calcularPromedio("Estadistica"));
        System.out.println("\nMediana: " + calcularMediana("Estadistica"));
        System.out.println("\nModa: " + calcularModa("Estadistica"));
        System.out.println("\nDesviación estándar: " + calcularDesviacion("Estadistica"));

    }

    
    /** 
     * @param curso
     * @return int
     */
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

    
    /** 
     * @param curso
     * @return int
     */
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

    
    /** 
     * @param curso
     * @return float
     */
    public float calcularPromedio(String curso) {
        float prom = 0.0f;
        for(int  i = 0; i < arrayEstudiante.size(); i++){
            if(curso.equals(arrayEstudiante.get(i).getArrayExamenes().get(i).getCurso()) && sedeEstudiante.equals(arrayEstudiante.get(i).getSede())){
                prom += arrayEstudiante.get(i).getArrayExamenes().get(i).getNota();
            }
        }
        return prom;
    }

    
    /** 
     * @param curso
     * @return int
     */
    public int calcularMediana(String curso) {
        int mediana = 0;
        ArrayList<Integer> notas = new ArrayList<>();
        for(int  i = 0; i < arrayEstudiante.size(); i++){
            if(curso.equals(arrayEstudiante.get(i).getArrayExamenes().get(i).getCurso()) && sedeEstudiante.equals(arrayEstudiante.get(i).getSede())){
                notas.add(arrayEstudiante.get(i).getArrayExamenes().get(i).getNota());
            }
        }
        Collections.sort(notas);
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

    
    /** 
     * @param curso
     * @return int
     */
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

    
    /** 
     * @param curso
     * @return float
     */



    public float calcularDesviacion(String curso) {
        float desviacion = 0.0f;
        ArrayList<Integer> notas = new ArrayList<>();
        for(int  i = 0; i < arrayEstudiante.size(); i++){
            //verificar si debo modificar .getArrayExamenes.get(0)
            if(curso.equals(arrayEstudiante.get(i).getArrayExamenes().get(i).getCurso()) && sedeEstudiante.equals(arrayEstudiante.get(i).getSede())){
                notas.add(arrayEstudiante.get(i).getArrayExamenes().get(i).getNota());
            }
        }

        float promedio = calcularPromedio(curso);

        float sumaDiferenciasCuadradas = 0;
        for (Integer n : notas) {
            float diferencia = n - promedio;
            sumaDiferenciasCuadradas += diferencia * diferencia;
        }

        // Calcular la desviación estándar
        desviacion = (float) Math.sqrt(sumaDiferenciasCuadradas / notas.size());

        return desviacion;
    }

    
    /** 
     * @return String
     */
    public String getSedeEstudiante(){
        return sedeEstudiante;
    }


}
