package com.simplestore.productservice.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Product {

    private int id;
    private String title;
    private double price;
    private String description;
    private String category;
    private String image;

}
