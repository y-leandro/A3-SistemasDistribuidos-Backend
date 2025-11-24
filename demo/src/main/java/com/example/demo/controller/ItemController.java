package com.example.demo.controller;

import java.util.List;
import org.springframework.web.bind.annotation.*;
import com.example.demo.model.item;
import com.example.demo.service.servicoItem;

@RestController
@RequestMapping("/item")
@CrossOrigin
public class ItemController {

    private final servicoItem service;

    public ItemController(servicoItem service) {
        this.service = service;
    }

    @GetMapping
    public List<item> listar() { return service.listar(); }

    @PostMapping
    public item salvar(@RequestBody item i) { return service.salvar(i); }

    @DeleteMapping("/{id}")
    public void remover(@PathVariable Long id) { service.remover(id); }

    @PutMapping("/{id}")
    public item atualizar(@PathVariable Long id, @RequestBody item i) {
        return service.atualizar(id, i);
    }

    @PatchMapping("/{id}/quantidade")
    public item atualizarQuantidade(@PathVariable Long id, @RequestBody Integer quantidade) {
        return service.atualizarQuantidade(id, quantidade);
    }
}
