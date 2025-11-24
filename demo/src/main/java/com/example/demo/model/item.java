package com.example.demo.model;

import jakarta.persistence.*;

@Entity
public class item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private Double preco;
    private Integer quantidade;
    private Integer quantidadeMin;
    private Integer quantidadeMax;
    private String categoria;

    public item() {}

    public item(String nome, Double preco, Integer quantidade, Integer quantidadeMin, Integer quantidadeMax, String categoria) {
        this.nome = nome;
        this.preco = preco;
        this.quantidade = quantidade;
        this.quantidadeMin = quantidadeMin;
        this.quantidadeMax = quantidadeMax;
        this.categoria = categoria;
    }

    
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public Double getPreco() { return preco; }
    public void setPreco(Double preco) { this.preco = preco; }
    public Integer getQuantidade() { return quantidade; }
    public void setQuantidade(Integer quantidade) { this.quantidade = quantidade; }
    public Integer getQuantidadeMin() { return quantidadeMin; }
    public void setQuantidadeMin(Integer quantidadeMin) { this.quantidadeMin = quantidadeMin; }
    public Integer getQuantidadeMax() { return quantidadeMax; }
    public void setQuantidadeMax(Integer quantidadeMax) { this.quantidadeMax = quantidadeMax; }
    public String getCategoria() { return categoria; }
    public void setCategoria(String categoria) { this.categoria = categoria; }
}
