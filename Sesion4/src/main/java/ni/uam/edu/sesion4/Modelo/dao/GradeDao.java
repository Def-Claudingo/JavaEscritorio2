package ni.uam.edu.sesion4.Modelo.dao;

import ni.uam.edu.sesion4.Modelo.StudentDao;

import java.util.ArrayList;
import java.util.List;

public class GradeDao {
    List<StudentDao> grades;
    public GradeDao(){
        grades = new ArrayList<>();
    }
    public void addGrade(StudentDao estudiante){
        grades.add(estudiante);
    }
    public List<StudentDao> getGrades(){
        return grades;
    }
    public StudentDao getGradeForName(String name){
        for (StudentDao student : grades){
            if (student.getName().equals(name)){
                return student;
            }
        }
        return null;

    }
}
