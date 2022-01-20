package zw.co.afrosoft.exercise.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import zw.co.afrosoft.exercise.domain.Course;

import java.time.LocalDateTime;
import java.util.Objects;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourseResponseDto {
    private Long id;
    private String courseCode;
    private String courseName;
    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;

    public static CourseResponseDto createCourseResponseDto(Course course){
        if(Objects.isNull(course)){
            return null;
        }
        return new CourseResponseDto(course.getId(), course.getCourseCode(), course.getCourseName(), course.getCreatedDate(),course.getModifiedDate());
    }

}
