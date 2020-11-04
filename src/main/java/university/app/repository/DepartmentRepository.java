package university.app.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import university.app.entity.Department;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
    Optional<Department> findByName(String name);
}
