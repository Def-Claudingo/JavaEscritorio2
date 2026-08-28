package ni.uam.edu.registro_app.controllers;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
    @FXML private TableView<Estudiante> tblEstudiantes;
    @FXML private TableColumn<Estudiante, String> colNombre;
    @FXML private TableColumn<Estudiante, String> colApellidos;
    @FXML private TableColumn<Estudiante, String> colCarrera;
    @FXML private TableColumn<Estudiante, String> colFechaNac;
    @FXML private TableColumn<Estudiante, String> colCiudad;
    @FXML private TableColumn<Estudiante, String> colSexo;
    @FXML private TableColumn<Estudiante, String> colBeca;
    private ToggleGroup rdSexo;
    private final ObservableList<Estudiante> datosTabla = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        cmbCiudad.getItems().addAll("Managua", "Masaya",
                "Granada", "Carazo", "Boaco", "Estelí");
        rdSexo = new ToggleGroup();
        rdMujer.setToggleGroup(rdSexo);
        rdHombre.setToggleGroup(rdSexo);
        prepararTabla();
    }

    private void prepararTabla() {
        colNombre.setCellValueFactory(fila -> new SimpleStringProperty(fila.getValue().getNombre()));
        colApellidos.setCellValueFactory(fila -> new SimpleStringProperty(fila.getValue().getApellido()));
        colCarrera.setCellValueFactory(fila -> new SimpleStringProperty(fila.getValue().getCarrera()));
        colFechaNac.setCellValueFactory(fila -> {
            LocalDate fecha = fila.getValue().getFechaNacimiento();
            return new SimpleStringProperty(fecha == null ? "" : fecha.toString());
        });
        colCiudad.setCellValueFactory(fila -> new SimpleStringProperty(fila.getValue().getHabitacion()));
        colSexo.setCellValueFactory(fila -> {
            RadioButton sexo = fila.getValue().getSexo();
            return new SimpleStringProperty(sexo == null ? "" : sexo.getText());
        });
        colBeca.setCellValueFactory(fila -> {
            Boolean beca = fila.getValue().getTieneBeca();
            return new SimpleStringProperty(Boolean.TRUE.equals(beca) ? "Si" : "No");
        });
        tblEstudiantes.setItems(datosTabla);
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
        datosTabla.setAll(listado.obteneRegistro());
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
