package university.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import university.app.entity.Degree;

public interface DegreeRepository extends JpaRepository<Degree, Long> {
}