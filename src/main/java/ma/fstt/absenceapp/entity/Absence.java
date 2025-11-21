package ma.fstt.absenceapp.entity;

import jakarta.persistence.*;
        import lombok.*;

        import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Absence {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate dateAbsence;
    private String justification;

    @ManyToOne
    @JoinColumn(name = "etudiant_id")
    private Etudiant etudiant;

    public void setEtudiant(Etudiant e) {
        this.etudiant = e;
    }

    public Etudiant getEtudiant() {
        return etudiant;
    }
}
