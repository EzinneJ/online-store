package com.ezinne.dtos;

import com.ezinne.entities.ProductCategory;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ProductRequest {
    private String productCode;
    private String productName;
    private Long productQuantity;
    private ProductCategory productCategory;

}
