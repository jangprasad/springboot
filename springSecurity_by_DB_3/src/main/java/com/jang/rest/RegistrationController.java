package com.jang.rest;

import com.jang.model.User;
import com.jang.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegistrationController {

    @Autowired
    private UserRepository repo;

    @Autowired
    PasswordEncoder passwordEncoder; //user for password encoder

    @PostMapping("/register/user")
    public ResponseEntity<User> saveUserData(@RequestBody User usr)
    {
        usr.setPassword(passwordEncoder.encode(usr.getPassword()));
                 User user = repo.save(usr);
            return new ResponseEntity<>(user, HttpStatus.CREATED);
    }
}
