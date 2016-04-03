/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import es.upv.inf.Product;
import java.beans.PropertyChangeSupport;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;



/**
 *
 * @authors Alicia Monleón and Mario Alameda
 */
public class Component {

    private ObjectProperty<Product> product;
    private IntegerProperty quantity;
    
    public Component(Product p, Integer q){
        this.product = new SimpleObjectProperty<>(p);
        this.quantity = new SimpleIntegerProperty(q);
    }

    /**
     * @return the observable product
     */
    public ObjectProperty<Product> getProductProperty() {
        return product;
    }

    /**
     * @return the product
     */
    public Product getProduct() {
        return product.get();
    }

    /**
     * @param product the product to set
     */
    public void setProduct(Product product) {
        this.product.set(product);
    }

    /**
     * @return the observable quantity
     */
    public IntegerProperty getQuantityProperty() {
        return quantity;
    }
    
     /**
     * @return the quantity
     */
    public Integer getQuantity() {
        return quantity.get();
    }

    /**
     * @param quantity the quantity to set
     */
    public void setQuantity(Integer quantity) {
        this.quantity.set(quantity);
    }
}