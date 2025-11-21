package ma.fstt.absenceapp.controller;

import ma.fstt.absenceapp.entity.Etudiant;
import ma.fstt.absenceapp.repository.EtudiantRepository;
import ma.fstt.absenceapp.service.EtudiantService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import jakarta.servlet.http.HttpSession;

import java.util.List;

@Controller
@RequestMapping("/etudiants")
public class EtudiantController {

    @Autowired
    private EtudiantService etudiantService;
    @Autowired
    private EtudiantRepository etudiantRepository;

    @GetMapping
    public String listEtudiants(Model model,  HttpSession session) {   // <-- juste @GetMapping
        if (session.getAttribute("admin") == null) {
            return "redirect:/login";
        }
        List<Etudiant> etudiants = etudiantRepository.findAll();
        model.addAttribute("etudiants", etudiants);
        return "etudiants/list";
    }

    @GetMapping("/add")
    public String add(Model model) {
        model.addAttribute("etudiant", new Etudiant());
        return "etudiants/add";
    }

    @PostMapping("/save")
    public String save(Etudiant e) {
        etudiantService.save(e);
        return "redirect:/etudiants";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Long id, Model model) {
        model.addAttribute("etudiant", etudiantService.getById(id));
        return "etudiants/edit";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        etudiantService.delete(id);
        return "redirect:/etudiants";
    }
}
