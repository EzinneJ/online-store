package com.ezinne.controllers;

import com.ezinne.dtos.ProductRequest;
import com.ezinne.entities.Product;
import com.ezinne.entities.ProductCategory;
import com.ezinne.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    @PostMapping("/addProduct")
    @PreAuthorize("hasRole('client_admin')")
    public ResponseEntity<Product> addProduct(@RequestBody ProductRequest request) {
        Product product = productService.addProduct(request);
        return ResponseEntity.ok(product);
    }

    @PutMapping("/edit")
    @PreAuthorize("hasRole('client_admin')")
    public ResponseEntity<String> editProduct(Long productId, Product newProductDetails) {
        String response = productService.editProduct(productId, newProductDetails);
        if (response.contains("no product assigned to this ID")){
            return ResponseEntity.badRequest().body("You can not edit an unassigned productID");
        }
        return ResponseEntity.ok("This product has been edited successfully");
    }

    @GetMapping("/pages")
    @PreAuthorize("hasRole('client_user')")
    public ResponseEntity<Page<Product>> viewProductInPages(){
        return ResponseEntity.ok(productService.listOfProducts());
    }

    @GetMapping()
    @PreAuthorize("hasRole('client_user')")
    public ResponseEntity<List<Product>> productsByCategory(
            @RequestHeader ProductCategory category) {
        return ResponseEntity.ok(productService.productsByCategory(category));
    }

    @DeleteMapping("/delete")
    @PreAuthorize("hasRole('client_admin')")
    public ResponseEntity<String> deleteProduct(Long productId) {
        String response = productService.deleteProduct(productId);
        if (response.contains("no product assigned to this ID")) {
            return ResponseEntity.badRequest().body("You can not delete an unassigned productID");
        }
        return ResponseEntity.ok("This product has been deleted successfully");
    }
}
