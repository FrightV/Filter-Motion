package com.filtermotion.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.filtermotion.model.produto;

public interface ProdutoRepository extends JpaRepository<produto, Long> {

}