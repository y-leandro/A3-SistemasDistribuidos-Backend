package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;
import com.example.demo.model.categoria;
import com.example.demo.repository.CategoriaRepository;

@Service
public class ServicoCategoria {

    private final CategoriaRepository repo;

    public ServicoCategoria(CategoriaRepository repo) {
        this.repo = repo;
    }

    public List<categoria> listar() {
        return repo.findAll();
    }

    public categoria salvar(categoria c) {
        return repo.save(c);
    }

    public void remover(Long id) {
        repo.deleteById(id);
    }

    public categoria atualizar(Long id, categoria c) {
        categoria atual = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Categoria não encontrada"));

        atual.setNome(c.getNome());
        atual.setTamanho(c.getTamanho());
        atual.setEmbalagem(c.getEmbalagem());

        return repo.save(atual);
    }
}
