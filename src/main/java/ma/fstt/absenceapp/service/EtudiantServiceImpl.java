package ma.fstt.absenceapp.service;

import ma.fstt.absenceapp.entity.Etudiant;
import ma.fstt.absenceapp.repository.EtudiantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EtudiantServiceImpl implements EtudiantService {

    @Autowired
    private EtudiantRepository etudiantRepository;

    @Override
    public List<Etudiant> getAll() {
        return etudiantRepository.findAll();
    }

    @Override
    public Etudiant save(Etudiant e) {
        return etudiantRepository.save(e);
    }

    @Override
    public Etudiant getById(Long id) {
        return etudiantRepository.findById(id).orElse(null);
    }

    @Override
    public void delete(Long id) {
        etudiantRepository.deleteById(id);
    }
}
