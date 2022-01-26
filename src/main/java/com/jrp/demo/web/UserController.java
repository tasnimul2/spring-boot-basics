package com.jrp.demo.web;

import com.jrp.demo.domain.Product;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

@RestController()
@RequestMapping("/user")
public class UserController {

    @RequestMapping("/{userId}")
    public String displayUser(@PathVariable int userId){
        return "user found with id# " + userId;
    }

    @RequestMapping("/{userId}/invoices")
    public String displayUserInvoices(@PathVariable int userId,
                                      @RequestParam(value="date",required = false) Date dateOrNull){
        return "invoice found for user : " + userId + " on the date : "  + dateOrNull;
    }

    @RequestMapping("/{userId}/items")
    public List<String> displayStringJson(){
        return Arrays.asList("Phone","bottle","brush");
    }

    @RequestMapping("/{userId}/products_as_json")
    public List<Product> displayProductJson(){
        return Arrays.asList(new Product(1,"shoes",42.99),
                new Product(2,"Bag",2.99),
                new Product(3,"Brush",32.99));
    }



}
