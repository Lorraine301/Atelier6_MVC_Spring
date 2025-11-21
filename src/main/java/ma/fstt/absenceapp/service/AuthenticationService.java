package ma.fstt.absenceapp.service;

import ma.fstt.absenceapp.entity.Admin;

public interface AuthenticationService {
    Admin login(String email, String password);
}
