package com.muhammet.authservice.service;

import com.muhammet.authservice.dto.request.AddProductRequestDto;
import com.muhammet.authservice.dto.respose.ProductListResponseDto;
import com.muhammet.authservice.entity.Category;
import com.muhammet.authservice.entity.Product;
import com.muhammet.authservice.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;
    private final CategoryService categoryService;
    public void addProduct(AddProductRequestDto dto) {
        productRepository.save(
                Product.builder()
                        .categoryId(dto.categoryId())
                        .images(dto.images())
                        .price(dto.price())
                        .name(dto.name())
                        .rate(0d)
                        .review(0)
                        .sizeList(dto.sizeList())
                        .stock(dto.stock())
                        .thumpnail(dto.thumpnail())
                        .build()
        );
    }

    public List<ProductListResponseDto> getAllProductList() {
        List<ProductListResponseDto> result = new ArrayList<>();
        List<Product> productList = productRepository.findAll();
        List<Category> categoryList = categoryService.getAll();
        productList.forEach(p->{
            Optional<Category> category = categoryList.stream().filter(x->x.getId().equals(p.getCategoryId())).findFirst();
            if(category.isPresent())
                result.add(
                       ProductListResponseDto.builder()
                               .productId(p.getId())
                               .categoryName(category.get().getCategoryName())
                               .name(p.getName())
                               .price(p.getPrice())
                               .rate(p.getRate())
                               .reView(p.getReview())
                               .sizes(p.getSizeList())
                               .stock(p.getStock())
                               .thumbnailUrl(p.getThumpnail())
                               .build()
                );
        });
        return result;
    }

    public Optional<Product> getProductById(Long productId) {
        return productRepository.findById(productId);
    }

    public void updateProduct(Product product) {
        /**
         * DİKKAT!!!!!
         * kullanıcı tarafından gelen değerlerde id null ya da boş gelir ise bu nedenle
         * save işlemi update yerine güncelleme yapar.
         */
        if(!Objects.isNull(product.getId()) && product.getId() < 1)
            productRepository.save(product);
    }

    public void deleteById(Long productId) {
        productRepository.deleteById(productId);
    }
}
