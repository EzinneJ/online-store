package com.ezinne.dtos;

import com.ezinne.entities.Product;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class CatalogueRequest {
    private List<Product> productList;

}
