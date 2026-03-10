/*package com.filtermotion.service;

import com.filtermotion.dto.ProdutoDTO;
import com.filtermotion.model.Produto;
import com.filtermotion.repository.ProdutoRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class PriceMonitorService {

    private final ProdutoRepository produtoRepository;
    private final ProdutoService produtoService;

    public PriceMonitorService(ProdutoRepository produtoRepository,
                               ProdutoService produtoService) {
        this.produtoRepository = produtoRepository;
        this.produtoService = produtoService;
    }

    public void atualizarPrecos() {

        List<Produto> produtos = produtoRepository.findAll();

        for (Produto produto : produtos) {

            try {

                List<ProdutoDTO> resultados =
                        produtoService.buscarProdutos(produto.getNome());

                if (!resultados.isEmpty()) {

                    ProdutoDTO primeiro = resultados.get(0);

                    BigDecimal precoAtual = primeiro.getPreco();

                    produto.setPrecoAtual(precoAtual);

                    produtoRepository.save(produto);

                    System.out.println("Preço atualizado: " + produto.getNome());
                }

            } catch (Exception e) {

                System.out.println("Erro ao atualizar produto: " + produto.getNome());

            }
        }
    }
}*/