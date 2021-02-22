package br.com.zup.estrelas.carrinho.cliente.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "cliente")
public class ClienteEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_cliente")
	private Long idCliente;

	@JsonBackReference
	@OneToMany(mappedBy = "cliente")
	private List<CarrinhoEntity> carrinho;

	@OneToOne
	@JoinColumn(name = "id_usuario")
	private UsuarioEntity usuario;

	@Column(nullable = false)
	private String cpf;

	@Column(nullable = false)
	private Integer idade;

	@Column(nullable = false)
	private String endereco;

	@Column(nullable = false)
	private String telefone;

	public ClienteEntity() {

	}

	public Long getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Long idCliente) {
		this.idCliente = idCliente;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Integer getIdade() {
		return idade;
	}

	public void setIdade(Integer idade) {
		this.idade = idade;
	}

	public List<CarrinhoEntity> getCarrinho() {
		return carrinho;
	}

	public void setCarrinho(List<CarrinhoEntity> carrinho) {
		this.carrinho = carrinho;
	}

}
