module ni.uam.edu.reservahospedaje {
    requires javafx.controls;
    requires javafx.fxml;


    opens ni.uam.edu.reservahospedaje to javafx.fxml;
    exports ni.uam.edu.reservahospedaje;
}