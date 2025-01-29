package com.muhammet.authservice.dto.request;

public record AddUserProfileDto(
        String name, String email,String address, String phone
) {
}
