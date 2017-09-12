package com.algaworks.gestaolivro.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.algaworks.gestaolivro.model.Autora;

public interface Autoras extends JpaRepository<Autora, Long> {
	
	@Query(value ="SELECT * "
			+ " FROM autora a "
			+ " ORDER BY a.id_autora", nativeQuery = true)
	List<Autora> findAllOrderByAutora();
	

}