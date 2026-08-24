module ni.uam.edu.accesosistemaacademico {
    requires javafx.controls;
    requires javafx.fxml;


    opens ni.uam.edu.accesosistemaacademico to javafx.fxml;
    exports ni.uam.edu.accesosistemaacademico;
}