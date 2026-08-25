package ni.uam.edu.accesosistemaacademico;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class HelloController {
    @FXML
    private Label lblMiEtiqueta;
    @FXML
    public void initialize() {
        Image miImagen = new Image(getClass().getResourceAsStream("labels.jpg"));

        ImageView imageView = new ImageView(miImagen);
        imageView.setFitWidth(50);
        imageView.setFitHeight(50);
        imageView.setPreserveRatio(true);

        lblMiEtiqueta.setGraphic(imageView);
    }
    @FXML
    private Label welcomeText;
    @FXML private TextField txtUsuario;
    @FXML private PasswordField txtClave;
    @FXML private Label lblMensaje;

    @FXML
    protected void btnConfirmar() {
        String usuario = txtUsuario.getText().trim();
        String clave = txtClave.getText();

        if (usuario.isEmpty() || clave.isEmpty()) {
            lblMensaje.setText("Complete todos los campos.");
            return;
        }
        if (usuario.equals("admin") && clave.equals("admin")){
            lblMensaje.setText("Datos recibidos para validación.");
            txtUsuario.clear();
            txtClave.clear();
        }
        else{
            lblMensaje.setText("Usuario o contraseña incorrectos.");
            txtUsuario.clear();
            txtClave.clear();
        }
    }

}
