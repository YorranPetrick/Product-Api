package com.yorranpetrick.produtosApi.controller;

import com.yorranpetrick.produtosApi.models.Product;
import com.yorranpetrick.produtosApi.repository.ProdutoRepository;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/productApi")
public class ControllerProduct {

    private ProdutoRepository produtoRepository;

    public ControllerProduct(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    @PostMapping
    public void saveProduct(@RequestBody Product product){
        var id = UUID.randomUUID().toString();  //UUID classe java que cria um random unico
        product.setId(id);
        produtoRepository.save(product);
    }

    @GetMapping("/{id}")
    public Product researchProductId(@PathVariable("id") String id){
        var product = produtoRepository.findById(id).orElse(null); //Se houver um produto ele irá retornar, se não voltará nulo
        System.out.println(product);
        return product;
    }

}
