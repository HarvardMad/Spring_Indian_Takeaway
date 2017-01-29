package com.springapp.product;

import com.springapp.dao.ProductDao;
import com.springapp.model.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

//import javax.persistence.Query;

/**
 * Created by LalinPethiyagoda on 06/12/2016.
 */
@Repository
@Transactional
public class ProductDaoImpl implements ProductDao {
    @Autowired
    public SessionFactory sessionFactory;//available directly from the application context

    @Override
    public void addProduct(Product product) {
        Session session = sessionFactory.getCurrentSession(); //used as a singleton so need to access
        //it each time you wish to perform session methods
        session.saveOrUpdate(product);
        session.flush();
    }

    public void editProduct(ProductImpl product) {
        Session session = sessionFactory.getCurrentSession(); //used as a singleton so need to access
        //it each time you wish to perform session methods
        //session.saveOrUpdate(product);
        session.saveOrUpdate(product);
        session.flush();
    }

    @Override
    public Product getProductById(int productId) {
        Session session = sessionFactory.getCurrentSession();
        Product retrievedProduct = (Product)session.get(ProductImpl.class,productId);
        return retrievedProduct;
    }

    @Override
    public List<ProductImpl> getAllProducts() {
        Session session = sessionFactory.getCurrentSession();
        org.hibernate.Query query = session.createQuery("from ProductImpl");
        List<ProductImpl> productList = query.list();
        session.flush();


        return productList;
    }
    @Override
    public void deleteProduct(int productId) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(getProductById(productId));
        session.flush();
    }
}
