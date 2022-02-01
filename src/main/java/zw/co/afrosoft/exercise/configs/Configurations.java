package zw.co.afrosoft.exercise.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import zw.co.afrosoft.exercise.repository.CourseLecturerRepository;
import zw.co.afrosoft.exercise.repository.CourseRepository;
import zw.co.afrosoft.exercise.repository.LecturerRepository;
import zw.co.afrosoft.exercise.service.*;

@Configuration
public class Configurations {
    @Bean
    public CourseService courseService(CourseRepository courseRepository, LecturerRepository lecturerRepository, CourseLecturerRepository courseLecturerRepository){
        return new CourseServiceImpl(courseRepository,lecturerRepository, courseLecturerRepository);
    }
    @Bean
    public LecturerService lecturerService(LecturerRepository lecturerRepository, CourseLecturerRepository courseLecturerRepository){
        return new LecturerServiceImpl(lecturerRepository, courseLecturerRepository);
    }
}
