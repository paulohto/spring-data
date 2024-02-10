package com.organicxpto.estoque;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EstoqueController {
    private final ProdutoService produtoService;

    public EstoqueController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @GetMapping("/get-all")
    public ResponseEntity<List<Produto>> getAllpedidos(){
        return ResponseEntity.ok(this.produtoService.getAll());
    }
}
