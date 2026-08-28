package ni.uam.edu.registro_app.DAO;

import ni.uam.edu.registro_app.Interfaces.CRUD;
import ni.uam.edu.registro_app.modelos.Estudiante;

import java.util.ArrayList;
import java.util.List;

public class EstudianteDAO implements CRUD<Estudiante> {
    List<Estudiante> estudiantes;
    public EstudianteDAO(){
        estudiantes = new ArrayList<>();
    }
    @Override
    public void agregar(Estudiante entidad) {
        estudiantes.add(entidad);
    }

    @Override
    public List<Estudiante> obteneRegistro() {
        return estudiantes;
    }
}
