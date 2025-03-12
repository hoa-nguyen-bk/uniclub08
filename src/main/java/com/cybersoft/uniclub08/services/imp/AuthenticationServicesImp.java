package com.cybersoft.uniclub08.services.imp;

import com.cybersoft.uniclub08.entity.User;
import com.cybersoft.uniclub08.respository.UserRepository;
import com.cybersoft.uniclub08.services.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthenticationServicesImp implements AuthenticationService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public boolean authenticate(String username, String password){
        Optional<User> userOptional = userRepository.findByUsernameAndPassword(username, password);
//        if(userOptional.isPresent()){
//            userOptional.get().getFullname();
//        }
        return userOptional.isPresent();
    }
}
