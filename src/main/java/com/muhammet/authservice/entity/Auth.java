package com.muhammet.authservice.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "tblauth")
public class Auth {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String email;
    String password;

}
