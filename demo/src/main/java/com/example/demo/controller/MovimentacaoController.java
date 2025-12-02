package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;
import com.example.demo.model.Movimentacao;
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
    public List<Movimentacao> listar() {
        return service.listar();
    }

    
    @PostMapping
    public Movimentacao registrar(@RequestBody Movimentacao mov) {
        return service.registrar(
            mov.getProduto().getId(),
            mov.getQuantidade(),
            mov.getTipo()
        );
    }

    @GetMapping("/mais-entrada")
    public Movimentacao maisEntrada() {
        return service.maisEntrada();
    }

    @GetMapping("/mais-saida")
    public Movimentacao maisSaida() {
        return service.maisSaida();
    }
}
