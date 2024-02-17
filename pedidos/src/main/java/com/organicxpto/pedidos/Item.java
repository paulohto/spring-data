package com.organicxpto.pedidos;

import jakarta.persistence.*;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;


import java.math.BigDecimal;


@Entity
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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
