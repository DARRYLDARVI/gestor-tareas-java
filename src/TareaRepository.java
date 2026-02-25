import java.util.Collection;

public interface TareaRepository {
    void guardar(Tarea tarea);
    Collection<Tarea> obtenerTodas();
    boolean completar(int id);
}
