package br.com.zup.estrelas.carrinho.cliente.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UsuarioDTO {

	@NotNull(message = "O campo não pode ser vazio.")
	private String username;

	@NotNull(message = "O campo não pode ser vazio.")
	private String nome;

	@Email(message = "O formato do e-mail esta inválido.")
	@NotNull(message = "O campo não pode ser vazio.")
	private String email;

	@Size(min = 8, max = 16, message = "O campo deve conter no mínimo 8 e no máximo 16 caracteres.")
	@NotNull(message = "O campo não pode ser vazio.")
	private String senha;

	@NotNull(message = "O campo não pode ser vazio.")
	private boolean isAdmin;

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

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public boolean isAdmin() {
		return isAdmin;
	}

	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
}
