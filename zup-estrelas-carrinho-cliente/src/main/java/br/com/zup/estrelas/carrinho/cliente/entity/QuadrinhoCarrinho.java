package br.com.zup.estrelas.carrinho.cliente.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "quadrinho_carrinho")
public class QuadrinhoCarrinho {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idQuadrinhoCliente;

	@ManyToOne
	private CarrinhoEntity idCarrinho;

	@ManyToOne
	private Quadrinho idQuadrinho;

	private Integer quantidade;

	public Long getIdQuadrinhoCliente() {
		return idQuadrinhoCliente;
	}

	public void setIdQuadrinhoCliente(Long idQuadrinhoCliente) {
		this.idQuadrinhoCliente = idQuadrinhoCliente;
	}

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

	public Quadrinho getIdQuadrinho() {
		return idQuadrinho;
	}

	public void setIdQuadrinho(Quadrinho idQuadrinho) {
		this.idQuadrinho = idQuadrinho;
	}
}
