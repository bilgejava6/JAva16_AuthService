package com.muhammet.authservice.service;

import com.muhammet.authservice.entity.Auth;
import com.muhammet.authservice.repository.AuthRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final AuthRepository authRepository;
    public void save(Auth auth){
        authRepository.save(auth);
    }

    public Optional<Auth> doLogin(String email, String password){
        return authRepository.findByEmailAndPassword(email, password);
    }

    public List<Auth> findAll() {
        return authRepository.findAll();
    }
}
