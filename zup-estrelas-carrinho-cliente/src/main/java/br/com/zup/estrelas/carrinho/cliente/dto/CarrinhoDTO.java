package br.com.zup.estrelas.carrinho.cliente.dto;

import javax.validation.constraints.NotNull;

public class CarrinhoDTO {

	@NotNull(message = "O campo não pode ser vazio.")
	private String nome;

	// @NotNull(message = "O campo não pode ser vazio.")
	private StatusPedidoDTO statusPedido;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public StatusPedidoDTO getStatusPedido() {
		return statusPedido;
	}

	public void setStatusPedido(StatusPedidoDTO statusPedido) {
		this.statusPedido = statusPedido;
	}

}
