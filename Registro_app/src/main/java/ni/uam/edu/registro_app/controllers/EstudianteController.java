package ni.uam.edu.registro_app.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import ni.uam.edu.registro_app.DAO.EstudianteDAO;
import ni.uam.edu.registro_app.modelos.Estudiante;

import java.time.LocalDate;

public class EstudianteController {
    EstudianteDAO listado = new EstudianteDAO();
    @FXML private TextField txtNombre;
    @FXML private TextField txtApellidos;
    @FXML private TextField txtCarrera;
    @FXML private DatePicker dpfechaNac;
    @FXML private CheckBox chktieneBeca;
    @FXML private Button btnAgregar;
    @FXML private Label lblRegistros;
    @FXML private RadioButton rdHombre;
    @FXML private RadioButton rdMujer;
    @FXML private ComboBox<String> cmbCiudad;
    @FXML private Label lblMensajeError;
    private ToggleGroup rdSexo;

    @FXML
    public void initialize() {
        cmbCiudad.getItems().addAll("Managua", "Masaya",
                "Granada", "Carazo", "Boaco", "Estelí");
        rdSexo = new ToggleGroup();
        rdMujer.setToggleGroup(rdSexo);
        rdHombre.setToggleGroup(rdSexo);
    }
    @FXML protected void guardarOnClick(){
        leerDatos();
        contrarRegistro();
    }
    private void leerDatos(){

        if (!validarTexto(txtNombre)) {
            lblMensajeError.setText("Ingrese sus nombres");
            return;
        }
        if (!validarTexto(txtApellidos)) {
            lblMensajeError.setText("Ingrese sus apellidos");
            return;
        }
        if (!validarTexto(txtCarrera)) {
            lblMensajeError.setText("Ingrese sus carreras");
            return;
        }

        String nombre = txtNombre.getText();
        String apellidos = txtApellidos.getText();
        String carrera = txtCarrera.getText();
        LocalDate fechaNac = dpfechaNac.getValue();
        Boolean tieneBeca = chktieneBeca.isSelected();
        String ciudad = cmbCiudad.getValue();
        RadioButton sexo = (RadioButton) rdSexo.getSelectedToggle();
        agregarDatos(new Estudiante(nombre, apellidos, carrera, fechaNac, tieneBeca, ciudad, sexo));

    }
    private void agregarDatos(Estudiante estudiante){
        listado.agregar(estudiante);
        cleanView();
    }
    private void contrarRegistro(){
        lblRegistros.setText("Registros almacenados: " + listado.obteneRegistro().size());
    }
    private void cleanView(){
        txtApellidos.clear();
        txtCarrera.clear();
        txtNombre.clear();
        cmbCiudad.getSelectionModel().clearSelection();
        rdMujer.setSelected(false);
        rdHombre.setSelected(false);
        chktieneBeca.setSelected(false);
        dpfechaNac.setValue(null);
        lblMensajeError.setText("");

    }
    private boolean validarTexto(TextField campo) {
        if (campo.getText() == null || campo.getText().trim().isEmpty()) {
            return false;
        }
        return true;
    }

}
