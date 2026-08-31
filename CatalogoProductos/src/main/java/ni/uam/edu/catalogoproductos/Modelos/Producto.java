package ni.uam.edu.catalogoproductos.Modelos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Producto {
    private String nombre;
    private double precio;
    private LocalDate fechaIngreso;
    private Image imagen;
}
