package com.techsara.store.inventory.repository;

import com.techsara.store.inventory.entity.Product;
import com.techsara.store.inventory.model.ProductModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository  extends JpaRepository<Product ,Integer> {
    List<Product> findByProductName(String productName);// here is using productTable name from entity

    List<Product> findByProductBrandAndProductSize(String productName, String productSize);

// this is using native query to find the data from database 
    @Query(value = "select * from bestbuy.product where product_brand =? and product_Size = ? and product_Type = ?", nativeQuery = true)
    List<Product> findProductByQuery(String productBrand, String productSize, String productType);
    @Transactional
    public void deleteByProductCode( String code );
}
