package com.filtermotion.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.filtermotion.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

}