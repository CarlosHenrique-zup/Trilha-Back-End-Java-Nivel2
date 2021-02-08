package br.com.zup.estrelas.carrinho.cliente.dto;

public class ErrorDTO {

	public ErrorDTO(String mensagem) {
		this.mensagem = mensagem;
	}

	private String mensagem;

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
}
