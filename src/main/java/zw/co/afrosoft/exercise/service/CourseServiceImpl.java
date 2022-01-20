package zw.co.afrosoft.exercise.service;

import org.springframework.stereotype.Service;
import zw.co.afrosoft.exercise.domain.Course;
import zw.co.afrosoft.exercise.domain.Lecturer;
import zw.co.afrosoft.exercise.dto.CourseRequestDto;
import zw.co.afrosoft.exercise.dto.CourseResponseDto;
import zw.co.afrosoft.exercise.repository.CourseRepository;
import zw.co.afrosoft.exercise.repository.LecturerRepository;

@Service
public class CourseServiceImpl implements CourseService{
    private final CourseRepository courseRepository;
    private final LecturerRepository lecturerRepository;

    public CourseServiceImpl(CourseRepository courseRepository, LecturerRepository lecturerRepository) {
        this.courseRepository = courseRepository;
        this.lecturerRepository = lecturerRepository;
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

    @Override
    public void save(CourseResponseDto course) {
        Course sub = new Course();
        sub.setCourseCode(course.getCourseCode());
        sub.setCourseName(course.getCourseName());
        courseRepository.save(sub);
    }

    @Override
    public void assignLecturerToCourse(Long courseId, Long lecturerId) {
        Course course = courseRepository.findById(courseId).get();
        Lecturer lecturer = lecturerRepository.findById(lecturerId).get();
        course.assignLecturer(lecturer);
        courseRepository.save(course);
    }

}
