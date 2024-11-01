package com.controle_estoque.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "en_produto")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProduto;
    private String nomeProduto;
    private String descricaoProduto;

    public Produto() {
    }

    public Produto(Long idProduto, String nomeProduto, String descricaoProduto) {
        this.idProduto = idProduto;
        this.nomeProduto = nomeProduto;
        this.descricaoProduto = descricaoProduto;
    }

    public Long getIdProduto() { return idProduto; }
    public void setIdProduto(Long idProduto) {
        this.idProduto = idProduto;
    }

    public String getNomeProduto() { return nomeProduto; }
    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public String getDescricaoProduto() { return descricaoProduto; }
    public void setDescricaoProduto(String descricaoProduto) {
        this.descricaoProduto = descricaoProduto;
    }
}