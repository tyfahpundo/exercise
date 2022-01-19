package zw.co.afrosoft.exercise.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import zw.co.afrosoft.exercise.domain.Lecturer;

import java.util.Objects;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LecturerDto {
    private String name;
    private String employeeNumber;
    private String title;
    private int age;
    private String nationalId;

    public static LecturerDto createLecturerDto(Lecturer lecturer){
        if(Objects.isNull(lecturer)){
            return null;
        }
        return new LecturerDto(lecturer.getName(), lecturer.getEmployeeNumber(), lecturer.getTitle(), lecturer.getAge(),
                lecturer.getNationalId());
    }
}
