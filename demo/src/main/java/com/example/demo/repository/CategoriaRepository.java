package com.example.demo.repository;

import com.example.demo.model.categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<categoria, Long> { }
