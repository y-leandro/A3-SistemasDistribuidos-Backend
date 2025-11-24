package com.example.demo.repository;

import com.example.demo.model.item;

import org.springframework.data.jpa.repository.JpaRepository;


public interface repoItem extends JpaRepository<item, Long> {
}
