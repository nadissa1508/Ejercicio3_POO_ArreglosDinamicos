/**
 * Universidad del Valle de Guatemala
 * @author Angie Nadissa Vela López, 23764
 * @description Clase principal que funciona como la forma provisional de que el usuario interactue
 * con el programa
 * @date creación 02/09/2023 última modificación 06/09/23
 */

import java.util.Scanner;

public class Principal {
   /**
     * Menú principal del programa
     */
    public static void menu1(){
        Scanner teclado = new Scanner(System.in);
        Universidad universidad = new Universidad();
        int opcion = 0;
        String opUser = "";

        while (opcion != 3){
            
            System.out.println("\n***************************");
            System.out.println("\nMENU PRINCIPAL");
            System.out.println("\n***************************");
            System.out.println("\nOpciones: \n1.Seleccionar sede \n2.Registrar sede \n3.Salir");
            System.out.println("\nSeleccione su opción: ");
            opUser = teclado.nextLine();

            try{
                opcion = Integer.parseInt(opUser);      
            }catch(Exception e){
                System.out.println("\nError, ingrese un número");
            }

            if(opcion < 1 || opcion > 3){
                System.out.println("\nError, ingrese una opción del menú");
            }else {
                if(opcion == 1){
                    if(universidad.getSedeEstudiante().equals("")){
                        System.out.println("Error, debe registrar una sede");
                    }else{
                        String op = "";
                        int op2 = 0;
                        System.out.println(universidad.mostrarSedes());
                        op = teclado.nextLine();
    
                        try{
                            op2 = Integer.parseInt(op);      
                        }catch(Exception e){
                            System.out.println("\nError, ingrese un número");
                        }
                        if(op2 > 0 ){
                            universidad.seleccionarSede((op2-1));
                            menu2();
                        }

                    }
                }else if(opcion == 2){
                    String sedee = "";
                    System.out.println("\n\nIngrese la nueva sede de la Universidad: ");
                    sedee = teclado.nextLine();
                    universidad.registrarSede(sedee);
                
                }
                

            }
        }   
    }

    public static void menu2(){

        Scanner teclado = new Scanner(System.in);
        Universidad universidad = new Universidad();
        int opcion = 0;
        String opUser = "";

        while (opcion != 4){
            
            System.out.println("\n\n***************************");
            System.out.println("\nAdministración de la Universidad");
            System.out.println("\n***************************");
            System.out.println("\nOpciones: \n1.Registrar estudiante \n2.Registrar notas \n3.Mostrar estadisticas \n4.Regresar");
            System.out.println("\nSeleccione su opción: ");
            opUser = teclado.nextLine();

            try{
                opcion = Integer.parseInt(opUser);      
            }catch(Exception e){
                System.out.println("\nError, ingrese un número");
            }

            if(opcion < 1 || opcion > 4){
                System.out.println("\nError, ingrese una opción del menú");
            }else {
                if(opcion == 1){
                            
                    System.out.println("\nRegistrar estudiante");
                    System.out.println("\n***************************");
                    String nombre = "", apellido = "", fechaNacimiento = "", correo= "", carnetEst = "";
                    int carnet = 0;
            
                    System.out.println("\n\nIngrese nombre: ");
                    nombre = teclado.nextLine();
            
                    System.out.println("\nIngrese apellido: ");
                    apellido = teclado.nextLine();

                    System.out.println("\nIngrese fecha de nacimiento: ");
                    fechaNacimiento = teclado.nextLine();

                    System.out.println("\nIngrese correo: ");
                    correo = teclado.nextLine();
            
                    System.out.println("\nIngrese carnet: ");
                    carnetEst = teclado.nextLine();  
            
                    try{
                        carnet = Integer.parseInt(carnetEst);
                    }catch(Exception e){
                        System.out.println("\nError, debe ingresar un código numérico");
                    }
                    
                    if(carnet > 0){
                        universidad.registrarEstudiante(nombre, apellido, carnet, fechaNacimiento, correo);
                    }else{
                        System.out.println("\nError, carnet invalido");
                    }
    
        
                }else if(opcion == 2){
                    System.out.println("\n\nCursos");
                    System.out.println("\n1.Matematica \n2.Lenguaje \n3.Quimica \n4.Fisica \n5.Comprension Lectora 6.\nEstadistica");
                    String op3 = "";
                    int opcion2 = 0;
                    System.out.println("\nElija una opción: ");
                    op3 = teclado.nextLine();
                    try{
                        opcion2 = Integer.parseInt(op3);      
                    }catch(Exception e){
                        System.out.println("\nError, ingrese un número");
                    }
                    if(opcion2 < 1 || opcion2 > 6){
                        System.out.println("\nError, ingrese una opción del menú");
                    }else{
                        
                        String carnetEst = "", nota = "";
                        int carnet = 0, nota2 = 0;

                        System.out.println("\n\nIngrese carnet del estudiante: ");
                        carnetEst = teclado.nextLine();

                        try{
                            carnet = Integer.parseInt(carnetEst);      
                        }catch(Exception e){
                            System.out.println("\nError, ingrese un número");
                        }

                        System.out.println("\n\nIngrese nota del estudiante: ");
                        nota = teclado.nextLine();

                        try{
                            nota2 = Integer.parseInt(nota);      
                        }catch(Exception e){
                            System.out.println("\nError, ingrese un número");
                        }

                        if(nota2 > -1 && nota2 < 101){
                            universidad.registrarNotas(carnet, universidad.devolverCurso(opcion2), nota2);
                        }else{
                            System.out.println("\nError, nota invalida");
                        }

                    }
                }else if(opcion == 3){
                    universidad.mostrarEstadisticas();
                }

            }
        }


    }
    
    
    /** 
     * @param args
     */
    public static void main(String[] args){
        //iniciar el menu principal del juego
        menu1();
    } 
}