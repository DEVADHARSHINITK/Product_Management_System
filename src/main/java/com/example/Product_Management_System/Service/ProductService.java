package com.example.Product_Management_System.Service;

import com.example.Product_Management_System.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService
{
    @Autowired
    private ProductRepository productRepository;

    public long countProducts() {
        return productRepository.count();
    }
}
