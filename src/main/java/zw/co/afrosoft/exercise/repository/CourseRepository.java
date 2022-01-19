package zw.co.afrosoft.exercise.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import zw.co.afrosoft.exercise.domain.Course;

public interface CourseRepository extends JpaRepository<Course,Long> {
}
