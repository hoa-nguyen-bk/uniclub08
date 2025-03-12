package com.cybersoft.uniclub08.controller;

import com.cybersoft.uniclub08.payload.response.BaseResponse;
import com.cybersoft.uniclub08.services.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {
    @Autowired
    private AuthenticationService authenticationService;

    @PostMapping("/sign-in")
    public ResponseEntity<?> signIn(@RequestParam String email, @RequestParam String password){
        boolean isSuccess = authenticationService.authenticate(email, password);

        BaseResponse response = new BaseResponse();
        response.setData(isSuccess);
        response.setMessage(isSuccess? "Successful Login!": "Failure !");
        response.setCode(200);

        return ResponseEntity.ok(response);
    }
}
