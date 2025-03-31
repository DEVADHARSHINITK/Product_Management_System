package com.example.Product_Management_System.DTO;

import com.example.Product_Management_System.Model.Orders;
import com.example.Product_Management_System.Model.Users;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import java.time.LocalDate;
import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ReqRes {
        private int statusCode;
        private String error;
        private String message;
        private String token;
        private String refreshToken;
        private String expirationTime;

        private String name;
        private LocalDate dob;
        private String gender;
        private List<String> preferences;
        private String phoneNo;
        private String address;
        private String email;
        private String password;
        private String role;
        private Users user;
        private List<Users> userList;

        private String customerName;
        private List<Orders> orders;

        public int getStatusCode() {
                return statusCode;
        }

        public void setStatusCode(int statusCode) {
                this.statusCode = statusCode;
        }

        public String getError() {
                return error;
        }

        public void setError(String error) {
                this.error = error;
        }

        public String getMessage() {
                return message;
        }

        public void setMessage(String message) {
                this.message = message;
        }

        public String getToken() {
                return token;
        }

        public void setToken(String token) {
                this.token = token;
        }

        public String getRefreshToken() {
                return refreshToken;
        }

        public void setRefreshToken(String refreshToken) {
                this.refreshToken = refreshToken;
        }

        public String getExpirationTime() {
                return expirationTime;
        }

        public void setExpirationTime(String expirationTime) {
                this.expirationTime = expirationTime;
        }

        public String getName() {
                return name;
        }

        public void setName(String name) {
                this.name = name;
        }

        public LocalDate getDob() {
                return dob;
        }

        public void setDob(LocalDate dob) {
                this.dob = dob;
        }

        public String getGender() {
                return gender;
        }

        public void setGender(String gender) {
                this.gender = gender;
        }

        public List<String> getPreferences() {
                return preferences;
        }

        public void setPreferences(List<String> preferences) {
                this.preferences = preferences;
        }

        public String getPhoneNo() {
                return phoneNo;
        }

        public void setPhoneNo(String phoneNo) {
                this.phoneNo = phoneNo;
        }

        public String getAddress() {
                return address;
        }

        public void setAddress(String address) {
                this.address = address;
        }

        public String getEmail() {
                return email;
        }

        public void setEmail(String email) {
                this.email = email;
        }

        public String getPassword() {
                return password;
        }

        public void setPassword(String password) {
                this.password = password;
        }

        public String getRole() {
                return role;
        }

        public void setRole(String role) {
                this.role = role;
        }

        public Users getUser() {
                return user;
        }

        public void setUser(Users user) {
                this.user = user;
        }

        public List<Users> getUserList() {
                return userList;
        }

        public void setUserList(List<Users> userList) {
                this.userList = userList;
        }

        public String getCustomerName() {
                return customerName;
        }

        public void setCustomerName(String customerName) {
                this.customerName = customerName;
        }

        public List<Orders> getOrders() {
                return orders;
        }

        public void setOrders(List<Orders> orders) {
                this.orders = orders;
        }
}
