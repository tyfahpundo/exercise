package zw.co.afrosoft.exercise.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import zw.co.afrosoft.exercise.repository.CourseRepository;
import zw.co.afrosoft.exercise.repository.LecturerRepository;
import zw.co.afrosoft.exercise.service.CourseService;
import zw.co.afrosoft.exercise.service.CourseServiceImpl;
import zw.co.afrosoft.exercise.service.LecturerService;
import zw.co.afrosoft.exercise.service.LecturerServiceImpl;

@Configuration
public class Configurations {
    @Bean
    public CourseService courseService(CourseRepository courseRepository, LecturerRepository lecturerRepository){
        return new CourseServiceImpl(courseRepository,lecturerRepository);
    }
    @Bean
    public LecturerService lecturerService(LecturerRepository lecturerRepository){
        return new LecturerServiceImpl(lecturerRepository);
    }
}
