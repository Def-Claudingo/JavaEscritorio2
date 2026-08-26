package ni.uam.edu.reservahospedaje;

import javafx.fxml.FXML;
import javafx.scene.control.*;

public class HelloController {
    @FXML
    private Label welcomeText;
    @FXML
    private ComboBox comboHabitacion;
    @FXML
    private ListView listaServicios;
    @FXML
    private RadioButton radioEfectivo;
    @FXML
    private RadioButton radioTarjeta;
    @FXML
    private Button btnReservar;
    @FXML
    private Label lblResultado;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }


}
