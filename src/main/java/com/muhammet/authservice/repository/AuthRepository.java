package com.muhammet.authservice.repository;


import com.muhammet.authservice.entity.Auth;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AuthRepository extends JpaRepository<Auth,Long> {
    Optional<Auth> findByEmailAndPassword(String email, String password);
}
