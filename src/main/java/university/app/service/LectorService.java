package university.app.service;

import java.util.List;
import university.app.entity.Lector;

public interface LectorService {
    Lector save(Lector lector);

    List<Lector> search(String suffix);
}
