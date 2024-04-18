package com.techsara.store.inventory.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.techsara.store.inventory.entity.Product;
import com.techsara.store.inventory.model.ProductModel;
import com.techsara.store.inventory.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    public String addProduct(ProductModel productModel){
        //==== this  code is work for all object save one time //

//        ObjectMapper objectMapper = new ObjectMapper();
//        Product product = objectMapper.convertValue(productModel, Product.class);

        Product product = new Product();
        product.setProductName(productModel.getProductName());
        product.setEntryDate(new Date());//====> this is for set date
        product.setProductCode(productModel.getProductCode());
        product.setProductBrand(productModel.getProductBrand());
        product.setProductPrice(productModel.getProductPrice());
        product.setInventoryDate(productModel.getInventoryDate());
        product.setProductQuantity(productModel.getProductQuantity());
        product.setProductSize(productModel.getProductSize());
        product.setProductType(productModel.getProductType());
        productRepository.save(product);
        return   "Successfully added product";
    }


    public String updateProduct(ProductModel productModel) {

        Optional<Product> productFromDb = productRepository.findById(productModel.getUpdateId());
        Product product = productFromDb.get();
        if(productModel.getProductName()!=null) {//======if model get value then set it
            product.setProductName(productModel.getProductName());
        }
        if(productModel.getProductPrice()!=0){
            product.setProductPrice(productModel.getProductPrice());
        }
        if (productModel.getInventoryDate()!=null){
            product.setInventoryDate(productModel.getInventoryDate());
        }
        if (productModel.getProductCode()!=null){
            product.setProductCode(productModel.getProductCode());
        }
        if (productModel.getProductType()!=null){
            product.setProductType(productModel.getProductType());
        }
        if (productModel.getProductBrand()!=null){
            product.setProductBrand(productModel.getProductBrand());
        }
        if (productModel.getProductSize()!=null){
            product.setProductSize(productModel.getProductSize());
        }
        productRepository.save(product);

        return "updated";

    }

    public List<Product> findByProductName(String productName){
        // this Like code is work for space count
       return productRepository.findByProductNameLike("%" + productName + "%");

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

    // this code work fetch data from id base ==//

    public Optional<Product> productById(Integer id) {
        Optional<Product> salesFromDb = productRepository.findById(id);
        return salesFromDb;
    }

    public String deleteProduct( String code){
        productRepository.deleteByProductCode(code);
       return "successfully product deleted";
    }


    public List<Product> findByInventoryDate(String inventoryDate) {
       return productRepository.findByInventoryDate(inventoryDate) ;
    }

    // this code is work for delete in id base====//

    public String deleteInventory(Integer id) {
      productRepository.deleteById(id);
      return "delete success";
    }
}
