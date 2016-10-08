package com.github.handioq.shopapp.service;

import com.github.handioq.shopapp.model.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProductService {

    Product getById(long id);

    //List<Product> findAll();

    Page<Product> findAllByPage(Pageable pageable);

}