package com.organicxpto.pedidos;

import java.math.BigDecimal;

public class Item {

    private Long id;
    private Long idProduct;

    private BigDecimal quantidade;

    public Item() {
        super();
    }

    public Item(Long id, Long idProduct, BigDecimal quantidade) {
        this.id = id;
        this.idProduct = idProduct;
        this.quantidade = quantidade;
    }

    public Long getId() {
        return id;
    }

    public Long getIdProduct() {
        return idProduct;
    }

    public BigDecimal getQuantidade() {
        return quantidade;
    }
}
