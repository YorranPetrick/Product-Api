package com.yorranpetrick.produtosApi.controller;

import com.yorranpetrick.produtosApi.models.Product;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/productApi")
public class ControllerProduct {

    @PostMapping
    public String postProduct(@RequestBody Product product){
        return "Product" + product;
    }
}
