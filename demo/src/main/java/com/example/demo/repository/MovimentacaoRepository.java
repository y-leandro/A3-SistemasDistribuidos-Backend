package com.example.demo.repository;

import com.example.demo.model.Movimentacao;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface MovimentacaoRepository extends JpaRepository<Movimentacao, Long> {
   
    List<Movimentacao> findByTipo(String tipo);   
    List<Movimentacao> findByProdutoId(Long produtoId);
    Movimentacao findTopByTipoOrderByQuantidadeDesc(String tipo);
}
