package br.com.zup.estrelas.carrinho.cliente.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

public class QuadrinhoDTO {

	@NotNull(message = "O campo não pode deve ser vazio.")
	private String nome;

	@Positive(message = "O campo deve ser maior que zero.")
	@NotNull(message = "O campo não pode deve ser vazio.")
	private Integer numPaginas;

	@Positive(message = "O campo deve ser maior que zero.")
	@NotNull(message = "O campo não pode deve ser vazio.")
	private Double preco;

	@NotNull(message = "O campo não pode deve ser vazio.")
	private String descricao;

	@Positive(message = "O campo deve ser maior que zero.")
	@NotNull(message = "O campo não pode deve ser vazio.")
	private Integer quantidade;

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
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

}
