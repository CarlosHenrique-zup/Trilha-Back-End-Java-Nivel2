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
@Table(name = "quadrinho_carrinho")
public class QuadrinhoCarrinhoEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_quadrinho_carrinho")
	private Long idQuadrinhoCarrinho;

	@ManyToOne
	@JoinColumn(name = "id_carrinho", nullable = false)
	private CarrinhoEntity carrinho;

	@ManyToOne
	@JoinColumn(name = "id_quadrinho", nullable = false)
	private QuadrinhoEntity quadrinho;

	@Column(nullable = false)
	private Integer quantidade;

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public Long getIdQuadrinhoCarrinho() {
		return idQuadrinhoCarrinho;
	}

	public void setIdQuadrinhoCarrinho(Long idQuadrinhoCarrinho) {
		this.idQuadrinhoCarrinho = idQuadrinhoCarrinho;
	}

	public CarrinhoEntity getCarrinho() {
		return carrinho;
	}

	public void setCarrinho(CarrinhoEntity carrinho) {
		this.carrinho = carrinho;
	}

	public QuadrinhoEntity getQuadrinho() {
		return quadrinho;
	}

	public void setQuadrinho(QuadrinhoEntity quadrinho) {
		this.quadrinho = quadrinho;
	}
}
