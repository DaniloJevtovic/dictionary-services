package com.dictionary.user.controller;

import com.dictionary.user.dto.LoginDTO;
import com.dictionary.user.dto.RegisterDTO;
import com.dictionary.user.dto.TokenDTO;
import com.dictionary.user.util.JwtUtil;
import com.dictionary.user.user.User;
import com.dictionary.user.user.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("api/auth")
@Slf4j
public class AuthController {

    private final UserService userService;
    private final JwtUtil jwtUtil;

    @PostMapping("/register")
    public User registerUser(@RequestBody RegisterDTO registerDTO) {
        return userService.saveUser(registerDTO);
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginDTO loginDTO) {
        if (userService.checkCredentials(loginDTO))     // ako su kredencijali dobri generisem i vracam token
            return new ResponseEntity<>(jwtUtil.generateToken(loginDTO.email()), HttpStatus.OK);

        return new ResponseEntity<>("Pogresni kredencijali", HttpStatus.BAD_REQUEST);
    }

    @PostMapping("/validateToken")
    public Boolean validateToken(@RequestBody TokenDTO token) {
        log.info("validacija...");
        return jwtUtil.validateToken(token.token());
    }

}
