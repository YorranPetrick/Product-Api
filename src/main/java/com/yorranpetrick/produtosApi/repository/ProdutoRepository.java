package com.yorranpetrick.produtosApi.repository;

import com.yorranpetrick.produtosApi.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


// O JpaRepository precisa de dois parâmetros:
// 1. A classe da entidade (Produto)
// 2. O tipo do ID da entidade (por exemplo, Long, String)

public interface ProdutoRepository extends JpaRepository<Product,String>{
}
