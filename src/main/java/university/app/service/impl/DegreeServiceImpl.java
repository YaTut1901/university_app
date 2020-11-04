package university.app.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import university.app.entity.Degree;
import university.app.repository.DegreeRepository;
import university.app.service.DegreeService;

@Service
public class DegreeServiceImpl implements DegreeService {
    private final DegreeRepository degreeRepository;

    @Autowired
    public DegreeServiceImpl(DegreeRepository degreeRepository) {
        this.degreeRepository = degreeRepository;
    }

    @Override
    public Degree save(Degree degree) {
        return degreeRepository.save(degree);
    }
}
