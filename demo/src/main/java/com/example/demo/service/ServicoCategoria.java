package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;
import com.example.demo.model.Categoria;
import com.example.demo.repository.CategoriaRepository;

@Service
public class ServicoCategoria {

    private final CategoriaRepository repo;

    public ServicoCategoria(CategoriaRepository repo) {
        this.repo = repo;
    }

    public List<Categoria> listar() {
        return repo.findAll();
    }

    public Categoria salvar(Categoria c) {
        return repo.save(c);
    }

    public void remover(Long id) {
        repo.deleteById(id);
    }

    public Categoria atualizar(Long id, Categoria c) {
        Categoria atual = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Categoria não encontrada"));

        atual.setNome(c.getNome());
        atual.setTamanho(c.getTamanho());
        atual.setEmbalagem(c.getEmbalagem());

        return repo.save(atual);
    }
}
