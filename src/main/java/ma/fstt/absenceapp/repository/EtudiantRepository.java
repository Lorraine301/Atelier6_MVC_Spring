package ma.fstt.absenceapp.repository;



import ma.fstt.absenceapp.entity.Etudiant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EtudiantRepository extends JpaRepository<Etudiant, Long> { }
