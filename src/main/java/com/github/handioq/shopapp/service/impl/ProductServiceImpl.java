package com.github.handioq.shopapp.service.impl;

import com.github.handioq.shopapp.model.entity.Product;
import com.github.handioq.shopapp.repository.ProductRepository;
import com.github.handioq.shopapp.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository productRepository;

    @Override
    public Product getById(long id) {
        return productRepository.findOne(id);
    }

   /*@Override
    public List<Product> findAll() {
        return productRepository.findAll(); // TODO add pagination
    }*/

    @Override
    public Page<Product> findAllByPage(Pageable pageable) {
        return productRepository.findAll(pageable);
    }
}