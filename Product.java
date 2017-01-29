package com.springapp.model;

import org.springframework.web.multipart.MultipartFile;

/**
 * Created by LalinPethiyagoda on 23/01/2017.
 */
public interface Product {
    String getProductName();
    int getProductId() ;
    void setProductId(int productId);
    void setProductName(String productName);
    String getProductCategory();
    void setProductCategory(String productCategory);
    String getProductDescription();
    void setProductDescription(String productDescription);
    double getProductPrice();
    void setProductPrice(double productPrice);
    String getProductCondition();
    void setProductCondition(String productCondition);
    String getProductStatus();
    void setProductStatus(String productStatus);
    int getUnitInStock();
    void setUnitInStock(int unitInStock);
    String getProductManufacturer();
    void setProductManufacturer(String productManufacturer);
    MultipartFile getProductImage();
    void setProductImage(MultipartFile productImage);
}
