package ni.uam.edu.catalogoproductos;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ProductoApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(ProductoApplication.class.getResource("Producto-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Registro - productos");
        stage.setScene(scene);
        stage.show();
    }
}
