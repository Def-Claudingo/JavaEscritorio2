module ni.uam.edu.catalogoproductos {
    requires javafx.controls;
    requires javafx.fxml;
    requires static lombok;


    opens ni.uam.edu.catalogoproductos to javafx.fxml;
    exports ni.uam.edu.catalogoproductos;
}