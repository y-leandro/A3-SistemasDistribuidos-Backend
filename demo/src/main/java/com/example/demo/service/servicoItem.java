package com.example.demo.service;

import java.util.List;

import com.example.demo.model.item;
import com.example.demo.repository.repoItem;

import org.springframework.stereotype.Service;


@Service
public class servicoItem {

    private final repoItem repo;

    public servicoItem(repoItem repo) {
        this.repo = repo;
    }

    public List<item> listar() { return repo.findAll(); }
    public item salvar(item p) { return repo.save(p); }
    public void remover(Long id) { repo.deleteById(id); }
}
