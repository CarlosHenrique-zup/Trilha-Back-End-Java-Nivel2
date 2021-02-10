package br.com.zup.estrelas.carrinho.cliente.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "carrinho")
public class CarrinhoEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_carrinho")
	private Long idCarrinho;

	@JsonManagedReference
	@OneToMany(mappedBy = "carrinho")
	private List<ClienteEntity> idCliente;

	@OneToMany
	@JoinColumn(name = "id_quadrinho", foreignKey = @ForeignKey(name = "FK_QUADRINHO_CARRINHO"))
	private List<QuadrinhoCarrinhoEntity> quadrinhoCarrinho;

	@Column(nullable = false)
	private String nome;

	@ManyToOne
	@JoinColumn(name = "id_status_pedido")
	private StatusPedidoEntity statusPedido;

	public CarrinhoEntity() {

	}

	public List<ClienteEntity> getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(List<ClienteEntity> idCliente) {
		this.idCliente = idCliente;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Long getIdCarrinho() {
		return idCarrinho;
	}

	public void setIdCarrinho(Long idCarrinho) {
		this.idCarrinho = idCarrinho;
	}

	public List<QuadrinhoCarrinhoEntity> getQuadrinhoCarrinho() {
		return quadrinhoCarrinho;
	}

	public void setQuadrinhoCarrinho(List<QuadrinhoCarrinhoEntity> quadrinhoCarrinho) {
		this.quadrinhoCarrinho = quadrinhoCarrinho;
	}

	public StatusPedidoEntity getStatusPedido() {
		return statusPedido;
	}

	public void setStatusPedido(StatusPedidoEntity statusPedido) {
		this.statusPedido = statusPedido;
	}

}
