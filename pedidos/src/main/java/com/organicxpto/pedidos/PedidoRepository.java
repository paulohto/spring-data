package com.organicxpto.pedidos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.UUID;

public interface PedidoRepository extends JpaRepository<Pedido, UUID> {

    @Query(value = "select p from Pedido p where p.id_cliente = ?1", nativeQuery = true)
    Pedido findByCliente(UUID idCliente);
}
