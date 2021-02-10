package br.com.zup.estrelas.carrinho.cliente.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

public class ClienteDTO {

	@NotNull(message = "O campo não pode ser vazio.")
	private String nome;

	@NotNull(message = "O campo não pode ser vazio.")
	private String email;

	@NotNull(message = "O campo não pode ser vazio.")
	private String cpf;

	@Positive(message = "O campo deve ser maior que zero.")
	@NotNull(message = "O campo não pode ser vazio.")
	private Integer idade;

	@NotNull(message = "O campo não pode ser vazio.")
	private String endereco;

	@NotNull(message = "O campo não pode ser vazio.")
	private String telefone;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getIdade() {
		return idade;
	}

	public void setIdade(Integer idade) {
		this.idade = idade;
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

}
