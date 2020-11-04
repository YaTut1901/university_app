package university.app.service;

import java.util.Map;
import university.app.entity.Department;
import university.app.entity.Lector;

public interface DepartmentService {

    Department save(Department department);

    Lector getHeadOf(String departmentName);

    Map<String, Integer> getStatisticsOf(String departmentName);

    Double getAverageSalaryOf(String departmentName);

    Integer countLectorsOf(String departmentName);
}
