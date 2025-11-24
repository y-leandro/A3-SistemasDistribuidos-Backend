package com.example.demo.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.model.item;
import com.example.demo.model.movimentacao;
import com.example.demo.repository.ItemRepository;
import com.example.demo.repository.MovimentacaoRepository;

@Service
public class ServicoMovimentacao {

    private final MovimentacaoRepository movRepo;
    private final ItemRepository itemRepo;

    public ServicoMovimentacao(MovimentacaoRepository movRepo, ItemRepository itemRepo) {
        this.movRepo = movRepo;
        this.itemRepo = itemRepo;
    }

    public List<movimentacao> listar() {
        return movRepo.findAll();
    }

    public movimentacao registrar(Long itemId, Integer quantidade, String tipo) {
        item prod = itemRepo.findById(itemId)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado"));

        movimentacao mov = new movimentacao();
        mov.setProduto(prod);
        mov.setQuantidade(quantidade);
        mov.setTipo(tipo);
        mov.setData(LocalDate.now());

        return movRepo.save(mov);
    }

    public movimentacao maisEntrada() {
        return movRepo.findTopByTipoOrderByQuantidadeDesc("Entrada");
    }

    public movimentacao maisSaida() {
        return movRepo.findTopByTipoOrderByQuantidadeDesc("Saída");
    }
}
