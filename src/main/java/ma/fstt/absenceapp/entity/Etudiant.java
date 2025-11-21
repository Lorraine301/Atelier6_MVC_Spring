package ma.fstt.absenceapp.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Etudiant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;
    private String prenom;
    private String email;
    private String telephone;

    @OneToMany(mappedBy = "etudiant", cascade = CascadeType.ALL)
    private List<Absence> absences;
}
