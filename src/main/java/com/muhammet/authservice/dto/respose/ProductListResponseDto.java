package com.muhammet.authservice.dto.respose;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductListResponseDto {
    Long productId;
    String name;
    List<String> sizes;
    BigDecimal price;
    String thumbnailUrl;
    Double rate;
    Integer stock;
    String categoryName;
    Integer reView;

}
