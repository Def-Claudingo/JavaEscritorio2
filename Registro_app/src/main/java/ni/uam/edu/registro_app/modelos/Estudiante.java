package ni.uam.edu.registro_app.modelos;

import javafx.scene.control.RadioButton;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Estudiante {
    private String nombre;
    private String apellido;
    private String carrera;
    private LocalDate fechaNacimiento;
    private Boolean tieneBeca;
    private String ciudad;
    private RadioButton sexo;
}
