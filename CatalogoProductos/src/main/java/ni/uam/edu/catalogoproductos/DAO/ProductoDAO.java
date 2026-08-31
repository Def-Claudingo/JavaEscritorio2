package ni.uam.edu.catalogoproductos.DAO;

import ni.uam.edu.catalogoproductos.Interfaces.Interfaz;
import ni.uam.edu.catalogoproductos.Modelos.Producto;

import java.util.ArrayList;
import java.util.List;

public class ProductoDAO implements Interfaz<Producto>{
    List<Producto> productos;
    public ProductoDAO(){productos = new ArrayList<>();}
    @Override
    public void agregar(Producto entidad) {
        productos.add(entidad);
    }
    @Override
    public List<Producto> obtenerLista() {
        return productos;
    }

    @Override
    public void eliminar(Producto entidad) {
        productos.remove(entidad);
    }
}
