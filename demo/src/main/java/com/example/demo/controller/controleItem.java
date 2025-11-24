package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;
import com.example.demo.model.item;
import com.example.demo.service.servicoItem;

import java.util.List;

@RestController
@RequestMapping("/item")
@CrossOrigin
public class controleItem {
    
    private final servicoItem service;

    public controleItem(servicoItem service){
        this.service = service;
    }

    @GetMapping
    public List<item> listas() {
        return service.listar();
    }

    @PostMapping
    public item salvar(@RequestBody item i){
        return service.salvar(i);
    }

    @DeleteMapping("/{id}")
    public void remove(@PathVariable Long id){
        service.remover(id);
    }
}
