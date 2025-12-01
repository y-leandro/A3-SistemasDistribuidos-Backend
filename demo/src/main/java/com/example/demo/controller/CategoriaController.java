package com.example.demo.controller;

import java.util.*;
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
    public List<categoria> listar() {
        return service.listar();
    }

    @PostMapping
    public categoria salvar(@RequestBody categoria c) {
        return service.salvar(c);
    }

    @DeleteMapping("/{id}")
    public void remover(@PathVariable Long id) {
        service.remover(id);
    }

    @PutMapping("/{id}")
    public categoria atualizar(@PathVariable Long id, @RequestBody categoria c) {
        return service.atualizar(id, c);
    }

    @GetMapping("/quantidades")
    public List<Map<String, Object>> getQuantidadePorCategoria() {
        List<categoria> categorias = service.listar(); // << usar o service
        List<Map<String, Object>> lista = new ArrayList<>();

        for (categoria cat : categorias) {
            Map<String, Object> item = new HashMap<>();
            item.put("nome", cat.getNome());
            item.put("quantidade", cat.getItens().size());
            lista.add(item);
        }

        return lista;
    }

}
