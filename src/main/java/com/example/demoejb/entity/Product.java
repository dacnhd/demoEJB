package com.example.demoejb.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
public class Product {
    @Id
    private String prodID;
    private String prodName;
    private String Description;
    private String dateOfManf;
    private long price;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Sale> sales;

    public Product(String prodID, String prodName, String description, String dateOfManf, long price) {
        this.prodID = prodID;
        this.prodName = prodName;
        Description = description;
        this.dateOfManf = dateOfManf;
        this.price = price;
    }
}
