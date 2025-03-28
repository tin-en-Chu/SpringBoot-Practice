package com.example.demo.controller;

import ch.qos.logback.core.net.SMTPAppenderBase;
import com.example.demo.bean.LoginRequest;
import com.example.demo.bean.ResponseBean;
import com.example.demo.exception.APIException;
import com.example.demo.util.ErrorCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "api")
public class IndexController {

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private PasswordEncoder passwordEncoder;


    @PostMapping
    @RequestMapping(value = "/Login" ,consumes = "application/json" , produces = "application/json")
    public ResponseBean<LoginRequest> login(@RequestBody LoginRequest request) throws APIException {

        try{
            UserDetails user = userDetailsService.loadUserByUsername(request.getUsername());
            if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
                throw new BadCredentialsException("Authentication fails because of incorrect password.");
            }

            LoginRequest loginRequest = new LoginRequest(request.getUsername(), passwordEncoder.encode(request.getPassword()));

            return ResponseBean.<LoginRequest>builder().statusCode("200").datas(loginRequest).build();
        } catch (Exception e) {
            throw e;
        }


    }
}
