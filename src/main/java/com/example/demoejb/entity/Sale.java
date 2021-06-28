package com.example.demoejb.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
public class Sale {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long slNo;
    private String salesmanID;
    private String salesmanName;
    private String dos;

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "prodID")
    private Product product;

    @Column(insertable = false, updatable = false)
    private String prodID;

    public Sale(String salesmanID, String salesmanName, String dOS, String prodID) {
        this.salesmanID = salesmanID;
        this.salesmanName = salesmanName;
        this.dos = dOS;
        this.prodID = prodID;
    }
}
