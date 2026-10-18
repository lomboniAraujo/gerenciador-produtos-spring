package com.example.gerenciadorprodutos.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "logs_acao")
public class LogAcao {

    @Id
    private String id;

    private String descricao;

    private LocalDateTime dataHora;

    public LogAcao() {
    }

    public LogAcao(String descricao, LocalDateTime dataHora) {
        this.descricao = descricao;
        this.dataHora = dataHora;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }
}
