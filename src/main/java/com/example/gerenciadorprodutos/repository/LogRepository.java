package com.example.gerenciadorprodutos.repository;

import com.example.gerenciadorprodutos.model.LogAcao;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface LogRepository extends MongoRepository<LogAcao, String> {
}
