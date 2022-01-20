package zw.co.afrosoft.exercise.service;

import zw.co.afrosoft.exercise.domain.Course;
import zw.co.afrosoft.exercise.domain.Lecturer;
import zw.co.afrosoft.exercise.dto.CourseRequestDto;
import zw.co.afrosoft.exercise.dto.CourseResponseDto;
import zw.co.afrosoft.exercise.dto.LecturerDto;


public interface CourseService {
    CourseResponseDto createCourse(CourseRequestDto CourseRequestDto);

    CourseResponseDto getCourseById(Long courseId);

    void save(CourseResponseDto course);

    void assignLecturerToCourse(Long courseId, Long lecturerId);
}
