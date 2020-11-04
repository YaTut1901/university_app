package university.app.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import university.app.entity.Degree;
import university.app.entity.Department;
import university.app.entity.Lector;
import university.app.repository.DegreeRepository;
import university.app.repository.DepartmentRepository;
import university.app.repository.LectorRepository;
import university.app.service.DepartmentService;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    private final DepartmentRepository departmentRepository;
    private final LectorRepository lectorRepository;
    private final DegreeRepository degreeRepository;

    @Autowired
    public DepartmentServiceImpl(DepartmentRepository departmentRepository,
                                 LectorRepository lectorRepository,
                                 DegreeRepository degreeRepository) {
        this.departmentRepository = departmentRepository;
        this.lectorRepository = lectorRepository;
        this.degreeRepository = degreeRepository;
    }

    @Override
    public Department save(Department department) {
        return departmentRepository.save(department);
    }

    public Lector getHeadOf(String departmentName) {
        return departmentRepository.findByName(departmentName)
                .orElseThrow().getHead();
    }

    public Map<String, Integer> getStatisticsOf(String departmentName) {
        List<Degree> degrees = degreeRepository.findAll();
        List<Integer> counts = degrees.stream()
                .map(degree -> lectorRepository
                        .countLectorsByDegreeAndDepartmentsContains(degree,
                                departmentRepository.findByName(departmentName)
                                        .orElseThrow()))
                .map(Optional::orElseThrow)
                .collect(Collectors.toList());
        Map<String, Integer> result = new HashMap<>();
        IntStream.range(0, degrees.size())
                .forEach(i -> result.put(degrees.get(i).getName(), counts.get(i)));
        return result;
    }

    public Double getAverageSalaryOf(String departmentName) {
        return lectorRepository.getAvgSalaryByDepartment(departmentName).orElseThrow();
    }

    public Integer countLectorsOf(String departmentName) {
        return lectorRepository.countAllByDepartmentsContains(departmentRepository.findByName(departmentName)
                .orElseThrow()).orElseThrow();
    }


}
