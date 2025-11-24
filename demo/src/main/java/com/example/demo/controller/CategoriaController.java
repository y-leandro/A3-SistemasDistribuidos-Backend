package com.example.demo.controller;

import java.util.List;
import org.springframework.web.bind.annotation.*;
import com.example.demo.model.categoria;
import com.example.demo.service.ServicoCategoria;

@RestController
@RequestMapping("/categoria")
@CrossOrigin
public class CategoriaController {

    private final ServicoCategoria service;

    public CategoriaController(ServicoCategoria service) {
        this.service = service;
    }

    @GetMapping
    public List<categoria> listar() { return service.listar(); }

    @PostMapping
    public categoria salvar(@RequestBody categoria c) { return service.salvar(c); }

    @DeleteMapping("/{id}")
    public void remover(@PathVariable Long id) { service.remover(id); }

    @PutMapping("/{id}")
    public categoria atualizar(@PathVariable Long id, @RequestBody categoria c) {
        return service.atualizar(id, c);
    }
}
