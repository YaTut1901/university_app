package university.app.util;

import java.util.Map;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import university.app.entity.Lector;
import university.app.service.DepartmentService;
import university.app.service.LectorService;

@Component
public class CommandExecutor {
    private final CommandReader reader;
    private final LectorService lectorService;
    private final DepartmentService departmentService;

    @Autowired
    public CommandExecutor(CommandReader reader,
                           LectorService lectorService,
                           DepartmentService departmentService) {
        this.reader = reader;
        this.lectorService = lectorService;
        this.departmentService = departmentService;
    }

    public String execute(String input) {
        String[] command = reader.read(input);
        switch(command[0]) {
            case "head":
                Lector head = departmentService.getHeadOf(command[1]);
                return new StringBuilder("Head of ")
                        .append(command[1])
                        .append(" department is ")
                        .append(head.getName())
                        .append(" ")
                        .append(head.getSurname())
                        .toString();
            case "statistics":
                Map<String, Integer> statistic = departmentService.getStatisticsOf(command[1]);
                return statistic.keySet().stream()
                        .map(key -> key + " - " + statistic.get(key))
                        .collect(Collectors.joining("\n"));
            case "salary":
                return new StringBuilder("The average salary of ")
                        .append(command[1])
                        .append(" is ")
                        .append(departmentService.getAverageSalaryOf(command[1]))
                        .toString();
            case "count":
                return departmentService.countLectorsOf(command[1]).toString();
            case "search":
                return lectorService.search(command[1]).stream()
                        .map(lector -> lector.getName() + " " + lector.getSurname() + ", " + lector.getDegree().getName() + ", salary: " + lector.getSalary())
                        .collect(Collectors.joining("\n"));
            case "quit":
                System.exit(0);
            default:
                return "No such command available";
        }
    }
}
