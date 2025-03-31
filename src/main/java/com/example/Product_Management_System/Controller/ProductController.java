package com.example.Product_Management_System.Controller;

import com.example.Product_Management_System.DTO.DashBoardCounts;
import com.example.Product_Management_System.Model.Product;
import com.example.Product_Management_System.Repository.ProductRepository;
import com.example.Product_Management_System.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductRepository repository;

    @Autowired
    private ProductService productService;

    @GetMapping
    public List<Product> getAllProducts() {
        return repository.findAll();
    }

    @PostMapping
    public Product addProduct(@RequestBody Product product) {
        return repository.save(product);
    }

    @GetMapping("/count")
    public ResponseEntity<Map<String, Long>> getProductCount() {
        long count = productService.countProducts();
        Map<String, Long> response = new HashMap<>();
        response.put("count", count);
        return ResponseEntity.ok(response);
    }

}
