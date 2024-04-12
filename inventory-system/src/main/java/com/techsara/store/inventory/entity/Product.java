package com.techsara.store.inventory.entity;

//import jakarta.persistence.*;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
@Entity
@Table(name="product")
@Getter
@Setter
public class Product {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer id;
    
    @Column(name="inventory_date")
    private String inventoryDate;

    @Column(name="product_name")
    private String productName;

    @Column(name="product_Size")
    private String productSize;

    @Column(name="product_Code")
    private  String productCode;

    @Column(name="product_Price")
    private double productPrice;

    @Column(name="product_Brand")
    private String productBrand;

    @Column(name="product_Type")
    private String productType;

    @Column(name="product_Quantity")
    private int productQuantity;
}
