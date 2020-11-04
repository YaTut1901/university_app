package university.app.util;

import org.springframework.stereotype.Component;
import university.app.exception.WrongCommandFormatException;

@Component
public class CommandReader {
    public String[] read(String input) {
        String[] executed = input.split(" ");
        if (executed.length == 2) {
            return executed;
        }
        throw new WrongCommandFormatException("Wrong arguments amount");
    }
}
