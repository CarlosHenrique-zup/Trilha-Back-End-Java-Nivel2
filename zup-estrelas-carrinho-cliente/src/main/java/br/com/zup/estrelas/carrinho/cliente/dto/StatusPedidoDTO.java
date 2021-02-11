package br.com.zup.estrelas.carrinho.cliente.dto;

public class StatusPedidoDTO {

	private Long idStatusPedido;

	private String nome;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Long getIdStatusPedido() {
		return idStatusPedido;
	}

	public void setIdStatusPedido(Long idStatusPedido) {
		this.idStatusPedido = idStatusPedido;
	}
}
