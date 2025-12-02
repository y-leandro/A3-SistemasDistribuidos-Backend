package com.example.demo.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.model.Item;
import com.example.demo.model.Movimentacao;
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

    public List<Movimentacao> listar() {
        return movRepo.findAll();
    }

    public Movimentacao registrar(Long itemId, Integer quantidade, String tipo) {
        Item prod = itemRepo.findById(itemId)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado"));

        Movimentacao mov = new Movimentacao();
        mov.setProduto(prod);
        mov.setQuantidade(quantidade);
        mov.setTipo(tipo);
        mov.setData(LocalDate.now());

        return movRepo.save(mov);
    }

    public Movimentacao maisEntrada() {
        return movRepo.findTopByTipoOrderByQuantidadeDesc("Entrada");
    }

    public Movimentacao maisSaida() {
        return movRepo.findTopByTipoOrderByQuantidadeDesc("Saída");
    }
}
