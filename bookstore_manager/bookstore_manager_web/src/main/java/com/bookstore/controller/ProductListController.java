package com.bookstore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 商品列表
 */
@Controller
public class ProductListController {
    @RequestMapping("/product_list")
    public String productList(){
        return "product_list";
    }
}
