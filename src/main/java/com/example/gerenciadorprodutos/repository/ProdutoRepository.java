package com.example.gerenciadorprodutos.repository;

import com.example.gerenciadorprodutos.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
