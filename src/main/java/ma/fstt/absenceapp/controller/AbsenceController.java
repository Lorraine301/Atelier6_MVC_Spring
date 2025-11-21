package ma.fstt.absenceapp.controller;


import ma.fstt.absenceapp.entity.Absence;
import ma.fstt.absenceapp.service.AbsenceService;
import ma.fstt.absenceapp.service.EtudiantService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.LinkedHashMap;
@Controller
@RequestMapping("/absences")
public class AbsenceController {

    @Autowired
    private AbsenceService absenceService;

    @Autowired
    private EtudiantService etudiantService;

  @GetMapping("")
  public String list(
          @RequestParam(name = "date", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date,
          Model model) {

      List<Absence> absences;

      if (date != null) {
          absences = absenceService.getAllOrderedByDate().stream()
                  .filter(a -> a.getDateAbsence().equals(date))
                  .toList();
      } else {
          absences = absenceService.getAllOrderedByDate();
      }

      // Grouper par date pour l'affichage des tableaux
      Map<LocalDate, List<Absence>> absencesGroupByDate = absences.stream()
              .collect(Collectors.groupingBy(
                      Absence::getDateAbsence,
                      LinkedHashMap::new,
                      Collectors.toList()
              ));

      model.addAttribute("absencesGroupByDate", absencesGroupByDate);
      model.addAttribute("filterDate", date);

      return "absences/list";
  }
    @GetMapping("/stats")
    public String stats(Model model) {
        // Calculer le nombre d'absences par étudiant (comme avant)
        Map<String, Long> absenceCountByStudent = absenceService.getAll().stream()
                .collect(Collectors.groupingBy(
                        a -> a.getEtudiant().getNom() + " " + a.getEtudiant().getPrenom(),
                        LinkedHashMap::new,
                        Collectors.counting()
                ));

        model.addAttribute("absenceCountByStudentKeys", new ArrayList<>(absenceCountByStudent.keySet()));
        model.addAttribute("absenceCountByStudentValues", new ArrayList<>(absenceCountByStudent.values()));

        return "absences/stats";
    }


    @GetMapping("/add")
    public String add(Model model) {
        model.addAttribute("absence", new Absence());
        model.addAttribute("etudiants", etudiantService.getAll());
        return "absences/add";
    }

    @PostMapping("/save")
    public String save(@RequestParam(required = false) Long etudiantId, Absence a) {
        if (a.getId() == null) {
            // C'est un ajout
            a.setEtudiant(etudiantService.getById(etudiantId));
        } else {
            // C'est une modification
            Absence existing = absenceService.getById(a.getId());
            if (existing != null) {
                existing.setDateAbsence(a.getDateAbsence());
                existing.setJustification(a.getJustification());
                a = existing; // On remplace l'objet pour sauvegarder
            }
        }
        absenceService.save(a);
        return "redirect:/absences";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Long id, Model model) {
        model.addAttribute("absence", absenceService.getById(id));
        model.addAttribute("etudiants", etudiantService.getAll());
        return "absences/edit";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        absenceService.delete(id);
        return "redirect:/absences";
    }
}
