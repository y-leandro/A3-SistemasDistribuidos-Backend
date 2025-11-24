package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;
import com.example.demo.model.item;
import com.example.demo.model.categoria;
import com.example.demo.repository.ItemRepository;
import com.example.demo.repository.CategoriaRepository;

@Service
public class servicoItem {

    private final ItemRepository repo;
    private final CategoriaRepository categoriaRepo;

    public servicoItem(ItemRepository repo, CategoriaRepository categoriaRepo) {
        this.repo = repo;
        this.categoriaRepo = categoriaRepo;
    }

    public List<item> listar() {
        return repo.findAll();
    }

    public item salvar(item i) {
        if (i.getcategoria() != null) {
            categoria cat = categoriaRepo.findById(i.getcategoria().getId())
                    .orElseThrow(() -> new RuntimeException("Categoria não encontrada"));
            i.setcategoria(cat);
        }
        return repo.save(i);
    }

    public void remover(Long id) {
        repo.deleteById(id);
    }

    public item atualizar(Long id, item i) {
        item atual = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("item não encontrado"));

        atual.setNome(i.getNome());
        atual.setPreco(i.getPreco());
        atual.setQuantidade(i.getQuantidade());
        atual.setQuantidadeMin(i.getQuantidadeMin());
        atual.setQuantidadeMax(i.getQuantidadeMax());

        if (i.getcategoria() != null) {
            categoria cat = categoriaRepo.findById(i.getcategoria().getId())
                    .orElseThrow(() -> new RuntimeException("Categoria não encontrada"));
            atual.setcategoria(cat);
        }

        return repo.save(atual);
    }

    public item atualizarQuantidade(Long id, Integer novaQtde) {
        item atual = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("item não encontrado"));
        atual.setQuantidade(novaQtde);
        return repo.save(atual);
    }
}
