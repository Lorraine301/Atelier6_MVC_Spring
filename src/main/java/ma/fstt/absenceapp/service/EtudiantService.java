package ma.fstt.absenceapp.service;



import ma.fstt.absenceapp.entity.Etudiant;
import java.util.List;

public interface EtudiantService {
    List<Etudiant> getAll();
    Etudiant save(Etudiant e);
    Etudiant getById(Long id);
    void delete(Long id);
}
