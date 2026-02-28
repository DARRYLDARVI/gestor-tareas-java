import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);

        TareaRepository repositorio = new TareaRepositoryEnMemoria();

        int opcion = 0;


        while (opcion != 4){
            System.out.println("""
            Gestor de tareas
            1- Agregar tarea
            2- Ver tareas
            3- Completar Tarea
            4- Salir  
            
            Seleccione la opcion deseada
            """);

            try{
                opcion = teclado.nextInt();


                switch (opcion) {

                    case 1:
                        System.out.println("Escriba el id: ");
                        try {
                            int id = teclado.nextInt();
                            teclado.nextLine();
                            System.out.println("Escriba la descripcion de la tarea: ");
                            String descripcion = teclado.nextLine();
                            Tarea tarea = new Tarea(id, descripcion);
                            repositorio.guardar(tarea);
                        } catch (java.util.InputMismatchException e){
                            System.out.println("Error: Ingrese un numero como ID");
                            teclado.nextLine();
                        }

                        break;

                    case 2:

                        for (Tarea t : repositorio.obtenerTodas()) {
                            System.out.println(t);
                        }
                        break;

                    case 3:
                        System.out.println("Ingrese la tarea que desea buscar por su ID:");
                        try{
                            int tareaBuscar = teclado.nextInt();
                            boolean exito = repositorio.completar(tareaBuscar);

                            if (exito) {
                                System.out.println("Tarea completada!");
                            } else {
                                System.out.println("ERROR: No existe ninguna tarea con ese ID");
                            }
                        }catch (java.util.InputMismatchException e){
                            System.out.println("Error: Ingrese un numero en ID");
                            teclado.nextLine();
                        }
                        break;
                }
            }catch (java.util.InputMismatchException e){
                System.out.println("Error: Porfavor ingresa un numero de las opciones");
                teclado.nextLine();
            }
        }

    }
}
