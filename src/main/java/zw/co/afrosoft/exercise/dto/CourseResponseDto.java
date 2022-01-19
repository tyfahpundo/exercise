package zw.co.afrosoft.exercise.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import zw.co.afrosoft.exercise.domain.Course;
import zw.co.afrosoft.exercise.domain.Lecturer;

import java.util.Objects;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourseResponseDto {
    private Long id;
    private String courseCode;
    private String courseName;
    private Lecturer Lecturer;

    public static CourseResponseDto createCourseResponseDto(Course course){
        if(Objects.isNull(course)){
            return null;
        }
        return new CourseResponseDto(course.getId(), course.getCourseCode(), course.getCourseName(), course.getLecturer());
    }
    public void assignLecturer(Lecturer lecturer) {
        this.Lecturer = lecturer;
    }
}
