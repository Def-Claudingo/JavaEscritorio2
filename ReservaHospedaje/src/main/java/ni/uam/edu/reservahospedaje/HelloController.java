package ni.uam.edu.reservahospedaje;

import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.util.ArrayList;

public class HelloController {
    @FXML private Label lblMensajeError;
    @FXML private ComboBox<String> comboHabitacion;
    @FXML private RadioButton radioEfectivo;
    @FXML private RadioButton radioTarjeta;
    @FXML private Button btnReservar;
    @FXML private ListView lvResultado;
    @FXML private CheckBox chkTransporte;
    @FXML private CheckBox chkLavanderia;
    @FXML private CheckBox chkTour;
    private ToggleGroup grupoPago;

    @FXML
    public void initialize() {
        comboHabitacion.getItems().addAll("Individual", "Doble", "Familiar", "Suite");
        grupoPago = new ToggleGroup();
        radioEfectivo.setToggleGroup(grupoPago);
        radioTarjeta.setToggleGroup(grupoPago);
    }


    @FXML protected void Reservar() {

        ReadAnswers();

    }

    private void ReadAnswers(){

        ArrayList<String> serviciosElegidos = new ArrayList<>();
        if (chkTransporte.isSelected()) { serviciosElegidos.add(chkTransporte.getText()); }
        if (chkLavanderia.isSelected()) { serviciosElegidos.add(chkLavanderia.getText()); }
        if (chkTour.isSelected()) { serviciosElegidos.add(chkTour.getText()); }

        String habitacion = comboHabitacion.getValue();

        RadioButton seleccionado = (RadioButton) grupoPago.getSelectedToggle();

        if (habitacion == null) {
            lblMensajeError.setText("Elija una habitación");
            return;
        }

        if (seleccionado == null) {
            lblMensajeError.setText("Elija un método de pago");
            return;
        }

        String pago = seleccionado.getText();

        String reserva = "Habitación: " + habitacion +
                "\nPago: " + pago +
                "\nServicios:";

        lvResultado.getItems().add(reserva);
        for (String servicio : serviciosElegidos) {
            lvResultado.getItems().add(servicio);
            cleanSpace();

        }
    }

    private void cleanSpace(){

        comboHabitacion.getSelectionModel().clearSelection();

        radioTarjeta.setSelected(false);
        radioEfectivo.setSelected(false);

        chkTransporte.setSelected(false);
        chkLavanderia.setSelected(false);
        chkTour.setSelected(false);
        lblMensajeError.setText("");
    }
    @FXML protected void cleanView() {lvResultado.getItems().clear();}
}
