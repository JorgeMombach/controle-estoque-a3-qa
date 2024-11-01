package com.controle_estoque.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "en_entrada_produto")
public class EntradaProduto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "produto_id", nullable = false)
    private Produto produto;
    @Column(nullable = false)
    private int quantidade;
    @Column(name = "data_entrada", nullable = false)
    private LocalDateTime dataEntrada;
    @Column(nullable = false)
    private Boolean ativo = true;

    public EntradaProduto() {
    }

    public EntradaProduto(Produto produto, int quantidade, LocalDateTime dataEntrada, Boolean ativo) {
        this.produto = produto;
        this.quantidade = quantidade;
        this.dataEntrada = dataEntrada;
        this.ativo = ativo;
    }

    public EntradaProduto(Produto produto, int quantidade, LocalDateTime dataEntrada) {
        this.produto = produto;
        this.quantidade = quantidade;
        this.dataEntrada = dataEntrada;
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

    public LocalDateTime getDataEntrada() {
        return dataEntrada;
    }

    public void setDataEntrada(LocalDateTime dataEntrada) {
        this.dataEntrada = dataEntrada;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    @Override
    public String toString() {
        return "EntradaProduto{" +
                "id=" + id +
                ", produto=" + (produto != null ? produto.getNome() : "null") +
                ", quantidade=" + quantidade +
                ", dataEntrada=" + dataEntrada +
                ", ativo=" + ativo +
                '}';
    }
}