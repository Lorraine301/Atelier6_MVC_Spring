package ma.fstt.absenceapp.service;


import ma.fstt.absenceapp.entity.Absence;
import java.util.List;

public interface AbsenceService {
    List<Absence> getAll();
    Absence save(Absence a);
    Absence getById(Long id);
    void delete(Long id);
    List<Absence> getAllOrderedByDate();
}
