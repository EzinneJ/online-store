package com.ezinne.entities;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Entity
@Table(name = "products")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Product implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long productId;

    @Column(name = "product_code", columnDefinition = "VARCHAR(255)", unique = true)
    private String productCode;

    @Column(name = "product_name", columnDefinition = "VARCHAR(255)")
    private String productName;

    @Column(name = "product_qty")
    private Long productQuantity;

    @Enumerated(EnumType.STRING)
    @JoinColumn(name = "product_category", columnDefinition = "VARCHAR(255)")
    private ProductCategory productCategory;
}
