package com.techsara.store.inventory.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductModel {

    private int updateId;//=======> this is id use for update  only
	
	private String inventoryDate;

    private String productName;

    private String productSize;

    private  String productCode;

    private double productPrice;

    private String productBrand;

    private String productType;

    private int productQuantity;

}
