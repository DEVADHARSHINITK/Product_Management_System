package com.example.Product_Management_System.Service;

import com.example.Product_Management_System.Repository.OrdersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrdersService {

    @Autowired
    OrdersRepository ordersRepository;

    public long countOrders() {
        return ordersRepository.count();
    }
}
