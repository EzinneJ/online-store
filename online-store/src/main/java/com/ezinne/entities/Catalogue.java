package com.ezinne.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "catalogue")
@Getter
@Setter
@NoArgsConstructor
public class Catalogue implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long catalogueId;

    @JoinColumn(name = "products")
    private List<Product> productList;

}
