package br.com.zup.estrelas.carrinho.cliente.dto;

import java.util.List;

import javax.validation.constraints.NotNull;

public class CarrinhoDTO {

	private ClienteDTO cliente;

	private List<QuadrinhoCarrinhoDTO> quadrinhoCarrinho;

	@NotNull(message = "O campo não pode ser vazio.")
	private String nome;

	@NotNull(message = "O campo não pode ser vazio.")
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

	public ClienteDTO getCliente() {
		return cliente;
	}

	public void setCliente(ClienteDTO cliente) {
		this.cliente = cliente;
	}

	public List<QuadrinhoCarrinhoDTO> getQuadrinhoCarrinho() {
		return quadrinhoCarrinho;
	}

	public void setQuadrinhoCarrinho(List<QuadrinhoCarrinhoDTO> quadrinhoCarrinho) {
		this.quadrinhoCarrinho = quadrinhoCarrinho;
	}

}
