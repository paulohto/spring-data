package com.organicxpto.pedidos;

import org.bouncycastle.jcajce.provider.asymmetric.util.EC5Util;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PedidoService {

    private List<Pedido> fakeDb = new ArrayList<>();

    private final EstoquePedidoProducer estoquePedidoProducer;

    public PedidoService(EstoquePedidoProducer estoquePedidoProducer) {
        this.estoquePedidoProducer = estoquePedidoProducer;
    }

    List<Pedido> getAll() { return  this.fakeDb; }

    public void save(Pedido pedido) {
        try {
            pedido.getItens().forEach( p ->
                    this.estoquePedidoProducer.removerEstoque(
                            new RemoverEstoqueRequest(p.getIdProduct(), p.getQuantidade())
                    ));

            this.fakeDb.add(pedido);

        } catch (Exception e){
            throw new UnsupportedOperationException("Fora de estoque");
        }
    }
}
