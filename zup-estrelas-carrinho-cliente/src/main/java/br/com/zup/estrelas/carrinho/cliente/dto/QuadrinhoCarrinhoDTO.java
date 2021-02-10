package br.com.zup.estrelas.carrinho.cliente.dto;

public class QuadrinhoCarrinhoDTO {

	private Long idQuadrinhoCarrinho;

	private Long idCarrinho;

	private Long idQuadrinho;

	private Integer quantidade;

	public Long getIdQuadrinhoCarrinho() {
		return idQuadrinhoCarrinho;
	}

	public void setIdQuadrinhoCarrinho(Long idQuadrinhoCarrinho) {
		this.idQuadrinhoCarrinho = idQuadrinhoCarrinho;
	}

	public Long getIdCarrinho() {
		return idCarrinho;
	}

	public void setIdCarrinho(Long idCarrinho) {
		this.idCarrinho = idCarrinho;
	}

	public Long getIdQuadrinho() {
		return idQuadrinho;
	}

	public void setIdQuadrinho(Long idQuadrinho) {
		this.idQuadrinho = idQuadrinho;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

}
