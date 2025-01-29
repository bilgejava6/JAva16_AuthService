package com.muhammet.authservice.service;

import com.muhammet.authservice.dto.request.AddUserProfileDto;
import com.muhammet.authservice.entity.UserProfile;
import com.muhammet.authservice.repository.UserProfileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

import static com.muhammet.authservice.util.Tools.*;
@Service
@RequiredArgsConstructor
public class UserProfileService {
    private final UserProfileRepository userProfileRepository;

    public void addUser(AddUserProfileDto dto) {
        Random random = new Random();
        userProfileRepository.save(
                UserProfile.builder()
                        .address(dto.address())
                        .email(dto.email())
                        .name(dto.name())
                        .phone(dto.phone())
                        .avatar(avatars[random.nextInt(0,499)])
                        .build()
        );
    }

    public List<UserProfile> findAll() {
        return userProfileRepository.findAll();
    }
}
