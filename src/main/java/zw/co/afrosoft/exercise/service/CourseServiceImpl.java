package zw.co.afrosoft.exercise.service;

import zw.co.afrosoft.exercise.domain.Course;
import zw.co.afrosoft.exercise.domain.Lecturer;
import zw.co.afrosoft.exercise.dto.CourseRequestDto;
import zw.co.afrosoft.exercise.dto.CourseResponseDto;
import zw.co.afrosoft.exercise.exceptions.CourseNotFoundException;
import zw.co.afrosoft.exercise.exceptions.CustomException;
import zw.co.afrosoft.exercise.repository.CourseRepository;
import zw.co.afrosoft.exercise.repository.LecturerRepository;

import java.util.Objects;
import java.util.Optional;

public class CourseServiceImpl implements CourseService{
    private final CourseRepository courseRepository;
    private final LecturerRepository lecturerRepository;

    public CourseServiceImpl(CourseRepository courseRepository, LecturerRepository lecturerRepository) {
        this.courseRepository = courseRepository;
        this.lecturerRepository = lecturerRepository;
    }

    @Override
    public CourseResponseDto createCourse(CourseRequestDto CourseRequestDto) {
        if(Objects.isNull(CourseRequestDto)){
            throw new CustomException("Course Details must not be null");
        }
        Course course = new Course();
        course.setCourseName(CourseRequestDto.getCourseName());
        course.setCourseCode(generateCourseCode());
        courseRepository.save(course);
        return CourseResponseDto.createCourseResponseDto(course);
    }

    @Override
    public CourseResponseDto getCourseById(Long courseId) {
        Optional<Course> course = courseRepository.findById(courseId);
        if(!course.isPresent()){
            throw new CourseNotFoundException("No course with id "+ courseId+" was Found");
        }
        return CourseResponseDto.createCourseResponseDto(course.get());
    }

    @Override
    public void assignLecturerToCourse(Long courseId, Long lecturerId) {
        Optional<Course> course = courseRepository.findById(courseId);
        Optional<Lecturer> lecturer = lecturerRepository.findById(lecturerId);
        if(course.isEmpty()){
            throw new CourseNotFoundException("No course with id "+courseId+" was found");
        }
        if(lecturer.isEmpty()){
            throw new CourseNotFoundException("No lecturer with id "+lecturerId+" was found");
        }
        course.get().assignLecturer(lecturer.get());
        courseRepository.save(course.get());
    }
    public String generateCourseCode(){
        Course course = courseRepository.findFirstByOrderByIdDesc();
        if(course.getId()==null){
            return getPrefix()+String.format("%04d") + 1;
        }
        long counter = course.getId();
        String var = String.format("%04d",++counter);
        return getPrefix() + var;
    }
    public String getPrefix(){
        return "CS";
    }

}
