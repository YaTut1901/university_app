package university.app;

import java.util.NoSuchElementException;
import java.util.Scanner;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import university.app.exception.WrongCommandFormatException;
import university.app.util.CommandExecutor;
import university.app.util.DataInjector;

@SpringBootApplication
public class UniversityApp implements CommandLineRunner {
    public static final String INTRO_MESSAGE = "------------------------------------------------------------WELCOME TO UNIVERSITY------------------------------------------------------------" + "\n"
                                             + "---------------------------------------------------------------------------------------------------------------------------------------------" + "\n"
                                             + "---                                                       ENTER FOLLOWING COMMANDS:                                                       ---" + "\n"
                                             + "---                                            head {department_name} - get head of department                                            ---" + "\n"
                                             + "---                                         statistics {department_name} - department statistics                                          ---" + "\n"
                                             + "---                                     salary {department_name} - get average salary by department                                       ---" + "\n"
                                             + "---                                    count {department_name} - get amount of employee by department                                     ---" + "\n"
                                             + "---                                                   search {suffix} - global search                                                     ---" + "\n"
                                             + "---                                                      quit program - quit program                                                      ---" + "\n"
                                             + "---------------------------------------------------------------------------------------------------------------------------------------------" + "\n"
                                             + "---------------------------------------------------------------------------------------------------------------------------------------------" + "\n";
    private final DataInjector dataInjector;
    private final CommandExecutor commandExecutor;

    @Autowired
    public UniversityApp(DataInjector dataInjector, CommandExecutor commandExecutor) {
        this.dataInjector = dataInjector;
        this.commandExecutor = commandExecutor;
    }

    @PostConstruct
    public void init() {
        dataInjector.inject();
    }

    public static void main(String[] args) {
        SpringApplication.run(UniversityApp.class, args);
    }

    @Override
    public void run(String... args) {
        System.out.println(INTRO_MESSAGE);
        Scanner scanner = new Scanner(System.in);
        while(true) {
            String input = scanner.nextLine();
            try {
                System.out.println(commandExecutor.execute(input));
            } catch (WrongCommandFormatException e) {
                System.out.println(e.getMessage());
            } catch (NoSuchElementException e) {
                System.out.println("No data found on your request");
                System.out.println(INTRO_MESSAGE);
            }
        }
    }
}
