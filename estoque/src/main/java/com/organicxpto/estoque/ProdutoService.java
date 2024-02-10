package com.organicxpto.estoque;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class ProdutoService {

    private List<Produto> fakeDb = List.of(
            new Produto(1L, "Tomates", BigDecimal.valueOf(10000)),
            new Produto(2L, "Abacaxi", BigDecimal.TEN)
    );

    public List<Produto> getAll() {
        return fakeDb;
    }

    public void removerEstoque(Long idProduto, BigDecimal quantidade){
        this.fakeDb.stream().filter(
                p -> p.getId().equals(idProduto)).findFirst()
                .orElseThrow().removerEstoque(quantidade);
    }
}
