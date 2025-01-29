package com.muhammet.authservice.controller;

import com.muhammet.authservice.dto.request.AuthDto;
import com.muhammet.authservice.dto.request.RegisterDto;
import com.muhammet.authservice.dto.respose.BaseResponse;
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

    @PostMapping("/register")
    public ResponseEntity<BaseResponse<Boolean>> register(@RequestBody RegisterDto registerDto){
        authService.register(registerDto);
        return ResponseEntity.ok(BaseResponse.<Boolean>builder()
                        .code(200)
                        .data(true)
                        .message("Kullanıcı başarı ile oluşturuldu")
                .build());
    }

    @PostMapping("/do-login")
    public ResponseEntity<BaseResponse<Auth>> doLogin(@RequestBody AuthDto authDto){
        Optional<Auth> authOptional = authService.doLogin(authDto.email(), authDto.password());
        if(authOptional.isEmpty())
            return ResponseEntity.ok(BaseResponse.<Auth>builder()
                            .code(400)
                            .data(null)
                            .message("Kullanıcı adı yada şifre hatalıdır.")
                    .build());
        return ResponseEntity.ok(BaseResponse.<Auth>builder()
                        .message("giriş Başarılı")
                        .data(authOptional.get())
                        .code(200)
                .build());
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
    public ResponseEntity<BaseResponse<List<Auth>>> getAll(){
        return ResponseEntity.ok(BaseResponse.<List<Auth>>builder()
                        .message("tüm kullanıcılar getirildi.")
                        .code(200)
                        .data(authService.findAll())
                .build());
    }
}
