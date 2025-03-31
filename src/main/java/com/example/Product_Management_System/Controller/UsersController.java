package com.example.Product_Management_System.Controller;

import com.example.Product_Management_System.DTO.DashBoardCounts;
import com.example.Product_Management_System.DTO.ReqRes;
import com.example.Product_Management_System.Model.Users;
import com.example.Product_Management_System.Service.ProductService;
import com.example.Product_Management_System.Service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class UsersController {
    @Autowired
    private UsersService userService;

    @Autowired
    private ProductService productService;

    @PostMapping("/register")
    public ResponseEntity<ReqRes> register(@RequestBody ReqRes registerRequest){
        return ResponseEntity.ok(userService.register(registerRequest));
    }

    @PostMapping("/login")
    public ResponseEntity<ReqRes> login(@RequestBody ReqRes loginRequest){
        return ResponseEntity.ok(userService.login(loginRequest));
    }

    @GetMapping("/userList")
    public ResponseEntity<ReqRes> getAllUsers(){
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @DeleteMapping("/delete/{userId}")
    public ResponseEntity<ReqRes> deleteUSer(@PathVariable Integer userId){
        return ResponseEntity.ok(userService.deleteUser(userId));
    }

    @GetMapping("/users/count")
    public ResponseEntity<Map<String, Long>> getUserCount() {
        long count = userService.countUsers();
        Map<String, Long> response = new HashMap<>();
        response.put("count", count);
        return ResponseEntity.ok(response);
    }
}
