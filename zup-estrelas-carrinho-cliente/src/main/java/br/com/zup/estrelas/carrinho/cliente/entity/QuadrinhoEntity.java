package br.com.zup.estrelas.carrinho.cliente.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "quadrinho")
public class QuadrinhoEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_quadrinho")
	private Long idQuadrinho;

	@OneToMany
	@JoinColumn(name = "id_quadrinho_carrinho", foreignKey = @ForeignKey(name = "FK_QUADRINHO_QUADRINHO_CARRINHO"))
	private List<QuadrinhoCarrinhoEntity> quadrinhoCarrinho;

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

	public QuadrinhoEntity() {

	}

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
