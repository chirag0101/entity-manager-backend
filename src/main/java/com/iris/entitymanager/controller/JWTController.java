//package com.iris.entitymanager.controller;
//
//import com.iris.entitymanager.configjwt.JWTUtility;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.http.ResponseEntity;
//
//@RestController
//@RequestMapping("/auth")
//public class JWTController {
//
//    private final JWTUtility jwtUtility;
//
//    public JWTController(JWTUtility jwtUtility) {
//        this.jwtUtility = jwtUtility;
//    }
//
//    @PostMapping("/login")
//    public ResponseEntity<String> login(@RequestParam String username) {
//        String token = jwtUtility.generateToken(username);
//        return ResponseEntity.ok(token); // Return the JWT token
//    }
//}
//
