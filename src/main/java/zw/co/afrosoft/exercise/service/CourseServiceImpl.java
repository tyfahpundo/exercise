package zw.co.afrosoft.exercise.service;

import org.springframework.stereotype.Service;
import zw.co.afrosoft.exercise.domain.Course;
import zw.co.afrosoft.exercise.domain.Lecturer;
import zw.co.afrosoft.exercise.dto.CourseRequestDto;
import zw.co.afrosoft.exercise.dto.CourseResponseDto;
import zw.co.afrosoft.exercise.repository.CourseRepository;

@Service
public class CourseServiceImpl implements CourseService{
    private final CourseRepository courseRepository;

    public CourseServiceImpl(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Override
    public CourseResponseDto createCourse(CourseRequestDto CourseRequestDto) {
        Course course = new Course();
        course.setCourseName(CourseRequestDto.getCourseName());
        course.setCourseCode(course.generateCourseCode());
        courseRepository.save(course);
        return CourseResponseDto.createCourseResponseDto(course);
    }

    @Override
    public CourseResponseDto getCourseById(Long courseId) {
        Course course = courseRepository.findById(courseId).get();
        return CourseResponseDto.createCourseResponseDto(course);
    }
}
