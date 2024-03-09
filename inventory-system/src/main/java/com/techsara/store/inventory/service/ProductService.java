package com.techsara.store.inventory.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.techsara.store.inventory.entity.Product;
import com.techsara.store.inventory.model.ProductModel;
import com.techsara.store.inventory.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    public String addProduct(ProductModel productModel){
        ObjectMapper objectMapper = new ObjectMapper();
        Product product = objectMapper.convertValue(productModel, Product.class);
        productRepository.save(product);
        return   "Successfully added product";
    }

    public List<Product> findByProductName(String productName){
       return productRepository.findByProductName(productName);

    }

    public List<Product> findProductWithBrandAndSize(String productBrand, String productSize){
        return productRepository. findByProductBrandAndProductSize(productBrand,productSize);
    }

    public List<Product> findProductByQuery(String productBrand, String productSize, String productType){
        return productRepository.findProductByQuery(productBrand,productSize, productType);
    }


    public Product getProduct(String productCode){
        return null;
    }

   public String updateProduct(ProductModel productModel){
      return "success";
    }
    public String deleteProduct( String code){
        productRepository.deleteByProductCode(code);
       return "successfully product deleted";
    }


}
