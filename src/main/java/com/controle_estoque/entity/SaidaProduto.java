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
    @JoinColumn(name = "produto_id", nullable = false)
    private Produto produto;
    @Column(nullable = false)
    private int quantidade;
    @Column(name = "data_saida", nullable = false)
    private LocalDateTime dataSaida;
    @Column(nullable = false)
    private Boolean ativo = true;

    public SaidaProduto() {
    }

    public SaidaProduto(Produto produto, int quantidade, LocalDateTime dataSaida, Boolean ativo) {
        this.produto = produto;
        this.quantidade = quantidade;
        this.dataSaida = dataSaida;
        this.ativo = ativo;
    }

    public SaidaProduto(Produto produto, int quantidade, LocalDateTime dataSaida) {
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

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public LocalDateTime getDataSaida() {
        return dataSaida;
    }

    public void setDataSaida(LocalDateTime dataSaida) {
        this.dataSaida = dataSaida;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    @Override
    public String toString() {
        return "SaidaProduto{" +
                "id=" + id +
                ", produto=" + (produto != null ? produto.getNome() : "null") +
                ", quantidade=" + quantidade +
                ", dataSaida=" + dataSaida +
                ", ativo=" + ativo +
                '}';
    }
}
