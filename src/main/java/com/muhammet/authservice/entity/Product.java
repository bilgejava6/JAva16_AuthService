package com.muhammet.authservice.entity;

import jakarta.persistence.*;
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
@Entity
@Table(name = "tblproduct")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    Long categoryId;
    String name;
    @ElementCollection
    List<String> sizeList;
    BigDecimal price;
    Integer stock;
    Double rate;
    Integer review;
    String thumpnail;
    @ElementCollection
    List<String> images;
}
