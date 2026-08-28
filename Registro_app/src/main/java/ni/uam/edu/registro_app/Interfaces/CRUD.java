package ni.uam.edu.registro_app.Interfaces;

import java.util.List;

public interface CRUD <T> {
    public void agregar(T entidad);

    public List<T> obteneRegistro();
}
