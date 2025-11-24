package com.example.demo.repository;

import com.example.demo.model.item;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ItemRepository extends JpaRepository<item, Long> {
    List<item> findByCategoriaId(Long categoriaId);
}
