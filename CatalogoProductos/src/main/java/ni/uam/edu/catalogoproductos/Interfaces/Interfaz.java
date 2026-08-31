package ni.uam.edu.catalogoproductos.Interfaces;

import java.util.List;

public interface Interfaz <T>{
public void agregar(T entidad);
public List<T> obtenerLista();
public void eliminar(T entidad);
}
