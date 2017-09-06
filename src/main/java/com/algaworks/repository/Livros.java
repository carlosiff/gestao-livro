package com.algaworks.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.algaworks.model.Livro;

public interface Livros extends JpaRepository<Livro, Long> {

}