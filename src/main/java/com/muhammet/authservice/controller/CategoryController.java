package com.muhammet.authservice.controller;


import com.muhammet.authservice.dto.request.AddCategoryRequestDto;
import com.muhammet.authservice.dto.respose.BaseResponse;
import com.muhammet.authservice.entity.Category;
import com.muhammet.authservice.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/category")
@CrossOrigin("*")
public class CategoryController {
    private final CategoryService categoryService;

    @PostMapping("add-category")
    public ResponseEntity<BaseResponse<Boolean>> addCategory(@RequestBody AddCategoryRequestDto dto) {
        categoryService.addCategory(dto);
        return ResponseEntity.ok(BaseResponse.<Boolean>builder()
                        .data(true)
                        .code(200)
                        .message("Kategori eklendi.")
                .build());
    }

    @GetMapping("/get-all")
    public ResponseEntity<BaseResponse<List<Category>>> getAllCategory() {
        return ResponseEntity.ok(BaseResponse.<List<Category>>builder()
                        .message("Kategori listelendi.")
                        .code(200)
                        .data(categoryService.getAll())
                .build());
    }
}
