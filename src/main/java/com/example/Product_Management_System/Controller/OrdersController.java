package com.example.Product_Management_System.Controller;

import com.example.Product_Management_System.DTO.ReqRes;
import com.example.Product_Management_System.Model.Orders;
import com.example.Product_Management_System.Model.Product;
import com.example.Product_Management_System.Repository.OrdersRepository;
import com.example.Product_Management_System.Repository.ProductRepository;
import com.example.Product_Management_System.Service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/orders")
public class OrdersController {

    @Autowired
    private OrdersRepository ordersRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private OrdersService ordersService;
    @GetMapping
    public List<Orders> getAllOrders() {
        return ordersRepository.findAll();
    }

    @PostMapping
    public String placeOrder(@RequestBody ReqRes orderRequest) {
        if (orderRequest.getCustomerName() == null || orderRequest.getCustomerName().isEmpty()) {
            throw new IllegalArgumentException("Customer name is required");
        }

        for (Orders order : orderRequest.getOrders()) {
            if (order.getProductId() == null) {
                throw new IllegalArgumentException("Product ID must not be null");
            }

            Product product = productRepository.findById(order.getProductId())
                    .orElseThrow(() -> new RuntimeException("Product not found"));

            order.setTotalPrice(order.getQuantity() * product.getPrice());
            order.setCustomerName(orderRequest.getCustomerName()); // Assign customer name

            ordersRepository.save(order);
        }

        return "Order placed successfully";
    }


    @PutMapping("/{orderId}/deliver")
    public String markOrderAsDelivered(@PathVariable Long orderId) {
        Orders order = ordersRepository.findById(orderId)
                .orElseThrow(() -> new RuntimeException("Order not found"));

        order.setDelivered(true);
        ordersRepository.save(order);

        return "Order marked as delivered";
    }


    @GetMapping("/count")
    public ResponseEntity<Map<String, Long>> getOrderCount() {
        long count = ordersService.countOrders();
        Map<String, Long> response = new HashMap<>();
        response.put("count", count);
        return ResponseEntity.ok(response);
    }


}
