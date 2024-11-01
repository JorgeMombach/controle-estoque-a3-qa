package com.controle_estoque.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "en_saida_produto")
public class SaidaProduto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn
    private Produto produto;
    private Integer quantidade;
    private LocalDateTime dataSaida;

    public SaidaProduto() {
    }

    public SaidaProduto(Produto produto, Integer quantidade, LocalDateTime dataSaida) {
        this.produto = produto;
        this.quantidade = quantidade;
        this.dataSaida = dataSaida;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public LocalDateTime getDataSaida() {
        return dataSaida;
    }

    public void setDataSaida(LocalDateTime dataSaida) {
        this.dataSaida = dataSaida;
    }
}
