package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;
import com.example.demo.model.movimentacao;
import com.example.demo.service.ServicoMovimentacao;

@RestController
@RequestMapping("/movimentacao")
@CrossOrigin
public class MovimentacaoController {

    private final ServicoMovimentacao service;

    public MovimentacaoController(ServicoMovimentacao service) {
        this.service = service;
    }

    @GetMapping
    public List<movimentacao> listar() {
        return service.listar();
    }

    
    @PostMapping
    public movimentacao registrar(@RequestBody movimentacao mov) {
        return service.registrar(
            mov.getProduto().getId(),
            mov.getQuantidade(),
            mov.getTipo()
        );
    }

    @GetMapping("/mais-entrada")
    public movimentacao maisEntrada() {
        return service.maisEntrada();
    }

    @GetMapping("/mais-saida")
    public movimentacao maisSaida() {
        return service.maisSaida();
    }
}
