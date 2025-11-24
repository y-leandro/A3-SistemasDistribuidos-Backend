package com.example.demo.repository;

import com.example.demo.model.movimentacao;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface MovimentacaoRepository extends JpaRepository<movimentacao, Long> {
   
    List<movimentacao> findByTipo(String tipo);   
    List<movimentacao> findByProdutoId(Long produtoId);
    movimentacao findTopByTipoOrderByQuantidadeDesc(String tipo);
}
