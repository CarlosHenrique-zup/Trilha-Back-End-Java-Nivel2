package br.com.zup.estrelas.carrinho.cliente.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UsuarioDTO {

//	private Long idUsuario;

	@NotNull(message = "O campo não pode ser vazio.")
	private String nome;

	@Email(message = "O formato do e-mail esta inválido.")
	@NotNull(message = "O campo não pode ser vazio.")
	private String email;

	@Size(min = 8, max = 16, message = "O campo deve conter no mínimo 8 e no máximo 16 caracteres.")
	@NotNull(message = "O campo não pode ser vazio.")
	private String senha;

	@NotNull(message = "O campo não pode ser vazio.")
	private String role;

//	public Long getIdUsuario() {
//		return idUsuario;
//	}
//
//	public void setIdUsuario(Long idUsuario) {
//		this.idUsuario = idUsuario;
//	}

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

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
}
