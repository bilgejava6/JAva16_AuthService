package com.muhammet.authservice.dto.request;

import java.math.BigDecimal;
import java.util.List;

public record AddProductRequestDto(
        Long categoryId, String name, List<String> sizeList,
        BigDecimal price, Integer stock, String thumpnail,
        List<String> images
) {
}
