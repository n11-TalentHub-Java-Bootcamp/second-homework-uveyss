package com.example.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "Products")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductEntity implements Serializable {
    @SequenceGenerator(schema = "public",name = "generator", sequenceName = "product_id_seq")
    @Id
    @GeneratedValue(generator = "generator")
    @Column(name = "ProductId", nullable = false)
    private long productId;
    @Column(name = "ProductName", nullable = false)
    private String productName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CategoryId",foreignKey = @ForeignKey(name = "fk_product_categoryid"))
    private  CategoryEntity category;
    @Column(name = "Price", nullable = false,precision = 18,scale = 2)
    private double price;
    @Column(name = "Quantity", nullable = false)
    private int quantity;
    @Column(name = "RecordDate", nullable = false)
    private Date recordDate;

}
