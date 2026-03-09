package com.filtermotion.dto;

import java.math.BigDecimal;

public class ProdutoDTO {

    private String nome;
    private String loja;
    private BigDecimal preco;
    private String url;
    private String imagem;

    public ProdutoDTO() {}

    public ProdutoDTO(String nome, String loja, BigDecimal preco, String url, String imagem) {
        this.nome = nome;
        this.loja = loja;
        this.preco = preco;
        this.url = url;
        this.imagem = imagem;
    }

    public String getNome() {
        return nome;
    }

    public String getLoja() {
        return loja;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public String getUrl() {
        return url;
    }

    public String getImagem() {
        return imagem;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setLoja(String loja) {
        this.loja = loja;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }
}