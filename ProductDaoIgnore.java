package com.springapp.dao;

import com.springapp.product.ProductImpl;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by LalinPethiyagoda on 19/11/2016.
 */
@Service
public class ProductDaoIgnore {
    private List<ProductImpl> productList = new ArrayList<ProductImpl>();

    public List<ProductImpl> getProductList() {
        productList.clear();
        addProduct(1, "Guitar One",
                "String Instrument",
                "Fender Guitar",
                1200,
                "new",
                "active",
                10,
                "Fender");

        addProduct(2, "Guitar Two",
                "String Instrument",
                "Boheme Guitar",
                1500,
                "new",
                "active",
                12,
                "Boheme");

        addProduct(3, "Violin",
                "String Instrument",
                "Stentor 2",
                150,
                "new",
                "active",
                10,
                "Stentor");
        return productList;
    }

    public void addProduct(int id,
                           String productName,
                           String productCategory,
                           String productDescription,
                           double productPrice,
                           String productCondition,
                           String productStatus,
                           int unitInStock,
                           String productManufacturer) {
/*
        productList.add(new ProductImpl(id,productName,
                                    productCategory,
                                    productDescription,
                                    productPrice,
                                    productCondition,
                                    productStatus,
                                    unitInStock,
                                    productManufacturer));
    }*/

   /* public ProductImpl getProudct(int id) throws IOException {
        ProductImpl productItem = productList
                .stream()
                .filter(product -> product.getProductId() == id)
                .findAny()
                .orElse(null);

        if(productItem==null){
            throw new IOException(" No ");
        }
        else{
            return productItem;
        }
    }

    */

    }
}