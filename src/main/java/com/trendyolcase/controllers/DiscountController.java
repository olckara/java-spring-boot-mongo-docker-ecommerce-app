package com.trendyolcase.controllers;


import com.trendyolcase.models.CartItem;
import com.trendyolcase.services.DiscountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Controller
public class DiscountController {
    @Autowired
    private DiscountService discountService;

    @PostMapping(value = "/calculateDiscounts/")
    public ResponseEntity<List<CartItem>> create(@RequestBody List<CartItem> cartItems) {
        return new ResponseEntity<>(discountService.applyDiscounts(cartItems), HttpStatus.OK);
    }
}
