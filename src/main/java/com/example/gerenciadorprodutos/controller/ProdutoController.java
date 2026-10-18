package com.example.gerenciadorprodutos.controller;

import com.example.gerenciadorprodutos.client.ApiExternaClient;
import com.example.gerenciadorprodutos.client.EnderecoResponse;
import com.example.gerenciadorprodutos.model.Produto;
import com.example.gerenciadorprodutos.service.ProdutoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import retrofit2.Call;
import retrofit2.Response;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {

    private final ProdutoService produtoService;
    private final ApiExternaClient apiExternaClient;

    public ProdutoController(ProdutoService produtoService, ApiExternaClient apiExternaClient) {
        this.produtoService = produtoService;
        this.apiExternaClient = apiExternaClient;
    }

    @PostMapping
    public ResponseEntity<Produto> cadastrar(@RequestBody Produto produto) {
        Produto salvo = produtoService.salvar(produto);
        return ResponseEntity.status(HttpStatus.CREATED).body(salvo);
    }

    @GetMapping
    public List<Produto> listar() {
        return produtoService.listar();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        produtoService.deletar(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/consultar-cep/{cep}")
    public ResponseEntity<?> consultarCep(@PathVariable String cep) {
        try {
            Call<EnderecoResponse> call = apiExternaClient.consultarCep(cep);
            Response<EnderecoResponse> response = call.execute();

            if (!response.isSuccessful() || response.body() == null) {
                return ResponseEntity.status(HttpStatus.BAD_GATEWAY)
                        .body("Não foi possível consultar o CEP informado.");
            }

            return ResponseEntity.ok(response.body());
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erro ao consultar API externa: " + e.getMessage());
        }
    }
}