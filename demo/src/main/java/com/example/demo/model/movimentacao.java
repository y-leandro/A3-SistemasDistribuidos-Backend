package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class movimentacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private item produto;

    private LocalDate data;
    private Integer quantidade;
    private String tipo; 

    public movimentacao() {}

    public movimentacao(item produto, LocalDate data, Integer quantidade, String tipo) {
        this.produto = produto;
        this.data = data;
        this.quantidade = quantidade;
        this.tipo = tipo;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public item getProduto() {
        return produto;
    }
    public void setProduto(item produto) {
        this.produto = produto;
    }

    public LocalDate getData() {
        return data;
    }
    public void setData(LocalDate data) {
        this.data = data;
    }

    public Integer getQuantidade() {
        return quantidade;
    }
    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public String getTipo() {
        return tipo;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
