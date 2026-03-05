package com.filtermotion.controller;

import com.filtermotion.model.Produto;
import com.filtermotion.service.ProdutoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/produtos")
@RequiredArgsConstructor
public class ProdutoController {

    private final ProdutoService produtoService;

    @PostMapping
    public Produto criar(@RequestBody Produto produto) {
        return produtoService.salvar(produto);
    }

    @GetMapping
    public List<Produto> listar(
            @RequestParam(required = false) String nome,
            @RequestParam(required = false) BigDecimal precoMax
    ) {

        if (nome != null && precoMax != null) {
            return produtoService.buscarPorNomeEPrecoMax(nome, precoMax);
        }

        if (nome != null) {
            return produtoService.buscarPorNome(nome);
        }

        if (precoMax != null) {
            return produtoService.buscarPorPrecoMax(precoMax);
        }

        return produtoService.listarTodos();
    }

    @GetMapping("/{id}")
    public Produto buscar(@PathVariable Long id) {
        return produtoService.buscarPorId(id);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        produtoService.deletar(id);
    }

}