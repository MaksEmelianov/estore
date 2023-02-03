package com.estore.service;

import com.estore.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;

public interface ProductsService {
    boolean getByTitle(Product product);
    Product getById(Long id);
    List<Product> getAllProducts();
    Page<Product> getProductsByCost(Pageable pageable, Double min, Double max);
    Page<Product> getProductsWithPagingAndFiltering(int pageNumber, int pageSize,
                                                    Specification<Product> productSpecification);
}
