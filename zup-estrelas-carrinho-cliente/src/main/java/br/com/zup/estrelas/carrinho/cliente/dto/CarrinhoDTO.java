package br.com.zup.estrelas.carrinho.cliente.dto;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotNull;

import br.com.zup.estrelas.carrinho.cliente.entity.StatusPedidoEntity;

public class CarrinhoDTO {

	@NotNull(message = "O campo não pode ser vazio.")
	private String nome;

	@Enumerated(EnumType.STRING)
	@NotNull(message = "O campo não pode ser vazio.")
	private StatusPedidoEntity statusPedido;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public StatusPedidoEntity getStatusPedido() {
		return statusPedido;
	}

	public void setStatusPedido(StatusPedidoEntity statusPedido) {
		this.statusPedido = statusPedido;
	}
}
