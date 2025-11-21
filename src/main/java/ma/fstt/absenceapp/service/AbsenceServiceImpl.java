package ma.fstt.absenceapp.service;

import ma.fstt.absenceapp.entity.Absence;
import ma.fstt.absenceapp.repository.AbsenceRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AbsenceServiceImpl implements AbsenceService {

    @Autowired
    private AbsenceRepository absenceRepository;

    @Override
    public List<Absence> getAll() {
        return absenceRepository.findAll();
    }

    @Override
    public Absence save(Absence a) {
        return absenceRepository.save(a);
    }

    @Override
    public Absence getById(Long id) {
        return absenceRepository.findById(id).orElse(null);
    }

    @Override
    public void delete(Long id) {
        absenceRepository.deleteById(id);
    }
    @Override
    public List<Absence> getAllOrderedByDate() {
        return absenceRepository.findAllByOrderByDateAbsenceAsc();
    }

}
