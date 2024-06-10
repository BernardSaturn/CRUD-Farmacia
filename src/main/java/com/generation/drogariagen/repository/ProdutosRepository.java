package com.generation.drogariagen.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.generation.drogariagen.model.Produtos;

public interface ProdutosRepository extends JpaRepository<Produtos, Long> {

	public List<Produtos> findAllByNomeContainingIgnoreCase(@Param("nome") String nome);

}