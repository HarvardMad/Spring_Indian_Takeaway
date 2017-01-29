package com.springapp.dao;

import com.springapp.model.Product;
import com.springapp.product.ProductImpl;

import java.util.List;

/**
 * Created by LalinPethiyagoda on 06/12/2016.
 */
public interface ProductDao {
    void addProduct(Product product);
    Product getProductById(int productId);
    List<ProductImpl> getAllProducts();
    void deleteProduct(int productId);
    void editProduct(ProductImpl product);

}

