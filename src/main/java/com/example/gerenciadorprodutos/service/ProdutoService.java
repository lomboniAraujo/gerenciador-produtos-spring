package com.example.gerenciadorprodutos.service;

import com.example.gerenciadorprodutos.model.LogAcao;
import com.example.gerenciadorprodutos.model.Produto;
import com.example.gerenciadorprodutos.repository.LogRepository;
import com.example.gerenciadorprodutos.repository.ProdutoRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ProdutoService {

    private final ProdutoRepository produtoRepository;
    private final LogRepository logRepository;

    public ProdutoService(ProdutoRepository produtoRepository, LogRepository logRepository) {
        this.produtoRepository = produtoRepository;
        this.logRepository = logRepository;
    }

    public Produto salvar(Produto produto) {
        Produto salvo = produtoRepository.save(produto);
        logRepository.save(new LogAcao("Produto cadastrado: " + salvo.getNome(), LocalDateTime.now()));
        return salvo;
    }

    public List<Produto> listar() {
        return produtoRepository.findAll();
    }
}
