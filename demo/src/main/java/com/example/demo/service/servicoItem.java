package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;
import com.example.demo.model.Item;
import com.example.demo.model.Categoria;
import com.example.demo.repository.ItemRepository;
import com.example.demo.repository.CategoriaRepository;

@Service
public class ServicoItem {

    private final ItemRepository repo;
    private final CategoriaRepository categoriaRepo;

    public ServicoItem(ItemRepository repo, CategoriaRepository categoriaRepo) {
        this.repo = repo;
        this.categoriaRepo = categoriaRepo;
    }

    public List<Item> listar() {
        return repo.findAll();
    }

    public Item salvar(Item i) {
        if (i.getcategoria() != null) {
            Categoria cat = categoriaRepo.findById(i.getcategoria().getId())
                    .orElseThrow(() -> new RuntimeException("Categoria não encontrada"));
            i.setcategoria(cat);
        }
        return repo.save(i);
    }

    public void remover(Long id) {
        repo.deleteById(id);
    }

    public Item atualizar(Long id, Item i) {
        Item atual = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("item não encontrado"));

        atual.setNome(i.getNome());
        atual.setPreco(i.getPreco());
        atual.setQuantidade(i.getQuantidade());
        atual.setQuantidadeMin(i.getQuantidadeMin());
        atual.setQuantidadeMax(i.getQuantidadeMax());

        if (i.getcategoria() != null) {
            Categoria cat = categoriaRepo.findById(i.getcategoria().getId())
                    .orElseThrow(() -> new RuntimeException("Categoria não encontrada"));
            atual.setcategoria(cat);
        }

        return repo.save(atual);
    }

    public Item atualizarQuantidade(Long id, Integer novaQtde) {
        Item atual = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("item não encontrado"));
        atual.setQuantidade(novaQtde);
        return repo.save(atual);
    }
}
