package com.yorranpetrick.produtosApi.controller;

import com.yorranpetrick.produtosApi.models.Product;
import com.yorranpetrick.produtosApi.repository.ProdutoRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
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


    @RequestMapping(value = "/deleteProduct/{id}", method = RequestMethod.DELETE)
    public void deleteProductId(@PathVariable("id") String id){
        var product = researchProductId(id);
        if (product != null) produtoRepository.delete(product);
        else System.out.println("Produto não encontrado");
        }

    /*
    @DeleteMapping("/deleteProduct/{id}")
    public void deleteProduct(@PathVariable("id") String id){
        produtoRepository.deleteById(id);
        System.out.println("Produto Deletado");
    }*/

    @PutMapping("/updateProduct/{id}")
    public void updateProduct(@PathVariable("id") String id, @RequestBody Product newProduct){
        var product = researchProductId(id);
        if (product != null){
            newProduct.setId(id);
            produtoRepository.save(newProduct);
        }
        else System.out.println("Produto Não encontrado para a atualização");
    }

    @GetMapping
    public List<Product> researchListProduct(@RequestParam("name") String name){
        return produtoRepository.findByName(name);
    }

}
