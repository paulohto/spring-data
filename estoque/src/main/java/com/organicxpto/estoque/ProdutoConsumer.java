package com.organicxpto.estoque;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.function.Consumer;

@Component
public class ProdutoConsumer {

    private final ProdutoService produtoService;

    public ProdutoConsumer(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @Bean(name = "remova-estoque")
    Consumer<ProdutoRequest> consumer(){
        return produtoRequest -> this.produtoService.removerEstoque(
                produtoRequest.getIdProduto(),
                produtoRequest.getQuantidade());
    }
}
