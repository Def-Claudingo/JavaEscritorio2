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
    GradeDao grades = new GradeDao();
    @FXML
    protected void SaveButtonAction(){
        addGrade();
        countGrade();
    }
    private void addGrade(){
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
}
