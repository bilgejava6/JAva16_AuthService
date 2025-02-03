package com.muhammet.authservice.controller;

import com.muhammet.authservice.dto.request.AddProductRequestDto;
import com.muhammet.authservice.dto.respose.BaseResponse;
import com.muhammet.authservice.dto.respose.ProductListResponseDto;
import com.muhammet.authservice.entity.Product;
import com.muhammet.authservice.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/product")
@CrossOrigin("*")
public class ProductController {
    private final ProductService productService;

    @PostMapping("/add-product")
    public ResponseEntity<BaseResponse<Boolean>> addProduct(@RequestBody AddProductRequestDto dto){
        productService.addProduct(dto);
        return  ResponseEntity.ok(BaseResponse.<Boolean>builder()
                        .data(true)
                        .code(200)
                        .message("Ürün başarıyla kayıt edildi.")
                .build());
    }

    @GetMapping("/get-all")
    public ResponseEntity<BaseResponse<List<ProductListResponseDto>>> getAllProducts(){
        return ResponseEntity.ok(
                BaseResponse.<List<ProductListResponseDto>>builder()
                        .message("Tüm Ürünler listelendi.")
                        .code(200)
                        .data(productService.getAllProductList())
                        .build()
        );
    }

    @GetMapping("/get-product-by-id")
    public ResponseEntity<BaseResponse<Product>> getProductById(Long productId){
        Optional<Product> product = productService.getProductById(productId);
        if(product.isEmpty())return ResponseEntity.ok(BaseResponse.<Product>builder()
                        .message("Hata! id si verilen ürün bulunamadı")
                        .code(400)
                        .data(null)
                .build());
        return ResponseEntity.ok(BaseResponse.<Product>builder()
                        .data(product.get())
                        .code(200)
                        .message("Ürün bilgisi getiirldi.")
                .build());
    }
}
