package com.filtermotion.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.filtermotion.model.Produto;

import java.math.BigDecimal;
import java.util.List;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
    List<Produto> findByNomeContainingIgnoreCase(String nome);

    List<Produto> findByPrecoAtualLessThanEqual(BigDecimal preco);

    List<Produto> findByNomeContainingIgnoreCaseAndPrecoAtualLessThanEqual(String nome, BigDecimal preco);
}
