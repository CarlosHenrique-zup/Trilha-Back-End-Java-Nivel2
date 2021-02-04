package br.com.zup.estrelas.carrinho.cliente.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

public class QuadrinhoDTO {

	@Positive(message = "O campo deve ser maior que zero")
	@NotNull(message = "O campo não pode deve ser vazio")
	private Integer quantidade;

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}
}
