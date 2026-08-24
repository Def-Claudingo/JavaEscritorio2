module ni.uam.edu.sesion4 {
    requires javafx.controls;
    requires javafx.fxml;
    requires static lombok;


    opens ni.uam.edu.sesion4 to javafx.fxml;
    exports ni.uam.edu.sesion4;
}