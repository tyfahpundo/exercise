package zw.co.afrosoft.exercise.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import zw.co.afrosoft.exercise.domain.CourseLecturer;

public interface CourseLecturerRepository extends JpaRepository<CourseLecturer,Long> {
}
