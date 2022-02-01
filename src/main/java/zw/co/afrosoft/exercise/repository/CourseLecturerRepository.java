package zw.co.afrosoft.exercise.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import zw.co.afrosoft.exercise.domain.Course;
import zw.co.afrosoft.exercise.domain.CourseLecturer;
import zw.co.afrosoft.exercise.domain.Lecturer;
import java.util.Set;

public interface CourseLecturerRepository extends JpaRepository<CourseLecturer,Long> {
    Set<Course> findAllByLecturer(Lecturer lecturer);
}
