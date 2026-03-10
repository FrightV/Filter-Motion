package com.filtermotion.controller;

import com.filtermotion.dto.ProdutoDTO;
import com.filtermotion.service.ProdutoService;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    private final ProdutoService service;

    public ProdutoController(ProdutoService Service) {
        this.service = Service;
    }

    @GetMapping("/buscar")
    public List<ProdutoDTO> buscar(
            @RequestParam String termo,
            @RequestParam(required = false) BigDecimal precoMax
    ) {
        return service.buscarProdutos(termo, precoMax);
    }
}