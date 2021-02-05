package br.com.zup.estrelas.carrinho.cliente.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "carrinho")
public class CarrinhoEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_carrinho")
	private Long idCarrinho;

	@OneToMany(mappedBy = "carrinho")
	private List<ClienteEntity> idCliente;

	@Column(nullable = false)
	private String nome;

	@OneToOne
	private StatusPedidoEntity statusPedido;

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

}
