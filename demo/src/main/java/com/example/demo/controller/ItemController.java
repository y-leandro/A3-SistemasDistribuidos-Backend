package com.example.demo.controller;

import java.util.List;
import org.springframework.web.bind.annotation.*;
import com.example.demo.model.Item;
import com.example.demo.service.ServicoItem;

@RestController
@RequestMapping("/item")
@CrossOrigin
public class ItemController {

    private final ServicoItem service;

    public ItemController(ServicoItem service) {
        this.service = service;
    }

    @GetMapping
    public List<Item> listar() { return service.listar(); }

    @PostMapping
    public Item salvar(@RequestBody Item i) { return service.salvar(i); }

    @DeleteMapping("/{id}")
    public void remover(@PathVariable Long id) { service.remover(id); }

    @PutMapping("/{id}")
    public Item atualizar(@PathVariable Long id, @RequestBody Item i) {
        return service.atualizar(id, i);
    }

    @PatchMapping("/{id}/quantidade")
    public Item atualizarQuantidade(@PathVariable Long id, @RequestBody Integer quantidade) {
        return service.atualizarQuantidade(id, quantidade);
    }
}
