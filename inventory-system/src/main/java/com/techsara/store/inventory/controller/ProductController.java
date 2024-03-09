package com.techsara.store.inventory.controller;

import com.techsara.store.inventory.entity.Product;
import com.techsara.store.inventory.model.ProductModel;
import com.techsara.store.inventory.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.ArrayList;
import java.util.List;

@RestController("/inventory")
public class ProductController {
    @Autowired// ==== creating object annotation
    private ProductService productService;// ===== this is dependency injection

    @PostMapping("/save")// this is work for creating table
    public String saveProduct(@RequestBody ProductModel productModel){
        String message =  productService.addProduct(productModel);
        return message;
    }

    @PutMapping("/update/{id}")//=== this is work for updating the value
    public String updateProduct(@PathVariable int id, @RequestBody ProductModel productModel){
        String updatedMassage =  productService.updateProduct(productModel);
        return updatedMassage;
    }

    @GetMapping("/productDetails")// this is work for fetch the data
    public List<Product> productDetails(@RequestParam String productName){
        List<Product> productList = productService.findByProductName(productName);
        return productList;
    }

    @GetMapping("/productDetailsByBrandAndSize")// this is work for fetch the data
    public List<Product> getProductWithBrandAndSize(@RequestParam String productBrand, @RequestParam  String productSize){
        List<Product> productList = productService.findProductWithBrandAndSize(productBrand, productSize);
        return productList;
    }

    @GetMapping("/searchProduct")// this is work for fetch the data
    public List<Product> searchProduct(@RequestParam String productBrand, @RequestParam  String productSize,  @RequestParam  String productType){
        List<Product> productList = productService.findProductByQuery(productBrand, productSize, productType);
        return productList;
    }

    @DeleteMapping("/delete/{code}")
    public String deleteProduct(@PathVariable String code){
        String deleted= productService.deleteProduct(code );
        return deleted;
    }

    @Configuration
    public class CorsConfig {

        @Bean
        public CorsFilter corsFilter() {
            CorsConfiguration corsConfiguration = new CorsConfiguration();
            corsConfiguration.addAllowedOrigin("http://127.0.0.1:5500"); // Adjust the origin as needed
            corsConfiguration.addAllowedMethod("*");
            corsConfiguration.addAllowedHeader("*");

            UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
            source.registerCorsConfiguration("/**", corsConfiguration);

            return new CorsFilter(source);
        }
    }
}
