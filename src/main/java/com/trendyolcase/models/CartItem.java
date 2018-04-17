package com.trendyolcase.models;

import java.util.Optional;

public class CartItem {

    private String productId;
    private String categoryId;
    private Long price;
    private Long discountPrice;

    public CartItem(){

    }

    public CartItem(String productId, String categoryId, Long price) {
        this.productId = productId;
        this.categoryId = categoryId;
        this.price = price;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public Long getDiscountPrice() {
        return discountPrice;
    }

    public void setDiscountPrice(Long discountPrice) {
        this.discountPrice = discountPrice;
    }
}
