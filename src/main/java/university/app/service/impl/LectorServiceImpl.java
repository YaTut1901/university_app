package university.app.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import university.app.entity.Lector;
import university.app.repository.LectorRepository;
import university.app.service.LectorService;

@Service
public class LectorServiceImpl implements LectorService {
    private final LectorRepository lectorRepository;

    @Autowired
    public LectorServiceImpl(LectorRepository lectorRepository) {
        this.lectorRepository = lectorRepository;
    }

    @Override
    public Lector save(Lector lector) {
        return lectorRepository.save(lector);
    }

    public List<Lector> search(String suffix) {
        return lectorRepository.findByNameContainingOrSurnameContaining(suffix, suffix);
    }
}
