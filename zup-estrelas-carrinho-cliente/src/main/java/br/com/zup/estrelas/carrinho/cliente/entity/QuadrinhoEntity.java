package br.com.zup.estrelas.carrinho.cliente.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "quadrinho")
public class QuadrinhoEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_quadrinho")
	private Long idQuadrinho;

	@ManyToOne
	@JoinColumn(name = "id_carrinho", nullable = false)
	private QuadrinhoCarrinhoEntity carrinhoQuadrinho;

	@Column(nullable = false)
	private String nome;

	@Column(name = "numero_paginas", nullable = false)
	private Integer numPaginas;

	@Column(nullable = false)
	private Double preco;

	@Column(nullable = false)
	private String descricao;

	@Column(nullable = false)
	private Integer quantidade;

	public Long getIdQuadrinho() {
		return idQuadrinho;
	}

	public void setIdQuadrinho(Long idQuadrinho) {
		this.idQuadrinho = idQuadrinho;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getNumPaginas() {
		return numPaginas;
	}

	public void setNumPaginas(Integer numPaginas) {
		this.numPaginas = numPaginas;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}
}
