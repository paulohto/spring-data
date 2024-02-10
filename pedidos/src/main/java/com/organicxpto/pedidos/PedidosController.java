package com.organicxpto.pedidos;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import java.util.List;

@RestController
public class PedidosController {
    private final PedidoService pedidoService;

    public PedidosController(PedidoService pedidoService) {
        this.pedidoService = pedidoService;
    }

    @GetMapping("/get-all")
    public ResponseEntity<List<Pedido>> getAllpedidos(){
        return ResponseEntity.ok(this.pedidoService.getAll());
    }
}
