package ni.uam.edu.catalogoproductos;

import javafx.animation.PauseTransition;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.effect.ImageInput;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.util.Duration;
import ni.uam.edu.catalogoproductos.DAO.ProductoDAO;
import ni.uam.edu.catalogoproductos.Modelos.Producto;

import java.time.LocalDate;

public class ProductoController {
    private Image imagenTemporal;
    ProductoDAO productos = new ProductoDAO();
    @FXML private TextField txtnombre;
    @FXML private TextField txtprecio;
    @FXML private DatePicker dtFecha;
    @FXML private ImageView ivImagen1;
    @FXML private ImageView ivImagen2;
    @FXML private Label lblMensajeError;
    @FXML private Label lblMensajeError2;
    @FXML private TableView <Producto> tblProducto;
    @FXML private TableColumn <Producto, String> colNombre;
    @FXML private TableColumn <Producto, Double>colPrecio;
    @FXML private TableColumn <Producto, String>colFecha;
    @FXML private Button agregarProducto;
    @FXML private Button eliminarProducto;
    @FXML private Button elegirImagen;

    private final ObservableList listaPrductos = FXCollections.observableArrayList();

    @FXML public void initialize(){
        dtFecha.setEditable(false);
        prepararTabla();
        tblProducto.getSelectionModel().selectedItemProperty().addListener((
                observable, filaAnterior, filaNueva) -> {
            if (filaNueva != null) {
                Image foto = filaNueva.getImagen();
                if (foto != null) {
                    ivImagen2.setImage(foto);
                } else {
                    ivImagen2.setImage(null);
                }
            }
        });
        tblProducto.setRowFactory(tv -> {
            TableRow<Producto> fila = new TableRow<>();

            fila.indexProperty().addListener((obs,anterior,nuevo) ->
            {
                if (nuevo.intValue() % 2 == 0 ){
                    fila.setStyle("-fx-background-color: #0099ab; -fx-text-fill: white;" +
                            " -fx-font-weight: bold;");
                }
                else{
                    fila.setStyle("-fx-background-color: white; -fx-text-fill: #0099ab;" +
                            " -fx-font-weight: bold;");
                }
            });
            return fila;
        });
    }

    private void prepararTabla(){
        colNombre.setCellValueFactory(
                fila -> new SimpleStringProperty(fila.getValue().getNombre()));
        colPrecio.setCellValueFactory(
                fila -> new SimpleDoubleProperty(fila.getValue().getPrecio()).asObject());
        colFecha.setCellValueFactory(fila -> {
            LocalDate fecha = fila.getValue().getFechaIngreso();
            return new SimpleStringProperty(fecha == null ? "" : fecha.toString());
        });
        tblProducto.setItems(listaPrductos);
    }

    @FXML protected void btnAgregar() {
        agregarProductos();
    }
    private void agregarProductos(){
        leerproducto();
        listaPrductos.setAll(productos.obtenerLista());
    }

    private void leerproducto(){
        if(!validarTexto(txtnombre)){
            lblMensajeError.setText("Ingrese el nombre del producto");
            return;
        }

        if(!validarEntero(txtprecio)){
            lblMensajeError.setText("Ingrese el precio del producto");
            return;
        }
        if (!validarFechas(dtFecha)) {
            lblMensajeError.setText("Seleccione una fecha de ingreso");
            return;
        }

        String nombre = txtnombre.getText();
        double precio = Double.parseDouble(txtprecio.getText());
        LocalDate fecha = dtFecha.getValue();
        Image imagen = imagenTemporal;
        productos.agregar(new Producto(nombre,precio,fecha, imagen));
        cleanView();
    }

    @FXML private void seleccionarImagen(){
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Seleccionar fotografía del producto");

        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Imágenes", "*.png", "*.jpg", "*.jpeg")
        );

        java.io.File archivoElegido = fileChooser.showOpenDialog(txtnombre.getScene().getWindow());

        if (archivoElegido != null) {

            Image imagen = new Image(archivoElegido.toURI().toString());

            imagenTemporal = imagen;
            ivImagen1.setImage(imagen);

        }
    }
    @FXML protected void eliminarRegistro(){
        Producto seleccionado = tblProducto.getSelectionModel().getSelectedItem();
        if(seleccionado == null){
            lblMensajeError2.setText("Seleccione un producto");
            return;
        }
        listaPrductos.remove(seleccionado);
        ivImagen2.setImage(null);
        lblMensajeError2.setText("Producto eliminado");
        PauseTransition temporizador = new PauseTransition(Duration.seconds(3));
        temporizador.setOnFinished(evento -> lblMensajeError2.setText(""));
        temporizador.play();
    }

    private void cleanView(){
        txtnombre.clear();
        txtprecio.clear();
        dtFecha.setValue(null);
        ivImagen1.setImage(null);
    }

    private boolean validarTexto(TextField campo) {
        if (campo.getText() == null || campo.getText().trim().isEmpty()) {
            return false;
        }
        return true;
    }
    private boolean validarEntero(TextField campo) {
        try {
            int numero = Integer.parseInt(campo.getText().trim());
            return numero > 0;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    private boolean validarFechas(DatePicker campo){
        if(campo.getValue() == null){
            return false;
        }
        return true;
    }
}

