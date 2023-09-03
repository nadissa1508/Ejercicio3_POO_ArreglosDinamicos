/**
 * Universidad del Valle de Guatemala
 * @author Angie Nadissa Vela López, 23764
 * @description Clase que modela el examen de ingreso de un estudiante
 * @date creación 02/09/2023 última modificación 28/08/23
 */

public class Examen {
    private String curso;
    
    
    private int nota;
    
    public Examen(String curso, int nota){
        this.curso = curso;
        this.nota = nota;
    }

    //ver si es necesario
    public Examen(){
        this.curso = "";
        nota = 0;
    }
    
    
    /** 
     * @return String
     */
    public String getCurso() {
        return curso;
    }
    
    /** 
     * @param curso
     */
    public void setCurso(String curso) {
        this.curso = curso;
    }
    
    
    /** 
     * @return int
     */
    public int getNota() {
        return nota;
    }
    
    
    /** 
     * @param nota
     */
    public void setNota(int nota) {
        this.nota = nota;
    }
}
