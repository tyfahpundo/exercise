package zw.co.afrosoft.exercise.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import zw.co.afrosoft.exercise.domain.Course;
import zw.co.afrosoft.exercise.domain.Lecturer;


import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class LecturerResponseDto {
    private Long id;
    private String name;
    private String employeeNumber;
    private String title;
    private int age;
    private String nationalId;
    private Set<CourseResponseDto> courseSet;

        public static LecturerResponseDto createLecturerResponseDto(Lecturer lecturer, Set<Course> courses){
            if(Objects.isNull(lecturer)){
                return null;
            }
            return new LecturerResponseDto(lecturer.getId(), lecturer.getName(), lecturer.getEmployeeNumber(), lecturer.getTitle(), lecturer.getAge(),
                    lecturer.getNationalId(), courses.stream().map(CourseResponseDto::createCourseResponseDto).collect(Collectors.toSet()));
        }

}
