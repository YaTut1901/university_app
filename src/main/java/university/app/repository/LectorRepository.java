package university.app.repository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import university.app.entity.Degree;
import university.app.entity.Department;
import university.app.entity.Lector;

public interface LectorRepository extends JpaRepository<Lector, Long> {
    Optional<Integer> countLectorsByDegreeAndDepartmentsContains(Degree degree, Department department);

    List<Lector> findByNameContainingOrSurnameContaining(String nameSuffix, String surnameSuffix);

    Optional<Integer> countAllByDepartmentsContains(Department department);

    @Query("select avg(l.salary) from Lector l where :departmentName in (select name from Department)")
    Optional<Double> getAvgSalaryByDepartment(String departmentName);
}
