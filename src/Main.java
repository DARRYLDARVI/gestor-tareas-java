import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);

        HashMap<Integer, Tarea> mapaTareas = new HashMap<>();

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

            opcion = teclado.nextInt();


            switch (opcion){

                case 1:
                    System.out.println("Escriba el id: ");
                    int id = teclado.nextInt();
                    teclado.nextLine();
                    System.out.println("Escriba la descripcion de la tarea: ");
                    String descripcion = teclado.nextLine();
                    Tarea tarea = new Tarea(id, descripcion);
                    mapaTareas.put(id, tarea);

                    break;

                case 2:

                    for (Tarea t : mapaTareas.values()){
                        System.out.println(t);
                    }
                    break;

                case 3:
                    System.out.println("Ingrese la tarea que desea buscar por su ID:");
                    int tareaBuscar = teclado.nextInt();
                    Tarea tareaEncontrada = mapaTareas.get(tareaBuscar);

                    if (tareaEncontrada != null){
                        tareaEncontrada.setCompletada(true);
                        System.out.println("Tarea completada!");
                    }else {
                        System.out.println("ERROR: No existe ninguna tarea con ese ID");
                    }
                    break;

            }
        }

    }
}
