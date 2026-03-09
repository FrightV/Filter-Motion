package com.filtermotion.service;

import com.filtermotion.model.AlertaPreco;
import com.filtermotion.model.Produto;
import com.filtermotion.repository.AlertaPrecoRepository;
import com.filtermotion.repository.ProdutoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MonitoramentoService {

    private final ProdutoRepository produtoRepository;
    private final AlertaPrecoRepository alertaPrecoRepository;

    @Scheduled(fixedRate = 60000)//verifica a cada 60 segundos
    public void verificarPrecos() {

        List<Produto> produtos = produtoRepository.findAll();
        List<AlertaPreco> alertas = alertaPrecoRepository.findAll();

        for (Produto produto : produtos) {
            for (AlertaPreco alerta : alertas) {

                if (produto.getNome().toLowerCase().contains(alerta.getNomeProduto().toLowerCase())) {


                    if (produto.getPrecoAtual().compareTo(alerta.getPrecoMaximo()) <= 0) {

                        System.out.println("EM PROMOÇÃO!!!");
                        System.out.println("Produto: " + produto.getNome());
                        System.out.println("Preço atual: " + produto.getPrecoAtual());
                        System.out.println("Preço desejado: " + alerta.getPrecoMaximo());
                        System.out.println("--------------------");

                    }

                }

            }
        }

    }

}