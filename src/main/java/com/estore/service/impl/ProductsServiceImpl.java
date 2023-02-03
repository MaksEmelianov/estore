package com.estore.service.impl;

import com.estore.entity.Product;
import com.estore.service.ProductsService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductsServiceImpl implements ProductsService {
    @Override
    public boolean getByTitle(Product product) {
        return false;
    }

    @Override
    public Product getById(Long id) {
        return null;
    }

    @Override
    public List<Product> getAllProducts() {
        return null;
    }

    @Override
    public Page<Product> getProductsByCost(Pageable pageable, Double min, Double max) {
        return null;
    }

    @Override
    public Page<Product> getProductsWithPagingAndFiltering(int pageNumber, int pageSize, Specification<Product> productSpecification) {
        return null;
    }
}
