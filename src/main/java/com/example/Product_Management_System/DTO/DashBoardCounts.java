package com.example.Product_Management_System.DTO;

public class DashBoardCounts
{
    private long userCount;
    private long productCount;
    private long orderCount;

        // Constructor
        public DashBoardCounts(long userCount, long productCount,long orderCount) {
            this.userCount = userCount;
            this.productCount = productCount;
            this.orderCount=orderCount;
        }

        // Getters and Setters
        public long getUsersCount() {
            return userCount;
        }

        public void setUserCount(long userCount) {
            this.userCount = userCount;
        }

        public long getProductsCount() {
            return productCount;
        }

        public void setProductCount(long productCount) {
            this.productCount = productCount;
        }

    public long getOrderCount() {
        return orderCount;
    }

    public void setOrderCount(long orderCount) {
        this.orderCount = orderCount;
    }
}
