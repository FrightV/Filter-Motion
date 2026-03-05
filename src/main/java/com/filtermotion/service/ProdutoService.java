package com.filtermotion.service;

import com.filtermotion.model.Produto;
import com.filtermotion.repository.ProdutoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProdutoService {

    private final ProdutoRepository produtoRepository;

    public Produto salvar(Produto produto) {
        return produtoRepository.save(produto);
    }

    public List<Produto> listarTodos() {
        return produtoRepository.findAll();
    }

    public Produto buscarPorId(Long id) {
        return produtoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado"));
    }

    public void deletar(Long id) {
        produtoRepository.deleteById(id);
    }

    public List<Produto> buscarPorNome(String nome) {
        return produtoRepository.findByNomeContainingIgnoreCase(nome);
    }

    public List<Produto> buscarPorPrecoMax(BigDecimal precoMax) {
        return produtoRepository.findByPrecoAtualLessThanEqual(precoMax);
    }

    public List<Produto> buscarPorNomeEPrecoMax(String nome, BigDecimal precoMax) {
        return produtoRepository
                .findByNomeContainingIgnoreCaseAndPrecoAtualLessThanEqual(nome, precoMax);
    }
}