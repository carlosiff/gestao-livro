package com.algaworks.gestaolivro.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.algaworks.gestaolivro.model.Livro;

public interface Livros extends JpaRepository<Livro, Long> {

}
