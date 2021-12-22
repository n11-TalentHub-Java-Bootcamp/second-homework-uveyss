package com.example.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class ProductDto {
/*
* Getter ve Setter lombock ile eklendi.
* Lombock sayesinde constructor oluşturuldu.
* fazla kod yazımından kaçınıldı.*
* */
    private long productId;
    private BigDecimal price;
    private String productName;
    private int quantity;
    private Date recordDate;
    private Long categoryId;
}
