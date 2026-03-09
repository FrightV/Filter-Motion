package com.filtermotion.controller;

import com.filtermotion.dto.ProdutoDTO;
import com.filtermotion.model.Produto;
import com.filtermotion.repository.ProdutoRepository;
import com.filtermotion.service.ProdutoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    private final ProdutoService service;
    private final ProdutoRepository produtoRepository;

    public ProdutoController(ProdutoService service, ProdutoRepository produtoRepository) {
        this.service = service;
        this.produtoRepository = produtoRepository;
    }

    @GetMapping("/buscar")
    public List<ProdutoDTO> buscar(@RequestParam String termo) {
        return service.buscarProdutos(termo);
    }

    @PostMapping("/monitorar")
    public Produto monitorarProduto(@RequestBody Produto produto) {
        return produtoRepository.save(produto);
    }
}