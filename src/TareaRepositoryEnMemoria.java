import java.util.Collection;
import java.util.HashMap;

public class TareaRepositoryEnMemoria implements TareaRepository{
    private HashMap<Integer, Tarea> baseDeDatos = new HashMap<>();

    @Override
    public void guardar (Tarea tarea){
        baseDeDatos.put(tarea.getId(), tarea);
    }

    @Override
    public Collection<Tarea> obtenerTodas(){
        return baseDeDatos.values();
    }

    @Override
    public boolean completar(int id){
        Tarea t = baseDeDatos.get(id);
        if (t != null) {
            t.setCompletada(true);
            return true;
        }
        return false;
    }
}
