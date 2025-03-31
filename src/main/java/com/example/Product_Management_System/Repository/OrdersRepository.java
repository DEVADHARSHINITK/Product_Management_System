package com.example.Product_Management_System.Repository;

import com.example.Product_Management_System.Model.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrdersRepository extends JpaRepository<Orders, Long> {
}
