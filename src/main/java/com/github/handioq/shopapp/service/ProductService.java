package com.github.handioq.shopapp.service;

import com.github.handioq.shopapp.model.entity.Product;

import java.util.List;

public interface ProductService {

    Product getById(long id);

    List<Product> findAll();

}
