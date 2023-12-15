package com.ezinne.services;

import com.ezinne.dtos.ProductRequest;
import com.ezinne.entities.Product;
import com.ezinne.entities.ProductCategory;
import com.ezinne.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    public Product addProduct(ProductRequest request) {
        Product product = new Product();
        request.setProductCode(product.getProductCode());
        request.setProductName(product.getProductName());
        request.setProductQuantity(product.getProductQuantity());
        request.setProductCategory(product.getProductCategory());
        return productRepository.save(product);
    }

    public String editProduct(Long productId, Product newProductDetails) {
        Optional<Product> optionalProduct = productRepository.findById(productId);
        if (optionalProduct.isEmpty()){
            return "no product assigned to this ID";
        }
        optionalProduct.ifPresent(product -> {
            product.setProductCode(newProductDetails.getProductCode());
            product.setProductName(newProductDetails.getProductName());
            product.setProductQuantity(newProductDetails.getProductQuantity());
            product.setProductCategory(newProductDetails.getProductCategory());
            productRepository.save(product);
        });
        return "Product successfully edited";
    }

    public Page<Product> listOfProducts() {
        return productRepository.findAll(Pageable.ofSize(10));
    }

    public List<Product> productsByCategory(ProductCategory category) {
        List<Product> productByCategory = productRepository.findByCategory(category);
        if (productByCategory.isEmpty()) {
            return List.of();
        }
        return productByCategory;
    }

    public String deleteProduct(Long productId){
        Optional<Product> optionalProduct = productRepository.findById(productId);
        if (optionalProduct.isEmpty()) {
           return "no product assigned to this ID";
        }
        productRepository.deleteById(productId);
        return "Successfully deleted";
    }
}
