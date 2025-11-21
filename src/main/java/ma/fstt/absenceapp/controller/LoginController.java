package ma.fstt.absenceapp.controller;

import jakarta.servlet.http.HttpSession;
import ma.fstt.absenceapp.entity.Admin;
import ma.fstt.absenceapp.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class LoginController {

    @Autowired
    private AuthenticationService authService;

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @PostMapping("/login")
    public String login(@RequestParam String email,
                        @RequestParam String password,
                        HttpSession session,
                        Model model) {

        Admin admin = authService.login(email, password);

        if (admin != null) {
            session.setAttribute("admin", admin); //On stocke l'admin
            return "redirect:/etudiants";
        }

        model.addAttribute("error", "Email ou mot de passe incorrect");
        return "login";
    }

}
