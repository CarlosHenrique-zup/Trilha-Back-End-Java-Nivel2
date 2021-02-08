package br.com.zup.estrelas.carrinho.cliente.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
	private CarrinhoEntity idCarrinho;

	@ManyToOne
	private QuadrinhoEntity idQuadrinho;

	@Column(nullable = false)
	private Integer quantidade;

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public CarrinhoEntity getIdCarrinho() {
		return idCarrinho;
	}

	public void setIdCarrinho(CarrinhoEntity idCarrinho) {
		this.idCarrinho = idCarrinho;
	}

	public QuadrinhoEntity getIdQuadrinho() {
		return idQuadrinho;
	}

	public void setIdQuadrinho(QuadrinhoEntity idQuadrinho) {
		this.idQuadrinho = idQuadrinho;
	}

	public Long getIdQuadrinhoCarrinho() {
		return idQuadrinhoCarrinho;
	}

	public void setIdQuadrinhoCarrinho(Long idQuadrinhoCarrinho) {
		this.idQuadrinhoCarrinho = idQuadrinhoCarrinho;
	}
}
