package com.organicxpto.estoque;

import java.math.BigDecimal;

public class ProdutoRequest {

    private Long idProduto;

    private BigDecimal quantidade;

    public Long getIdProduto() {
        return idProduto;
    }

    public BigDecimal getQuantidade() {
        return quantidade;
    }


}
