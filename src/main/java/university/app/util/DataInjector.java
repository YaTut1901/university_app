package university.app.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import university.app.entity.Degree;
import university.app.entity.Department;
import university.app.entity.Lector;
import university.app.service.DegreeService;
import university.app.service.DepartmentService;
import university.app.service.LectorService;

@Component
public class DataInjector {
    private final DegreeService degreeService;
    private final DepartmentService departmentService;
    private final LectorService lectorService;

    @Autowired
    public DataInjector(DegreeService degreeService,
                        DepartmentService departmentService,
                        LectorService lectorService) {
        this.degreeService = degreeService;
        this.departmentService = departmentService;
        this.lectorService = lectorService;
    }

    public void inject() {
        Degree assistant = new Degree("assistant");
        degreeService.save(assistant);
        Degree associateProfessor = new Degree("associate professor");
        degreeService.save(associateProfessor);
        Degree professor = new Degree("professor");
        degreeService.save(professor);

        Department science = new Department("science");
        departmentService.save(science);
        Department programming = new Department("programming");
        departmentService.save(programming);
        Department literature = new Department("literature");
        departmentService.save(literature);

        Lector firstLector = new Lector("John", "Wick", assistant, 1000);
        firstLector.getDepartments().add(science);
        lectorService.save(firstLector);
        science.getLectors().add(firstLector);
        science.setHead(firstLector);
        departmentService.save(science);

        Lector secondLector = new Lector("Johnson", "Dwayne", associateProfessor, 2000);
        firstLector.getDepartments().add(programming);
        lectorService.save(secondLector);
        programming.getLectors().add(secondLector);
        programming.setHead(secondLector);
        departmentService.save(programming);

        Lector thirdLector = new Lector("Matthew", "McConaughey", professor, 3000);
        thirdLector.getDepartments().add(science);
        thirdLector.getDepartments().add(programming);
        lectorService.save(thirdLector);
        science.getLectors().add(thirdLector);
        departmentService.save(science);
        programming.getLectors().add(thirdLector);
        programming.setHead(thirdLector);
        departmentService.save(programming);
    }
}
