package com.springapp.model;

import java.sql.Date;

/**
 * Created by LalinPethiyagoda on 23/01/2017.
 */
public interface Order {
    int getOrderId();
    void setOrderId(int orderId);
    Date getOrderDate();
    void setOrderDate();

}
