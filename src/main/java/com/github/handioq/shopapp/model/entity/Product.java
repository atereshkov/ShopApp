package com.github.handioq.shopapp.model.entity;

import javax.persistence.*;

//@Entity
//@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;



}
