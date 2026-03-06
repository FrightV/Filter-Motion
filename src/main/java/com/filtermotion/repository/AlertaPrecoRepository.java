package com.filtermotion.repository;

import com.filtermotion.model.AlertaPreco;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AlertaPrecoRepository extends JpaRepository<AlertaPreco, Long> {

    List<AlertaPreco> findByNomeProdutoContainingIgnoreCase(String nomeProduto);

}