package ni.uam.edu.sesion4;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import ni.uam.edu.sesion4.Modelo.StudentDao;
import ni.uam.edu.sesion4.Modelo.dao.GradeDao;

public class GradeController {
    @FXML private Button btnSave;
    @FXML private TextField txtName;
    @FXML private TextField txtCareer;
    @FXML private TextField txtGrades;
    @FXML private Label lblCountGrade;
    @FXML private Label lblMensajeError;
    GradeDao grades = new GradeDao();
    @FXML
    protected void SaveButtonAction(){
        addGrade();
        countGrade();
    }
    private void addGrade(){
        if(!validarTexto(txtName)){
            lblMensajeError.setText("Ingrese su nombre");
            return;
        }
        if(!validarTexto(txtCareer)){
            lblMensajeError.setText("Ingrese su carrera");
            return;
        }
        if(!validarEntero(txtGrades)){
            lblMensajeError.setText("Ingrese sus notas");
            return;
        }
        String name = txtName.getText();
        String career = txtCareer.getText();
        int grade = Integer.parseInt(txtGrades.getText());
        saveGrade(new StudentDao(name, career, grade));
    }
    private void saveGrade(StudentDao student){
        grades.addGrade(student);
    }
    private void countGrade(){
        lblCountGrade.setText("Registros guardados: " + grades.getGrades().size());
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
}
