package zw.co.afrosoft.exercise.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import zw.co.afrosoft.exercise.domain.Course;
import zw.co.afrosoft.exercise.domain.Lecturer;

import java.util.Objects;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LecturerResponseDto {
    private String name;
    private String employeeNumber;
    private String title;
    private int age;
    private String nationalId;
    private Set<Course> courses;

        public static LecturerResponseDto createLecturerResponseDto(Lecturer lecturer){
            if(Objects.isNull(lecturer)){
                return null;
            }
            return new LecturerResponseDto(lecturer.getName(), lecturer.getEmployeeNumber(), lecturer.getTitle(), lecturer.getAge(),
                    lecturer.getNationalId(),lecturer.getCourses());
        }

}
