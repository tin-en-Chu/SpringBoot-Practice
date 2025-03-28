package com.example.demo.controller;

import ch.qos.logback.core.net.SMTPAppenderBase;
import com.example.demo.Service.JwtService;
import com.example.demo.bean.LoginRequest;
import com.example.demo.bean.ResponseBean;
//import com.example.demo.exception.APIException;
import com.example.demo.enums.Code;
import com.example.demo.exception.APIException;
import com.example.demo.util.Language;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "api")
public class IndexController {

    @Autowired
    private UserDetailsService userDetailsService;

//    @Autowired
//    private PasswordEncoder passwordEncoder;

//    @Autowired
//    private JwtService jwtService;

    @PostMapping
    @RequestMapping(value = "/Login" ,consumes = "application/json" , produces = "application/json")
    public ResponseBean<LoginRequest> login(@RequestBody LoginRequest request) throws APIException {

        try{
//            UserDetails user = userDetailsService.loadUserByUsername(request.getUsername());
//            if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
//                throw new BadCredentialsException("Authentication fails because of incorrect password.");
//            }
//            if( 1 == 1){
//                throw new APIException(Code.CODE_401 , Language.TEST);
//            }
//            LoginRequest loginRequest = new LoginRequest(request.getUsername(), passwordEncoder.encode(request.getPassword()));

//            return ResponseBean.<LoginRequest>builder().statusCode("200").datas(loginRequest).jwtToken(jwtService.createLoginAccessToken(user)).build();
            return ResponseBean.<LoginRequest>builder().statusCode("200").build();
        } catch (Exception e) {
            throw e;
        }
    }
}
