package ni.uam.edu.sesion4.Modelo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StudentDao {
    private String name;
    private String career;
    private int grade;
}
