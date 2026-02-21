import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);

        ArrayList<Tarea> listaTareas = new ArrayList<>();

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
                    listaTareas.add(tarea);

                    break;

                case 2:

                    for (Tarea t :listaTareas){
                        System.out.println(t);
                    }
                    break;

                case 3:
                    System.out.println("Ingrese la tarea que desea buscar por su ID:");
                    int tareaBuscar = teclado.nextInt();

                    for (Tarea t : listaTareas){
                        if (tareaBuscar == t.getId()){
                            t.setCompletada(true);
                        }
                    }


                    break;

            }
        }

    }
}
