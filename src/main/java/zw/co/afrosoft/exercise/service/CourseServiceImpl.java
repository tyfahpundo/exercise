package zw.co.afrosoft.exercise.service;

import zw.co.afrosoft.exercise.domain.Course;
import zw.co.afrosoft.exercise.domain.CourseLecturer;
import zw.co.afrosoft.exercise.domain.Lecturer;
import zw.co.afrosoft.exercise.dto.CourseRequestDto;
import zw.co.afrosoft.exercise.dto.CourseResponseDto;
import zw.co.afrosoft.exercise.exceptions.CourseNotFoundException;
import zw.co.afrosoft.exercise.exceptions.CustomException;
import zw.co.afrosoft.exercise.repository.CourseLecturerRepository;
import zw.co.afrosoft.exercise.repository.CourseRepository;
import zw.co.afrosoft.exercise.repository.LecturerRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Objects;
import java.util.Optional;

public class CourseServiceImpl implements CourseService{
    private final CourseRepository courseRepository;
    private final LecturerRepository lecturerRepository;
    private final CourseLecturerRepository courseLecturerRepository;

    public CourseServiceImpl(CourseRepository courseRepository, LecturerRepository lecturerRepository, CourseLecturerRepository courseLecturerRepository) {
        this.courseRepository = courseRepository;
        this.lecturerRepository = lecturerRepository;
        this.courseLecturerRepository = courseLecturerRepository;
    }

    @Override
    public CourseResponseDto createCourse(CourseRequestDto CourseRequestDto) {
        if(Objects.isNull(CourseRequestDto)){
            throw new CustomException("Course Details must not be null");
        }
        Course course = new Course();
        course.setCourseName(CourseRequestDto.getCourseName());
        course.setCourseCode(generateCourseCode());
        course.setCreatedDate(LocalDateTime.now());
        course.setModifiedDate(LocalDateTime.now());
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
        assignCourseToLecturer(course.get(),lecturer.get());
    }
    public void assignCourseToLecturer(Course course,Lecturer lecturer){
        CourseLecturer courseLecturer = new CourseLecturer();
        courseLecturer.setCourse(course);
        courseLecturer.setLecturer(lecturer);
        courseLecturerRepository.save(courseLecturer);
    }

    public String generateCourseCode(){
        Course course = courseRepository.findFirstByOrderByIdDesc();
        if(course==null){
            return getPrefix()+String.format("%04d",+ 1);
        }
        long counter = course.getId();
        String var = String.format("%04d",++counter);
        return getPrefix() + var;
    }
    public String getPrefix(){
        return "CS";
    }

}
