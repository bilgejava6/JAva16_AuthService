package com.muhammet.authservice.dto.request;

public record RegisterDto(
        String email,
        String password
) {
}
