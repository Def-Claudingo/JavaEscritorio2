package ni.uam.edu.sesion4;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import lombok.Locked;

public class LoginController {

    @FXML private Label lblMiEtiqueta;
    @FXML private Label welcomeText;
    @FXML private PasswordField txtUsuario;
    @FXML private PasswordField txtClave;
    @FXML private Label lblMensaje;

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
    protected void btnConfirmar() {
        ReadUser();
        abrirGradeView();
    }

    private void ReadUser(){
        String usuario = txtUsuario.getText().trim();
        String clave = txtClave.getText();

        if (usuario.isEmpty() || clave.isEmpty()) {
            lblMensaje.setText("Complete todos los campos.");
            return;
        }

        if (usuario.equals("admin") && clave.equals("admin")) {

        } else {
            lblMensaje.setText("Usuario o contraseña incorrectos.");
        }
    }
    private void abrirGradeView() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("grade-view-fxml.fxml"));
            Scene scene = new Scene(loader.load());
            Stage stage = (Stage) txtUsuario.getScene().getWindow();
            stage.setTitle("Grade View");
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
