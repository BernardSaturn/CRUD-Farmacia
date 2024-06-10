package com.generation.drogariagen.model;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "tb_produtos")
public class Produtos {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank(message = "o atributo NOME é obrigatório!!")
	@Size(min = 1, max = 100, message = " O atributo NOME deve ter no minimo 1 caracteres e no maximo 100.")
	private String nome;

	@NotNull(message = "O atributo PRECO é obrigatório!!")
	@Positive(message = "O preço deve ser um número positivo!")
    @DecimalMax(value = "9999999999.99", inclusive = true, message = "O preço deve ser um número até 9999999999.99!")
    private BigDecimal preco;
	
	@NotNull(message = "O atributo QUANTIDADE é obrigatório!!")
	private int quantidade;


	@ManyToOne
	@JsonIgnoreProperties("produtos")
	private Categoria categoria;


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public BigDecimal getPreco() {
		return preco;
	}


	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}


	public int getQuantidade() {
		return quantidade;
	}


	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}


	public Categoria getCategoria() {
		return categoria;
	}


	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}



}