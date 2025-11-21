package ma.fstt.absenceapp.service;

import ma.fstt.absenceapp.entity.Admin;
import ma.fstt.absenceapp.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {

    @Autowired
    private AdminRepository adminRepository;

    @Override
    public Admin login(String email, String password) {
        Admin admin = adminRepository.findByEmail(email);
        if (admin != null && admin.getPassword().equals(password)) {
            return admin;
        }
        return null;
    }
}
