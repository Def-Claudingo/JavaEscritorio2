package ni.uam.edu.registro_app.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.InputStream;

public class LoginController {

    @FXML private TextField txtUsuario;
    @FXML private PasswordField txtClave;
    @FXML private Label lblMensaje;
    @FXML private Button confirmarBoton;

    @FXML public void initialize(){
        confirmarBoton.setDefaultButton(true);
    }


    @FXML
    protected void btnConfirmar() {
        String usuario = txtUsuario.getText().trim();
        String clave = txtClave.getText();

        if (usuario.isEmpty() || clave.isEmpty()) {
            lblMensaje.setText("Complete todos los campos.");
            return;
        }

        if (usuario.equals("admin") && clave.equals("admin")) {
            abrirRegistro();
        } else {
            lblMensaje.setText("Usuario o contrasena incorrectos.");
            txtUsuario.clear();
            txtClave.clear();
        }
    }
    private void abrirRegistro() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/ni/uam/edu/registro_app/estudiante-view.fxml"));
            Scene scene = new Scene(loader.load());
            Stage stage = (Stage) txtUsuario.getScene().getWindow();
            stage.setTitle("Registro App");
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            lblMensaje.setText("Error al abrir el registro.");
            e.printStackTrace();
        }
    }
}