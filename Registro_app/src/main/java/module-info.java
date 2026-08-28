module ni.uam.edu.registro_app {
    requires javafx.controls;
    requires javafx.fxml;
    requires static lombok;


    opens ni.uam.edu.registro_app.controllers to javafx.fxml;
    exports ni.uam.edu.registro_app;
}