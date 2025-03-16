package com.cybersoft.uniclub08.services.imp;

import com.cybersoft.uniclub08.entity.User;
import com.cybersoft.uniclub08.respository.UserRepository;
import com.cybersoft.uniclub08.services.AuthenticationService;
import com.cybersoft.uniclub08.utils.JwtHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthenticationServicesImp implements AuthenticationService {
    @Autowired
    private PasswordEncoder passwordEncoder; // new

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JwtHelper jwtHelper;

    @Override
    public String authenticate(String username, String password) {
        String token = "";
        Optional<User> userOptional = userRepository.findByUsername(username);
        if(userOptional.isPresent()){
            User user = userOptional.get();
            if(passwordEncoder.matches(password, user.getPassword())){
                token = jwtHelper.generateToken("hel");
            } else {
                token = "wrong";
            }
        }
        return token;
    }
}
