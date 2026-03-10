/*package com.filtermotion.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Table(name = "produtos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String url;

    private String imagem;

    private String loja;

    private BigDecimal precoAtual;

    private BigDecimal precoDesejado;

    private Boolean ativo = true;

}*/