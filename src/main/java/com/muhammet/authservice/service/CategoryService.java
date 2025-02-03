package com.muhammet.authservice.service;

import com.muhammet.authservice.dto.request.AddCategoryRequestDto;
import com.muhammet.authservice.entity.Category;
import com.muhammet.authservice.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryRepository categoryRepository;

    public void addCategory(AddCategoryRequestDto dto) {
        categoryRepository.save(Category.builder()
                        .categoryName(dto.name())
                .build());
    }

    public List<Category> getAll() {
        return categoryRepository.findAll();
    }
}
