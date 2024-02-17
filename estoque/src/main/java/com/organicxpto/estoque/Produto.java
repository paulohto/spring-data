package com.organicxpto.estoque;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.math.BigDecimal;

@Document
public class Produto {

    @MongoId
    private Long id;

    private String nome;

    private BigDecimal quantidade;

    public Produto(Long id, String nome, BigDecimal quantidade) {
        this.id = id;
        this.nome = nome;
        this.quantidade = quantidade;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public BigDecimal getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(BigDecimal quantidade) {
        this.quantidade = quantidade;
    }

    public void removerEstoque(BigDecimal quantidade) {
        if(quantidade.compareTo(BigDecimal.ZERO) < 0){
            throw new UnsupportedOperationException("Valor invalido");
        } else if (this.quantidade.subtract(quantidade).compareTo(BigDecimal.ZERO) < 0) {
            throw new UnsupportedOperationException("Estoque Insuficiente");
        } else {
            this.quantidade = this.quantidade.subtract(quantidade);
        }
    }
}
