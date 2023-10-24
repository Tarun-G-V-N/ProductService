package com.simplestore.productservice.exceptions;

public class ProductNotFoundException extends RuntimeException{

    public ProductNotFoundException(int id) {

        super("Product with ID: "+id+" not available in the store!!");
    }
}
