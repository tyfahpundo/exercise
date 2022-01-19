package zw.co.afrosoft.exercise.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import zw.co.afrosoft.exercise.domain.Lecturer;

public interface LecturerRepository extends JpaRepository<Lecturer,Long> {
}
