package com.muhammet.authservice.controller;

import com.muhammet.authservice.dto.request.AddUserProfileDto;
import com.muhammet.authservice.dto.respose.BaseResponse;
import com.muhammet.authservice.entity.UserProfile;
import com.muhammet.authservice.service.UserProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user-profile")
@CrossOrigin("*")
public class UserProfileController {
    private final UserProfileService userProfileService;

    @PostMapping("/add")
    public ResponseEntity<BaseResponse<Boolean>> addUser(@RequestBody AddUserProfileDto dto){
        userProfileService.addUser(dto);
        return ResponseEntity.ok(BaseResponse.<Boolean>builder()
                        .data(true)
                        .code(200)
                        .message("User Profile Eklendi.")
                .build());
    }

    @GetMapping("/get-all")
    public ResponseEntity<BaseResponse<List<UserProfile>>> getAll(){
        return ResponseEntity.ok(BaseResponse.<List<UserProfile>>builder()
                        .message("User Profile başarı ile getirildi.")
                        .code(200)
                        .data(userProfileService.findAll())
                .build());
    }
}
