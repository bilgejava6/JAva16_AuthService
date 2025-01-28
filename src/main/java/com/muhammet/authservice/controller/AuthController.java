package com.muhammet.authservice.controller;

import com.muhammet.authservice.dto.request.AuthDto;
import com.muhammet.authservice.entity.Auth;
import com.muhammet.authservice.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
@CrossOrigin("*")
public class AuthController {
    private final AuthService authService;

    @PostMapping("/do-login")
    public ResponseEntity<Auth> doLogin(@RequestBody AuthDto authDto){
        Optional<Auth> authOptional = authService.doLogin(authDto.email(), authDto.password());
        if(authOptional.isEmpty()) ResponseEntity.notFound().build();
        return ResponseEntity.ok(authOptional.get());
    }

    @GetMapping("/create-default")
    public ResponseEntity<String> createAuth(){
        authService.save(Auth.builder()
                        .email("muhammet@gmail.com")
                        .password("123456")
                .build());
        authService.save(Auth.builder()
                .email("demet@gmail.com")
                .password("123456")
                .build());
        return ResponseEntity.ok("Ok");
    }

    @GetMapping("get-all")
    public ResponseEntity<List<Auth>> getAll(){
        return ResponseEntity.ok(authService.findAll());
    }
}
